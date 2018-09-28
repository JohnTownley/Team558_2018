package org.usfirst.frc.team558.robot.gameState;

import org.usfirst.frc.team558.robot.autocommands.*;
import org.usfirst.frc.team558.robot.util.gameState;
import org.usfirst.frc.team558.robot.util.gameState.Side;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class rightSwitch extends CommandGroup {

    public rightSwitch(gameState gameState) {
	    	if(gameState.mySwitchSide == Side.RIGHT) {
				
					addSequential(new switchRight());
				
			}
	    	else if(gameState.scaleSide == Side.RIGHT) {
	    			
	    			addSequential(new scaleRight());
	    			
	    	}
	   		else {
	    			
	    			addSequential(new CrossTheLine());
	    			
	    	}
    }
}
