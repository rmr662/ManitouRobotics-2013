package com.github.manitourobotics.robot.subsystems;

import com.github.manitourobotics.robot.RobotMap;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SmallArms extends Subsystem {
    Relay smallArmsMotor = new Relay(RobotMap.RELAY_SMALL_ARMS); 


    private final double DEFAULT_ANGLE = 45; // default angle of the arm relative to the ground
    private final double MIN_ANGLE = 45;
    private final double MAX_ANGLE = 95;

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
        double angle = absAngle.getVoltage() * 360/4.9; 
        SmartDashboard.putNumber("Angle", angle);
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
        smallArmsMotor.set(Relay.Value.kForward);;
    }
    public void moveSmallArmsDown() {
        if(encoderEnabled) {
            double angle = getAngle();
            if(angle < MIN_ANGLE) {
                stopSmallArms();
                return;
            }
        }
        smallArmsMotor.set(Relay.Value.kReverse);
    }

    public void stopSmallArms() {
        smallArmsMotor.set(Relay.Value.kOff);
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
