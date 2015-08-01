package com.rcp.example.module.c.editorpart;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;

public class ElementEditorInput implements IEditorInput {
	private Element element;
	
	public ElementEditorInput(Element element) {
		this.element = element;
	}

	public Element getElement() {
		return element;
	}
	
	@Override
	public Object getAdapter(Class adapter) {
		return null;
	}

	@Override
	public boolean exists() {
		return false;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (super.equals(obj)) {
			return true;
		}
		if (!(obj instanceof ElementEditorInput)) {
			return false;
		}
		ElementEditorInput other = (ElementEditorInput) obj;
		return this.element.getName().equalsIgnoreCase(other.getName());
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		return null;
	}

	@Override
	public String getName() {
		return this.element.getName();
	}

	@Override
	public IPersistableElement getPersistable() {
		return null;
	}

	@Override
	public String getToolTipText() {
		return element.getName();
	}

}
