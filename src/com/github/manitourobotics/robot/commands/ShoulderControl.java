/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.manitourobotics.robot.commands;

import com.github.manitourobotics.robot.Logger;
import com.github.manitourobotics.robot.OI;
import com.github.manitourobotics.robot.RobotMap;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author robotics
 */
public class ShoulderControl extends CommandBase {
    
    boolean manualControl;
    double speed;

    public ShoulderControl() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(tilterOrArms);
        manualControl = true;
    }
    public ShoulderControl(double speed) {
        this();
        manualControl = false;
        this.speed = speed;
    }


    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(manualControl) {
            speed = oi.madcatz.getRawAxis(RobotMap.MADCATZ_AXIS_SHOULDER_ARM_CONTROL);
        } // else speed is already set
        Logger.log(Logger.SHOULDER_ARMS, Double.toString(speed));
        tilterOrArms.setTilterOrArmsSpeed(speed);
        SmartDashboard.putString("shoulderControl", Double.toString(speed));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(!manualControl) {
            return false;
        } 
        if(oi.getMode() == RobotMap.MODE_CLIMBING) {
            return false;
        } else
        {
            return true;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
        if(manualControl) { // this would cause a jerking motion every time in non-manualcontrol
            tilterOrArms.setTilterOrArmsSpeed(0);
        }
        SmartDashboard.putString("shoulderControl", "Done");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
