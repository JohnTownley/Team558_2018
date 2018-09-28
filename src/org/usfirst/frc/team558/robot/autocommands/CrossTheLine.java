package org.usfirst.frc.team558.robot.autocommands;

import org.usfirst.frc.team558.robot.auto_subsystems.FollowArc;
import org.usfirst.frc.team558.robot.paths.CrossTheLineArc;

import edu.wpi.first.wpilibj.command.CommandGroup;


public class CrossTheLine extends CommandGroup {

    public CrossTheLine() {
        addSequential(new FollowArc(new CrossTheLineArc()));
    }
}
