/**
 * 
 */
package com.norcp.example.hibernate.registry;

import java.util.HashSet;
import java.util.Set;

import net.sf.cglib.core.ClassesKey;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IRegistryChangeEvent;
import org.eclipse.core.runtime.IRegistryChangeListener;
import org.eclipse.core.runtime.Platform;
import org.hibernate.HibernateException;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;

/**
 * @author jxf
 *
 */
public class BundleAnnotationSessionFactoryBeanRegistry extends AnnotationSessionFactoryBean implements IRegistryChangeListener{
	
	/**
	 * 插件ID
	 */
	public static String PLUGIN_ID = "com.norcp.example.hibernate";
	
	/**
	 * 扩展名称
	 */
	public static String EXTENSION_NAME = "BundleAnnotationSessionFactoryBean";
	
	/**
	 * PLUGIN_ID + "." + EXTENSION_NAME
	 */
	public static String EXTENSIONPOINT_ID = PLUGIN_ID + "." + EXTENSION_NAME;
	
	/**
	 * extensionRegistry
	 */
	private IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
	
	/**
	 * Extensions
	 */
	private Set<IExtension> sessionFactoryExtensions = new HashSet<IExtension>();
	
	/**
	 * 构造函数 
	 */
	public BundleAnnotationSessionFactoryBeanRegistry() {
		super();
		
		extensionRegistry.addRegistryChangeListener(this, EXTENSIONPOINT_ID);
		
		IExtensionPoint extensionPoint = extensionRegistry.getExtensionPoint(EXTENSIONPOINT_ID);
		
		if (extensionPoint != null) {
			IExtension[] extensions = extensionPoint.getExtensions();
			if (extensions != null) {
				for (IExtension extension : extensions) {
					sessionFactoryExtensions.add(extension);
				}
			}
		}
	}
	
	protected Class<?>[] extensionAnnotatedClasses(Set<IExtension> sessionFactoryExtensions) {
		Set<Class<?>> classes = new HashSet<Class<?>>();
		for (IExtension extension : sessionFactoryExtensions) {
			IConfigurationElement[] iConfigurationElements = extension.getConfigurationElements();
			
			for (IConfigurationElement iConfigurationElement : iConfigurationElements) {
				
				if (iConfigurationElement.getName().equalsIgnoreCase("annotatedClasses")) {
					IConfigurationElement[] annotatedClasses = iConfigurationElement.getChildren("annotatedClass");
					
					for (IConfigurationElement annotatedClass : annotatedClasses) {
						String className = annotatedClass.getAttribute("className");
						
						try {
							Class<?> annotatedClazz = Class.forName(className);
							classes.add(annotatedClazz);
							System.out.println("annotatedClazz:" + extension.getContributor() + ":" + annotatedClazz);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		return classes.toArray(new Class[classes.size()]);
	}
	
	protected String[] extensionAnnotatedPackages(Set<IExtension> sessionFactoryExtensions) {
		Set<String> packageNames = new HashSet<String>();
		for (IExtension extension : sessionFactoryExtensions) {
			IConfigurationElement[] iConfigurationElements = extension.getConfigurationElements();
			
			for (IConfigurationElement iConfigurationElement : iConfigurationElements) {
				
				if (iConfigurationElement.getName().equalsIgnoreCase("annotatedPackages")) {
					IConfigurationElement[] annotatedPackages = iConfigurationElement.getChildren("annotatedPackage");
					
					for (IConfigurationElement annotatedPackage : annotatedPackages) {
						String packageName = annotatedPackage.getAttribute("packageName");
						packageNames.add(packageName);
					}
				}
			}
		}
		return packageNames.toArray(new String[packageNames.size()]);
	}
	
	protected String[] extensionPackagesToScan(Set<IExtension> sessionFactoryExtensions) {
		Set<String> packageNames = new HashSet<String>();
		for (IExtension extension : sessionFactoryExtensions) {
			IConfigurationElement[] iConfigurationElements = extension.getConfigurationElements();
			
			for (IConfigurationElement iConfigurationElement : iConfigurationElements) {
				
				if (iConfigurationElement.getName().equalsIgnoreCase("packagesToScan")) {
					IConfigurationElement[] packagesToScan = iConfigurationElement.getChildren("packageToScan");
					
					for (IConfigurationElement packageToScan : packagesToScan) {
						String packageName = packageToScan.getAttribute("packageName");
						packageNames.add(packageName);
						System.out.println("packageToScan:" + extension.getContributor() + ":" + packageName);
					}
				}
			}
		}
		return packageNames.toArray(new String[packageNames.size()]);
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean#postProcessMappings(org.hibernate.cfg.Configuration)
	 */
	@Override
	protected void postProcessMappings(Configuration config) throws HibernateException {
		super.postProcessMappings(config);
		AnnotationConfiguration annotationConfiguration = (AnnotationConfiguration) config;
		
		//扩展点注解类
		Class<?>[] extensionAnnotatedClasses = this.extensionAnnotatedClasses(sessionFactoryExtensions);
		if (extensionAnnotatedClasses != null) {
			for (Class<?> annotatedClass : extensionAnnotatedClasses) {
				annotationConfiguration.addAnnotatedClass(annotatedClass);
			}
		}
		
		String[] extensionAnnotatedPackages = this.extensionAnnotatedPackages(sessionFactoryExtensions);
		if (extensionAnnotatedPackages != null) {
			for (String annotatedPackage : extensionAnnotatedPackages) {
				annotationConfiguration.addPackage(annotatedPackage);
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.IRegistryChangeListener#registryChanged(org.eclipse.core.runtime.IRegistryChangeEvent)
	 */
	public void registryChanged(IRegistryChangeEvent event) {
	}
	
}
