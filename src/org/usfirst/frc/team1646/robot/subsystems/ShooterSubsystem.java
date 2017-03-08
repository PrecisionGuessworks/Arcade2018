package org.usfirst.frc.team1646.robot.subsystems;

import org.usfirst.frc.team1646.robot.RobotMap;
import org.usfirst.frc.team1646.robot.commands.ActivateFlyWheels;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ShooterSubsystem extends Subsystem {

	private CANTalon flywheels;

	PIDController controller; // where is private or public tag
	
	//Encoder model == AMT103-V; Resolution set to 250 RPM min. 15000 RPM max
	private Encoder flywheelRevolutionEncoder;
	
	private static double P = .5;
	private static double I = 0.01;
	private static double D = .1;

	// FIXME ConstantUpdater? The order of these static cannot be defined be
	// cause these values are
	// initialized first before the methods are called
	private static double period = 0.02;
	private static double rate = 10;
	private static double pulse = 0;
	// Average = Finds the mean of 'period' value. Simpler words: Makes up for
	// mechanical mistakes
	// Valid values are 1 to 127 samples: Don't go over 127
	private static int average = 0;
	public boolean stopped = true;

	public ShooterSubsystem() {

		// Initialize the electronics
		initFlywheels();
		// initEncoder();
	//	initShooterEncoder();
		// Initialize the PID Controller
		// controller = new PIDController(P, I, D, new
		// Source(countRotationEncoder), new Output(flywheels));
	}

	//
	private void initFlywheels() {
		//flywheels = new CANTalon(RobotMap.flyWheels);
	}
	
	/*private void initShooterEncoder() {
		flywheelRevolutionEncoder = new Encoder(RobotMap.shooterEncoderA, RobotMap.shooterEncoderB);
	}
*/
	/*
	 * private void initEncoder() { countRotationEncoder = new Encoder
	 * (RobotMap.flywheel1, RobotMap.flywheel2, false,
	 * Encoder.EncodingType.k1X); countRotationEncoder.reset(); stopped =
	 * countRotationEncoder.getStopped(); // This is the time between pulses on
	 * an individual channel. countRotationEncoder.setMaxPeriod(period); //
	 * Minimum rate before it's considered stopped.
	 * countRotationEncoder.setMinRate(rate); // Set the scale factor between
	 * pulses and distance. countRotationEncoder.setDistancePerPulse(pulse); //
	 * Sets the direction the encoder counts.
	 * countRotationEncoder.setReverseDirection(true); // Number of samples to
	 * average when determining the period.
	 * countRotationEncoder.setSamplesToAverage(average); }
	 */
	public double getPeriod() {
		return period;
	}

	public double getRate() {
		return rate;
	}

	public double getPulse() {
		return pulse;
	}

	public int getAverage() {
		return average;
	}

	public boolean getReset() {
		return stopped;
	}

	
	public CANTalon getFlyWheels() {
		return flywheels;
	}

	public void set(double power) {
		flywheels.set(power);
	}

	public void setSpeed(double speed) {
		controller.setSetpoint(speed);
	}

	@Override
	protected void initDefaultCommand() {
		// setDefaultCommand(new FlyWheelPIDcontroller());
		setDefaultCommand(new ActivateFlyWheels());
	}
	
	
	private class Output implements PIDOutput {
		// PIDOutput =

		// Now has access to flywheels that were initialized previously.
		

		public Output(double d) {
			set(d);
		}

		// PIDController calculates the
		@Override
		public void pidWrite(double output) {
			flywheels.set(output);
		}

	}
	
	private class Source implements PIDSource {
		// PIDSource =

		// Now has access to Encoder that was initialized previously.
		Encoder encoder;

		public Source(Encoder e) {
			encoder = e;
		}

		// Assigns a process control variable to one of the parameters: In this
		// case, 'pidSource'
		// 'pidSource' is an enum, meaning it passes only one out of a small set
		// of possible values that you describe
		@Override
		public void setPIDSourceType(PIDSourceType pidSource) {
			// TODO Auto-generated method stub

		}
//
		// Get the process control variable,'pidSource', and return Rate
		@Override
		public PIDSourceType getPIDSourceType() {
			// TODO Auto-generated method stub
			return PIDSourceType.kRate;
		}

//		// returns a result to use in PIDcontroller
		@Override
		public double pidGet() {

			return encoder.pidGet();
			// return 0;
		}

	}

}
