package org.usfirst.frc.team558.robot.gameState;

import org.usfirst.frc.team558.robot.autocommands.*;
import org.usfirst.frc.team558.robot.util.gameState;
import org.usfirst.frc.team558.robot.util.gameState.Side;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class rightScale extends CommandGroup {

    public rightScale(gameState gameState) {
    	if(gameState.scaleSide == Side.RIGHT) {
			
			addSequential(new scaleRight());
			
		}
    	else if(gameState.mySwitchSide == Side.RIGHT) {
   			
    		addSequential(new switchRight());
    			
   		}
   		else {
    			
   			addSequential(new CrossTheLine());
    			
   		}
    }
}
