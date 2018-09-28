package org.usfirst.frc.team558.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.*;
import org.usfirst.frc.team558.robot.commands.*;
/**
 *
 */
public class ShoulderArm extends Subsystem {

    TalonSRX Arm = new TalonSRX(10);
    DigitalInput zeroButton = new DigitalInput(3);
    
    
    
    public ShoulderArm(){
    	
    	Arm.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 0);
    	Arm.setSensorPhase(true);
    	Arm.setInverted(false);
    	Arm.selectProfileSlot(0, 0);
    	Arm.config_kF(0, 0.474, 0);
    	Arm.config_kP(0, 0.629, 0);
    	Arm.config_kI(0, 0, 0);
    	Arm.config_kD(0, 0, 0);
    	Arm.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10, 0);
    	Arm.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, 0);
    	
    	Arm.configNominalOutputForward(0, 0);
    	Arm.configNominalOutputReverse(0, 0);
    	Arm.configPeakOutputForward(1, 0);
    	Arm.configPeakOutputReverse(-1, 0);
    	
    	Arm.configMotionAcceleration(4000, 0); //originally 2052
    	Arm.configMotionCruiseVelocity(4000,0); // originally 1056
    }
    
    public void motionMagic(double num){
    	
    	Arm.set(ControlMode.MotionMagic, num);
    	
    }
    
    public boolean zeroEncoderSensor(){
    	
    	 return zeroButton.get();
    	
    }
    
    public void resetEncoder(){
    	
    	Arm.setSelectedSensorPosition(0, 0, 0);
    	
    }
    
    public void scale(){
    	
    	Arm.set(ControlMode.MotionMagic, 2095);
    	
    	
    }
    public void HPload(){
    	
    	Arm.set(ControlMode.MotionMagic, 5688);
    	
    }
    
    public void floorPickUp(){
    	
    	Arm.set(ControlMode.MotionMagic, -10800);
    	
    	
    }
    
    public void FrontSideSwitch(){
    	
    	Arm.set(ControlMode.MotionMagic, -3450);
    	
    	
    }
    
    public double readEncoder(){
    	
    	return Arm.getSelectedSensorPosition(0);
    	
    	
    }
    
    public void goToZero(){
    	
    	Arm.set(ControlMode.MotionMagic, 0);
    	
    }
    
    public void ManualMode(double speed){
    	Arm.set(ControlMode.PercentOutput, speed);
    }
    
    
    
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	setDefaultCommand(new ArmManual());
    }
}

