/*******************************************************************************
 * Copyright (c) 2016 Composent, Inc. and others. All rights reserved. This
 * program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Composent, Inc. - initial API and implementation
 ******************************************************************************/
package org.eclipse.ecf.provider.chronicle.common;

import org.eclipse.ecf.core.identity.URIID.URIIDNamespace;

public class ChronicleNamespace extends URIIDNamespace {

	private static final long serialVersionUID = 2460015768559081873L;

	public static final String NAME = "ecf.chronicle.namespace";
	private static final String SCHEME = "ecf.chronicle";
	private static ChronicleNamespace INSTANCE;
	
	/**
	 * The singleton instance of this namespace is created (and registered
	 * as a Namespace service) in the Activator class for this bundle.
	 * The singleton INSTANCE may then be used by both server and client.
	 */
	public ChronicleNamespace() {
		super(NAME, "Example 1 Namespace");
		INSTANCE = this;
	}

	public static ChronicleNamespace getInstance() {
		return INSTANCE;
	}
	
	@Override
	public String getScheme() {
		return SCHEME;
	}
}
