package org.usfirst.frc.team1646.robot.commands;

import org.usfirst.frc.team1646.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveWithSticks extends Command {
	private double maxPower = 0;
	private boolean modeTank = true;
	// private boolean modeArcade = false;
	private int counter = 0;
	// private int maxCount = 34;
	private double maxTime = 2.0; 
	private boolean timeStop = false;
	public boolean a = false;
	
	public DriveWithSticks() {
		requires(Robot.driveSubsystem);
	}

	@Override
	protected void initialize() {
		// Robot.driveSubsystem.tankDrive(.5, .5);
	}

	// make a button that moves some distance away from the loading station: 4
	// 1/2 in.
	// half power/100 cycles
	
	@Override
	protected void execute() {
		double left = Robot.oi.leftStick.getY();
		double right = Robot.oi.rightStick.getY();

		boolean leftTrigger = Robot.oi.leftStick.getRawButton(1);
		boolean rightTrigger = Robot.oi.rightStick.getRawButton(1);

		boolean rightBumper = Robot.oi.leftStick.getRawButton(3);
		boolean leftBumper = Robot.oi.rightStick.getRawButton(3);

		boolean middleLeft = Robot.oi.leftStick.getRawButton(2);
		boolean middleRight = Robot.oi.rightStick.getRawButton(2);
		
		//How does one read encoder values and translate it to engineering values (inches/etc)
		/*@SuppressWarnings("deprecation")
		double leftEncoder = SmartDashboard.getNumber("LeftEncoder Input");
		//if the encoder starts working (leftEncoder >0) and the autonomous starts running, then 
		//the encoders will start printing values for distance traveled
		if (leftEncoder > 0 && autonomousInit()) {
			setEncoderDistanceL();
			SmartDashboard.putNumber("leftEncoder", Robot.driveSubsystem.leftSideEncoder.getDistance());
			if () {
				resetEncoderDistance();
			}
		}
		@SuppressWarnings("deprecation")
		double rightEncoder = SmartDashboard.getNumber("rightEncoder Input");
		if (rightEncoder > 0 &&) {
			setEncoderDistanceR();
			SmartDashboard.putNumber("rightEncoder", Robot.driveSubsystem.rightSideEncoder.getDistance());
		}*/
		SmartDashboard.putData(Robot.driveSubsystem);

		/*if (leftBumper || rightBumper) {
			counter = 0;
			resetEncoderDistance();
			setEncoderDistance();
			modeTank = false;
			
			maxTime = 0;
			maxTime+=0.1;
			if (maxTime == 2) {
				modeTank = true;
			}
		} 
		
		while ((leftBumper || rightBumper) && counter <= 100) {
			double power = 0.3;
			Robot.driveSubsystem.tankDrive(power, -power);
			SmartDashboard.putNumber("Encoder Distance L:", Robot.driveSubsystem.leftSideEncoder.getDistance());
			SmartDashboard.putNumber("Encoder Distance R:", Robot.driveSubsystem.rightSideEncoder.getDistance());
			counter++;
			
			if (Robot.driveSubsystem.leftSideEncoder.getDistance() > 4.5 && Robot.driveSubsystem.rightSideEncoder.getDistance() > 4.5) {
				modeTank = true;
			}	
		}
*/
		//ask if counter needs to be set to 0 here
		if (counter > 100) {
			modeTank = true;
		}

		/*
		 * 
		 * if (leftBelowTrigger || rightBelowTrigger) { if (counter == 0) {
		 * swapDriveMode(); } counter++; }
		 * 
		 * if (counter != 0) { counter++;
		 * 
		 * if (counter == maxCount) { counter = 0; } }
		 * 
		 * // 1 if (modeArcade) { maxPower = 0.5;
		 * 
		 * double Y = Robot.oi.leftStick.getY(); double X =
		 * Robot.oi.rightStick.getX();
		 * 
		 * boolean middleLeft = Robot.oi.leftStick.getRawButton(2); boolean
		 * middleRight = Robot.oi.rightStick.getRawButton(2);
		 * 
		 * Robot.driveSubsystem.arcadeDrive(maxPower * Y, maxPower * -X);
		 * 
		 * if (middleLeft || middleRight) {
		 * Robot.driveSubsystem.arcadeDrive(maxPower * -Y, maxPower * X); if
		 * (leftTrigger || rightTrigger) { Robot.driveSubsystem.arcadeDrive(-Y,
		 * X); } } if (leftTrigger || rightTrigger) {
		 * Robot.driveSubsystem.arcadeDrive(Y, -X); } }
		 */
		if (modeTank) {
			if (leftTrigger || rightTrigger) {
				maxPower = 1;
				Robot.driveSubsystem.tankDrive(maxPower * left, maxPower * right);
			} else {
				maxPower = 0.5;
				Robot.driveSubsystem.tankDrive(maxPower * left, maxPower * right);
			}
			
			//Changing Y- values of both joysticks:joysticks forward = robot backwards
			if (middleLeft || middleRight) {
				maxPower = 1;
				Robot.driveSubsystem.tankDrive(maxPower * left, -maxPower * right);
			}
			
			// If backup button pressed
			// 1) Set modeTank false
			// 2) Set drives backwards speed
			// 3) Reset distance measured on encoders
			// 4) set max backup time to 2 seconds
		}
		// else
		// Get encoder distance 
		// If distance > X inches (?) || timeout
		//		Drives stop
		//		modeTank true
	}
	
	//Make a boolean that says true if autonomousDrive is running
	//put the boolean in the if-statement in the "encoder/smartdashboard" area
	//I am hoping to make the encoders print out value only when the autonomous is running 
	//we want the autoGear during the competition to work
	/*private boolean autoHasBegun() {
		
		if (new autonomousDrive(0.5,0.5,0.5)) {
			return true;
		}
	}*/
	
	private void resetEncoderDistance() {
		Robot.driveSubsystem.leftSideEncoder.reset();
    	Robot.driveSubsystem.rightSideEncoder.reset();
	}
	
	
	//6 = inches on drive train wheels
    public void setEncoderDistanceL() {
    	Robot.driveSubsystem.leftSideEncoder.setDistancePerPulse(Math.abs((1.0/250.0)*6*Math.PI));
    	
    	Robot.driveSubsystem.leftSideEncoder.setMaxPeriod(3);
    	
    //if setMaxPeriod > 3 seconds, then the Robot should stop immediately
    //if we can read the encoder inputs from smartdashboard, this is not necessary
    //inertia = too overpowered
    	/*if () {
    		
    	}*/
    }
    
    public void setEncoderDistanceR() {
    	Robot.driveSubsystem.rightSideEncoder.setDistancePerPulse(Math.abs((1.0/250.0)*6*Math.PI));
    	
    	Robot.driveSubsystem.rightSideEncoder.setMaxPeriod(3);
    }
    
    /*public void getEncoderDistance() {
    	Robot.driveSubsystem.leftSideEncoder.getDistance();
    	Robot.driveSubsystem.rightSideEncoder.getDistance();
    }
    */
    //determines whether the encoders have stopped or still working; not much else
    public void determineEncoderState() {
    	Robot.driveSubsystem.leftSideEncoder.getStopped();
    	Robot.driveSubsystem.rightSideEncoder.getStopped();
    }

	/*
	 * public void swapDriveMode() { modeTank = !modeTank; modeArcade =
	 * !modeArcade; }
	 */
	/*public void prepareGearLoad() {

		double power = 0.5;
		Robot.driveSubsystem.tankDrive(power, power);
*///		for (int i = 0; i < 1; i++) {
//			power += 0.1;
//			
//		}
//		for (int i = 0; i < 900; i++) {
//			Robot.driveSubsystem.tankDrive(power, power);
//		}
//		for (int i = 0; i < 1; i++) {
//			power -= 0.1;
//			Robot.driveSubsystem.tankDrive(power, power);
//		}
	
	/*
	 * double leftCircle = Robot.oi.controller.getY(); double rightCircle =
	 * Robot.oi.controller.getY();
	 * 
	 * boolean leftBumper = Robot.oi.controller.getRawButton(5); boolean
	 * rightBumper = Robot.oi.controller.getRawButton(6);
	 * 
	 * if (leftBumper || rightBumper) { maxPower = 1;
	 * Robot.driveSubsystem.tankDrive(maxPower * leftCircle, maxPower *
	 * rightCircle); } else { maxPower = 0.5;
	 * Robot.driveSubsystem.tankDrive(maxPower * leftCircle, maxPower *
	 * rightCircle); } }
	 */
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
