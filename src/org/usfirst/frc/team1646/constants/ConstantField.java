package org.usfirst.frc.team1646.constants;

import java.lang.reflect.Field;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

class ConstantField {
	private String displayName;
	private Field field;
	
	public ConstantField(String displayName, Field field) {
		this.displayName = displayName;
		this.field = field;
	}
	public String getDisplayName() {
		return displayName;
	}
	public Field getField() {
		return field;
	}
	
	public void updateRemote() throws IllegalArgumentException, IllegalAccessException {
		Class<?> type = field.getType();
		if (type.equals(Integer.TYPE) || type.equals(Integer.class)) {
			SmartDashboard.putNumber(displayName, field.getInt(null));
		} else if (type.equals(Float.TYPE) || type.equals(Float.class)) {
			SmartDashboard.putNumber(displayName, field.getFloat(null));
		} else if (type.equals(Double.TYPE) || type.equals(Double.class)) {
			SmartDashboard.putNumber(displayName, field.getDouble(null));
		} else if (type.equals(String.class)) {
			SmartDashboard.putString(displayName, (String)field.get(null));
		}
	}
	
	public void refreshLocal() throws IllegalArgumentException, IllegalAccessException {
		Class<?> type = field.getType();
		if (type.equals(Integer.TYPE) || type.equals(Integer.class)) {
			field.setInt(null, (int)SmartDashboard.getNumber(displayName, 0));
		} else if (type.equals(Float.TYPE) || type.equals(Float.class)) {
			field.setFloat(null, (float)SmartDashboard.getNumber(displayName, 0.0f));
		} else if (type.equals(Double.TYPE) || type.equals(Double.class)) {
			field.setDouble(null, (double)SmartDashboard.getNumber(displayName, 0.0d));
		} else if (type.equals(String.class)) {
			field.set(null, SmartDashboard.getString(displayName, ""));
		}
	}
}
