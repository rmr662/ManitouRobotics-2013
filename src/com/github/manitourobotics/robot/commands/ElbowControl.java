/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.manitourobotics.robot.commands;

import com.github.manitourobotics.robot.Logger;
import com.github.manitourobotics.robot.RobotMap;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author robotics
 */
public class ElbowControl extends CommandBase {
    
    boolean manualControl;
    double speed;

    public ElbowControl() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(elbowArms);
        manualControl = true;
    }

    public ElbowControl(double speed) {
        this();
        manualControl = false;
        this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(manualControl) {
            speed = oi.madcatz.getRawAxis(RobotMap.MADCATZ_AXIS_INNER_ARMS_ELBOW_CONTROL);
        }
        Logger.logCheck(Logger.ELBOW_ARMS, Double.toString(speed));
        elbowArms.setElbowArmSpeed(speed);
        SmartDashboard.putString("elbowControl", Double.toString(speed));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(!manualControl) {
            return false;
        } 
        if(oi.getMode() == RobotMap.MODE_CLIMBING) {
            return false;
        } else
        {
            return true;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
        if(manualControl) {
            elbowArms.setElbowArmSpeed(0);
        }
        SmartDashboard.putString("elbowControl", "Done");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
