package org.usfirst.frc.team558.robot.autocommands;

import org.usfirst.frc.team558.robot.auto_subsystems.*;
import org.usfirst.frc.team558.robot.scale_Paths.*;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class doubleRightScaleSwitch extends CommandGroup {

    public doubleRightScaleSwitch() {
	    	addSequential(new Arm(0, .25));
	    	addParallel(new PunchWithSensors(4.5));
	    	addSequential(new FollowArc(new doubleRightScaleBackArc()));
	    	addSequential(new zeroPidgeotto());
	    	addParallel(new Arm(-10600, .25));
	    	addParallel(new rollerClawSensor(1, 2));
	    	addSequential(new FollowArc(new doubleRightScaleFrontArc()));
	    	addSequential(new zeroPidgeotto());
	    	addSequential(new Arm(-3450, .1));
	    	addSequential(new FollowArc(new doubleScaleSwitchFrontArc()));
	    	addSequential(new rollerClaw(-.5, .1));
    }
}
