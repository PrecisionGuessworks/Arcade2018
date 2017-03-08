
package org.usfirst.frc.team1646.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team1646.constants.ConstantUpdater;
import org.usfirst.frc.team1646.robot.commands.AutonomousDrive;
import org.usfirst.frc.team1646.robot.commands.AutonomousServos;
import org.usfirst.frc.team1646.robot.commands.DriveWithSticks;
import org.usfirst.frc.team1646.robot.commands.StabilizeGear;
import org.usfirst.frc.team1646.robot.subsystems.ClimbSubsystem;
import org.usfirst.frc.team1646.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team1646.robot.subsystems.GearStabilizer;
import org.usfirst.frc.team1646.robot.subsystems.LEDSubsystem;
import org.usfirst.frc.team1646.robot.subsystems.ShooterSubsystem;
import org.usfirst.frc.team1646.robot.subsystems.ShootingAngleSubsystem;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static DriveSubsystem driveSubsystem;
	public static ConstantUpdater constantUpdater;
	public static ClimbSubsystem climbSubsystem;
	public static GearStabilizer gearStabilizer;
	public static ShootingAngleSubsystem shootingAngleSubsystem;
	public static ShooterSubsystem shooterSubsystem;
	public static LEDSubsystem ledSubsystem;
	public static OI oi;

	Command autonomousCommand;
	SendableChooser chooser;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {

		driveSubsystem = new DriveSubsystem();
		constantUpdater = new ConstantUpdater();
		climbSubsystem = new ClimbSubsystem();
		gearStabilizer = new GearStabilizer();
		shootingAngleSubsystem = new ShootingAngleSubsystem();
		shooterSubsystem = new ShooterSubsystem();
		ledSubsystem = new LEDSubsystem();
		oi = new OI();
		innitCamera();
		innitSmartDashboard();

		// chooser = new SendableChooser();
		// chooser.addDefault("Default Auto", new ExampleCommand());
		// chooser.addObject("My Auto", new MyAutoCommand());
		// SmartDashboard.putData("Auto mode", chooser);
	}

	public void innitCamera() {
		CameraServer server = CameraServer.getInstance();
		server.startAutomaticCapture("Cam0", 0);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	public void disabledInit() {

	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/*
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	public void autonomousInit() {
		//This set of autonomous command is for SIDE autoGear
		//Robot must move forward then angle whatever degrees to align with the hook
		//find the CORRECT VALUES for EVERYTHING under autonomousInit()
		boolean stabilize = true;
		boolean release = true;
		new AutonomousDrive(-.5, -.5, 0.5).start();

		//Turning right currently, put the negative side on the middle parameter to make it turn left while the robot is still
		//new AutonomousDrive(-0.5, 0.5, 0.5).start();
		//Robot must move forward again to get the gear on the hook
		//new AutonomousDrive(-0.5, -0.5, 0.5.start();

		//Servos: make 2 AutonomousServos: 1 for stabilize, 1 for release
		//stabilize = closed(- -), release = open (| |)

		// Open the servos (release = true)
//		new AutonomousServos(!stabilize, release).start();

		//Robot must move back from the hook before it can close the servos
//		new AutonomousDrive(0.5, 0.5, 0.5).start();

		//Close the servos (stabilize = true)
//		new AutonomousServos(stabilize, !release).start();
		//Optional: make the robot "straight" instead of angled at the end for driver's convenience
		// new AutonomousDrive(0.5, -0.5, 0.5).start();



		//This set of autonomous command is for MID autoGear
		//Robot must move forward until it reaches the middle of the hook
		// new AutonomousDrive(-0.5, -0.5. 0.5).start();

		//Servos: make 2 AutonomousServos: 1 for stabilize, 1 for release
		//stabilize = closed(- -), release = open (| |)

		//Open the servos (release = true)
		// new AutnomousServos(false, true, 1).start();

		//Robot must move back from the hook before it can close the servos
		// new AutonomousDrive(0.5, 0.5, 0.5).start();

		//Close the servos (stabilize = true)
		// new AutnomousServos(true, false, 1).start();

		/*
		 * under the assumption that a false stabilize boolean implies that the
		 * servos are closed and a true release boolean implies that the servos
		 * are open, this should work. I don't know what the wait time is, but
		 * the value is in ms, I think. So if you intend on waiting 1 second
		 * before release, it should be 1000 ms. Also, for turning precisely
		 * during Auton, it would be beneficial to use the encoders I made!!!!!
		 * Also, kinda need to test distances with the encoders, however if you
		 * know x rotations = y distance, which can be calculated through simply
		 * angular motion and physics equations, you should be able to find out
		 * far a single rotation of the wheels moves you forward. Additionally,
		 * turning is a hard thing to do. However, you should be able to turn
		 * some ratio (triangles!!) between the two sides in order to turn 45
		 * degrees or any number of degrees. If you decide to turn, I would
		 * suggest starting out with a stationary turning via encoders. So, x
		 * rotations on the left and y rotations on the right.
		 */

		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		new DriveWithSticks().start();
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}

	public void innitSmartDashboard() {
		SmartDashboard.putNumber("shooter speed", 0);
		SmartDashboard.putNumber("leftEncoder", 0);
		SmartDashboard.putNumber("rightEncoder", 0);
	}
}
