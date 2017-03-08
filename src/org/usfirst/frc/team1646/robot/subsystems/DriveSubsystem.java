package org.usfirst.frc.team1646.robot.subsystems;

import org.usfirst.frc.team1646.robot.Robot;
import org.usfirst.frc.team1646.robot.RobotMap;
import org.usfirst.frc.team1646.robot.commands.DriveWithSticks;

import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveSubsystem extends Subsystem{

	private Victor frontLeft;
	private Victor frontRight;
	private Victor backLeft;
	private Victor backRight;
	
	public Encoder leftSideEncoder;
	public Encoder rightSideEncoder;
	
	private static final double MAX = 1;
	private static final double MIN = -1;
	
	public DriveSubsystem() {
		
		frontLeft = new Victor(RobotMap.driveFrontLeft);
		frontRight = new Victor(RobotMap.driveFrontRight);
		backLeft = new Victor(RobotMap.driveBackLeft);
		backRight = new Victor(RobotMap.driveBackRight);

		leftSideEncoder = new Encoder(RobotMap.driveLeftEncoderA, RobotMap.driveLeftEncoderB, false, CounterBase.EncodingType.k4X);
		rightSideEncoder = new Encoder(RobotMap.driveRightEncoderA, RobotMap.driveRightEncoderB, false, CounterBase.EncodingType.k4X);
		
		/*initEncoder();
		getDriveEncoderVal();*/
	}
	
	public void rightPower(double right) {
		frontRight.set(right);
		backRight.set(right);
	}
	
	public void leftPower(double left) {
		frontLeft.set(-left);
		backLeft.set(-left);
	}
	
	
	
	public Victor getFrontLeft()
	{
		return frontLeft;
	}
	
	public Victor getFrontRight()
	{
		return frontRight;
	}
	
	public Victor getBackLeft()
	{
		return backLeft;
	}
	
	public Victor getBackRight()
	{
		return backRight;
	}
	
	
	public static double rangeCheck(double input, double max, double min){
		if (input > max) {
			return max;
		} else if (input < min) {
			return min;
		} 
		return input;	
	}
	
	
	public void arcadeDrive(double Y, double X)	
	{
		double rightPower;
		double leftPower;
		
		rightPower = Y - X;
		leftPower = Y + X;
		
		rightPower = rangeCheck(rightPower, MAX, MIN);
		leftPower = rangeCheck(leftPower, MAX, MIN);
		
		frontLeft.set(-leftPower);
		backLeft.set(-leftPower);
		
		frontRight.set(rightPower);
		backRight.set(rightPower);
	}
	
	/*public void initEncoder() {
		leftSideEncoder.reset();
		rightSideEncoder.reset();
		
		leftSideEncoder.setDistancePerPulse(50);
		rightSideEncoder.setDistancePerPulse(50);

		leftSideEncoder.setMinRate(10);
		rightSideEncoder.setMinRate(10);
	}
	
	public void getDriveEncoderVal() {

		int countL = leftSideEncoder.get();
		int countR = rightSideEncoder.get();
		double distanceL = leftSideEncoder.getDistance();
		double distanceR = rightSideEncoder.getDistance();
		double rateL = leftSideEncoder.getRate();
		double rateR = rightSideEncoder.getRate();
		boolean directionL = leftSideEncoder.getDirection();
		boolean directionR = rightSideEncoder.getDirection();
		boolean stoppedL = leftSideEncoder.getStopped();
		boolean stoppedR = rightSideEncoder.getStopped();
	}*/
	/*
	public void setEncoderValues() {
		leftSideEncoder.setDistancePerPulse(20);
		rightSideEncoder.setDistancePerPulse(20);
		
		leftSideEncoder.setMinRate(2);
		rightSideEncoder.setMinRate(2);
		
		leftSideEncoder.setReverseDirection(true);
		rightSideEncoder.setReverseDirection(true);
		
		leftSideEncoder.setSamplesToAverage(10);
		rightSideEncoder.setSamplesToAverage(10);
	}
	
	public void getEncoderValues() {
		int count;
		leftSideEncoder.getDistance();
		rightSideEncoder.getDistance();
		
		leftSideEncoder.getStopped();
		rightSideEncoder.getStopped();
		
	}*/
	public void tankDrive(double left, double right) 
	{
//		SmartDashboard.putNumber("left power:", left);
//		SmartDashboard.putNumber("Right power:", right);

		frontLeft.set(-left);
		backLeft.set(-left);
		
		frontRight.set(right);
		backRight.set(right);
	}
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new DriveWithSticks());
	}

}
