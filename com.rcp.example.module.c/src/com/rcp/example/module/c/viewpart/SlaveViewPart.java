package com.rcp.example.module.c.viewpart;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.ViewPart;

import com.rcp.example.module.c.editorpart.Element;
import com.rcp.example.module.c.editorpart.ElementPOJOComposite;
import com.rcp.example.module.c.editorpart.POJOCompositeUtils;

public class SlaveViewPart extends ViewPart {

	public static final String ID = "com.rcp.example.module.c.viewpart.SlaveViewPart"; //$NON-NLS-1$

	public SlaveViewPart() {
	}

	/**
	 * Create contents of the view part.
	 * 
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		final Composite composite = new ElementPOJOComposite(parent, SWT.NONE);

		createActions();
		initializeToolBar();
		initializeMenu();
		
		//添加选择监听器
		getSite().getPage().addSelectionListener(new ISelectionListener() {
			
			@Override
			public void selectionChanged(IWorkbenchPart part, ISelection selection) {
				//不响应当前视图的选择事件
				if(part.equals(this)) return;
				
				StructuredSelection ss = (StructuredSelection)selection;
				Element element = (Element) ss.getFirstElement();
				if (element != null && element instanceof Element) {
					POJOCompositeUtils.setPOJO(composite, element);
				}
			}
		});
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
		IToolBarManager toolbarManager = getViewSite().getActionBars().getToolBarManager();
	}

	/**
	 * Initialize the menu.
	 */
	private void initializeMenu() {
		IMenuManager menuManager = getViewSite().getActionBars().getMenuManager();
	}

	@Override
	public void setFocus() {
		// Set the focus
	}

}
