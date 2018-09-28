package org.usfirst.frc.team558.robot.autocommands;

import org.usfirst.frc.team558.robot.auto_subsystems.Arm;
import org.usfirst.frc.team558.robot.auto_subsystems.FollowArc;
import org.usfirst.frc.team558.robot.auto_subsystems.rollerClaw;
import org.usfirst.frc.team558.robot.paths.RightExchangeArc;
import org.usfirst.frc.team558.robot.paths.RightExchangeFrontArc;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ExchangeRight extends CommandGroup {

    public ExchangeRight() {
    	addSequential(new Arm(0, .25));
        addSequential(new FollowArc(new RightExchangeArc()));
        addSequential(new Arm(0, 3));
        addSequential(new FollowArc(new RightExchangeFrontArc()));
        addSequential(new Arm(-10800, 1));
        addSequential(new rollerClaw(-.5, 3));
    }
}
