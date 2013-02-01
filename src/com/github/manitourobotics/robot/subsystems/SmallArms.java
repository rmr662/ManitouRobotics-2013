package com.github.manitourobotics.robot.subsystems;

import com.github.manitourobotics.robot.RobotMap;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;

public class SmallArms extends Subsystem {
    Jaguar smallArmsMotor = new Jaguar(RobotMap.SMALL_ARMS); 
    private double moveSpeed = 1;


    public void moveSmallArmsUp() {
        smallArmsMotor.set(moveSpeed);
    }
    public void moveSmallArmsDown() {
        smallArmsMotor.set(moveSpeed * -1);
    }

    public void stopSmallArms() {
        smallArmsMotor.set(0);
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
