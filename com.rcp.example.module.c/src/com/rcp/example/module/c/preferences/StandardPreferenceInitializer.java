/**
 * 
 */
package com.rcp.example.module.c.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import com.rcp.example.module.c.Activator;

/**
 * @author jxf
 *
 */
public class StandardPreferenceInitializer extends AbstractPreferenceInitializer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#
	 * initializeDefaultPreferences()
	 */
	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		store.setDefault(StandardPreferenceContants.P_Standard_BOOLEAN, true);
		store.setDefault(StandardPreferenceContants.P_Standard_CHOICE, "Choice 2");
		store.setDefault(StandardPreferenceContants.P_Standard_BOOLEAN, "Standard-Default value");
	}
	
	public static void setBooleanPreference(Boolean b) {
		Activator.getDefault().getPreferenceStore().setValue(StandardPreferenceContants.P_Standard_BOOLEAN, b);
	}
	
	public static Boolean getBooleanPreference() {
		return Activator.getDefault().getPreferenceStore().getBoolean(StandardPreferenceContants.P_Standard_BOOLEAN);
	}
	
	public static Boolean getDefaultBooleanPreference() {
		return Activator.getDefault().getPreferenceStore().getDefaultBoolean(StandardPreferenceContants.P_Standard_BOOLEAN);
	}
	
	public static void setChoicePreference(String c) {
		Activator.getDefault().getPreferenceStore().setValue(StandardPreferenceContants.P_Standard_CHOICE, c);
	}
	
	public static String getChoicePreference() {
		return Activator.getDefault().getPreferenceStore().getString(StandardPreferenceContants.P_Standard_CHOICE);
	}
	
	public static String getDefaultChoicePreference() {
		return Activator.getDefault().getPreferenceStore().getDefaultString(StandardPreferenceContants.P_Standard_CHOICE);
	}

	public static void setStringPreference(String s) {
		Activator.getDefault().getPreferenceStore().setValue(StandardPreferenceContants.P_Standard_STRING, s);
	}

	public static String getStringPreference() {
		return Activator.getDefault().getPreferenceStore().getString(StandardPreferenceContants.P_Standard_STRING);
	}
	
	public static String getDefaultStringPreference() {
		return Activator.getDefault().getPreferenceStore().getDefaultString(StandardPreferenceContants.P_Standard_STRING);
	}
}
