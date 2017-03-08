/*package org.usfirst.frc.team1646.robot.subsystems;

import org.usfirst.frc.team1646.robot.RobotMap;
import org.usfirst.frc.team1646.robot.commands.GearMovement;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearSubsystem extends Subsystem {
	
	private Solenoid gearHolder;
	
	public static boolean extended = true;
	public static boolean retracted = false;
	
	
	
	public GearSubsystem() {
		gearHolder = new Solenoid(RobotMap.gearHolder);
	}
	
	public Solenoid getGearHolder() {
		return gearHolder; 
	}
	
	// true means extended, false means extracted
		public void setExtended() {
			gearHolder.set(extended);	
		}
		
		public void setRetracted() {
			gearHolder.set(retracted);
		}
	
	
	//added setDefaultCommand(new GearMovement()); to follow to model...
	@Override
	protected void initDefaultCommand() {	
		setDefaultCommand(new GearMovement());
	}
		
}*/
