/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.manitourobotics.robot.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.github.manitourobotics.robot.RobotMap;

public class ShootingTrigger extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private Relay acquisitionMotorTop = new Relay(RobotMap.RELAY_PUSH_FRISBEE);
    
    public void setAcquisitionMotors(Relay.Value value) {
        acquisitionMotorTop.set(value);
    }
    
    public ShootingTrigger() {
        setAcquisitionMotors(Relay.Value.kOn);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
