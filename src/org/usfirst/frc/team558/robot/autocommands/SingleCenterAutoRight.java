package org.usfirst.frc.team558.robot.autocommands;

import org.usfirst.frc.team558.robot.auto_subsystems.Arm;
import org.usfirst.frc.team558.robot.auto_subsystems.FollowArc;
import org.usfirst.frc.team558.robot.auto_subsystems.rollerClaw;
import org.usfirst.frc.team558.robot.center_paths.CenterAutoRightArc;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SingleCenterAutoRight extends CommandGroup {

    public SingleCenterAutoRight() {
    	addSequential(new Arm(3450, .25));
    	addSequential(new FollowArc(new CenterAutoRightArc()));
        addSequential(new rollerClaw(.5, 1));
    }
}
