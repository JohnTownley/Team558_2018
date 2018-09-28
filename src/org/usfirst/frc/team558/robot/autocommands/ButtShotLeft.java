package org.usfirst.frc.team558.robot.autocommands;

import org.usfirst.frc.team558.robot.auto_subsystems.*;
import org.usfirst.frc.team558.robot.scale_Paths.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ButtShotLeft extends CommandGroup {

    public ButtShotLeft() {
       addParallel(new Arm(2095, .25));
       addSequential(new FollowArc(new ButtShotArc()));
       addSequential(new TurnWithGyro(-80, .7, .017));
       addSequential(new zeroPidgeotto());
       addSequential(new FollowArc(new ButtShot2Arc()));
       addSequential(new AutoPunch(1));
        
        
    }
}
