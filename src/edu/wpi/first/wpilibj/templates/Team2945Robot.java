/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.AcquisitionForward;
import edu.wpi.first.wpilibj.templates.commands.AcquisitionReverse;
import edu.wpi.first.wpilibj.templates.commands.AcquisitionStop;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import edu.wpi.first.wpilibj.templates.commands.ExampleCommand;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Team2945Robot extends IterativeRobot {

    Command autonomousCommand;

    // Not final because I need to enable it for the test() method
    private static boolean DEBUG_ALL = false;
    private static final boolean DEBUG_CHASSIS = false;
    private static final boolean DEBUG_CAMERA = false;

    /** 
     * Debugging flagging:
     * Called before an optional output to either the output console or the SmartDashboard. Can be personalized for subsystems see 
     * 
     * If the code is in debugging mode(always in the test method), then all subsystems will have debug output.
     * 
     * @param type specifies if the debugging check is looking for only a certain part of the code. Any arguments should be a lower case version of the subsystem: "chassis"
     * @return true if debugging is enabled for this chunk of code. Return false if not.
     */
    public static boolean isDebugging(String type) {
        
        // Allows me to putdata to the SmartDashboard without displaying something if debugging is false
        boolean debug = false;

        if(DEBUG_ALL) {
            SmartDashboard.putString("Debugging:", "ALL");
            debug = true;
        }
        else if( type.equals("chassis") && DEBUG_CHASSIS) {
            debug = true;	
        }
        else if( type.equals("camera") && DEBUG_CAMERA ) {
            debug = true;
        }
        else {
            debug = false;
        }

        if(debug) {
            SmartDashboard.putString("Debugging:", type);
        }

        return debug;
    }

    /**
     * Supplying no arguments to the isDebugging() method simply checks if debugging is enabled for all subsystems
     * 
     * @return true if the DEBUG_ALL flag is enabled. false if the DEBUG_ALL flag is disabled
     */
    public static boolean isDebugging() {
	if(DEBUG_ALL) {
		SmartDashboard.putString("Debugging:", "ALL");
		return true;
	}

	return false;
    }
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        // instantiate the command used for the autonomous period
        autonomousCommand = new ExampleCommand();

        // Initialize all subsystems
        CommandBase.init();
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
        getWatchdog().setEnabled(true);
        autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        getWatchdog().feed();
    }

    public void teleopInit() {
	// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        autonomousCommand.cancel();
        getWatchdog().setEnabled(true);
        OI.setupControls();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        getWatchdog().feed();

        OI.executeControls();
        OI.displayControls();
        
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testIint() {
        getWatchdog().setEnabled(false);
    }
    public void testPeriodic() {
        getWatchdog().feed();
        LiveWindow.run();
        SmartDashboard.putData(new AcquisitionForward());
        SmartDashboard.putData(new AcquisitionReverse());
        SmartDashboard.putData(new AcquisitionStop());

    }
}
