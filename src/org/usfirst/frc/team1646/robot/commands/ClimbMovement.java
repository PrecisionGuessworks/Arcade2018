package org.usfirst.frc.team1646.robot.commands;

import org.usfirst.frc.team1646.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ClimbMovement extends Command {

	private double motorPower;

	public ClimbMovement() {
		requires(Robot.climbSubsystem);
	}

	@Override
	protected void initialize() {
		Robot.climbSubsystem.set(0);
	}

	@Override
	protected void execute() {

		boolean Xbutton = Robot.oi.controller.getRawButton(3);

		// 50 points :D 
		if (Xbutton) {

			motorPower = -1;
			Robot.climbSubsystem.set(motorPower);

		} else {
			motorPower = 0;
			Robot.climbSubsystem.set(motorPower);

		}
	}

	@Override
	protected boolean isFinished() {
		return false;
	}


	@Override
	protected void end() {


	}

	@Override
	protected void interrupted() {
	}
}

