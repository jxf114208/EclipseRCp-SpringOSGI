/**
 * 
 */
package com.rcp.example.module.c.action;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.part.ViewPart;

/**
 * @author jxf
 *
 */
public class ViewPartMenuBarExample {
	/**
	 * 
	 */
	public ViewPartMenuBarExample(ViewPart viewPart) {
		IMenuManager mm = viewPart.getViewSite().getActionBars().getMenuManager();
		
		fillActions(mm);
		mm.update(true);
	}

	/**
	 * @param mm
	 */
	protected void fillActions(IMenuManager mm) {
		ActionExample action = new ActionExample();
		action.setText("ViewPart MenuItem");
		mm.add(action);
	}
}
