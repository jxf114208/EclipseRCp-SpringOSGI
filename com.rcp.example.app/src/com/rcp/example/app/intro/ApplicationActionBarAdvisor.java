package com.rcp.example.app.intro;

import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.jface.action.IAction;

import com.rcp.example.app.Messages;
import com.rcp.example.module.c.statusline.StatusLineContributionItemExample;

public class ApplicationActionBarAdvisor extends ActionBarAdvisor {

    private IWorkbenchAction introAction;
    private IAction helpContentsAction;
	private IAction saveAction;
	private IWorkbenchAction preferencesAction;
    
	public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
		super(configurer);
	}

	protected void makeActions(IWorkbenchWindow window) {
		{
			introAction = ActionFactory.INTRO.create(window);
			register(introAction);
		}
		{
			helpContentsAction = ActionFactory.HELP_CONTENTS.create(window);
			register(helpContentsAction);
		}
		{
			saveAction = ActionFactory.SAVE.create(window);
			register(saveAction);
		}
		{
			preferencesAction = ActionFactory.PREFERENCES.create(window);
			register(preferencesAction);
		}
	}

	protected void fillMenuBar(IMenuManager menuBar) {
		
		// Help
		MenuManager helpMenu = new MenuManager(Messages.ApplicationActionBarAdvisor_help, IWorkbenchActionConstants.M_HELP);
		helpMenu.add(helpContentsAction);
		helpMenu.add(new Separator());
		helpMenu.add(introAction);
		menuBar.add(helpMenu);
		
		MenuManager windowMenu = new MenuManager("&Window", IWorkbenchActionConstants.M_WINDOW);
		// Preferences
		windowMenu.add(preferencesAction);
		menuBar.add(windowMenu);
	}
	
	@Override
	protected void fillCoolBar(ICoolBarManager coolBar) {
		
		ToolBarManager toolBarManager = new ToolBarManager(SWT.ARROW_DOWN);
		coolBar.add(toolBarManager);
		
		toolBarManager.add(introAction);
		toolBarManager.add(saveAction);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.application.ActionBarAdvisor#fillStatusLine(org.eclipse.jface.action.IStatusLineManager)
	 */
	@Override
	protected void fillStatusLine(IStatusLineManager statusLine) {
		statusLine.add(new StatusLineContributionItemExample("Example"));
	}
}
