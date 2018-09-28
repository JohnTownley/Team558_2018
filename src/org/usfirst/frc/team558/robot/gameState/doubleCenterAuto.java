package org.usfirst.frc.team558.robot.gameState;

import org.usfirst.frc.team558.robot.autocommands.*;
import org.usfirst.frc.team558.robot.util.gameState;
import org.usfirst.frc.team558.robot.util.gameState.Side;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class doubleCenterAuto extends CommandGroup {

    public doubleCenterAuto(gameState gameState) {
    	if(gameState.mySwitchSide == Side.LEFT) {
			
			addSequential(new doubleCenterLeftSwitch());
			
		}
		else if(gameState.mySwitchSide == Side.RIGHT){
			
			addSequential(new doubleCenterRightSwitch());
			
		}
		else {
			
			addSequential(new CrossTheLine());
			
		}
    }
}
