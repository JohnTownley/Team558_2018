package org.usfirst.frc.team558.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LineSensor extends Subsystem {

    DigitalInput lineSensor1 = new DigitalInput(0);
    DigitalInput lineSensor2 = new DigitalInput(1);
    
    public boolean readSensors(){
    	
    	return lineSensor1.get() || lineSensor2.get();
    	
    }
    
    public boolean readLineSensor1(){
    	
    	return lineSensor1.get();
    	
    }
    
    public boolean readLineSensor2(){
    	
    	return lineSensor2.get();
    	
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

