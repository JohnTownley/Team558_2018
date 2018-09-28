package org.usfirst.frc.team558.robot.commands;

import org.usfirst.frc.team558.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ClimberUp extends Command {

    public ClimberUp() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.climber);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double climberPOV = Robot.m_oi.getClimberPOV();
    	
    	if(climberPOV == 0 || climberPOV == 45 || climberPOV == 315) {
    		
    		Robot.climber.climberLaunch();
    		
    	}
    	
    	else if(climberPOV == 180 || climberPOV == 135 || climberPOV == 225){
    		
    		Robot.climber.climberMotors(1);
    		
    	}
    	else{
    		
    		Robot.climber.climberMotors(0);
    		
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
