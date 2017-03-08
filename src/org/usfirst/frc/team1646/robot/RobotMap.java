package org.usfirst.frc.team1646.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	// PWM   2/3/0/1
	public static int driveFrontLeft = 2;
	public static int driveBackLeft = 3;
	public static int driveFrontRight = 0;
	public static int driveBackRight = 1;

	//6/7/8/9
	//public static int gearHolder = 6;
	//1 = left, 2 = right
	public static int gearStabilizer1 = 6;
	public static int gearStabilizer2 = 5;
	
	//FIXME
	public static int ropeClimber = 8;
	
	//5/4
	public static int shooterHood = 9;
	public static int flyWheels = 1;
	
	// DIO + 6 DIO ports for 3 encoders/treat them as 4-pin, but we are using 5-pinx
	public static int flywheel1 = 0;
	public static int flywheel2 = 1;
	
	
	//public static int shooterEncoderA = 2;
	//public static int shooterEncoderB = 3;
	
	//these refers to the sides of the drive train
	public static int driveLeftEncoderA = 0;
	public static int driveLeftEncoderB = 1;
	public static int driveRightEncoderA = 2;
	public static int driveRightEncoderB = 3;
	
	//public static int gearHolder = 2;
	//public static int gearStabilizer = 3;
	
	
	
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
