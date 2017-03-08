package org.usfirst.frc.team1646.robot.subsystems;

import org.usfirst.frc.team1646.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ShootingAngleSubsystem extends Subsystem {

	private Talon adjustAngle;
	private static int adjustSpeed = 1;

	public boolean collectFuel = true;
	public boolean fireFuel = false;

	public ShootingAngleSubsystem() {
		adjustAngle = new Talon(RobotMap.shooterHood);
	}

	public boolean getPositionRecharge() {
		return false;
	}

	public boolean getPositionFire() {
		return false;
	}

	public Talon getShootingAngleSubsystem() {
		return adjustAngle;
	}

	public void moveToCollect() {
		adjustAngle.set(adjustSpeed);
	}

	public void moveToFire(){
		adjustAngle.set(-adjustSpeed);
	}

	public void stop(){
		adjustAngle.set(0);
	}

	public void swapShooterHood() {
		collectFuel = !collectFuel;
		fireFuel = !fireFuel;
	}

	@Override
	protected void initDefaultCommand() {
	//	setDefaultCommand();
	}
}
