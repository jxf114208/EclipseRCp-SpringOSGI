package com.rcp.example.module.c.action;

import org.eclipse.jface.action.CoolBarManager;
import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.widgets.CoolBar;

public class CoolBarManagerExample {

	public CoolBarManagerExample(CoolBar coolBar) {
		CoolBarManager cbm = new CoolBarManager(coolBar);
		fillAcitons(cbm);
		cbm.update(true);
	}

	protected void fillAcitons(ICoolBarManager cbm) {
		ActionExample action = new ActionExample();
		action.setText("CoolBar CoolItem");
		ToolBarManager tbm = new ToolBarManager();
		tbm.add(action);
		
		cbm.add(tbm);
	}
}
