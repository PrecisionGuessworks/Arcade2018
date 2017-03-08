package org.usfirst.frc.team1646.robot.subsystems;

import org.usfirst.frc.team1646.robot.commands.LEDJoysticks;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LEDSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	DigitalOutput port1;
	DigitalOutput port2;
	DigitalOutput port3;
	
	public LEDSubsystem () {
		port1 = new DigitalOutput(10);
		port2 = new DigitalOutput(11);
		port3 = new DigitalOutput(12);
	}
	
	//Shifts LED to Off (0,0,0)
	public void setToOff() {
		setLEDColor(false, false, false);
	}
	
	//Shifts LED to Blue (0,0,1)
	public void setToBlue() {
		setLEDColor(false, false, true);
	}
	
	//Shifts LED to Red (0,1,0)
	public void setToRed() {
		setLEDColor(false, true, false);
	}
	
	//Shifts LED to Green (0,1,1)
	public void setToGreen() {
		setLEDColor(false, true, true);
	}
	
	//Shifts LED to Orange (1,0,0)
	public void setToOrange() {
		setLEDColor(true, false, false);
	}
	
	//Shifts LED to Yellow (1,0,1)
	public void setToYellow() {
		setLEDColor(true, false, true);
	}
	
	//Shifts LED to Purple (1,1,0)
	public void setToPurple() {
		setLEDColor(true, true, false);
	}
	
	//Shifts LED to (1,1,1)
	public void setToRainbow() {
		setLEDColor(true, true, true);
	}
		
		
	public void setLEDColor(boolean one, boolean two, boolean three){
		port1.set(one);
		port2.set(two);
		port3.set(three);
	}
	

    public void initDefaultCommand() {
    	setDefaultCommand(new LEDJoysticks());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

