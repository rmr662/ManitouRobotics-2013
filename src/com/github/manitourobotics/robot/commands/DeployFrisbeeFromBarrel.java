package com.github.manitourobotics.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author robotics
 */
public class DeployFrisbeeFromBarrel extends CommandGroup {
    
    public DeployFrisbeeFromBarrel() {
        // Timeouts only specify how long to hold the servo for
        addSequential(new MoveServoUp(0.5));
        addSequential(new MoveServoDown(0.5));
    }
}
