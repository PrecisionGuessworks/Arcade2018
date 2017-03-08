package org.usfirst.frc.team1646.constants;

import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import edu.wpi.first.wpilibj.command.Subsystem;

public class ConstantUpdater extends Subsystem {

	private Collection<ConstantField> constantFields;
	
	public ConstantUpdater() {
		constantFields = new ArrayList<>();
		ArrayList<Class<?>> classes = new ArrayList<>();
		String jarName = "/home/lvuser/FRCUserProgram.jar";
		String packageDir = "org/usfirst/frc/team1646";
		try (ZipInputStream zis = new ZipInputStream(new FileInputStream(jarName))) {
			for (ZipEntry e = zis.getNextEntry(); e != null; e = zis.getNextEntry()) {
				if (!e.isDirectory()) {
					String eName = e.getName();
					if (eName.startsWith(packageDir) && eName.endsWith(".class")) {
						String className = eName.substring(0, eName.length() - ".class".length()).replace('/', '.');
						classes.add(Class.forName(className));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		HashSet<String> usedDisplayNames = new HashSet<String>();
		for (Class<?> cls : classes) {
			Field[] fields = cls.getDeclaredFields();
			for (Field field : fields) {
				if (field.getAnnotation(Constant.class) != null) {
					Class<?> type = field.getType();
					boolean isConstantType = type.equals(Integer.TYPE) || type.equals(Integer.class) ||
							type.equals(Double.TYPE) || type.equals(Double.class) ||
							type.equals(Float.TYPE) || type.equals(Float.class) ||
							type.equals(String.class);
					if (!isConstantType) {
						throw new RuntimeException("Constant must be int, double, float, or string\n" + field.toString());
					}
					if (!Modifier.isStatic(field.getModifiers())) {
						throw new RuntimeException("Constant must be static\n" + field.toString());
					}
					if (Modifier.isFinal(field.getModifiers())) {
						throw new RuntimeException("Constant must not be final\n" + field.toString());
					}
					field.setAccessible(true);
					StringBuilder displayNameBuilder = new StringBuilder();
					String fieldName = field.getName();
					for (int i = 0; i < fieldName.length(); i++) {
						if (i > 0) {
							char prevCh = fieldName.charAt(i - 1), curCh = fieldName.charAt(i);
							if (Character.isLowerCase(prevCh) && Character.isUpperCase(curCh)) {
								displayNameBuilder.append(' ');
								displayNameBuilder.append(Character.toLowerCase(curCh));
							} else {
								displayNameBuilder.append(curCh);
							}
						} else {
							displayNameBuilder.append(fieldName.charAt(i));
						}
					}
					if (usedDisplayNames.contains(displayNameBuilder.toString())) {
						throw new RuntimeException("Constant has duplicate name\n" + field.toString());
					}
					String displayName = displayNameBuilder.toString();
					usedDisplayNames.add(displayName);
					constantFields.add(new ConstantField(displayName, field));
				}
			}
		}
		constantFields = Collections.unmodifiableCollection(constantFields);
	}
	
	Collection<ConstantField> getConstantFields() {
		return constantFields;
	}
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new UpdateConstantsCommand(this));
	}

}
