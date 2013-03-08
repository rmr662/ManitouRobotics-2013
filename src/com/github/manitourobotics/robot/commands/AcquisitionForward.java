/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.manitourobotics.robot.commands;

import com.github.manitourobotics.robot.Team2945Robot;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class AcquisitionForward extends CommandBase {
    
    // The isFinished method will differ depending weather this command is on a 
    // timer for usually autonomous things
    private boolean isUsingTimer = false;

    public AcquisitionForward() {
        // Use requires() here to declare subsystem dependencies
        requires(acquisition);
    }

    public AcquisitionForward(double timeout) {
        this();
        setTimeout(timeout);
        isUsingTimer = true;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        acquisition.setAcquisitionMotors(Relay.Value.kForward);
        SmartDashboard.putString("Acquisition", "Forward");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {      
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(isUsingTimer) {
            return isTimedOut();
        } else
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
