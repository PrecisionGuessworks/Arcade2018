package org.usfirst.frc.team1646.robot.commands;

import org.usfirst.frc.team1646.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LEDJoysticks extends Command {

    public LEDJoysticks() {
    	requires(Robot.ledSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Left Joystick
    	boolean leftButton1 = Robot.oi.leftStick.getRawButton(7);
    	boolean leftDiagonalButton1 = Robot.oi.leftStick.getRawButton(5);
    	//boolean middleButton1 = Robot.oi.leftStick.getRawButton(2);
    	boolean rightDiagonalButton1 = Robot.oi.leftStick.getRawButton(6);
    	boolean rightButton1 = Robot.oi.leftStick.getRawButton(4);
    	
    	//Right Joystick
    	boolean leftButton2 = Robot.oi.rightStick.getRawButton(7);
    	boolean leftDiagonalButton2 = Robot.oi.rightStick.getRawButton(5);
    	//boolean middleButton2 = Robot.oi.rightStick.getRawButton(2);
    	boolean rightDiagonalButton2 = Robot.oi.rightStick.getRawButton(6);
    	boolean rightButton2 = Robot.oi.rightStick.getRawButton(4);
    	
    	if (leftButton1) {
    		Robot.ledSubsystem.setToRed();
    	}
    	
    	if (leftDiagonalButton1) {
    		Robot.ledSubsystem.setToOrange();
    	}
    	
    	if (rightDiagonalButton1) {
    		Robot.ledSubsystem.setToYellow();
    	}
    	
    	if (rightButton1) {
    		Robot.ledSubsystem.setToGreen();
    	}
    	
    	if (leftButton2) {
    		Robot.ledSubsystem.setToBlue();
    	}
    	
    	if (leftDiagonalButton2) {
    		Robot.ledSubsystem.setToPurple();
    	}
    	
    	if (rightDiagonalButton2) {
    		Robot.ledSubsystem.setToRainbow();
    	}
    	if (rightButton2) {
    		Robot.ledSubsystem.setToOff();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
