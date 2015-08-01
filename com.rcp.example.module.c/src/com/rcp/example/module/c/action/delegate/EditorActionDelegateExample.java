package com.rcp.example.module.c.action.delegate;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;

public class EditorActionDelegateExample implements IEditorActionDelegate {

	@Override
	public void run(IAction action) {
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
	}

	@Override
	public void setActiveEditor(IAction action, IEditorPart targetEditor) {
	}

}
