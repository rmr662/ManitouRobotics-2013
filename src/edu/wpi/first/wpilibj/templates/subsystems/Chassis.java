/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.RobotMap;
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
        drive.tankDrive(OI.madcatz.getRawAxis(RobotMap.MADCATZ_AXIS_LEFT_JOYSTICK_Y), OI.madcatz.getRawAxis(RobotMap.MADCATZ_AXIS_RIGHT_JOYSTICK_Y));
    }
}