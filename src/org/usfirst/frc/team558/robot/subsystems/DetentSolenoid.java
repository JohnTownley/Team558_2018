package org.usfirst.frc.team558.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DetentSolenoid extends Subsystem {


    Solenoid detent = new Solenoid(5);
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    
    public void FireDetent(){
    	detent.set(true);
    }
    public void RetractDetent(){
    	detent.set(false);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

