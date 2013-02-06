package com.github.manitourobotics.robot;

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

    public static final int MODE_SHOOTING = 1;
    public static final int MODE_CLIMBING = 2;
    public static final int MODE_AUTONOMOUS = 3;
    public static final int MODE_PLAY = 4;
    
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
    public static final int PWM_LEFT_DRIVE_TRAIN = 1;
    public static final int PWM_RIGHT_DRIVE_TRAIN = 2;
    public static final int PWM_TILTER_OR_CENTER_ARM = 3;
    public static final int PWM_ELBOW_ARMS = 4;
    public static final int PWM_SMALL_ARMS = 5; 
    public static final int PWM_SERVO_BARREL_STOPPER = 10;
    
    // relay ports
    public static final int RELAY_PUSH_FRISBEE = 1;
    // reserve ports 2 and 3 for acquisition
    public static final int RELAY_SHOOTER = 4;
    // reserve port 5 and 6 for shooting motors
    
    //madcatz shooting axes uses
    public static final int MADCATZ_AXIS_MANUAL_DRIVE_TRAIN_LEFT = MADCATZ_AXIS_LEFT_JOYSTICK_Y;
    public static final int MADCATZ_AXIS_MANUAL_DRIVE_TRAIN_RIGHT = MADCATZ_AXIS_RIGHT_JOYSTICK_Y;

    //madcatz climbing axes uses
    public static final int MADCATZ_AXIS_ELBOW_ARM_CONTROL = MADCATZ_AXIS_LEFT_JOYSTICK_Y;
    public static final int MADCATZ_AXIS_SHOULDER_ARM_CONTROL = MADCATZ_AXIS_RIGHT_JOYSTICK_Y;

    //madcatz shooting button uses
    public static final int MADCATZ_BUTTON_SMALL_ARM_UP = MADCATZ_BUTTON_X;
    public static final int MADCATZ_BUTTON_SMALL_ARM_DOWN = MADCATZ_BUTTON_A;
    
    //logitech button uses
    public static final int LOGITECH_BUTTON_FRISBEE_PUSH = 1; // trigger
    public static final int LOGITECH_BUTTON_SHOOTER_OFF = 4; 
    public static final int LOGITECH_BUTTON_SHOOTER_ON = 6; 

    public static final int LOGITECH_BUTTON_MODE_SWITCH = 11;
    
    //logitech axes uses  
    public static final int LOGITECH_AXIS_TILTER = Joystick.AxisType.kZ.value;
}

