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
    StreamConnection streamConnection;
    InputStream inputStream;
    DataInputStream data;
    BufferedReader in;
    private boolean isConnected = false;

    public ReceiveTCPData() {
        connectToSocket();
    }

    public void connectToSocket() {
        try {
            
        streamConnection = (StreamConnection) Connector.open("socket://10.29.45.4:1180");
        inputStream = streamConnection.openInputStream();

        } catch ( IOException ex) {
            ex.printStackTrace();
            SmartDashboard.putString("Socket Status", "Dead");
        }
    }

    public void grabData() {
        if (!isConnected) {
            connectToSocket();
            return;
        }
        try {
            int b;
            if ((b = inputStream.read()) != -1) {
                SmartDashboard.putNumber("tcpdata", b);
                System.out.println(b);
                SmartDashboard.putString("Socket Status", "recieving data");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            SmartDashboard.putString("Socket Status", "exception recieving data");
        }
        }

    
}
