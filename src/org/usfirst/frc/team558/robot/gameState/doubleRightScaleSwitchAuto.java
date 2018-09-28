package org.usfirst.frc.team558.robot.gameState;

import org.usfirst.frc.team558.robot.autocommands.*;
import org.usfirst.frc.team558.robot.util.gameState;
import org.usfirst.frc.team558.robot.util.gameState.Side;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class doubleRightScaleSwitchAuto extends CommandGroup {

    public doubleRightScaleSwitchAuto(gameState gameState) {
    		if(gameState.scaleSide == Side.RIGHT && gameState.mySwitchSide == Side.RIGHT) {
			
    			addSequential(new doubleScaleSwitch());
			
    		}
    		else if(gameState.scaleSide == Side.RIGHT) {
    			
    			addSequential(new doubleLeftScale());
    			
    		}
    		else if(gameState.mySwitchSide == Side.RIGHT){
    			
    			addSequential(new switchLeft());
    			
    		}
    		else {
    			
    			addSequential(new CrossTheLine());
    			
    		}
    }
}
