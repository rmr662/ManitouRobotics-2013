package com.github.manitourobotics.robot.subsystems;

import com.github.manitourobotics.robot.RobotMap;
import com.github.manitourobotics.robot.commands.StopSmallArms;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SmallArms extends Subsystem {
    Jaguar smallArmsMotor = new Jaguar(RobotMap.PWM_SMALL_ARMS); 
    private double moveSpeed = 1;


    private final double ABS_MIN_ANGLE = 0;
    private final double ABS_MAX_ANGLE = 90;

    private boolean encoderEnabled = false;
    private double baseSpeed = 0;
    private double baseVoltage = 0;
    private double baseAngle = 0;
    private double minRelAngle = 0;
    private double maxRelAngle = 0;

    // voltage yet to be turned into degrees
    AnalogChannel absAngle = new AnalogChannel(RobotMap.ANALOG_T_REX_ENCODER);

    public SmallArms(boolean encoderEnabled) {
        this.encoderEnabled = encoderEnabled;
        baseVoltage = absAngle.getVoltage();
        baseAngle = baseVoltage * 360/4.9 * -1 + 360 + 90;
         maxRelAngle = baseAngle;
         minRelAngle = baseAngle - 90;
         if(minRelAngle < 0) {
             minRelAngle = 360 - minRelAngle;
         }

    }

    private boolean isInRange(double minRelAngle, double maxRelAngle, double testAngle) {
        if( minRelAngle > maxRelAngle) {
            if(minRelAngle <= testAngle && testAngle <= 360 || testAngle <= maxRelAngle && testAngle >= 0) {
                return true;
            }
            else {
                return false;
            }
        }
            if( maxRelAngle > minRelAngle) {
                if(testAngle <= maxRelAngle && testAngle >= minRelAngle) {
                return true; 
            }
            return false;
        }

        return false;
        
    }

    private double getAbsAngle(double minRelAngle, double maxRelAngle, double testAngle) {
        if(minRelAngle > maxRelAngle && testAngle <= 360) {
            if(testAngle <= maxRelAngle) {
                return 90 - (maxRelAngle - testAngle);
            } else {
            return testAngle - minRelAngle;
            }
        }
        else {
            return maxRelAngle - testAngle;
        }

    }
    public SmallArms() {
    }



    public double getAngle() {
        double relAngle = absAngle.getVoltage() * -1 * 360/4.9 + 360 ;  // -1 is because the voltage increases as the angle decreases
        double angle = getAbsAngle(minRelAngle, maxRelAngle, relAngle);
        SmartDashboard.putNumber("small arms voltage", absAngle.getVoltage());
        SmartDashboard.putNumber("small arms Angle", angle);
        return angle;
    }

    public double getOverComeGravity(double currentAngle) {
        return -0.000074074074074*currentAngle*currentAngle-.00111111111111*currentAngle+.5;

    }

    public void moveSmallArmsUp() {
        if(encoderEnabled) {
            double angle = getAngle();
            if(angle > ABS_MAX_ANGLE) {
                stopSmallArms();
                return;
            }
           baseSpeed = getOverComeGravity(angle); 
        }
        smallArmsMotor.set( baseSpeed + moveSpeed * .25);
    }
    public void moveSmallArmsDown() {
        if(encoderEnabled) {
            double angle = getAngle();
            if(angle < ABS_MIN_ANGLE) {
                stopSmallArms();
                return;
            }
            baseSpeed = getOverComeGravity(angle);
        }
        smallArmsMotor.set(baseSpeed + moveSpeed * -1 * .25);
    }

    public void stopSmallArms() {
        if(encoderEnabled) {
            baseSpeed = getOverComeGravity(getAngle());
            baseSpeed = 0;
        }
        smallArmsMotor.set(baseSpeed);
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new StopSmallArms());
    }
}
