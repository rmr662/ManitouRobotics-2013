/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.manitourobotics.robot.subsystems;

import com.github.manitourobotics.robot.RobotMap;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author robotics
 */
//public class TilterOrArms extends PIDSubsystem {
public class TilterOrArms extends Subsystem {

    private static final double Kp = 0.0;
    private static final double Ki = 0.0;
    private static final double Kd = 0.0;

    Jaguar tilterJaguar = new Jaguar(RobotMap.PWM_TILTER_OR_CENTER_ARM);
    static final int SPEED = 1;

    Encoder encoder = new Encoder(RobotMap.IO_SHOULDER_ENCODER_A, RobotMap.IO_SHOULDER_ENCODER_B);
    private final double DEFAULT_ANGLE = 45; // default angle of the arm relative to the ground
    private final double MIN_ANGLE = 45;
    private final double MAX_ANGLE = 95;
    private final double ANGLE_CHANGE_PER_REVOLUTION = 2;
    // to be tested
    private final double MOVEMENT_PER_REVOLUTION = 2;

    private boolean encoderEnabled = false;
    double currentAngle = DEFAULT_ANGLE;

    private double getTotalAngleChange () { //change from default angle
        double revolutions = encoder.get()/1024;
        double angleDifference = revolutions * 2;
        return angleDifference;
    }

    public void setTilterOrArmsSpeed(double speed) {
        if(encoderEnabled) {
            currentAngle = DEFAULT_ANGLE + getTotalAngleChange();
            SmartDashboard.putNumber("currentAngle", currentAngle);

            if(currentAngle <= MIN_ANGLE && speed > 0) { 
                tilterJaguar.set(0);
                return;
            } else if(currentAngle >= MAX_ANGLE && speed < 0) { 
                tilterJaguar.set(0);
                return;
            }
        }
        tilterJaguar.set(speed);
    }

    public TilterOrArms(boolean encoderEnabled) {
        this.encoderEnabled = encoderEnabled;
    }
    // Initialize your subsystem here
    public TilterOrArms() {
        //super("TilterOrArms", Kp, Ki, Kd);

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