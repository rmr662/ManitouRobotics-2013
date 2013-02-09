/*
 *  * To change this template, choose Tools | Templates
 *  * and open the template in the editor.
 *  */
package com.github.manitourobotics.robot.commands;

import com.github.manitourobotics.robot.Logger;

/**
 *  *
 *  * @author robotics
 *  */
public class MoveSmallArmsUp extends CommandBase {
        
    public MoveSmallArmsUp() {
                // Use requires() here to declare subsystem dependencies
                // eg. requires(chassis);
                requires(smallArms);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        smallArms.moveSmallArmsUp();
        Logger.logCheck(Logger.SMALL_ARMS, Integer.toString(Logger.UP));
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

        // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
                return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
