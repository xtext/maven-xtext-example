package my.mavenized.standalone.tests;

import static org.junit.Assert.assertEquals;
import my.mavenized.HeroLanguageStandaloneSetupGenerated;
import my.mavenized.heroLanguage.Heros;
import my.mavenized.standalone.StandaloneXtext;

import org.junit.Test;

/**
 * Uses the XtextStandaloneUtil instead of the classic Xtext JUnit helpers you
 * would normally use (@RunWith(XtextRunner.class) @InjectWith(HeroLanguageInjectorProvider.class)),
 * if this was not a standalone example but an eclipse-test-plugin, to illustrate
 * more generally how Xtext can be, via Maven, in standalone (non-Test) code.
 * 
 * Also e.g. HeroLanguageInjectorProvider isn't easily available in such a standalone module because it's generated in the *.test bundle.
 */
public class SimpleParsingTest {

	@Test
	@SuppressWarnings({ "rawtypes", "unchecked" }) // TODO how to avoid this?!
	public void testXtextStandaloneUtilForSimpleParsing() throws Exception {
		StandaloneXtext<Heros> xtextBootstrap = new StandaloneXtext(HeroLanguageStandaloneSetupGenerated.class);
		String heroesText = "hero superman can FLY\nhero iceman can ICE";
		Heros eHeroes = xtextBootstrap.getParseHelper().parse(heroesText);
		assertEquals(2, eHeroes.getHeros().size());
	}

}
