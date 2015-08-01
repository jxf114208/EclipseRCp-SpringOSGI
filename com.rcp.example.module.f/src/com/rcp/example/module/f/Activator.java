package com.rcp.example.module.f;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.springframework.context.ApplicationContext;

import com.norcp.example.module.f.service.api.IUserService;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.rcp.example.module.f"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;

	//BundleContext 实例
	private BundleContext context;
	
	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		this.context = context;
		
		System.out.println("-------------------f-moudle--------------------");
		
		ApplicationContext fcontext = BundleSpringBeanUtils.getApplicationContext(context, "com.norcp.example.module.f");
		System.out.println("ApplicationContext-:" + fcontext);
		System.out.println("userDao:" + fcontext.getBean("userDao"));	
//		System.out.println("groupDao:" + fcontext.getBean("groupDao"));	
		
		
		System.out.println("-------------------g-moudle--------------------");
		
		ApplicationContext gcontext = BundleSpringBeanUtils.getApplicationContext(context, "com.norcp.example.module.g");
		System.out.println("ApplicationContext-:" + gcontext);
//		System.out.println("userDao:" + gcontext.getBean("userDao"));	
		System.out.println("groupDao:" + gcontext.getBean("groupDao"));	
		
	}
	
	
	/**
	 * @return
	 */
	public IUserService getIUserService() {
		return (IUserService)BundleContextServiceUtils.getService(context, IUserService.class);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}
}
