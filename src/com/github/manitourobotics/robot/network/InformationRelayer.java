/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.manitourobotics.robot.network;

import com.sun.squawk.util.StringTokenizer;

/**
 *
 * @author robotics
 */
public class InformationRelayer {
    // takes information from the raspberry pi and then disects them for other command inspection
    static StringTokenizer tok;
    static String latestData;

    //distance format: <alignment/distance>_:TARGET_<type>:<distance from target>
    static final int HORIZONTAL_ALIGNMENT_FROM_TARGET = 1;
    static final int DISTANCE_FROM_TARGET = 2;
    static final int TARGET_HIGH = 1;
    static final int TARGET_MIDDLE = 2;
    static final int TARGET_LOW = 3;
    static final int NO_INFORMATION = -1000;

    private static double targetDistance = NO_INFORMATION;
    private static int targetType = NO_INFORMATION;

    public static void giveData(String data) {
        latestData = data;
        int commandType;

        tok = new StringTokenizer(latestData, ":");
        commandType = Integer.parseInt(tok.nextToken());

        if(commandType == HORIZONTAL_ALIGNMENT_FROM_TARGET || commandType == DISTANCE_FROM_TARGET) {
            targetType = Integer.parseInt(tok.nextToken());
            targetDistance = Double.parseDouble(tok.nextToken());
        }
        else {
            System.out.println("data not found");
        }

    }

    static public double getTargetDistance() {
        return targetDistance;
    }

    static public int getTargetType() {
            return targetType;
    }
    
}
