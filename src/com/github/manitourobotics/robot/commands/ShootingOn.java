package com.github.manitourobotics.robot.commands;

import com.github.manitourobotics.robot.RobotMap;
import edu.wpi.first.wpilibj.Relay;

public class ShootingOn extends CommandBase {
    
    public ShootingOn() {
        // Use requires() here to declare subsystem dependencies
        requires(shooting);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        shooting.setShootingMotors(Relay.Value.kForward);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(oi.getMode() == RobotMap.MODE_AUTONOMOUS || oi.getMode() == RobotMap.MODE_SHOOTING) {
            return false;
        }
        else 
            return true;
    }

    // Called once after isFinished returns true
    protected void end() {
        new ShootingOff().start();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
