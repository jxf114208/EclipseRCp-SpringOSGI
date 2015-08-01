/**
 * 
 */
package com.rcp.example.module.f;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

/**
 * @author jxf
 *
 */
public class BundleContextServiceUtils {
	public static Object getService(BundleContext context, String className) {
		if (context == null) {
			return null;
		}
		ServiceReference<?> serviceReference = context.getServiceReference(className);
		if (serviceReference == null) {
			return null;
		}
		return context.getService(serviceReference);
	}
	
	public static Object getService(BundleContext context, Class<?> clazz) {
		return getService(context, clazz.getName());
	}
}
