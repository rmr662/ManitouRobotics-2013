/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author robotics
 */
public class Camera extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    AxisCamera camera;

    public Camera() {
        try {
            camera = AxisCamera.getInstance("10.29.45.11");
            camera.writeResolution(AxisCamera.ResolutionT.k320x240);
            camera.writeMaxFPS(18);
            System.out.print("foo");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void initDefaultCommand() {

        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
