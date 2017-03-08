package org.usfirst.frc.team1646.robot.commands;

import org.usfirst.frc.team1646.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ActivateFlyWheels extends Command {

	public static int counterRound;
	public boolean a = false;
	
	
	public ActivateFlyWheels() {
		requires(Robot.shooterSubsystem);
	}
	
	@Override
	protected void initialize() {
		
	}
	
	@Override
	protected void execute() {
		/*@SuppressWarnings("deprecation")
		double left = SmartDashboard.getNumber("shooter speed");
		double left = Robot.oi.leftStick.getY();
		Robot.shooterSubsystem.set(0);*/
		SmartDashboard.putData(Robot.shooterSubsystem);
		
		
		boolean leftBumper = Robot.oi.controller.getRawButton(5);
		boolean rightBumper = Robot.oi.controller.getRawButton(6);
		
		boolean backButton = Robot.oi.controller.getRawButton(7);
		if(leftBumper) {
			Robot.shooterSubsystem.set(0.5);
		}
		
		if(rightBumper) {
			Robot.shooterSubsystem.set(-0.5);
		}
		
		if(backButton) {
			Robot.shooterSubsystem.set(0);
		}
		
		
		/*
		boolean button2 = Robot.oi.leftStick.getRawButton(2);
		boolean button1 = Robot.oi.leftStick.getRawButton(7);
		
		if (button2) {
			a = false;
		} 
		
		if (button2 && counterRound <= 100) {
			Robot.shooterSubsystem.set(0.5);
			counterRound++;
		} else if (button1) {
			Robot.shooterSubsystem.set(0);
			a = true;
		} else if (counterRound > 100 && !a) {
			Robot.shooterSubsystem.set(0.15);
		}
	*/
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	

	@Override
	protected void end() {


	}

	@Override
	protected void interrupted() {


	}
}
