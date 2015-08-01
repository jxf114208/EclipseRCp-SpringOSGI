/**
 * 
 */
package com.rcp.example.module.f;

import java.util.HashSet;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

/**
 * @author jxf
 *
 */
public class BundleSpringBeanUtils {

	public static Set<ApplicationContext> getApplicationContexts(BundleContext context) {
		Set<ApplicationContext> acs = new HashSet<ApplicationContext>();
		Bundle[] bundles = context.getBundles();
		for (Bundle bundle : bundles) {
			ApplicationContext ac = getApplicationContext(context, bundle.getSymbolicName());
			if (ac != null) {
				acs.add(ac);
			}
		}
		return acs;
	}

	/**
	 * 获取Spring的ApplicationContext
	 * @param context
	 * @param bundleName
	 */
	public static ApplicationContext getApplicationContext(BundleContext context, String bundleName) {
		try {
			String filter = "(org.springframework.context.service.name="+ bundleName +")";
			ServiceReference<?>[] serviceReferences = context.getAllServiceReferences("org.springframework.context.ApplicationContext", filter);
			
			if (serviceReferences != null) {
				for (int i = 0; i < serviceReferences.length; i++) {
					ServiceReference<?> sr = serviceReferences[i];
					ApplicationContext ac = (ApplicationContext) context.getService(sr);
					if (ac != null) {
						return ac;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 通过指定的插件名称和Bean名称获取Spring Bean对象
	 * @param context
	 * @param bundleName
	 * @param beanName
	 * @return
	 */
	public static Object getSpringBean(BundleContext context, String bundleName, String beanName) {
		ApplicationContext ac = getApplicationContext(context, bundleName);
		return ac.getBean(beanName);
	}
	
	/**
	 * 通过插件容器和Bean名称获取Spring Bean对象
	 * @param context
	 * @param beanName
	 * @return
	 */
	public static Object getSpringBean(BundleContext context, String beanName) {
		Set<ApplicationContext> acs = getApplicationContexts(context);
		
		for (ApplicationContext ac : acs) {
			Object bean;
			try {
				bean = ac.getBean(beanName);
				if (bean != null) {
					return bean;
				}
			} catch (BeansException e) {
				e.printStackTrace();
			}
		}
		return null;
		
	}
}
