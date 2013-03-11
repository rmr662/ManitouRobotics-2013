package com.github.manitourobotics.robot.subsystems;

import com.github.manitourobotics.robot.RobotMap;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SmallArms extends Subsystem {
    Jaguar smallArmsMotor = new Jaguar(RobotMap.PWM_SMALL_ARMS); 
    private double moveSpeed = 1;


    private final double MIN_ANGLE = 0;
    private final double MAX_ANGLE = 90;
    private final double OFFSET = 230; // voltage to angle is off by a constant

    private boolean encoderEnabled = false;

    // voltage yet to be turned into degrees
    AnalogChannel absAngle = new AnalogChannel(RobotMap.ANALOG_T_REX_ENCODER);

    public SmallArms(boolean encoderEnabled) {
        this.encoderEnabled = encoderEnabled;
    }
    public SmallArms() {
    }

    public double getAngle() {
        double angle = absAngle.getVoltage() * -1 * 360/4.9 + OFFSET ;  // -1 is because the voltage increases as the angle decreases
        SmartDashboard.putNumber("small arms voltage", absAngle.getVoltage());
        SmartDashboard.putNumber("small arms Angle", angle);
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
