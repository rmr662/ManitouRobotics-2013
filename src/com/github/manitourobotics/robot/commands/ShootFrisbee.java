package com.github.manitourobotics.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author robotics
 */
public class ShootFrisbee extends CommandGroup {
    
        private static final double moveInterval = 0.1;
    public ShootFrisbee() {
        addSequential(new ShootingTriggerForward(moveInterval));
        addSequential(new ShootingTriggerReverse(moveInterval));
        addSequential(new ShootingTriggerStop());
        addSequential(new DeployFrisbeeFromBarrel()); // A new frisbee should be 
        // added to the barrel
    }
}
