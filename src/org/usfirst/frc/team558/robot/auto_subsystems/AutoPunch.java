package org.usfirst.frc.team558.robot.auto_subsystems;

import org.usfirst.frc.team558.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutoPunch extends Command {

    public AutoPunch(double timeout) {
        requires(Robot.punch);
        requires(Robot.rollerClaw);
        
        setTimeout(timeout);
    }

    protected void initialize() {
    }

    protected void execute() {
    	
    	Robot.punch.pushCube();
    	Robot.rollerClaw.setMotors(-1);
    	
    	
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
    	
    	Robot.punch.resetPunch();
    	Robot.rollerClaw.setMotors(0);
    	
    }

    protected void interrupted() {
    	
    	Robot.punch.resetPunch();
    	Robot.rollerClaw.setMotors(0);
    	
    }
}
