package org.usfirst.frc.team558.robot.commands;

import org.usfirst.frc.team558.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class rollerClaw extends Command {

    public rollerClaw() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.rollerClaw);
        requires(Robot.highGrip);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double rollerStick = Robot.m_oi.GetRollerStick();
    	double gripperTrigSensor = Robot.m_oi.GetGripperAxis();
    	double gripperTrigOverRide = Robot.m_oi.GetGripperAxisOverRide();
    	
    	if(rollerStick > 0){
    		
    		Robot.rollerClaw.setMotors(rollerStick);
    		
    	}
    	
    	else if(rollerStick < 0){
    		
    		Robot.rollerClaw.setMotors(rollerStick/2);
    		
    	}
    	else{
    		
    		Robot.rollerClaw.setMotors(0);
    		
    	}
    	
    	if(gripperTrigOverRide > .1){
    		
    		Robot.gripper.GripperOpen();
    		Robot.highGrip.HighpressureOff();
    		
    	}
    	
    	else if(!Robot.cubeDetector.readCubeSensor()){
    		
    		Robot.highGrip.HighpressureOn();
    		Robot.gripper.GripperClosed();
    		
    	}
    	
    	else if(gripperTrigSensor > .1){
    		
    		Robot.highGrip.HighpressureOff();
    		Robot.gripper.GripperOpen();
    		
    	}
    	
    	
    	else if(rollerStick > .1){
    		
    		Robot.highGrip.HighpressureOff();
    		
    	}
    	
    	
    	
    	else{
    		
    		Robot.highGrip.HighpressureOn();
    		Robot.gripper.GripperClosed();
    		
    	}
    	
    		
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
