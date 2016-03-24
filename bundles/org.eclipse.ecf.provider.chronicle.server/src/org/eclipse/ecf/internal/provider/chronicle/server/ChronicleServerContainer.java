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

import org.eclipse.ecf.core.identity.ID;
import org.eclipse.ecf.remoteservice.AbstractRSAContainer;
import org.eclipse.ecf.remoteservice.RSARemoteServiceContainerAdapter.RSARemoteServiceRegistration;

public class ChronicleServerContainer extends AbstractRSAContainer {

	public ChronicleServerContainer(ID id) {
		super(id);
	}

	@Override
	protected Map<String, Object> exportRemoteService(RSARemoteServiceRegistration registration) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void unexportRemoteService(RSARemoteServiceRegistration registration) {
		// TODO Auto-generated method stub
	}
}