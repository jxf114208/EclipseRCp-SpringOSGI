package com.rcp.example.module.c.editorpart;

import java.util.Random;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;


public class ElementFactory {
	public static Element[] getElements(int total) {
		return getElements(total,1);
	}
	
	public static Element[] getElements(int total, int second) {
		Element[] datas = new Element[total];
		for (int j = 1; j <= datas.length; j++) {
			datas[j-1] = new Element("element" + j,"col0-"+j, "col1-"+j);
		}
		try {
			Thread.sleep(second*1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return datas;
	}

	public static Element[] getRandomElements(int total) {
		return getRandomElements(total,1);
	}
	
	public static Element[] getRandomElements(int total, int second) {
		Random random = new Random();
		return getElements(random.nextInt(total), second);
	}
	
	public static Image getColumn0Image() {
		return Display.getDefault().getSystemImage(SWT.ICON_INFORMATION);
	}
	
	public static Image getColumn1Image() {
		return Display.getDefault().getSystemImage(SWT.ICON_QUESTION);
	}
	
	public static Image getImage() {
		return Display.getDefault().getSystemImage(SWT.ICON_WORKING);
	}
}
