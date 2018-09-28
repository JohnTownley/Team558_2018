package org.usfirst.frc.team558.robot.auto_subsystems;

import org.usfirst.frc.team558.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


public class Arm extends Command {

	
	private double setPoint;
	
    public Arm(double encoderValue, double timeout) {
        requires(Robot.Arm);
       
        this.setPoint = encoderValue;
        
        setTimeout(timeout);
        
    }

    
    protected void initialize() {
    }

    protected void execute() {
    	
    	Robot.Arm.motionMagic(setPoint);
    	
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
