/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.Team2945Robot;
import edu.wpi.first.wpilibj.templates.commands.ManualDriveTrainControl;

/**
 *
 * @author Justin
 */
public class Chassis extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    Jaguar leftDriveTrainMotor = new Jaguar(RobotMap.PWM_LEFT_DRIVE_TRAIN_MOTOR);
    Jaguar rightDriveTrainMotor = new Jaguar(RobotMap.PWM_RIGHT_DRIVE_TRAIN_MOTOR);
    RobotDrive drive = new RobotDrive(leftDriveTrainMotor, rightDriveTrainMotor);
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new ManualDriveTrainControl());
    }
    
    public void manualDriveTrainControl() {
        double leftValue = OI.madcatz.getRawAxis(RobotMap.MADCATZ_AXIS_LEFT_JOYSTICK_Y);
        double rightValue = OI.madcatz.getRawAxis(RobotMap.MADCATZ_AXIS_RIGHT_JOYSTICK_Y);
        drive.tankDrive(leftValue, rightValue);
        SmartDashboard.putNumber(("Left Drive Drain Control"), leftValue);
        SmartDashboard.putNumber(("Right Drive Drain Control"), rightValue);
        if (Team2945Robot.DEBUG_ALL || Team2945Robot.DEBUG_CHASSIS) {
            SmartDashboard.putNumber(("madcatz raw axis 1"), OI.madcatz.getRawAxis(RobotMap.MADCATZ_AXIS_LEFT_JOYSTICK_X));
            SmartDashboard.putNumber(("madcatz raw axis 2"), OI.madcatz.getRawAxis(RobotMap.MADCATZ_AXIS_LEFT_JOYSTICK_Y));
            SmartDashboard.putNumber(("madcatz raw axis 3"), OI.madcatz.getRawAxis(3));
            SmartDashboard.putNumber(("madcatz raw axis 4"), OI.madcatz.getRawAxis(RobotMap.MADCATZ_AXIS_RIGHT_JOYSTICK_X));
            SmartDashboard.putNumber(("madcatz raw axis 5"), OI.madcatz.getRawAxis(RobotMap.MADCATZ_AXIS_RIGHT_JOYSTICK_Y));
        }
    }
}
