package org.usfirst.frc.team558.robot.autocommands;

import org.usfirst.frc.team558.robot.auto_subsystems.Arm;
import org.usfirst.frc.team558.robot.auto_subsystems.FollowArc;
import org.usfirst.frc.team558.robot.auto_subsystems.rollerClaw;
import org.usfirst.frc.team558.robot.auto_subsystems.rollerClawSensor;
import org.usfirst.frc.team558.robot.center_paths.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class doubleCenterRightSwitch extends CommandGroup {

    public doubleCenterRightSwitch() {
    	addParallel(new Arm(-3450, .5));
        addSequential(new FollowArc(new doubleCenterRightArc()));
        addParallel(new rollerClaw(-.5, .2));
        addSequential(new FollowArc(new doubleCenterRightBackArc()));
        addSequential(new Arm(-10600, .1));
        addParallel(new rollerClawSensor(1, 2.3));
        addSequential(new FollowArc(new doubleCenterRightFrontArc()));
        addSequential(new Arm(-10600, .5));
        addParallel(new Arm(-3450, .1));
        addSequential(new FollowArc(new doubleCenterRightBack2Arc()));
        addSequential(new FollowArc(new doubleCenterRightFront2Arc()));
        addSequential(new rollerClaw(-.5, 1));
    }
}
