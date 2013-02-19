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
//public class ElbowArms extends PIDSubsystem {
public class ElbowArms extends Subsystem {

    private static final double Kp = 0.0;
    private static final double Ki = 0.0;
    private static final double Kd = 0.0;

    private final int MOTOR_STOP = 0;
    
    Jaguar elbowArmsMotor = new Jaguar(RobotMap.PWM_ELBOW_ARMS);

    Encoder encoder = new Encoder(RobotMap.IO_ELBOW_ENCODER_A, RobotMap.IO_ELBOW_ENCODER_B);
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
    public ElbowArms(boolean encoderEnabled) {
        this.encoderEnabled = encoderEnabled;
        encoder.start();
    }

    public void setElbowArmSpeed(double speed) {
        if(encoderEnabled) {
            currentAngle = DEFAULT_ANGLE + getTotalAngleChange();
            SmartDashboard.putNumber("currentAngle", currentAngle);

            if(currentAngle <= MIN_ANGLE && speed > 0) { 
                elbowArmsMotor.set(0);
                return;
            } else if(currentAngle >= MAX_ANGLE && speed < 0) { 
                elbowArmsMotor.set(0);
                return;
            }
        }
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
