/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.manitourobotics.robot.subsystems;

import com.github.manitourobotics.robot.RobotMap;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author robotics
 */
public class BarrelStopper extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    Servo barrelServo = new Servo(RobotMap.PWM_SERVO_BARREL_STOPPER);

    private final double servoUpValue = 0.5;
    private final double servoDownValue = 0;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public void setServoUp() {
        barrelServo.set(servoUpValue); 
    }

    public void setServoDown () {
        barrelServo.set(servoDownValue);

    }
}

