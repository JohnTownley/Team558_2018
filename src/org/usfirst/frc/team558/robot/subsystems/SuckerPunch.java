package org.usfirst.frc.team558.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;


public class SuckerPunch extends Subsystem {

    Solenoid punch = new Solenoid(0);
    Solenoid punch1 = new Solenoid(1);
    Solenoid punch2 = new Solenoid(7);
    

	public void pushCube() {
		
		punch.set(true);
		punch1.set(true);
		punch2.set(true);
		
	}
	public void resetPunch() {
		
		punch.set(false);
		punch1.set(false);
		punch2.set(false);
		
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

