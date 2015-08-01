/**
 * 
 */
package com.norcp.example.cp.dbcp.prop;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;

import org.osgi.framework.Bundle;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.Resource;
import org.springframework.osgi.io.OsgiBundleResource;

/**
 * @author jxf
 *
 */
public class BundlePlaceholderConfigurer extends PropertyPlaceholderConfigurer {
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.core.io.support.PropertiesLoaderSupport#loadProperties
	 * (java.util.Properties)
	 */
	@Override
	protected void loadProperties(Properties props) throws IOException {
		Resource[] locations = (Resource[]) getFieldValue(this, "locations");
		
		for (int i = 0; i < locations.length; i++) {
			Resource location = locations[i];
			if (!location.exists()) {
				if (location instanceof OsgiBundleResource) {
					OsgiBundleResource osgiResource = (OsgiBundleResource)location;
					
					String filename = osgiResource.getFilename();
					Bundle bundle = (Bundle) getFieldValue(osgiResource, "bundle");
					Resource newOsgiResource = getOsgiBundleResourceByBundles(bundle, filename);
					locations[i] = newOsgiResource;
				}
			}
		}
		super.loadProperties(props);
	}

	/**
	 * 在Bundle Context中加载资源文件
	 * 
	 * @return
	 */
	private Resource getOsgiBundleResourceByBundles(Bundle bundle, String bundleResourcePath)
	{
		Bundle[] bundles = bundle.getBundleContext().getBundles();
		for (int i = 0; i < bundles.length; i++) {
			Bundle bnd = bundles[i];
			Resource osgiBundleResource = getOsgiBundleResourceByBundles(bnd, bundleResourcePath);
			
			if (osgiBundleResource != null && osgiBundleResource.exists() && isActiveBundle(bundle)) {
				return osgiBundleResource;
			}
		}
		return null;
	}

	/**
	 * 从OSGI Bundle中获取资源
	 * 
	 * @param bundle
	 * @param bundleResourcePath
	 * @return
	 */
	private Resource getOsgiBundleResource(Bundle bundle, String bundleResourcePath) {
		OsgiBundleResource osgiBundleResource = new OsgiBundleResource(bundle, bundleResourcePath);
		return osgiBundleResource;
	}

	/**
	 * 如果有多个连接池插件只加载处于Active状态的配置文件
	 * 
	 * @param bundle
	 * @return
	 */
	private boolean isActiveBundle(Bundle bundle) {
		return bundle.getState() == Bundle.ACTIVE;
	}

	/**
	 * 因为无法获取部分类中的属性，因此通过反射机制获取这些值
	 * 
	 * @param bundlePlaceholderConfigurer
	 * @param string
	 * @return
	 */
	private Object getFieldValue(Object object, String fieldName) {
		Field field = getSupperDeclaredField(object.getClass(), fieldName);
		if (field != null) {
			field.setAccessible(true);
			try {
				return field.get(object);
			} catch (Exception e) {
				return null;
			}
		}else
		{
			return null;
		}
	}

	/**
	 * @param clazz
	 * @param fieldName
	 * @return
	 */
	private Field getSupperDeclaredField(Class<? extends Object> clazz, String fieldName) {
		try {
			if (clazz == null)
				return null;
			Field declaredField = clazz.getDeclaredField(fieldName);
			if (declaredField != null) {
				return declaredField;
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		}catch (NoSuchFieldException e) {
			Class<?> superclass = clazz.getSuperclass();
			if (superclass != null) {
				Field supperDeclaredField = getSupperDeclaredField(superclass, fieldName);
				if (supperDeclaredField != null) {
					return supperDeclaredField;
				}
			}
		}
		return null;
	}
}
