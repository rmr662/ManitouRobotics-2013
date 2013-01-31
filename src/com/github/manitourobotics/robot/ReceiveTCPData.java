/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.manitourobotics.robot;

import com.sun.squawk.io.BufferedReader;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import java.io.*;
import javax.microedition.io.*;

/**
 *
 * @author robotics
 */
public class ReceiveTCPData {
    SocketConnection socketConnect;
    InputStream inputStream;
    DataInputStream data;
    BufferedReader in;

    public ReceiveTCPData() {
        try {
            
        socketConnect = (SocketConnection) Connector.open("socket://10.29.45.4:1180");
        inputStream = socketConnect.openInputStream();

        } catch ( IOException ex) {
            ex.printStackTrace();
        }
    }

    public void grabData() {
        try {
            int b;
            while ((b = inputStream.read()) != -1) {
                SmartDashboard.putNumber("tcpdata", b);
                System.out.println(b);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        }

    
}
