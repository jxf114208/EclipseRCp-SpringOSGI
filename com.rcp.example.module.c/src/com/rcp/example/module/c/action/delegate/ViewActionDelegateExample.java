package com.rcp.example.module.c.action.delegate;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;

public class ViewActionDelegateExample implements IViewActionDelegate {

	@Override
	public void run(IAction action) {
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
	}

	@Override
	public void init(IViewPart view) {
	}

}
