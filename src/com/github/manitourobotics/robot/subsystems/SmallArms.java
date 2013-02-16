package com.github.manitourobotics.robot.subsystems;

import com.github.manitourobotics.robot.RobotMap;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;

public class SmallArms extends Subsystem {
    Jaguar smallArmsMotor = new Jaguar(RobotMap.PWM_SMALL_ARMS); 
    private double moveSpeed = 1;


    private final double DEFAULT_ANGLE = 45; // default angle of the arm relative to the ground
    private final double MIN_ANGLE = 45;
    private final double MAX_ANGLE = 95;
    private final double ANGLE_CHANGE_PER_REVOLUTION = 2;
    // to be tested
    private final double MOVEMENT_PER_REVOLUTION = 2;

    private boolean encoderEnabled = false;
    double currentAngle = DEFAULT_ANGLE;

    // voltage yet to be turned into degrees
    AnalogChannel absAngle = new AnalogChannel(RobotMap.ANALOG_T_REX_ENCODER);

    public SmallArms(boolean encoderEnabled) {
        this.encoderEnabled = encoderEnabled;
    }
    public SmallArms() {
    }

    public double getAngle() {
        double angle = absAngle.getVoltage() * 360/4.1; 
        return angle;
    }

    public void moveSmallArmsUp() {
        if(encoderEnabled) {
            double angle = getAngle();
            if(angle > MAX_ANGLE) {
                stopSmallArms();
                return;
            }
        }
        smallArmsMotor.set(moveSpeed);
    }
    public void moveSmallArmsDown() {
        if(encoderEnabled) {
            double angle = getAngle();
            if(angle < MIN_ANGLE) {
                stopSmallArms();
                return;
            }
        }
        smallArmsMotor.set(moveSpeed * -1);
    }

    public void stopSmallArms() {
        smallArmsMotor.set(0);
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
