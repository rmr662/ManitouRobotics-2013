/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.manitourobotics.robot.network;

import com.sun.squawk.io.BufferedReader;
import edu.wpi.first.wpilibj.networktables2.stream.SocketConnectionStream;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import java.io.*;
import javax.microedition.io.*;

/**
 *
 * @author robotics
 */
public class ReceiveTCPData {
    SocketConnection connection;
    InputStream inputStream;
    BufferedReader in;
    String data;

    private boolean isConnected = false;

    public ReceiveTCPData() {
        connectToSocket();
    }

    public void connectToSocket() {
        try {
            
        connection = (SocketConnection) Connector.open("socket://10.29.45.4:1180");
        in = new BufferedReader(new InputStreamReader( connection.openInputStream()));
        isConnected = true;

        } catch ( IOException ex) {
            isConnected = false;
            try {
                connection.close();
            } catch (Exception ex1) {
                ex1.printStackTrace();
            }
            ex.printStackTrace();
            SmartDashboard.putString("Socket Status", "Dead");
        }
    }

    public String grabData() {
        if (!isConnected) {
            connectToSocket();
            return "";
        }
        try {
                data = in.readLine();
                return data;
        } catch (IOException ex) {
            try {
                isConnected = false;
                connection.close();
        } catch (IOException ex1) {
                ex1.printStackTrace();
        }
        ex.printStackTrace();
        SmartDashboard.putString("Socket Status", "exception recieving data");
        return "";

        }
    }
}
    