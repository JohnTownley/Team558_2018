package org.usfirst.frc.team558.robot;

import org.usfirst.frc.team558.robot.commands.*;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


public class OI {

	
	XboxController driveStick = new XboxController(0);
	XboxController operatorStick = new XboxController(1);
	
	public OI() {

		//Operator Buttons
		JoystickButton punchButton = new JoystickButton(operatorStick ,6);
		JoystickButton weakPunch = new JoystickButton(operatorStick, 5);
		JoystickButton armScale = new JoystickButton(operatorStick, 4);
		JoystickButton armHP = new JoystickButton(operatorStick, 2);
		JoystickButton armFloor = new JoystickButton(operatorStick, 1);
		JoystickButton armFrontSwitch = new JoystickButton(operatorStick, 3);
		JoystickButton resetEncoder = new JoystickButton(operatorStick, 7);
		JoystickButton manualMode = new JoystickButton(operatorStick, 8);
		
		//Driver Buttons
		JoystickButton autoShootDriveButton = new JoystickButton(driveStick,5);
		
		//Operator Button Commands
		punchButton.whileHeld(new punch());
		weakPunch.whileHeld(new weakPunch());
		armScale.whenPressed(new ArmScale());
		armHP.whenPressed(new ArmHP());
		armFloor.whenPressed(new ArmFloor());
		armFrontSwitch.whenPressed(new ArmFrontSwitch());
		resetEncoder.whenPressed(new ArmReset());
		manualMode.whenPressed(new ArmManual());

		
		//Driver Button Commands
		autoShootDriveButton.whileHeld(new AutoShootDrive());
		
	}
	
//Operator Control Methods
	public double GetRollerStick(){		
		double power = operatorStick.getRawAxis(1);
		
		if ((power < .1) && (power > -.1)){
    		return 0;
    	}
    	else{
    		return power;
    	}
	}	
	
	public double GetArmStick(){
		double armPower = operatorStick.getRawAxis(5);
		
		if ((armPower < .1) && (armPower > -.1)){
    		return 0;
    	}
    	else
    		return armPower;
	}
	
	//Used for Harpooooooon Release and Winch
	public double getClimberPOV(){
		
		return operatorStick.getPOV();
	}

	
	public double GetGripperAxis(){
		return operatorStick.getRawAxis(3);
	}
	//Overrides Gripper Sensor
	public double GetGripperAxisOverRide(){
		
		return operatorStick.getRawAxis(2);
		
	}

	
	//Elm City Drive OI Methods
	
		public double GetThrottle(){
			double reverse = driveStick.getRawAxis(2);
		   	double forward = driveStick.getRawAxis(3);
		    	
		    	if ((reverse > .1) && (forward >.1)){
		    		return 0;
		    	}
		    	else if (forward > .1){
		    		return forward;
		    	}
		    	else if (reverse > .1){
		    		return -reverse;
		    	}
		    	else
		    		return 0;
			}

			
		public double GetTurn(){
			return driveStick.getRawAxis(0);
		}
		
		
		
		//Haptic Feedback 
		public void rumble(double rumble){
			
			driveStick.setRumble(GenericHID.RumbleType.kLeftRumble, rumble);
			driveStick.setRumble(GenericHID.RumbleType.kRightRumble, rumble);
			operatorStick.setRumble(GenericHID.RumbleType.kLeftRumble, rumble);
			operatorStick.setRumble(GenericHID.RumbleType.kRightRumble, rumble);
			
		}
}
