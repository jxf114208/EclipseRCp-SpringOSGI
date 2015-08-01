/**
 * 
 */
package com.rcp.example.module.c.statusline;

import org.eclipse.jface.action.StatusLineContributionItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

/**
 * @author jxf
 *
 */
public class StatusLineContributionItemExample extends StatusLineContributionItem {

	/**
	 * @param id
	 */
	public StatusLineContributionItemExample(String id) {
		super(id, StatusLineContributionItem.CALC_TRUE_WIDTH);
		this.setVisible(true);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.action.StatusLineContributionItem#fill(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void fill(Composite parent) {
		super.fill(parent);
		StatuslineComposite sc = new StatuslineComposite(parent, SWT.NONE);
	}
}
