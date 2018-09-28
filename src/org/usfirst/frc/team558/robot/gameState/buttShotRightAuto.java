package org.usfirst.frc.team558.robot.gameState;

import org.usfirst.frc.team558.robot.autocommands.ButtShotRight;
import org.usfirst.frc.team558.robot.autocommands.CrossTheLine;
import org.usfirst.frc.team558.robot.autocommands.switchRight;
import org.usfirst.frc.team558.robot.util.gameState;
import org.usfirst.frc.team558.robot.util.gameState.Side;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class buttShotRightAuto extends CommandGroup {

    public buttShotRightAuto(gameState gameState) {
    	if(gameState.scaleSide == Side.RIGHT) {
			
			addSequential(new ButtShotRight());
			
		}
    	else if(gameState.mySwitchSide == Side.RIGHT) {
   			
    		addSequential(new switchRight());
    			
   		}
   		else {
    			
   			addSequential(new CrossTheLine());
    			
   		}
    }
}
