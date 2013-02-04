/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.manitourobotics.robot;

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
        isConnected = true;
        in = new BufferedReader(new InputStreamReader( connection.openInputStream()));

        } catch ( IOException ex) {
            ex.printStackTrace();
            SmartDashboard.putString("Socket Status", "Dead");
        }
    }

    public String grabData() {
        if (!isConnected) {
            connectToSocket();
            return null;
        }
        try {
                data = in.readLine();
                return data;
        } catch (IOException ex) {
            isConnected = false;
            connectToSocket();

            ex.printStackTrace();
            SmartDashboard.putString("Socket Status", "exception recieving data");
            return null;
        }
    }
}
    