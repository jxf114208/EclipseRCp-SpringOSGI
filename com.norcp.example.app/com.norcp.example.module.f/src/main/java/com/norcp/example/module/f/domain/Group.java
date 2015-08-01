/**
 * 
 */
package com.norcp.example.module.f.domain;

import java.io.Serializable;

/**
 * @author jxf
 *
 */
public class Group implements Serializable {
	/**
	 * 
	 */
	public Group() {
	}
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
