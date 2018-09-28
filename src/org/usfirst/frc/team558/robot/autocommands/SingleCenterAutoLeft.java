package org.usfirst.frc.team558.robot.autocommands;

import org.usfirst.frc.team558.robot.auto_subsystems.Arm;
import org.usfirst.frc.team558.robot.auto_subsystems.FollowArc;
import org.usfirst.frc.team558.robot.auto_subsystems.rollerClaw;
import org.usfirst.frc.team558.robot.center_paths.CenterLeftAutoArc;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SingleCenterAutoLeft extends CommandGroup {

    public SingleCenterAutoLeft() {
    		addSequential(new Arm(-3450, .25));
    		addSequential(new FollowArc(new CenterLeftAutoArc()));
            addSequential(new rollerClaw(.5, 1));
    }
}
