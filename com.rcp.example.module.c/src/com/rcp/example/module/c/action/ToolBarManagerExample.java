package com.rcp.example.module.c.action;

import org.eclipse.jface.action.IContributionManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.widgets.ToolBar;

public class ToolBarManagerExample {

	public ToolBarManagerExample(ToolBar toolBar) {
		ToolBarManager tbm = new ToolBarManager(toolBar);
		fillActions(tbm);
		tbm.update(true);
	}

	protected void fillActions(IContributionManager tbm) {
		ActionExample action = new ActionExample();
		action.setText("ToolBar ToolItem");
		tbm.add(action);
	}
}
