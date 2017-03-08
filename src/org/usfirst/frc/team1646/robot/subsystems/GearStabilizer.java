package org.usfirst.frc.team1646.robot.subsystems;

import org.usfirst.frc.team1646.robot.RobotMap;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearStabilizer extends Subsystem {
	
	private Servo gearStabilizerL;
	private Servo gearStabilizerR;
	//public static double gearPower = 0.5;
	
	public GearStabilizer() {
		
		gearStabilizerL = new Servo(RobotMap.gearStabilizer1);
		gearStabilizerR = new Servo(RobotMap.gearStabilizer2);
		
	}
	
//	public boolean getPositionStabilized() {
//		return true;
//	}
//	public boolean getPositionRelease() {
//		return true;
//	}

	public Servo getLeftGearStabilizer() {
		return gearStabilizerL;
	}
	
	public Servo getRightGearStabilizer() {
		return gearStabilizerR;
	}
	
	public void moveToReleasedL() {
		//gearStabilizerL.set(1);
		gearStabilizerL.setPosition(.535);
	}
	public void moveToReleasedR() {
		//gearStabilizerR.set(1); .845
		gearStabilizerR.setPosition(.845);
	}
	
	
	public void moveToStabilizedL(){
		//gearStabilizerL.set(0);995
		gearStabilizerL.setPosition(.995);
	}
	public void moveToStabilizedR() {
		//gearStabilizerR.set(0);
		gearStabilizerR.setPosition(.335);
	}
	
	
	public void stop(){
		//gearStabilizerL.setDisabled();
		//gearStabilizerR.setDisabled();
	}
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

