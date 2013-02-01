/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.manitourobotics.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author robotics
 */
public class MoveBarrelServoUp extends CommandBase {
    
    // The purpose of the timeout is to allow this command to be added to a command group and 
    // Not execute the next command right away
    private double timeout;

    // timeoutEnabled allows one to call the command without a timeout by changing the 
    // isFinished conditions
    private boolean timeoutEnabled = false;

    public MoveBarrelServoUp() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(barrelStopper);
    }

    public MoveBarrelServoUp(double timeout) {
        this();
        timeoutEnabled = true;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        barrelStopper.setServoUp();
        SmartDashboard.putString("barrelStopper", "Up");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (timeoutEnabled && isTimedOut()) {
            return true;
        } else 
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
