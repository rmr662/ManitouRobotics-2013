/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.manitourobotics.robot.commands;

import com.github.manitourobotics.robot.OI;
import com.github.manitourobotics.robot.RobotMap;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author robotics
 */
public class ManualTilterControl extends CommandBase {
    
    public ManualTilterControl() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(tilterOrArms);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double speed = OI.getAxisAdjusted(OI.logitech, RobotMap.LOGITECH_AXIS_TILTER);
        tilterOrArms.setTilterOrArmsSpeed(speed);
        SmartDashboard.putString("TilterControl", Double.toString(speed));

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(OI.getMode() == RobotMap.MODE_SHOOTING) {
            return false;
        } else
        {
            return true;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
        tilterOrArms.setTilterOrArmsSpeed(0);
        SmartDashboard.putString("TilterControl", "Done");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
