package org.usfirst.frc.team558.robot.subsystems;

import org.usfirst.frc.team558.robot.commands.GripperSensor;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CubeDetector extends Subsystem {

	DigitalInput cubeDetector = new DigitalInput(2);

	public boolean readCubeSensor(){
		
		return cubeDetector.get();
		
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new GripperSensor());
    }
}

