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
    private static String pausedFilename;
    private static int pausedFileReadPosition;
    private static DataInputStream in;
    private static DataOutputStream out;
    private static Timer timer = new Timer();
    private static FileConnection fileConnection;
    private static String oldMode;

    public static final int SMALL_ARMS = 1;
    public static final int SHOULDER_ARMS = 2;
    public static final int ELBOW_ARMS = 3;

    public static final int UP = 1;
    public static final int DOWN = 2;
    public static final int STOP = 3;

    public static double timeStamp;
    public static int commandName;
    public static String content;

    public Logger() {
        try {
            fileConnection = (FileConnection) Connector.open("file://test.txt", Connector.READ_WRITE);
            fileConnection.delete();
            fileConnection.create();
            out = fileConnection.openDataOutputStream();
            in = fileConnection.openDataInputStream();
            SmartDashboard.putString("Logger", "init");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isRecording() {
        return recording;
    }
    public static void resume() {
    }
    public static void play(String filename) {
    }
    public static void startPlay() {
        if(recording) {
            return;
        }
        OI.togglePlayMode();
        SmartDashboard.putString("Logger", "Playing");
        playing = true;
        try {
            in.reset();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        timer.reset();
        timer.start();
    }
    public static void stopPlay() {
        OI.togglePlayMode();
        timer.reset();
        playing = false;

    }
    public static void togglePlay() {
        if(recording) {
            return;
        }
        if(!playing) {
            startPlay();
        }  else {
            stopPlay();
        }
    }
    public static void play() {
        if(!playing) {
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
            stopPlay();
            return;
        } catch (Exception e){
            playing = false;
            stopPlay();
            e.printStackTrace(); 
            return;
        }
        SmartDashboard.putString("Logger", "Done Playing");
    }

    public static void loggingToggle() {
        if(!recording) {
            SmartDashboard.putString("Logger", "Logging");
            timer.start();
            recording = true;
            return;
        }
        else {
            SmartDashboard.putString("Logger", "Done");
            recording = false;
            timer.stop();
            return;
        }
    }

    public static void log(int commandName, String content ) {
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
