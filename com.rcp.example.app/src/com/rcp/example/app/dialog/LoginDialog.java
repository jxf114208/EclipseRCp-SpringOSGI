/**
 * 
 */
package com.rcp.example.app.dialog;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.FormLayout;

/**
 * @author jxf
 *
 */
public class LoginDialog extends TitleAreaDialog {
	private Text textName;
	private Text textPassword;

	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public LoginDialog(Shell parentShell) {
		super(parentShell);
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite area = (Composite) super.createDialogArea(parent);
		area.setLayout(new GridLayout(2, false));
		new Label(area, SWT.NONE);
		
		Label lblNewLabel = new Label(area, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1));
		lblNewLabel.setText(" 用户名：");
		
		textName = new Text(area, SWT.BORDER);
		textName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblNewLabel_1 = new Label(area, SWT.NONE);
		lblNewLabel_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1));
		lblNewLabel_1.setText("密     码：");
		
		textPassword = new Text(area, SWT.BORDER | SWT.PASSWORD);
		textPassword.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		return area;
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		Button button = createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
//		button.addSelectionListener(new SelectionAdapter() {
//			/* (non-Javadoc)
//			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
//			 */
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//				super.widgetSelected(e);
//			}
//		});
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}
	
	private boolean login;
	

	public boolean isLogin() {
		return login;
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 300);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.Dialog#okPressed()
	 */
	@Override
	protected void okPressed() {
		if (textName.getText().equals("rcp") && textPassword.getText().equals("rcp")) {
			this.login = true;
		}else
		{
			login = false;
		}
		super.okPressed();
	}
}
