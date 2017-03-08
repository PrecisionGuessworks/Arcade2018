package org.usfirst.frc.team1646.constants;

import java.util.Collection;

import edu.wpi.first.wpilibj.command.Command;

class UpdateConstantsCommand extends Command {
	
	private Collection<ConstantField> constantFields;
	
	public UpdateConstantsCommand(ConstantUpdater constantUpdater) {
		constantFields = constantUpdater.getConstantFields();
		setRunWhenDisabled(true);
		setInterruptible(false);
		requires(constantUpdater);
	}

	@Override
	protected void initialize() {
		try {
			for (ConstantField constantField : constantFields) {
				constantField.updateRemote();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void execute() {
		try {
			for (ConstantField constantField : constantFields) {
				constantField.refreshLocal();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

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