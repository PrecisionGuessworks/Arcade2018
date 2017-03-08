package org.usfirst.frc.team1646.robot.commands;

import org.usfirst.frc.team1646.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */

public class StabilizeGear extends Command {

    public StabilizeGear() {
    	requires(Robot.gearStabilizer);
    }

    @Override
    protected void initialize() { 
		Robot.gearStabilizer.moveToStabilizedL();
		Robot.gearStabilizer.moveToStabilizedR();
    }

    @Override
    protected void execute() {	
    		
    	/*Robot.gearStabilizer.moveToStabilizedL();
    	Robot.gearStabilizer.moveToReleasedL();
    	
    	Robot.gearStabilizer.movetoStabilizedR();
     	Robot.gearStabilizer.moveToReleasedR();
*/ 
    	}
    
    	
    @Override
    protected boolean isFinished() {
    	return true;
    	//return Robot.gearStabilizer.getPositionStabilized();
    }

    @Override
    protected void end() {
    	//Robot.gearStabilizer.stop();
    }

    @Override
    protected void interrupted() {
    }
}
