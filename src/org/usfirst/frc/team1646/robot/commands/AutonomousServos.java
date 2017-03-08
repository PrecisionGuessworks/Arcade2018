package org.usfirst.frc.team1646.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class AutonomousServos extends CommandGroup {

	//ASK Kelvin about the waitTime/WaitCommand on servos
	//Whether it is necessary to have waitTime or not
    public AutonomousServos(boolean stabilizeGear, boolean releaseGear) {
    	addSequential(new AutoStabilizeServo(stabilizeGear));
    	//addSequential(new WaitCommand(waitTime));
    	addSequential(new AutoReleaseServo(releaseGear));
    	//addSequential(new StopMovingServos());
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
