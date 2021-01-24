/*
 * generated by Xtext 2.22.0
 */
package org.moflon.mofgen.ide

import com.google.inject.Guice
import org.eclipse.xtext.util.Modules2
import org.moflon.mofgen.MGLangRuntimeModule
import org.moflon.mofgen.MGLangStandaloneSetup

/**
 * Initialization support for running Xtext languages as language servers.
 */
class MGLangIdeSetup extends MGLangStandaloneSetup {

	override createInjector() {
		Guice.createInjector(Modules2.mixin(new MGLangRuntimeModule, new MGLangIdeModule))
	}
	
}
