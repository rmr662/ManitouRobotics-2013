/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.manitourobotics.robot.commands;

import com.github.manitourobotics.robot.OI;
import com.github.manitourobotics.robot.RobotMap;
import com.github.manitourobotics.robot.network.InformationRelayer;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author robotics
 */
public class AlignWithTarget extends CommandBase {
    
    public class TargetDistance implements PIDSource {

        public double pidGet() {
            return InformationRelayer.getTargetDistance();
        }
    }

    public class MoveRobotDrive implements PIDOutput {

        public void pidWrite(double d) {
            chassis.getRobotDrive().drive(d, 1);
        }
        
    }
    TargetDistance distance;
    MoveRobotDrive moveRobotDrive;
    boolean isFinished = false;

    PIDController controller = new PIDController(1/320, 0.0001, 0.0, distance, moveRobotDrive);

    public AlignWithTarget() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(chassis);
        isFinished = false;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        controller.enable();
        SmartDashboard.putString("Target Alignment", "on");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
       if(distance.pidGet() == InformationRelayer.NO_INFORMATION)  {
           isFinished = true;
           return;
       }
            
       controller.setSetpoint(0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(isFinished || OI.getMode() != RobotMap.MODE_SHOOTING) {
            return true;
        }
        else {
            return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
        chassis.getRobotDrive().drive(0, 0);
        controller.disable();
        SmartDashboard.putString("Target Alignment", "off");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
