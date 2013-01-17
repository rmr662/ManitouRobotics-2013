package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static final int leftMotor = 1;
    // public static final int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1;

    // two modes
    public static final int MODE_SHOOTING = 1;
    public static final int MODE_CLIMBING = 2;
    
    //joystick/controller ports
    public static final int JOYSTICK_MADCATZ = 1;
    public static final int JOYSTICK_LOGITECH = 2;
    
    // -- Madcatz -- \\
    // Madcatz controller mapping uses getRawButton()
    public static final int MADCATZ_BUTTON_A = 1;
    public static final int MADCATZ_BUTTON_B = 2;
    public static final int MADCATZ_BUTTON_X = 3;
    public static final int MADCATZ_BUTTON_Y = 4;
    public static final int MADCATZ_BUTTON_LB = 5;
    public static final int MADCATZ_BUTTON_RB = 6;

    // Madcatz axes mapping uses getRawAxis()
    public static final int MADCATZ_AXIS_LEFT_JOYSTICK_X = 1;
    public static final int MADCATZ_AXIS_LEFT_JOYSTICK_Y = 2;
    public static final int MADCATZ_AXIS_RIGHT_JOYSTICK_X = 4;
    public static final int MADCATZ_AXIS_RIGHT_JOYSTICK_Y = 5;
    
    //see Joystick documentation for mappings for getAxis()
    
    //PWM ports
    public static final int PWM_LEFT_DRIVE_TRAIN_MOTOR = 1;
    public static final int PWM_RIGHT_DRIVE_TRAIN_MOTOR = 2;
    
    // relay ports
    public static final int RELAY_ACQUISITION_MOTOR_TOP = 1;
    // reserve ports 2 and 3 for acquisition
    
    //madcatz axes uses
    public static final int MADCATZ_AXIS_MANUAL_DRIVE_TRAIN_LEFT = MADCATZ_AXIS_LEFT_JOYSTICK_Y;
    public static final int MADCATZ_AXIS_MANUAL_DRIVE_TRAIN_RIGHT = MADCATZ_AXIS_RIGHT_JOYSTICK_Y;
    
    //logitech button uses
    public static final int LOGITECH_BUTTON_ACQUISITION_STOP = 2;
    public static final int LOGITECH_BUTTON_ACQUISITION_REVERSE = 3;
    public static final int LOGITECH_BUTTON_MODE_SWITCH = 11;
    public static final int LOGITECH_BUTTON_ACQUISITION_FORWARD = Joystick.ButtonType.kTrigger.value;
    
    //logitech axes uses  
    public static final int LOGITECH_AXIS_SHOOTER_VERTICAL = Joystick.AxisType.kY.value;
    public static final int LOGITECH_AXIS_SHOOTER_HORIZONTAL = Joystick.AxisType.kTwist.value;
}

