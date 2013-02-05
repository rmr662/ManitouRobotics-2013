/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.manitourobotics.robot;

import com.sun.squawk.microedition.io.FileConnection;
import edu.wpi.first.wpilibj.Timer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import javax.microedition.io.Connector;

/**
 *
 * @author robotics
 */
public class Logger {
    private static boolean recording;
    private static String pausedFilename;
    private static int pausedFileReadPosition;
    private static DataInputStream in;
    private static DataOutputStream out;
    private static Timer timer = new Timer();
    private static FileConnection fileConnection;

    public static final int SMALL_ARMS = 1;
    public static final int SHOULDER_ARMS = 2;
    public static final int ELBOW_ARMS = 3;

    public static final int UP = 1;
    public static final int DOWN = 2;
    public static final int STOP = 3;

    public Logger() {
        try {
            fileConnection = (FileConnection) Connector.open("file://test.txt", Connector.READ_WRITE);
            out = fileConnection.openDataOutputStream();
            in = fileConnection.openDataInputStream();
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
    public static void play() {
        String data;
        try {
            while (true)
                data = in.readUTF();
            } catch (Exception e){
            e.printStackTrace(); 
            }
    }
    public static void stop() {
    }

    public static void loggingToggle() {
        if(recording) {
            //stopLogging
        }
        if(!recording) {
            startLogging();
        }
    }
    public static void startLogging() {
        timer.start();
        if(recording) {
            return; 
        }
        recording = true;
    }
    
    public static void stopLogging() {
        timer.stop();
        
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
