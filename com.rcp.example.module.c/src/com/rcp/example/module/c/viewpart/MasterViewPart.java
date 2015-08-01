package com.rcp.example.module.c.viewpart;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import com.rcp.example.module.c.action.ViewPartMenuBarExample;
import com.rcp.example.module.c.action.ViewPartToolBarExample;
import com.rcp.example.module.c.statusline.StatusLineContributionItemExample;

public class MasterViewPart extends ViewPart {

	public static final String ID = "com.rcp.example.module.c.viewpart.MasterViewPart"; //$NON-NLS-1$

	public MasterViewPart() {
	}

	/**
	 * Create contents of the view part.
	 * 
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		TreeViewComposite container = new TreeViewComposite(parent, SWT.NONE);

		createActions();
		initializeToolBar();
		initializeMenu();
		
		//将当前主ViewPart中的TreeViewer添加到SelectionProvider中
		getSite().setSelectionProvider(container.getTreeViewer());
		
		//在视图中访问状态栏管理器
		this.getViewSite().getActionBars().getStatusLineManager().add(new StatusLineContributionItemExample("Example"));
	}

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
	}

	/**
	 * Initialize the toolbar.
	 */
	private void initializeToolBar() {
		new ViewPartToolBarExample(this);
	}

	/**
	 * Initialize the menu.
	 */
	private void initializeMenu() {
		new ViewPartMenuBarExample(this);
	}

	@Override
	public void setFocus() {
		// Set the focus
	}

}
