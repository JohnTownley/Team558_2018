package org.usfirst.frc.team558.robot.subsystems;

import org.usfirst.frc.team558.robot.commands.rollerClaw;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.sensors.PigeonIMU;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class rollerclaw extends Subsystem {

    TalonSRX rollerMotor1 = new TalonSRX(4);
    TalonSRX rollerMotor2 = new TalonSRX(5);
    PigeonIMU pidgey = new PigeonIMU(rollerMotor2);
    
    
    public void setMotors(double rollerStick){
    	
    		rollerMotor1.set(ControlMode.PercentOutput, -rollerStick);
    		rollerMotor2.set(ControlMode.PercentOutput, rollerStick);
    	
    }
    
    public double getAngle() {
    		
    		double[] ypr = new double[3];
    		pidgey.getYawPitchRoll(ypr);
    		return ypr[0];
    		
    }
    
    public void zeroAngle() {
    		
    		pidgey.setYaw(0, 0);
    		
    }
    
    
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new rollerClaw());
    }
}

