package org.usfirst.frc.team1646.robot.commands;

import org.usfirst.frc.team1646.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ReleaseGear extends Command {

    public ReleaseGear() {
    	requires(Robot.gearStabilizer);
    
    }
    
    @Override
    protected void initialize() {
    	Robot.gearStabilizer.moveToReleasedL();
		Robot.gearStabilizer.moveToReleasedR();
    }
    
    @Override
    protected void execute() {
    	
    	
    		
    	
    	//Robot.gearStabilizer.moveToReleasedL();
    	
    }

    @Override
    protected boolean isFinished() {
        return true;
    	//return Robot.gearStabilizer.getPositionRelease();
    }

    @Override
    protected void end() {
    	//Robot.gearStabilizer.stop();
    }

    @Override
    protected void interrupted() {
    }
}
