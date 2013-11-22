package my.mavenized.herolanguage.tests

import com.google.inject.Inject
import my.mavenized.HeroLanguageInjectorProvider
import my.mavenized.heroLanguage.Heros
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

@RunWith(XtextRunner)
@InjectWith(HeroLanguageInjectorProvider)
class SimpleParsingTest {
	
	@Inject extension ParseHelper<Heros>
	
	@Test def void testParse() {
		val heros = '''
			hero superman can FLY
			hero iceman can ICE
		'''.parse
		assertEquals(2, heros.heros.size)
	}
}