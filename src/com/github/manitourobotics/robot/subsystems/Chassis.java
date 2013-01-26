/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.manitourobotics.robot.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.github.manitourobotics.robot.OI;
import com.github.manitourobotics.robot.RobotMap;
import com.github.manitourobotics.robot.Team2945Robot;
import com.github.manitourobotics.robot.commands.ManualDriveTrainControl;

/**
 *
 * @author Justin
 */
public class Chassis extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private Jaguar leftDriveTrainMotor = new Jaguar(RobotMap.PWM_LEFT_DRIVE_TRAIN_MOTOR);
    private Jaguar rightDriveTrainMotor = new Jaguar(RobotMap.PWM_RIGHT_DRIVE_TRAIN_MOTOR);
    private RobotDrive drive = new RobotDrive(leftDriveTrainMotor, rightDriveTrainMotor);

    public RobotDrive getRobotDrive() {
	    return drive;
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        //setDefaultCommand(new ManualDriveTrainControl());
    }
}
