/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.manitourobotics.robot;

/**
 *
 * @author robotics
 */
public class Logger {
    private static boolean loggingEnabled;
    private static String pausedFilename;
    private static int pausedFileReadPosition;

    public static boolean getLoggingEnabled() {
        return loggingEnabled;
    }
    public static void setLoggingEnabled(boolean loggingEnabled) {
        Logger.loggingEnabled = loggingEnabled;
    }
    public static void resume() {
    }
    public static void play(String filename) {

    }
    public static void stop() {
    }
    
    
}
