package org.usfirst.frc.team558.robot.subsystems;

import org.usfirst.frc.team558.robot.commands.ClimberUp;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {

	TalonSRX climberMaster1 = new TalonSRX(3);
	VictorSPX climberMaster2 = new VictorSPX(12);
	Solenoid harpoooooon = new Solenoid(4);
	
	
	public void climberLaunch(){
		
		harpoooooon.set(true);
		
	}
	
	public void ClimberDown(){
		harpoooooon.set(false);
	}
	
	public void climberMotors(double percent){
		
		climberMaster1.set(ControlMode.PercentOutput, percent);
		climberMaster2.set(ControlMode.PercentOutput, -percent);
		
	}
	
	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    		setDefaultCommand(new ClimberUp());
    }
}

