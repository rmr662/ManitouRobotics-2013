/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.manitourobotics.robot.commands;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Justin
 */
public class AcquisitionStop extends CommandBase {
    
    public AcquisitionStop() {
        // Use requires() here to declare subsystem dependencies
        requires(acquisition);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        acquisition.setAcquisitionMotors(Relay.Value.kOff);
        SmartDashboard.putString("Acquisition", "Stopped");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
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
