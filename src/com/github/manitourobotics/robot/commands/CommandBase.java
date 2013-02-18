package com.github.manitourobotics.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.github.manitourobotics.robot.OI;
import com.github.manitourobotics.robot.subsystems.Chassis;
import com.github.manitourobotics.robot.subsystems.Shooting;
import com.github.manitourobotics.robot.subsystems.ShootingTrigger;
import com.github.manitourobotics.robot.subsystems.BarrelStopper;
import com.github.manitourobotics.robot.subsystems.InnerArmsElbowJoint;
import com.github.manitourobotics.robot.subsystems.SmallOuterArms;
import com.github.manitourobotics.robot.subsystems.TilterOrInnerArmsShoulderJoint;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 * @author Author
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    // Create a single static instance of all of your subsystems
    public static Chassis chassis = new Chassis();
    public static ShootingTrigger acquisition = new ShootingTrigger();
    public static Shooting shooting = new Shooting();
    public static BarrelStopper barrelStopper = new BarrelStopper();
    public static SmallOuterArms smallArms = new SmallOuterArms(true); // encoder enabled
    public static InnerArmsElbowJoint elbowArms = new InnerArmsElbowJoint(true); // encoder enabled
    public static TilterOrInnerArmsShoulderJoint tilterOrArms = new TilterOrInnerArmsShoulderJoint(true); // encoder enabled

    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();

        // Show what command your subsystem is running on the SmartDashboard
        SmartDashboard.putData(chassis);
        SmartDashboard.putData(shooting);
        SmartDashboard.putData(smallArms);
        SmartDashboard.putData(tilterOrArms);
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
