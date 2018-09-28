package org.usfirst.frc.team558.robot.autocommands;

import org.usfirst.frc.team558.robot.auto_subsystems.Arm;
import org.usfirst.frc.team558.robot.auto_subsystems.AutoPunch;
import org.usfirst.frc.team558.robot.auto_subsystems.FollowArc;
import org.usfirst.frc.team558.robot.auto_subsystems.TurnWithGyro;
import org.usfirst.frc.team558.robot.auto_subsystems.zeroPidgeotto;
import org.usfirst.frc.team558.robot.scale_Paths.ButtShot2Arc;
import org.usfirst.frc.team558.robot.scale_Paths.ButtShotRightArc;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ButtShotRight extends CommandGroup {

    public ButtShotRight() {
    	addParallel(new Arm(2095, .25));
        addSequential(new FollowArc(new ButtShotRightArc()));
        addSequential(new TurnWithGyro(80, .7, .017));
        addSequential(new zeroPidgeotto());
        addSequential(new FollowArc(new ButtShot2Arc()));
        addSequential(new AutoPunch(1));
    }
}
