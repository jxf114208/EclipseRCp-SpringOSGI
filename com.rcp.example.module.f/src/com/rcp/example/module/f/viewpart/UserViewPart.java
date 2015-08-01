/**
 * 
 */
package com.rcp.example.module.f.viewpart;

import java.util.List;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.part.ViewPart;

import com.norcp.example.module.f.domain.Group;
import com.norcp.example.module.f.service.api.IUserService;
import com.rcp.example.module.f.Activator;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

/**
 * @author jxf
 *
 */
public class UserViewPart extends ViewPart {
	private class TableLabelProvider extends LabelProvider implements ITableLabelProvider {
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}
		public String getColumnText(Object element, int columnIndex) {
			Group user = (Group)element;
			return user.getName();
		}
	}
	
	public static final String ID = "com.rcp.example.module.f.viewpart.UserViewPart"; //$NON-NLS-1$
	private Table table;
	private TableViewer tableViewer;

	public UserViewPart() {
	}

	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new FillLayout(SWT.HORIZONTAL));
		{
			tableViewer = new TableViewer(container, SWT.BORDER | SWT.FULL_SELECTION);
			table = tableViewer.getTable();
			table.setLinesVisible(true);
			table.setHeaderVisible(true);
//			{
//				TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
//				TableColumn tblclmnNewColumn = tableViewerColumn.getColumn();
//				tblclmnNewColumn.setWidth(100);
//				tblclmnNewColumn.setText("name");
//			}
			tableViewer.setLabelProvider(new TableLabelProvider());
			tableViewer.setContentProvider(ArrayContentProvider.getInstance());
			
			IUserService service = Activator.getDefault().getIUserService();
			List<Group> users = service.queryUsers();
			tableViewer.setInput(users);
		}

		createActions();
		initializeToolBar();
		initializeMenu();
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
