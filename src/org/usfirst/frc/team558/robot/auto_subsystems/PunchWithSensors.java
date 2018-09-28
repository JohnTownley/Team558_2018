package org.usfirst.frc.team558.robot.auto_subsystems;

import org.usfirst.frc.team558.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PunchWithSensors extends Command {

    public PunchWithSensors(double timeout) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.lineSensor);
        requires(Robot.punch);
        requires(Robot.rollerClaw);
        
        setTimeout(timeout);
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	if(Robot.lineSensor.readSensors()){
    		
    		Robot.punch.pushCube();
    		Robot.rollerClaw.setMotors(-.7);
    		
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    	Robot.punch.resetPunch();
    	Robot.rollerClaw.setMotors(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	
	    	Robot.rollerClaw.setMotors(0);
	    	Robot.punch.resetPunch();
    }
}
