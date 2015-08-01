package com.rcp.example.module.c.editorpart;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;

public class ElementPOJOComposite extends Composite {
	private Text name;
	private Text column0;
	private Text column1;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public ElementPOJOComposite(Composite parent, int style) {
		super(parent, style);
		setLayout(new GridLayout(2, false));
		
		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel.setText(" name");
		
		name = new Text(this, SWT.BORDER);
		name.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblColumn = new Label(this, SWT.NONE);
		lblColumn.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblColumn.setText(" column1");
		
		column0 = new Text(this, SWT.BORDER);
		column0.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblNewLabel_1 = new Label(this, SWT.NONE);
		lblNewLabel_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_1.setText("column2");
		
		column1 = new Text(this, SWT.BORDER);
		column1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
