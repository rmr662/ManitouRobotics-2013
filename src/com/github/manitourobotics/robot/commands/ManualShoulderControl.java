/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.manitourobotics.robot.commands;

import com.github.manitourobotics.robot.RobotMap;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
        double speed = oi.madcatz.getRawAxis(RobotMap.MADCATZ_AXIS_SHOULDER_ARM_CONTROL);
        tilterOrArms.setTilterOrArmsSpeed(speed);
        SmartDashboard.putString("shoulderControl", Double.toString(speed));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(oi.getMode() == RobotMap.MODE_CLIMBING) {
            return false;
        } else
        {
            return true;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
        tilterOrArms.setTilterOrArmsSpeed(0);
        SmartDashboard.putString("shoulderControl", "Done");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
