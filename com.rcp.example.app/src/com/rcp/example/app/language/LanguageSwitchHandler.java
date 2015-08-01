package com.rcp.example.app.language;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IProduct;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.Bundle;

public class LanguageSwitchHandler extends AbstractHandler {
	//config.ini文件名称
	private String configini = "config.ini";
	
	//获取RCP产品
	private IProduct product = Platform.getProduct();
	
	

	public LanguageSwitchHandler() {
		super();
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		//获取命令参数中的语言代码值
		String locale = event.getParameter("com.rcp.example.language.locale");
		try {
			changeLocaleOnDevelop(locale);
			changeLocaleRuntime(locale);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//重启系统
		PlatformUI.getWorkbench().restart();
		return null;
	}

	/**
	 * 在产品导出后修改产品配置文件的方法
	 * @param locale
	 * @throws IOException 
	 */
	private void changeLocaleRuntime(String locale) throws IOException {
		//加载产品导出后配置文件所在位置
		String file = Platform.getConfigurationLocation().getURL().getFile() + File.separator + configini;
		
		//加载配置文件内容
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(file);
		prop.load(fis);
		fis.close();
		
		//重写配置文件国家语言信息
		prop.setProperty("osgi.nl", locale);
		FileOutputStream fos = new FileOutputStream(file);
		prop.store(fos, "Product Runtime Configuration File");
		fos.close();
	}

	/**
	 * 在开发阶段修改产品的配置文件的方法
	 * @param locale
	 * @throws IOException 
	 */
	private void changeLocaleOnDevelop(String locale) throws IOException {
		Bundle configiniBundle = product.getDefiningBundle();
		URL url = null;
		if (configini != null) {
			try {
				url = new URL(configini);
			} catch (Exception e) {
				url = FileLocator.find(configiniBundle, new Path(configini), null);
			}
		}
		
		//加载配置文件内容
		Properties prop = new Properties();
		InputStream fis = url.openStream();
		prop.load(fis);
		fis.close();
		
		//重写配置文件国家语言信息
		prop.setProperty("osgi.nl", locale);
		FileOutputStream fos = new FileOutputStream(FileLocator.toFileURL(url).getFile());
		prop.store(fos, "Product Runtime Configuration File");
		fos.close();
	}


}
