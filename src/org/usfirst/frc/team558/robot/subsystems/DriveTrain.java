package org.usfirst.frc.team558.robot.subsystems;


import org.usfirst.frc.team558.robot.commands.Elmcitydrive;

import com.ctre.phoenix.ErrorCode;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.RemoteSensorSource;
import com.ctre.phoenix.motorcontrol.SensorTerm;
import com.ctre.phoenix.motorcontrol.StatusFrame;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {

	public TalonSRX leftDriveMaster = new TalonSRX(15);
	VictorSPX leftDriveSlave1 = new VictorSPX(14);
	VictorSPX leftDriveSlave2 = new VictorSPX(13);
	public TalonSRX rightDriveMaster = new TalonSRX(16);
	VictorSPX rightDriveSlave1 = new VictorSPX(1);
	VictorSPX rightDriveSlave2 = new VictorSPX(2);
	
	
	
	public static final int DRIVE_PROFILE = 0;
	public static final int ROTATION_PROFILE = 1;
	
	public DriveTrain(){
		
		// DriveTrain Master
		this.leftDriveMaster.configMotionProfileTrajectoryPeriod(0, 0);
		this.leftDriveMaster.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
		this.leftDriveSlave1.follow(leftDriveMaster);
		this.leftDriveSlave2.follow(leftDriveMaster);
		this.leftDriveMaster.setSensorPhase(true);
		this.rightDriveMaster.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
		
		
		this.rightDriveSlave1.follow(rightDriveMaster);
		this.rightDriveSlave2.follow(rightDriveMaster);
		this.rightDriveMaster.configMotionProfileTrajectoryPeriod(0, 0);
		this.rightDriveMaster.setSensorPhase(true);
		this.rightDriveMaster.setInverted(true);
		this.rightDriveSlave1.setInverted(true);
		this.rightDriveSlave2.setInverted(true);
		
		this.configPIDF(DRIVE_PROFILE, .0875, 0.0, .156, .0725, 0);
		this.configPIDF(ROTATION_PROFILE, 4.5, 0, 7, 2, 5);

		// configure distance sensor
		// Remote 0 will be the other side's Talon
		rightDriveMaster.configRemoteFeedbackFilter(leftDriveMaster.getDeviceID(), RemoteSensorSource.TalonSRX_SelectedSensor, 0, 0);
		rightDriveMaster.configSensorTerm(SensorTerm.Sum0, FeedbackDevice.RemoteSensor0, 0);
		rightDriveMaster.configSensorTerm(SensorTerm.Sum1, FeedbackDevice.CTRE_MagEncoder_Relative, 0);

		
		 // distances from left and right are summed, so average them
		rightDriveMaster.configSelectedFeedbackSensor(FeedbackDevice.SensorSum, 0, 0);
		rightDriveMaster.configSelectedFeedbackCoefficient(.5, 0, 0);
		
		
		
		rightDriveMaster.configMaxIntegralAccumulator(ROTATION_PROFILE, 3000, 0);
		

		// configure angle sensor remote 1 will be a pigeon
		// Pigeon is plugged into rollerclaw talon so ID 5 is used
		rightDriveMaster.configRemoteFeedbackFilter(5, RemoteSensorSource.GadgeteerPigeon_Yaw, 1, 0);
		rightDriveMaster.configSelectedFeedbackSensor(FeedbackDevice.RemoteSensor1, 1, 0);
		
		
		//Coefficient for Pigeon to convert to 360
		rightDriveMaster.configSelectedFeedbackCoefficient((3600.0 / 8192.0), 1, 0);
		

		leftDriveMaster.setStatusFramePeriod(StatusFrame.Status_2_Feedback0, 5, 0);
		rightDriveMaster.configAuxPIDPolarity(false, 0);		
		
	}
	
	public void drive(double leftPower, double rightPower){
		this.leftDriveMaster.set(ControlMode.PercentOutput,leftPower);
		this.rightDriveMaster.set(ControlMode.PercentOutput,rightPower);
	}
	
	

	public double getDistance() {
		return rightDriveMaster.getSelectedSensorPosition(0);
	}
	
	public double readLeftEncoder() {
		
		return this.leftDriveMaster.getSelectedSensorPosition(0);
		
		
	}
	
	public double readRightEncoder() {
		
		return this.rightDriveMaster.getSelectedSensorPosition(0);
		
		
	}
	
	public double GetAverageEncoderDistance(){
    	return ((this.leftDriveMaster.getSelectedSensorPosition(0) + this.rightDriveMaster.getSelectedSensorPosition(0))/2);
    }
	
	public void setRampRate() {
		this.leftDriveMaster.configOpenloopRamp(.4, 0);
		this.rightDriveMaster.configOpenloopRamp(.4, 0);
		
	}
	
	public ErrorCode configPIDF(int slotIdx, double P, double I, double D, double F, int iZone ){
		ErrorCode errorCode = ErrorCode.OK;
		
		errorCode = this.leftDriveMaster.config_kP(slotIdx, P, 0);
		if (errorCode != ErrorCode.OK) {
			return errorCode;
		}
		errorCode = this.rightDriveMaster.config_kP(slotIdx, P, 0);
		if (errorCode != ErrorCode.OK) {
			return errorCode;
		}
		
		errorCode = this.leftDriveMaster.config_kI(slotIdx, I, 0);
		if (errorCode != ErrorCode.OK) {
			return errorCode;
		}
		errorCode = this.rightDriveMaster.config_kI(slotIdx, I, 0);
		if (errorCode != ErrorCode.OK) {
			return errorCode;
		}
		
		errorCode = this.leftDriveMaster.config_kD(slotIdx, D, 0);
		if (errorCode != ErrorCode.OK) {
			return errorCode;
		}
		errorCode = this.rightDriveMaster.config_kD(slotIdx, D, 0);
		if (errorCode != ErrorCode.OK) {
			return errorCode;
		}
		
		errorCode = this.leftDriveMaster.config_kF(slotIdx, F, 0);
		if(errorCode != ErrorCode.OK) {
			return errorCode;
		}

		
		errorCode = this.rightDriveMaster.config_kF(slotIdx, F, 0);
		if(errorCode != ErrorCode.OK) {
			return errorCode;
		}
		
		errorCode = this.leftDriveMaster.config_IntegralZone(slotIdx, iZone, 0);
		if(errorCode != ErrorCode.OK) {
			return errorCode;
		}

		
		errorCode = this.rightDriveMaster.config_IntegralZone(slotIdx, iZone, 0);
		return errorCode;
		
		
	}
	
	public void resetEncoders(){
		
		this.rightDriveMaster.setSelectedSensorPosition(0, 0, 0);
		this.leftDriveMaster.setSelectedSensorPosition(0, 0, 0);
		
	}
	
	public double leftgetVolt() {
		
		return this.leftDriveMaster.getMotorOutputPercent();
		
	}
	
	public double rightGetVolt() {
		
		return this.rightDriveMaster.getMotorOutputPercent();
		
	}
	
	

    public void initDefaultCommand() {
        setDefaultCommand(new Elmcitydrive());
    }
}

