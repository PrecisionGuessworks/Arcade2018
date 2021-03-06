package org.usfirst.frc.team1646.robot;

import org.usfirst.frc.team1646.robot.commands.ReleaseGear;
import org.usfirst.frc.team1646.robot.commands.StabilizeGear;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	
	public Joystick leftStick;
	public Joystick rightStick;
	public Joystick controller;
	
	public OI()
	{
		leftStick = new Joystick(0);
		rightStick = new Joystick(1);
		controller = new Joystick(2);
		initializeCommands();
		SmartDashboard.putData("release gear", new ReleaseGear());
		SmartDashboard.putData("StabalizeGear", new StabilizeGear());
		
	}
	
	public void initializeCommands(){
		
		Button releaseGear = new JoystickButton(controller, 1);
		releaseGear.whenPressed(new ReleaseGear());
		
		Button stabilizeGear = new JoystickButton(controller, 4);
		stabilizeGear.whenPressed(new StabilizeGear());
		
	}

	public double getControllerLeftStickY() {
		return controller.getRawAxis(1);
		
	}
	
	public double getControllerRightStickY() {
		return controller.getRawAxis(5);
		
	}
	
	public double getControllerRightStickX() {
		return controller.getRawAxis(4);
	}
	
}

	