package com.rcp.example.module.c.perspective;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class ElelmentPerspective implements IPerspectiveFactory {

	/**
	 * Creates the initial layout for a page.
	 */
	public void createInitialLayout(IPageLayout layout) {
		layout.setFixed(true);
		String editorArea = layout.getEditorArea();
		addFastViews(layout);
		addViewShortcuts(layout);
		addPerspectiveShortcuts(layout);
		
		//case1
//		layout.addView("com.rcp.example.module.c.viewpart.MasterViewPart", IPageLayout.LEFT, 0.46f, IPageLayout.ID_EDITOR_AREA);
//		layout.addView("com.rcp.example.module.c.viewpart.SlaveViewPart", IPageLayout.BOTTOM, 0.5f, IPageLayout.ID_EDITOR_AREA);
		
		//case2
		IFolderLayout folderLayout = layout.createFolder("folder", IPageLayout.LEFT, 0.36f, IPageLayout.ID_EDITOR_AREA);
		folderLayout.addView("com.rcp.example.module.c.viewpart.MasterViewPart");
		folderLayout.addView("com.rcp.example.module.c.viewpart.SlaveViewPart");
		folderLayout.addView("com.rcp.example.module.f.viewpart.UserViewPart");
		
		layout.getViewLayout("com.rcp.example.module.c.viewpart.MasterViewPart").setCloseable(false);
		layout.getViewLayout("com.rcp.example.module.c.viewpart.MasterViewPart").setMoveable(false);
	}

	/**
	 * Add fast views to the perspective.
	 */
	private void addFastViews(IPageLayout layout) {
	}

	/**
	 * Add view shortcuts to the perspective.
	 */
	private void addViewShortcuts(IPageLayout layout) {
		layout.addShowViewShortcut("com.rcp.example.module.f.viewpart.UserViewPart");
	}

	/**
	 * Add perspective shortcuts to the perspective.
	 */
	private void addPerspectiveShortcuts(IPageLayout layout) {
	}

}
