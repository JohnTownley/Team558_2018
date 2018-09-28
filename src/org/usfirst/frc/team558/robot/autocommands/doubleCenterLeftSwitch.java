package org.usfirst.frc.team558.robot.autocommands;

import org.usfirst.frc.team558.robot.auto_subsystems.*;
import org.usfirst.frc.team558.robot.center_paths.doubleCenterLeftArc;
import org.usfirst.frc.team558.robot.center_paths.doubleCenterLeftBack2Arc;
import org.usfirst.frc.team558.robot.center_paths.doubleCenterLeftBackArc;
import org.usfirst.frc.team558.robot.center_paths.doubleCenterLeftFront2Arc;
import org.usfirst.frc.team558.robot.center_paths.doubleCenterLeftFrontArc;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class doubleCenterLeftSwitch extends CommandGroup {

    public doubleCenterLeftSwitch() {
    	addParallel(new Arm(-3450, .25));
        addSequential(new FollowArc(new doubleCenterLeftArc()));
        addParallel(new rollerClaw(-.5, .2));
        addSequential(new FollowArc(new doubleCenterLeftBackArc()));
        addSequential(new Arm(-10600, .1));
        addParallel(new rollerClawSensor(1, 2.3));
        addSequential(new FollowArc(new doubleCenterLeftFrontArc()));
        addSequential(new Arm(-10600, .5));
        addParallel(new Arm(-3450, .1));
        addSequential(new FollowArc(new doubleCenterLeftBack2Arc()));
        addSequential(new FollowArc(new doubleCenterLeftFront2Arc()));
        addSequential(new rollerClaw(-.5, 1));
        
    }
}
