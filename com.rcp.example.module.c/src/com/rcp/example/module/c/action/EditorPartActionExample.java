package com.rcp.example.module.c.action;

import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.ui.part.EditorActionBarContributor;

import com.rcp.example.module.c.statusline.StatusLineContributionItemExample;

public class EditorPartActionExample extends EditorActionBarContributor {

	public EditorPartActionExample() {
	}

	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.EditorActionBarContributor#contributeToCoolBar(org.eclipse.jface.action.ICoolBarManager)
	 */
	@Override
	public void contributeToCoolBar(ICoolBarManager coolBarManager) {
		ActionExample action = new ActionExample();
		action.setText("EditorPartAction CoolItem");
		ToolBarManager tbm = new ToolBarManager();
		tbm.add(action);
		coolBarManager.add(tbm);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.EditorActionBarContributor#contributeToMenu(org.eclipse.jface.action.IMenuManager)
	 */
	@Override
	public void contributeToMenu(IMenuManager menuManager) {
		MenuManager menu = new MenuManager("EditorPartAction Menu");
		menuManager.add(menu);
		
		ActionExample action = new ActionExample();
		action.setText("EditorpartAction MenuItem");
		menu.add(action);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.EditorActionBarContributor#contributeToToolBar(org.eclipse.jface.action.IToolBarManager)
	 */
	@Override
	public void contributeToToolBar(IToolBarManager toolBarManager) {
		ActionExample action = new ActionExample();
		action.setText("EditorPartAction ToolItem");
		toolBarManager.add(action);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.EditorActionBarContributor#contributeToStatusLine(org.eclipse.jface.action.IStatusLineManager)
	 */
	@Override
	public void contributeToStatusLine(IStatusLineManager statusLineManager) {
		super.contributeToStatusLine(statusLineManager);
		statusLineManager.add(new StatusLineContributionItemExample("Example"));
	}
}
