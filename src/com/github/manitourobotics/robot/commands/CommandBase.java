package com.github.manitourobotics.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.github.manitourobotics.robot.OI;
import com.github.manitourobotics.robot.subsystems.Camera;
import com.github.manitourobotics.robot.subsystems.Chassis;
import com.github.manitourobotics.robot.subsystems.Shooting;
import com.github.manitourobotics.robot.subsystems.Acquisition;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 * @author Author
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    // Create a single static instance of all of your subsystems
    public static Camera camera = new Camera();
    public static Chassis chassis = new Chassis();
    public static Acquisition acquisition = new Acquisition();
    public static Shooting shooting = new Shooting();

    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();

        // Show what command your subsystem is running on the SmartDashboard
        SmartDashboard.putData(camera);
        SmartDashboard.putData(chassis);
        SmartDashboard.putData(acquisition);
        SmartDashboard.putData(shooting);
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
