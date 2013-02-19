/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.manitourobotics.robot.commands;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.github.manitourobotics.robot.OI;
import com.github.manitourobotics.robot.RobotMap;
import com.github.manitourobotics.robot.Team2945Robot;
import com.github.manitourobotics.robot.subsystems.Chassis;

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

        double leftValue = OI.madcatz.getRawAxis(RobotMap.MADCATZ_AXIS_MANUAL_DRIVE_TRAIN_LEFT);
        double rightValue = OI.madcatz.getRawAxis(RobotMap.MADCATZ_AXIS_MANUAL_DRIVE_TRAIN_RIGHT);
        
        // robot moving backward; multiply by -1 to move forward
        drive.tankDrive(leftValue * -1 , rightValue * -1);
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
        if(oi.getMode() == RobotMap.MODE_SHOOTING) {
            return false;
        } else
        {
            return true;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
            chassis.getRobotDrive().tankDrive(0, 0); // stop the motors
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }

}
