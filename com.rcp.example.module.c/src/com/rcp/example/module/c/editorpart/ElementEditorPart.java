package com.rcp.example.module.c.editorpart;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;

import com.rcp.example.module.c.statusline.StatusLineContributionItemExample;

public class ElementEditorPart extends EditorPart {

	public static final String ID = "com.rcp.example.module.c.editorpart.ElementEditorPart"; //$NON-NLS-1$
	private Composite composite;
	private ElementEditorInput elementEditorInput;

	public ElementEditorPart() {
	}

	/**
	 * Create contents of the editor part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		composite = new ElementPOJOComposite(parent, SWT.NONE);
		POJOCompositeUtils.setPOJO(composite, elementEditorInput.getElement());
		
		//添加选择监听器
		getSite().getPage().addSelectionListener(new ISelectionListener() {
			int a = 0;
			int b = 0;
			@Override
			public void selectionChanged(IWorkbenchPart part, ISelection selection) {
				System.out.println("a :" + ++a);
				//不响应当前编辑器的选择事件
				if(part.equals(this)) return;
				StructuredSelection ss = (StructuredSelection) selection;
				Element element = (Element) ss.getFirstElement();
				if (element != null && element instanceof Element) {
					System.out.println("b :" + ++b);
					POJOCompositeUtils.setPOJO(composite, element);
				}
			}
		});
		
		//在编辑器中访问状态栏管理器
		this.getEditorSite().getActionBars().getStatusLineManager().add(new StatusLineContributionItemExample("Example"));
	}

	@Override
	public void setFocus() {
		// Set the focus
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		// Do the Save operation
	}

	@Override
	public void doSaveAs() {
		// Do the Save As operation
	}

	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		// Initialize the editor part
		this.setSite(site);
		this.setInput(input);
		elementEditorInput = (ElementEditorInput) input;
		setPartName(elementEditorInput.getName());
	}

	@Override
	public boolean isDirty() {
		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

}
