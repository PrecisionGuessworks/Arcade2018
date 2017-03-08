package org.usfirst.frc.team1646.robot.commands;

import org.usfirst.frc.team1646.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ChangeAngle extends Command {

    public ChangeAngle() {
    	requires(Robot.shootingAngleSubsystem);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	boolean buttonB = Robot.oi.controller.getRawButton(2);
    	boolean buttonStart = Robot.oi.controller.getRawButton(8);
    	
    	if (buttonB) {
    		Robot.shootingAngleSubsystem.moveToCollect();
    	}
    	if (buttonStart) {
    		Robot.shootingAngleSubsystem.moveToFire();
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
