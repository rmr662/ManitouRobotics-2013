/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.manitourobotics.robot;

import com.github.manitourobotics.robot.commands.ElbowControl;
import com.github.manitourobotics.robot.commands.MoveSmallArmsDown;
import com.github.manitourobotics.robot.commands.MoveSmallArmsUp;
import com.github.manitourobotics.robot.commands.ShoulderControl;
import com.github.manitourobotics.robot.commands.StopSmallArms;
import com.sun.squawk.microedition.io.FileConnection;
import com.sun.squawk.util.StringTokenizer;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Watchdog;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import javax.microedition.io.Connector;

/**
 *
 * @author robotics
 */
public class Logger {
    private static boolean recording;
    private static boolean playing; 
    private static boolean isPaused = false;
    private static DataInputStream in;
    private static DataOutputStream out;
    private static Timer timer = new Timer();
    private static FileConnection fileInputConnection;
    private static FileConnection fileOutputConnection;

    public static final int SMALL_ARMS = 1;
    public static final int SHOULDER_ARMS = 2;
    public static final int ELBOW_ARMS = 3;

    public static final int UP = 1;
    public static final int DOWN = 2;
    public static final int STOP = 3;

    private static double timeStamp = 0;
    private static int commandName;
    private static String content;
    private static int fileNumber = 1;

    

    public Logger() {
        SmartDashboard.putString("Logger", "init");
    }

    static void togglePause() {
        if(recording) {
            return;
        }
        if(!playing) {
            return;
        }
        if(isPaused) {
            resumePlayback();
        } else {
            pausePlayback();
        }
    }

    public static void pausePlayback() {
        isPaused = true;
        timer.stop();
        OI.togglePlayMode();
        OI.setupClimbingControls();
    }
    public static void resumePlayback() {
        isPaused = false;
        timer.start();
        OI.togglePlayMode();
    }

    public static void startPlayback(String filename) {
        if(recording) {
            return;
        }
        try {
            fileInputConnection = (FileConnection) Connector.open("file://" + filename, Connector.READ);
            in = fileInputConnection.openDataInputStream();
        } catch (IOException e) {
            System.out.println("cannot read file");
            e.printStackTrace();
        }

        OI.togglePlayMode();
        SmartDashboard.putString("Logger", "Playing");
        playing = true;
        timer.reset();
        timer.start();
        timeStamp = 0;
    }

    public static void stopPlayback() {
        OI.togglePlayMode();
        timer.reset();
        try {
            if(in != null) {
                in.close();
            }
            if(fileInputConnection != null){
                fileInputConnection.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        playing = false;
        SmartDashboard.putString("Logger", "Done Playing");
        OI.setupClimbingControls(); 
        // The previous climbing controls commands have been removed by the playback mode, so I need to reinstantiate them

    }
    public static void togglePlayback() {
        if(recording) {
            return;
        }
        if(!playing) {
            startPlayback("final.txt");
        }  else {
            stopPlayback();
        }
    }

    // Check if playing is enabled. If so, read the file an run the necessary commands
    public static void playbackCheck() {
        if(!playing) {
            return;
        }
        if(isPaused) {
            return;
        }
        if (timer.get() <= timeStamp) {
            // wait until the timer is triggered
            return;
        }
        String data;
        StringTokenizer tok;

        try {
            Watchdog.getInstance().feed();
            data = in.readUTF();
            System.out.println(data);
            tok = new StringTokenizer(data, ":");
            timeStamp = Double.parseDouble(tok.nextToken());
            commandName = Integer.parseInt(tok.nextToken());
            content = tok.nextToken();

            if(commandName == SMALL_ARMS) {
                int contentSmallArms = Integer.parseInt(content);
                if (contentSmallArms == UP) {
                    Scheduler.getInstance().add(new MoveSmallArmsUp());
                } else if (contentSmallArms == DOWN) {
                    Scheduler.getInstance().add(new MoveSmallArmsDown());
                } else if (contentSmallArms == STOP) {
                    Scheduler.getInstance().add(new StopSmallArms());
                }
            } else if(commandName == SHOULDER_ARMS) {
                double contentShoulderArms = Double.parseDouble(content);
                Scheduler.getInstance().add(new ShoulderControl(contentShoulderArms));

            } else if(commandName == ELBOW_ARMS) {
                double contentElbowArms = Double.parseDouble(content);
                Scheduler.getInstance().add(new ElbowControl(contentElbowArms));
            }
        } catch (EOFException eof) {
            System.out.println("End of file");
            eof.printStackTrace();
            stopPlayback();
            return;
        } catch (Exception e){
            stopPlayback();
            e.printStackTrace(); 
            return;
        }
    }

    public static void loggingToggle() {
        if(playing) {
            return;
        }
        if(!recording) {
            startLogging();
        } else { 
            stopLogging();
        }
    }

    private static void startLogging() {
        SmartDashboard.putString("Logger", "Logging");
        try {
            do {
                // Find a unique filename log<x>.txt where x is a number. Never erase a logCheck
                // One must move the logCheck to final.txt (Get a ftp client under /ni-rt/system/) 
                // to actually read the log
                fileOutputConnection = (FileConnection) Connector.open("file://log" + Integer.toString(fileNumber) + ".txt", Connector.READ_WRITE);
                // Apparently I need read access to check if a file exists

                fileNumber += 1;
            } while (fileOutputConnection.exists()); 
            // if the file doesn't exists, then create a file

            fileOutputConnection.create();

    } catch (Exception e) {
        e.printStackTrace();
    }
        timer.start();
        recording = true;
        try {
            out = fileOutputConnection.openDataOutputStream();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void stopLogging() {
        SmartDashboard.putString("Logger", "Done Logging");
        recording = false; 
        timer.stop(); 
        try {
            out.close();
            fileOutputConnection.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // Check if logging is enabled. If so, write the command to a file
    public static void logCheck(int commandName, String content ) {
        if (!recording) {
            return;
        }
        try {

            String timestamp = Double.toString(timer.get());
            out.writeUTF(timestamp + ":" + Integer.toString(commandName) + ":" + content );
            out.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    
    
}
