package org.usfirst.frc.team558.robot.autocommands;

import org.usfirst.frc.team558.robot.auto_subsystems.*;
import org.usfirst.frc.team558.robot.scale_Paths.*;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class doubleRightScale extends CommandGroup {

    public doubleRightScale() {
	    	addSequential(new Arm(0, .25));
	    	addParallel(new PunchWithSensors(4.5));
	    	addSequential(new FollowArc(new doubleRightScaleBackArc()));
	    	addSequential(new zeroPidgeotto());
	    	addSequential(new Arm(-10600, .25));
	    	addParallel(new rollerClawSensor(1, 2));
	    	addSequential(new FollowArc(new doubleRightScaleFrontArc()));
	    	addSequential(new zeroPidgeotto());
	    	addSequential(new Arm(0, .1));
	    	addParallel(new PunchWithSensors(3));
	    	addSequential(new FollowArc(new doubleRightScaleBack2Arc()));
    }
}
