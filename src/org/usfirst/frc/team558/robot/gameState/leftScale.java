package org.usfirst.frc.team558.robot.gameState;

import org.usfirst.frc.team558.robot.autocommands.*;
import org.usfirst.frc.team558.robot.util.gameState;
import org.usfirst.frc.team558.robot.util.gameState.Side;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class leftScale extends CommandGroup {

    public leftScale(gameState gameState) {
    	if(gameState.scaleSide == Side.LEFT) {
			
			addSequential(new scaleLeft());
			
		}
    	else if(gameState.mySwitchSide == Side.LEFT) {
   			
    		addSequential(new switchLeft());
    			
   		}
   		else {
    			
   			addSequential(new ExchangeLeft());
    			
   		}
    }
}
