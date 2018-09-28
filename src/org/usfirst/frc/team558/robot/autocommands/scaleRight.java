package org.usfirst.frc.team558.robot.autocommands;

import org.usfirst.frc.team558.robot.auto_subsystems.Arm;
import org.usfirst.frc.team558.robot.auto_subsystems.FollowArc;
import org.usfirst.frc.team558.robot.auto_subsystems.PunchWithSensors;
import org.usfirst.frc.team558.robot.scale_Paths.scaleRightArc;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class scaleRight extends CommandGroup {

    public scaleRight() {
	    	addSequential(new Arm(0, .25));
	    	addParallel(new PunchWithSensors(5));
	    addSequential(new FollowArc(new scaleRightArc()));
    }
}
