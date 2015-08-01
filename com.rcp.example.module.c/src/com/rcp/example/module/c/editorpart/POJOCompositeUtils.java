package com.rcp.example.module.c.editorpart;

import java.lang.reflect.Field;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;

public class POJOCompositeUtils {
	public static void setPOJO(Composite composite, Object pojo) {
		initPOJO(composite, pojo, true);
	}

	public static void getPOJO(Composite composite, Object pojo) {
		initPOJO(composite, pojo, false);
	}

	private static void initPOJO(Composite composite, Object pojo, boolean set) {
		Field[] fields = pojo.getClass().getDeclaredFields();
		for (Field field : fields) {
			try {
				field.setAccessible(true);
				String fieldName = field.getName();
				Object fieldValue = field.get(pojo);
				Class<?> fieldType = field.getType();
				initControl(composite, pojo, fieldName, fieldValue, fieldType, set);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private static void initControl(Composite composite, Object pojo, String fieldName, Object fieldValue, Class<?> fieldType, boolean set) {
		if (fieldType.equals(String.class)) {
			try {
				Field fieldControl = composite.getClass().getDeclaredField(fieldName);
				fieldControl.setAccessible(true);
				Control control = (Control) fieldControl.get(composite);
				if (set) {
					if (control instanceof Text) {
						((Text)control).setText(fieldValue.toString());
					}else {
						Field fieldPojo = pojo.getClass().getDeclaredField(fieldName);
						fieldPojo.setAccessible(true);
						if (control instanceof Text) {
							fieldPojo.set(pojo, ((Text)control).getText());
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
