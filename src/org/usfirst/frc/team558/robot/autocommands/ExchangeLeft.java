package org.usfirst.frc.team558.robot.autocommands;

import org.usfirst.frc.team558.robot.auto_subsystems.Arm;
import org.usfirst.frc.team558.robot.auto_subsystems.FollowArc;
import org.usfirst.frc.team558.robot.auto_subsystems.rollerClaw;
import org.usfirst.frc.team558.robot.paths.ExchangeArc;
import org.usfirst.frc.team558.robot.paths.ExchangeFrontArc;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ExchangeLeft extends CommandGroup {

    public ExchangeLeft() {
    	addSequential(new Arm(0, .25));
        addSequential(new FollowArc(new ExchangeArc()));
        addSequential(new Arm(0, 3));
        addSequential(new FollowArc(new ExchangeFrontArc()));
        addSequential(new Arm(-10800, 1));
        addSequential(new rollerClaw(-.5, 3));
    }
}
