/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.Team2945Robot;

/**
 *
 * @author Justin
 */
public class Shooting extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    private Relay frontMotor = new Relay(RELAY_SHOOTER_MOTOR_FRONT)

    public Shooting() {
        // The shootings should never go backwards
        Relay.setDirection(Relay.Direction.kForward)    
    }

    public void setShootingMotors(Relay.Value value) {
        frontMotor.set(value)
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new ShootingOn())
        /* setDefaultCommand(new ShootingOff()) */
    }
}
