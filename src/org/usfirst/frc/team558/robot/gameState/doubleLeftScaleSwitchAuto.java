package org.usfirst.frc.team558.robot.gameState;


import org.usfirst.frc.team558.robot.autocommands.doubleLeftScale;
import org.usfirst.frc.team558.robot.autocommands.*;
import org.usfirst.frc.team558.robot.autocommands.switchLeft;
import org.usfirst.frc.team558.robot.util.gameState;
import org.usfirst.frc.team558.robot.util.gameState.Side;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class doubleLeftScaleSwitchAuto extends CommandGroup {

    public doubleLeftScaleSwitchAuto(gameState gameState) {
    		if(gameState.scaleSide == Side.LEFT && gameState.mySwitchSide == Side.LEFT) {
			
    			addSequential(new doubleScaleSwitch());
			
    		}
    		else if(gameState.scaleSide == Side.LEFT) {
    			
    			addSequential(new doubleLeftScale());
    			
    		}
    		else if(gameState.mySwitchSide == Side.LEFT){
    			
    			addSequential(new switchLeft());
    			
    		}
    		else {
    			
    			addSequential(new ExchangeLeft());
    			
    		}
    }
}
