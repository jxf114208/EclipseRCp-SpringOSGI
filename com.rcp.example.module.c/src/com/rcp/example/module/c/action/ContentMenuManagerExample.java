package com.rcp.example.module.c.action;

import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;

public class ContentMenuManagerExample {

	public ContentMenuManagerExample(final Control control) {
		final MenuManager mm = new MenuManager();
		mm.setRemoveAllWhenShown(true);
		Menu menu = mm.createContextMenu(control);
		control.setMenu(menu);
		
		mm.addMenuListener(new IMenuListener() {
			
			@Override
			public void menuAboutToShow(IMenuManager manager) {
				fillActions(mm);
			}
		});
	}

	protected void fillActions(IMenuManager mm) {
		ActionExample action = new ActionExample();
		action.setText("ContentMenu MenuItem");
		mm.add(action);
	}
}
