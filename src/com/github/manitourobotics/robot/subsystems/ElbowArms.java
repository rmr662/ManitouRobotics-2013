/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.manitourobotics.robot.subsystems;

import com.github.manitourobotics.robot.RobotMap;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author robotics
 */
//public class ElbowArms extends PIDSubsystem {
public class ElbowArms extends Subsystem {

    private static final double Kp = 0.0;
    private static final double Ki = 0.0;
    private static final double Kd = 0.0;

    private static final int MOTOR_STOP = 0;
    
    Jaguar elbowArmsMotor = new Jaguar(RobotMap.PWM_ELBOW_ARMS);

    public void setElbowArmSpeed(double speed) {
        elbowArmsMotor.set(speed);
    }
    // Initialize your subsystem here
    public ElbowArms() {
        //super("ElbowArms", Kp, Ki, Kd);

        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return 0.0;
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    }
}
