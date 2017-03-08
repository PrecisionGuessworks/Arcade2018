package org.usfirst.frc.team1646.robot.subsystems;

import org.usfirst.frc.team1646.robot.RobotMap;
import org.usfirst.frc.team1646.robot.commands.ClimbMovement;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ClimbSubsystem extends Subsystem {
	
	private Victor ropeClimber;
	
	public static boolean climbUp = true;
	public static boolean climbDown = false;
	
	
	public ClimbSubsystem() {
		
		ropeClimber = new Victor(RobotMap.ropeClimber);
	
	}
	
	public Victor getRopeClimber() {
		return ropeClimber;
	}

	public void set(double climbSpeed) {
		ropeClimber.set(climbSpeed);
	}	
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ClimbMovement());
	}
	
	
}
