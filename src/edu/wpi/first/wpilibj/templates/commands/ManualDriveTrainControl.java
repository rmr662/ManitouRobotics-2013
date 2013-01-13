/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.Team2945Robot;
import edu.wpi.first.wpilibj.templates.subsystems.Chassis;

/**
 *
 * @author Justin
 */
public class ManualDriveTrainControl extends CommandBase {
    
    
    public ManualDriveTrainControl() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        
        requires(chassis);
       
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        RobotDrive drive = chassis.getRobotDrive();
        double leftValue = OI.madcatz.getRawAxis(RobotMap.MADCATZ_AXIS_LEFT_JOYSTICK_Y);
        double rightValue = OI.madcatz.getRawAxis(RobotMap.MADCATZ_AXIS_RIGHT_JOYSTICK_Y);
        drive.tankDrive(leftValue, rightValue);
        SmartDashboard.putNumber(("Left Drive Drain Control"), leftValue);
        SmartDashboard.putNumber(("Right Drive Drain Control"), rightValue);
        if (Team2945Robot.isDebugging("chassis")) {
            SmartDashboard.putNumber(("madcatz raw axis 1"), OI.madcatz.getRawAxis(RobotMap.MADCATZ_AXIS_LEFT_JOYSTICK_X));
            SmartDashboard.putNumber(("madcatz raw axis 2"), OI.madcatz.getRawAxis(RobotMap.MADCATZ_AXIS_LEFT_JOYSTICK_Y));
            SmartDashboard.putNumber(("madcatz raw axis 3"), OI.madcatz.getRawAxis(3));
            SmartDashboard.putNumber(("madcatz raw axis 4"), OI.madcatz.getRawAxis(RobotMap.MADCATZ_AXIS_RIGHT_JOYSTICK_X));
            SmartDashboard.putNumber(("madcatz raw axis 5"), OI.madcatz.getRawAxis(RobotMap.MADCATZ_AXIS_RIGHT_JOYSTICK_Y));
	}
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
