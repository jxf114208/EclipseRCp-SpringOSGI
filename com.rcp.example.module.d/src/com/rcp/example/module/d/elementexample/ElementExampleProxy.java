/**
 * 
 */
package com.rcp.example.module.d.elementexample;

import java.io.InputStream;

/**
 * @author jxf
 *
 */
public class ElementExampleProxy {
	private String stringAttribute;
	private boolean booleanAttribute;
	private IElementExample javaAttribute;
	private InputStream resourceAttribute;

	public String getStringAttribute() {
		return stringAttribute;
	}

	public void setStringAttribute(String stringAttribute) {
		this.stringAttribute = stringAttribute;
	}

	public boolean isBooleanAttribute() {
		return booleanAttribute;
	}

	public void setBooleanAttribute(boolean booleanAttribute) {
		this.booleanAttribute = booleanAttribute;
	}

	public IElementExample getJavaAttribute() {
		return javaAttribute;
	}

	public void setJavaAttribute(IElementExample javaAttribute) {
		this.javaAttribute = javaAttribute;
	}

	public InputStream getResourceAttribute() {
		return resourceAttribute;
	}

	public void setResourceAttribute(InputStream resourceAttribute) {
		this.resourceAttribute = resourceAttribute;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("ElementExampleProxy[").append("\n");
		sb.append("stringAttribute:" + stringAttribute).append("\n");
		sb.append("booleanAttribute:" + booleanAttribute).append("\n");
		sb.append("javaAttribute:" + javaAttribute.hello()).append("\n");
		sb.append("resourceAttribute:" + resourceAttribute).append("\n");
		sb.append("]").append("\n");
		return super.toString();
	}
	
}
