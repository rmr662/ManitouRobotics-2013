/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.manitourobotics.robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author robotics
 */
public class SimpleButton {
   boolean previousState;
   boolean currentState;

   int rawButtonNumber;
   Joystick joystick; 

   public SimpleButton(Joystick joystick, int rawButtonNumber) {
       this.joystick = joystick;
       this.rawButtonNumber = rawButtonNumber;

       previousState = false; 

   }

   public boolean isPressed(){
       // I need to set the previousState after I know the return value
       boolean returnValue = false;
       currentState = joystick.getRawButton(rawButtonNumber);

       if(currentState && !previousState) {
            returnValue = true;
       }
       else {
            returnValue = false;
       }
       
       previousState = currentState;
       return returnValue;

   }

   public boolean isHeld() {
       if(currentState) {
           return true;
       } else {
           return false;
       }
   }
    
}
