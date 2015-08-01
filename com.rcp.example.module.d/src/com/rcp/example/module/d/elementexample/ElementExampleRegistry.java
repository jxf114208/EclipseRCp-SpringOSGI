/**
 * 
 */
package com.rcp.example.module.d.elementexample;

import org.eclipse.core.runtime.IExtensionDelta;
import org.eclipse.core.runtime.IRegistryChangeEvent;
import org.eclipse.core.runtime.IRegistryChangeListener;
import org.eclipse.core.runtime.Platform;

/**
 * @author jxf
 *
 */
public class ElementExampleRegistry implements IRegistryChangeListener {
	
	public static String PLUGIN_ID = "com.rcp.example.module.d";
	public static String EXTENSION_NAME = "ExtensionPointExample";
	public static String EXTENSIONPOINT_ID = PLUGIN_ID + "." + EXTENSION_NAME;
	
	/**
	 * 
	 */
	public ElementExampleRegistry() {
		super();
		Platform.getExtensionRegistry().addRegistryChangeListener(this, PLUGIN_ID);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.IRegistryChangeListener#registryChanged(org.eclipse.core.runtime.IRegistryChangeEvent)
	 */
	@Override
	public void registryChanged(IRegistryChangeEvent event) {
		IExtensionDelta[] deltas = event.getExtensionDeltas(PLUGIN_ID, EXTENSION_NAME);
	}

}
