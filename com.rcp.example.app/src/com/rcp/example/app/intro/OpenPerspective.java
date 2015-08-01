package com.rcp.example.app.intro;

import java.util.Properties;

import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.intro.IIntroPart;
import org.eclipse.ui.intro.IIntroSite;
import org.eclipse.ui.intro.config.IIntroAction;

public class OpenPerspective implements IIntroAction {

	@Override
	public void run(IIntroSite site, Properties params) {
		final String perspectiveID = params.getProperty("perspectiveId");
		if (perspectiveID != null) {
			try {
				//关闭intro view
				final IIntroPart introPart = PlatformUI.getWorkbench().getIntroManager().getIntro();
				PlatformUI.getWorkbench().getIntroManager().closeIntro(introPart);
				
				//打开perspective
				final IWorkbench workbench = PlatformUI.getWorkbench();
				workbench.showPerspective(perspectiveID, workbench.getActiveWorkbenchWindow());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
