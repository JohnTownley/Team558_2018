package org.usfirst.frc.team558.robot.auto_subsystems;

import org.usfirst.frc.team558.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;



public class TurnWithGyro extends Command {

	private double desiredAngle;
	private double error;
	private double mKp;
	private double tolerance = .5;
	private double pidSpeed;
	private double mMaxSpeed;
	
    public TurnWithGyro(double aAngle, double aMaxSpeed, double aKp) {
        requires(Robot.driveTrain);
        requires(Robot.rollerClaw);
        this.desiredAngle = aAngle;
        this.mMaxSpeed = aMaxSpeed;
        this.mKp = aKp;
        setTimeout(2);
        
    }

    protected void initialize() {
    	
    
    }


    protected void execute() {
    	error = Math.abs(Math.abs(desiredAngle) - Math.abs(Robot.rollerClaw.getAngle()));
    	
    	if (mKp * error >= mMaxSpeed){
    		pidSpeed = mMaxSpeed;
    	}
    	else {
    		pidSpeed = mKp * error;
    	}

  
    	if (Robot.rollerClaw.getAngle() > desiredAngle)
        {
    		Robot.driveTrain.drive(pidSpeed, -pidSpeed);
        }
        else
        {
        	Robot.driveTrain.drive(-pidSpeed, pidSpeed);
        }
    	
    	
    }


    protected boolean isFinished() {
    	return ((Math.abs(error) <= tolerance) || isTimedOut());
    }


    protected void end() {
    	Robot.driveTrain.drive(0, 0);
    }


    protected void interrupted() {
    }
}