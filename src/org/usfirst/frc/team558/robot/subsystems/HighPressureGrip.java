package org.usfirst.frc.team558.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class HighPressureGrip extends Subsystem {

	
	Solenoid gripper2 = new Solenoid(3);
	
	public void HighpressureOff(){
		
		gripper2.set(true);
		
	}
	
	public void HighpressureOn(){
		
		gripper2.set(false);
		
	}
	
	
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

