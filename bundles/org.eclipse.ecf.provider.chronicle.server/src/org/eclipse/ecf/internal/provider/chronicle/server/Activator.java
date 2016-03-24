/*******************************************************************************
 * Copyright (c) 2016 Composent, Inc. and others. All rights reserved. This
 * program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Composent, Inc. - initial API and implementation
 ******************************************************************************/
package org.eclipse.ecf.internal.provider.chronicle.server;

import java.util.Map;

import org.eclipse.ecf.core.ContainerTypeDescription;
import org.eclipse.ecf.core.IContainer;
import org.eclipse.ecf.provider.chronicle.common.ChronicleNamespace;
import org.eclipse.ecf.provider.chronicle.common.ChronicleProviderConstants;
import org.eclipse.ecf.remoteservice.provider.IRemoteServiceDistributionProvider;
import org.eclipse.ecf.remoteservice.provider.RemoteServiceContainerInstantiator;
import org.eclipse.ecf.remoteservice.provider.RemoteServiceDistributionProvider;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	private static final String SERVER_ID_PARAMETER = "id";
	private static final String SERVER_ID_PARAMETER_DEFAULT = "chronicle://localhost";
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.
	 * BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		// register this remote service distribution provider
		context.registerService(IRemoteServiceDistributionProvider.class,
				new RemoteServiceDistributionProvider.Builder().setName(ChronicleProviderConstants.SERVER_PROVIDER_CONFIG_TYPE)
						.setInstantiator(new RemoteServiceContainerInstantiator(ChronicleProviderConstants.SERVER_PROVIDER_CONFIG_TYPE,
								ChronicleProviderConstants.CLIENT_PROVIDER_CONFIG_TYPE) {
							@Override
							public IContainer createInstance(ContainerTypeDescription description,
									Map<String, ?> parameters) {
								// Create and configure an instance of our server 
								// container type
								return new ChronicleServerContainer(getIDParameterValue(ChronicleNamespace.getInstance(), parameters,
										SERVER_ID_PARAMETER, SERVER_ID_PARAMETER_DEFAULT));
							}
						}).build(),
				null);
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}
