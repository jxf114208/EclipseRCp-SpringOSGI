/**
 * 
 */
package com.rcp.example.module.c.statusline;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;

/**
 * @author jxf
 *
 */
public class StatuslineComposite extends Composite {

	/**
	 * @param parent
	 * @param style
	 */
	public StatuslineComposite(Composite parent, int style) {
		super(parent, style);
		setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setText(" ddd ");
	}
}
