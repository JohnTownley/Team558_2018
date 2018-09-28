package org.usfirst.frc.team558.robot.autocommands;

import org.usfirst.frc.team558.robot.auto_subsystems.FollowArc;
import org.usfirst.frc.team558.robot.paths.ThreeFeetArc;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class threeFeet extends CommandGroup {

    public threeFeet() {
        addSequential(new FollowArc(new ThreeFeetArc()));
        //addSequential(new FollowArc(new ThreeFeet90Arc()));
    }
}
