
package com.github.manitourobotics.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.DigitalIOButton;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.github.manitourobotics.robot.commands.AcquisitionForward;
import com.github.manitourobotics.robot.commands.AcquisitionReverse;
import com.github.manitourobotics.robot.commands.AcquisitionStop;
import com.github.manitourobotics.robot.commands.DriveStop;
import com.github.manitourobotics.robot.commands.ManualDriveTrainControl;
import com.github.manitourobotics.robot.commands.ElbowControl;
import com.github.manitourobotics.robot.commands.ShoulderControl;
import com.github.manitourobotics.robot.commands.ManualTilterControl;
import com.github.manitourobotics.robot.commands.MoveSmallArmsDown;
import com.github.manitourobotics.robot.commands.MoveSmallArmsUp;
import com.github.manitourobotics.robot.commands.ShootFrisbee;
import com.github.manitourobotics.robot.commands.ShootingOff;
import com.github.manitourobotics.robot.commands.ShootingOn;
import com.github.manitourobotics.robot.commands.StopSmallArms;
import com.github.manitourobotics.robot.subsystems.TilterOrArms;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    public static Joystick madcatz = new Joystick(RobotMap.JOYSTICK_MADCATZ);
    public static Joystick logitech = new Joystick(RobotMap.JOYSTICK_LOGITECH);
    private static boolean previousRecordButtonState;
    private static boolean previousPlayButtonState;
    private static boolean previousModeButtonState;
    private static boolean previousPauseButtonState;
    private static boolean previousFrisbeeButtonState;

    private static boolean pauseButtonState;
    private static boolean playButtonState;
    private static boolean loggingButtonState;
    private static boolean modeButtonState;
    private static boolean frisbeeButtonState;
    private static boolean armUpButtonState;
    private static boolean armDownButtonState;
    
    
    private static int previousMode;
    private static int mode;
    private static Button buttonMode = new JoystickButton(logitech, RobotMap.LOGITECH_BUTTON_MODE_SWITCH);
    
    // Create a small deadzone around zero because the madcatz joystick is slightly broken
    public static double getAxisAdjusted(Joystick joystick, int axisNumber) {
        double rawAxisValue = joystick.getRawAxis(axisNumber);
        double finalAxisValue;

        // dead zone between -.1 and .1
        if( rawAxisValue < .1 && rawAxisValue > -.1 ) {
            finalAxisValue = 0;
        }
        else {
            finalAxisValue = rawAxisValue;
        }

        return finalAxisValue;
    }
    public static void togglePlayMode() {
        if(mode == RobotMap.MODE_PLAY) {
            mode = previousMode;
        } else {
            previousMode = mode;
            mode = RobotMap.MODE_PLAY;
        }
    }
    public static int getMode() {
        return mode;
    }
    public OI () {
            // Refresh mode
            String modeName="None1";
            SmartDashboard.putString("Mode", modeName);
    }

    //Reset/set controls every teleop init
    public static void setupControls() {
        mode = RobotMap.MODE_SHOOTING; // Shooting always starts
        setupShootingControls();
    }

    public static void executeControls() {
        if(mode == RobotMap.MODE_SHOOTING) {
            executeShootingControls();
        }
        else if(mode == RobotMap.MODE_CLIMBING) {
            executeClimbingControls();
        }
        modeButtonState = logitech.getRawButton(RobotMap.LOGITECH_BUTTON_MODE_SWITCH);
        if(modeButtonState && !previousModeButtonState) { 
            // if the button is just pressed not hold
            toggleClimbingShootingMode();
        }
        previousModeButtonState = modeButtonState;

        pauseButtonState = madcatz.getRawButton(RobotMap.MADCATZ_BUTTON_RB);
        if(pauseButtonState && !previousPauseButtonState) {
            Logger.togglePause();
        }
        previousPauseButtonState = pauseButtonState;

    }

    private static void executeClimbingControls() {
        // nothing yet
        armDownButtonState = madcatz.getRawButton(RobotMap.MADCATZ_BUTTON_A);
        armUpButtonState = madcatz.getRawButton(RobotMap.MADCATZ_BUTTON_X);
        if(armDownButtonState) {
            Scheduler.getInstance().add(new MoveSmallArmsDown());
        } else if(armUpButtonState) {
            Scheduler.getInstance().add(new MoveSmallArmsUp());
        } else if (!armUpButtonState && !armDownButtonState ){
            Scheduler.getInstance().add(new StopSmallArms());
        }


        playButtonState = madcatz.getRawButton(RobotMap.MADCATZ_BUTTON_B);
        if(playButtonState && !previousPlayButtonState) {
            Logger.togglePlayback();
        }
        loggingButtonState = madcatz.getRawButton(RobotMap.MADCATZ_BUTTON_Y);
        if(loggingButtonState && !previousRecordButtonState) {
            Logger.loggingToggle();
        }
        previousRecordButtonState = loggingButtonState;
        previousPlayButtonState = playButtonState;
    }

    private static void executeShootingControls() {

        frisbeeButtonState = logitech.getRawButton(RobotMap.LOGITECH_BUTTON_FRISBEE_PUSH);
        if(frisbeeButtonState && !previousFrisbeeButtonState) {
            Scheduler.getInstance().add(new ShootFrisbee());
        }
        previousFrisbeeButtonState = frisbeeButtonState;

        if(logitech.getRawButton(RobotMap.LOGITECH_BUTTON_SHOOTER_OFF)) {
            Scheduler.getInstance().add(new ShootingOff());
        }
        if(logitech.getRawButton(RobotMap.LOGITECH_BUTTON_SHOOTER_ON)) {
            Scheduler.getInstance().add(new ShootingOn());
        }

    }

    public static void displayControls() {

        // since mode is an integer, I need to convert that integer to something meaningful to output to the SmartDashboard
        String modeName = "";
        if(mode == RobotMap.MODE_SHOOTING) {
            modeName="Shooting";
        }
        else if(mode == RobotMap.MODE_CLIMBING) {
            modeName="Climbing";
        }
        else if (mode == RobotMap.MODE_AUTONOMOUS){
            modeName="Autonomous";
        } else if (mode == RobotMap.MODE_PLAY){
            modeName="Playing";
        } else {
            modeName="None2"; // this should never happen
        }

        SmartDashboard.putString("Mode", modeName);
    }

    public static void toggleClimbingShootingMode() {
        // switch current modes
        if(mode == RobotMap.MODE_SHOOTING) {
            mode=RobotMap.MODE_CLIMBING;
            setupClimbingControls();
        }
        else if(mode == RobotMap.MODE_CLIMBING) {
            mode=RobotMap.MODE_SHOOTING;
            setupShootingControls();
        }
    }

    public static void setupClimbingControls() {
        Scheduler.getInstance().add(new DriveStop());

        // controls in command instead of oi
        Scheduler.getInstance().add(new ElbowControl());
        Scheduler.getInstance().add(new ShoulderControl());

    }

    private static void setupShootingControls() {
        Scheduler.getInstance().add(new StopSmallArms());

        Scheduler.getInstance().add(new ManualDriveTrainControl()); // controls 
        // in command instead of oi
        Scheduler.getInstance().add(new ManualTilterControl()); 

        Scheduler.getInstance().add(new ShootingOn()); // The shooting motors 
        // should always be on in shooting mode
    }

    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // Another type of button you can create is a DigitalIOButton, which is
    // a button or switch hooked up to the cypress module. These are useful if
    // you want to build a customized operator interface.
    // Button button = new DigitalIOButton(1);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}

