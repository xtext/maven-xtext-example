/*******************************************************************************
   * Copyright (c) 2013 Michael Vorburger.
   * All rights reserved. This program and the accompanying materials
   * are made available under the terms of the Eclipse Public License v1.0
   * which accompanies this distribution, and is available at
   * http://www.eclipse.org/legal/epl-v10.html
   * 
   * Contributors:
   *     Michael Vorburger - initial API and implementation
   ******************************************************************************/
package my.mavenized.standalone;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.junit4.GlobalRegistries;
import org.eclipse.xtext.junit4.IInjectorProvider;
import org.eclipse.xtext.junit4.util.ParseHelper;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * Utility to bootstrap Xtext-based grammars in standalone scenarios.
 * 
 * Intended to hide Xtext/Guice/EMF internals from simple client apps.
 * 
 * This should typically be used as a Singleton, and bootstrapped once
 * at a suitable lifecycle event of the client application (main() method,
 * Servlet Context Listener, etc.).
 * 
 * This basically does something similar to the respective gen. YourLanguageInjectorProvider from yourlang.tests/src-gen.
 * 
 * REPEAT: This class is intended for usage in STANDALONE scenarios only.
 * Standalone in Xtext terminology means something like "running outside of an
 * Eclipse IDE, typically plain Java SE" (or EE, if you must). Note that e.g. a
 * headless Eclipse product is NOT a standalone scenario.
 * 
 * @author Michael Vorburger
 */
public class StandaloneXtext<T extends EObject> implements IInjectorProvider {
	// implements IInjectorProvider isn't terribly important - could be removed if it causes any hassles
	
	static {
		GlobalRegistries.initializeDefaults();
	}

	// Always use com.google.inject.Inject instead of javax.inject.Inject here,
	// just to play it safe and avoid known problems typically encountered e.g.
	// when using the Spring Framework, wherein EE containers attempt to inject
	// stuff when you do not want them to....

	protected @Inject Injector injector;

	@SuppressWarnings("rawtypes")
	// Guice fails with: "ParseHelper<T> cannot be used as a key; It is not fully specified."
	// if we use ParseHelper<T> here, so we have to do it like this, and implicitly cast in getParseHelper() below.. :-( 
	protected @Inject ParseHelper parseHelper;

	protected StandaloneXtext() {
	}
	
	public StandaloneXtext(Injector injector) {
		injector.injectMembers(this);
	}

	public StandaloneXtext(ISetup iSetup) {
		this(iSetup.createInjectorAndDoEMFRegistration());
	}

	/**
	 * Constructor.
	 * 
	 * @param iSetupClass the respective YourLanguageStandaloneSetupGenerated.class from yourlang/src-gen.
	 */
	public StandaloneXtext(Class<ISetup> iSetupClass) {
		this(newISetup(iSetupClass));
	}

	private static ISetup newISetup(Class<ISetup> iSetupClass) {
		try {
			return iSetupClass.newInstance();
		} catch (InstantiationException e) {
			throw new IllegalArgumentException("newInstance() failed for " + iSetupClass.toString(), e);
		} catch (IllegalAccessException e) {
			throw new IllegalArgumentException("newInstance() failed for " + iSetupClass.toString(), e);
		} 
	}

	@SuppressWarnings("unchecked") // see note in parseHelper
	public ParseHelper<T> getParseHelper() {
		Preconditions.checkNotNull(parseHelper, StandaloneXtext.class.getName() + " hasn't been initialized correctly");
		return parseHelper;
	}
	
	/**
	 * Get the Guice Injector for this language.
	 * Normally you shouldn't have to use the Guice API directly, but use dependency injection everywhere.
	 * Sometimes it's useful though.
	 */
	public Injector getInjector() {
		Preconditions.checkNotNull(injector, StandaloneXtext.class.getName() + " hasn't been initialized correctly");
		return injector;
	}	
}
