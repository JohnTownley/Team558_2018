package org.usfirst.frc.team558.robot.gameState;

import org.usfirst.frc.team558.robot.autocommands.ButtShotLeft;
import org.usfirst.frc.team558.robot.autocommands.ExchangeLeft;
import org.usfirst.frc.team558.robot.autocommands.switchLeft;
import org.usfirst.frc.team558.robot.util.gameState;
import org.usfirst.frc.team558.robot.util.gameState.Side;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class buttShotLeftAuto extends CommandGroup {

    public buttShotLeftAuto(gameState gameState) {
    	if(gameState.scaleSide == Side.LEFT) {
			
			addSequential(new ButtShotLeft());
			
		}
    	else if(gameState.mySwitchSide == Side.LEFT) {
   			
    		addSequential(new switchLeft());
    			
   		}
   		else {
    			
   			addSequential(new ExchangeLeft());
    			
   		}
    }
}
