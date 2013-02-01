/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.manitourobotics.robot.commands;

import com.github.manitourobotics.robot.OI;
import com.github.manitourobotics.robot.RobotMap;

/**
 *
 * @author robotics
 */
public class ManualShoulderControl extends CommandBase {
    
    public ManualShoulderControl() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(tilterOrArms);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        tilterOrArms.setTilterOrArmsSpeed(OI.madcatz.getRawAxis(RobotMap.MADCATZ_AXIS_SHOULDER_ARM_CONTROL));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(OI.getMode() == RobotMap.MODE_CLIMBING) {
            return false;
        } else
        {
            return true;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
        tilterOrArms.setTilterOrArmsSpeed(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
