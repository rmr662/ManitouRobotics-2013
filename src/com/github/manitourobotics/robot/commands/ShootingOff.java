package com.github.manitourobotics.robot.commands;

import edu.wpi.first.wpilibj.Relay;

public class ShootingOff extends CommandBase {
    
    public ShootingOff() {
        // Use requires() here to declare subsystem dependencies
        requires(shooting);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        shooting.turnOn();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false; // returning false dispalys status on SmartDashboard
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
