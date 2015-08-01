package com.rcp.example.module.c.action;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;

public class ActionExample extends Action {
	
	@Override
	public void run() {
		MessageDialog.openInformation(null, "Hi", "I am Action");
	}
}
