package com.rcp.example.module.c.viewpart;

import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.PlatformUI;

import com.rcp.example.module.c.editorpart.Element;
import com.rcp.example.module.c.editorpart.ElementEditorInput;
import com.rcp.example.module.c.editorpart.ElementEditorPart;
import com.rcp.example.module.c.editorpart.ElementFactory;

public class TreeViewComposite extends Composite {
	private TreeViewer treeViewer;
	public TreeViewer getTreeViewer() {
		return treeViewer;
	}

	private static class TreeContentProvider implements ITreeContentProvider {
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}
		public void dispose() {
		}
		public Object[] getElements(Object inputElement) {
			return getChildren(inputElement);
		}
		public Object[] getChildren(Object parentElement) {
//			return new Object[] { "item_0", "item_1", "item_2" };
			return ((Element)parentElement).getChileren();
		}
		public Object getParent(Object element) {
			return null;
		}
		public boolean hasChildren(Object element) {
			return getChildren(element).length > 0;
		}
	}

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public TreeViewComposite(Composite parent, int style) {
		super(parent, style);
		setLayout(new FillLayout(SWT.HORIZONTAL));
		
		treeViewer = new TreeViewer(this, SWT.BORDER);
		treeViewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				//打开EditorPart
				IStructuredSelection ss = (IStructuredSelection) event.getSelection();
				Element element = (Element) ss.getFirstElement();
				ElementEditorInput input = new ElementEditorInput(element);
				try {
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(input, ElementEditorPart.ID);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		Tree tree = treeViewer.getTree();
		tree.setLinesVisible(true);
		tree.setHeaderVisible(true);
		treeViewer.setContentProvider(new TreeContentProvider());

		treeViewer.setInput(ElementFactory.getElements(1)[0]);
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
