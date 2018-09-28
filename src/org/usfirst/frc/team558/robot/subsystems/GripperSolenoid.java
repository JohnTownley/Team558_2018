package org.usfirst.frc.team558.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;


public class GripperSolenoid extends Subsystem {

	
	Solenoid gripper = new Solenoid(2);
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	
	public void GripperClosed(){
		gripper.set(false);
		//gripper2.set(true);
	}
	public void GripperOpen(){
		gripper.set(true);
		//gripper2.set(false);
	}
	
	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        
    }
}

