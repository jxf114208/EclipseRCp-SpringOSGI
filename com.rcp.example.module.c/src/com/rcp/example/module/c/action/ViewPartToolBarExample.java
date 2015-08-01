/**
 * 
 */
package com.rcp.example.module.c.action;

import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.ui.part.ViewPart;

/**
 * @author jxf
 *
 */
public class ViewPartToolBarExample {
	/**
	 * 
	 */
	public ViewPartToolBarExample(ViewPart viewPart) {
		IToolBarManager tbm = viewPart.getViewSite().getActionBars().getToolBarManager();
		fillActions(tbm);
		tbm.update(true);
	}

	/**
	 * @param tbm
	 */
	protected void fillActions(IToolBarManager tbm) {
		ActionExample action = new ActionExample();
		action.setText("ViewPart ToolItem");
		tbm.add(action);
	}
}
