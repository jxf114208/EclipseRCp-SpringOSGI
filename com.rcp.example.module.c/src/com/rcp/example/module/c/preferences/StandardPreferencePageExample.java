/**
 * 
 */
package com.rcp.example.module.c.preferences;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.rcp.example.module.c.Activator;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;

/**
 * @author jxf
 *
 */
public class StandardPreferencePageExample extends PreferencePage implements IWorkbenchPreferencePage {
	private Text text;
	private Button btnCheckButton;
	private Button btnRadioButton_1;
	private Button btnRadioButton_2;

	/**
	 * Create the preference page.
	 */
	public StandardPreferencePageExample() {
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
	}

	/**
	 * Create contents of the preference page.
	 * @param parent
	 */
	@Override
	public Control createContents(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		container.setLayout(new GridLayout(2, false));
		
		text = new Text(container, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		btnCheckButton = new Button(container, SWT.CHECK);
		btnCheckButton.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		btnCheckButton.setText("Check Button");
		
		btnRadioButton_1 = new Button(container, SWT.RADIO);
		btnRadioButton_1.setText("Radio Button1");
		btnRadioButton_1.setData("Choice 1");
		
		btnRadioButton_2 = new Button(container, SWT.RADIO);
		btnRadioButton_2.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		btnRadioButton_2.setText("Radio Button2");
		btnRadioButton_2.setData("Choice 2");
		
		btnCheckButton.setSelection(StandardPreferenceInitializer.getBooleanPreference());
		text.setText(StandardPreferenceInitializer.getStringPreference());
		btnRadioButton_1.setSelection(StandardPreferenceInitializer.getChoicePreference().equals(btnRadioButton_1.getData()));
		btnRadioButton_2.setSelection(StandardPreferenceInitializer.getChoicePreference().equals(btnRadioButton_2.getData()));

		return container;
	}

	/**
	 * Initialize the preference page.
	 */
	public void init(IWorkbench workbench) {
		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.PreferencePage#performOk()
	 */
	@Override
	public boolean performOk() {
		StandardPreferenceInitializer.setBooleanPreference(btnCheckButton.getSelection());
		StandardPreferenceInitializer.setStringPreference(text.getText());
		if (btnRadioButton_1.getSelection()) {
			btnRadioButton_1.setSelection(StandardPreferenceInitializer.getChoicePreference().equals(btnRadioButton_1.getData()));
		}
		if (btnRadioButton_2.getSelection()) {
			btnRadioButton_2.setSelection(StandardPreferenceInitializer.getChoicePreference().equals(btnRadioButton_2.getData()));
		}
		return super.performOk();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.PreferencePage#performDefaults()
	 */
	@Override
	protected void performDefaults() {
		btnCheckButton.setSelection(StandardPreferenceInitializer.getDefaultBooleanPreference());
		text.setText(StandardPreferenceInitializer.getDefaultStringPreference());
		btnRadioButton_1.setSelection(StandardPreferenceInitializer.getDefaultChoicePreference().equals(btnRadioButton_1.getData()));
		btnRadioButton_2.setSelection(StandardPreferenceInitializer.getDefaultChoicePreference().equals(btnRadioButton_2.getData()));
		super.performDefaults();
	}
}
