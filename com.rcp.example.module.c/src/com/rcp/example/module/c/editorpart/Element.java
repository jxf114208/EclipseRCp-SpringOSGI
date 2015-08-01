package com.rcp.example.module.c.editorpart;


public class Element implements Comparable<Element> {
	
	private String name;
	private String column0;
	private String column1;

	public Element(String name, String column0, String column1) {
		super();
		this.name = name;
		this.column0 = column0;
		this.column1 = column1;
	}
	
	public Element(String name)
	{
		super();
		this.name = name;
	}

	public Element() {
		super();
	}

	public Element(String column0, String column1) {
		this("",column0,column1);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColumn0() {
		return column0;
	}

	public void setColumn0(String column0) {
		this.column0 = column0;
	}

	public String getColumn1() {
		return column1;
	}

	public void setColumn1(String column1) {
		this.column1 = column1;
	}
	
	public Element[] getChileren() {
		return ElementFactory.getRandomElements(5);
	}

	@Override
	public int compareTo(Element o) {
		return o.getColumn0().compareTo(this.getColumn1());
	}
	
	@Override
	public String toString() {
		return this.name;
	}

}
