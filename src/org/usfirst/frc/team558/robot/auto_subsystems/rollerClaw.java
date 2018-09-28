package org.usfirst.frc.team558.robot.auto_subsystems;

import org.usfirst.frc.team558.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class rollerClaw extends Command {

	private double intake;
	
    public rollerClaw(double intakeValue, double timeout) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.rollerClaw);
        this.intake = intakeValue;
        
        setTimeout(timeout);
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	Robot.rollerClaw.setMotors(intake);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    	Robot.rollerClaw.setMotors(0);
    	
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	
    	//Robot.rollerClaw.setMotors(0);
    	
    }
}
