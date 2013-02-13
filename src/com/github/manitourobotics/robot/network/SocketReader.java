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
public class SocketReader {
    // takes information from the raspberry pi and then disects them for other command inspection
    StringTokenizer tok;
    String latestData;

    static final int DISTANCE_FROM_TARGET = 1;

    double targetDistance;

    public void giveData(String data) {
        latestData = data;
        int commandType;

        tok = new StringTokenizer(latestData, ":");
        commandType = Integer.parseInt(tok.nextToken());

        if(commandType == DISTANCE_FROM_TARGET) {
            targetDistance = Double.parseDouble(tok.nextToken());
        }
        else {
            System.out.println("data not found");
        }

    }

    double getTargetDistance() {
        return targetDistance;
    }
    
}
