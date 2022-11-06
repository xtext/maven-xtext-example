package my.hero

import org.junit.Test
import static org.junit.Assert.*
import my.pack.HelloHelper

class SuperManTest {
	
	@Test def void testSuperman() {
		assertEquals("Hello I can FLY!",
			new my.company.Superman().helloSuperman)
	}

	@Test def void testLazySuperman() {
		var thrown = assertThrows(
			UnsupportedOperationException,
			[new my.company.LazySuperman().helloLazySuperman]
		)
		assertEquals("Sorry, I'm lazy! ;)",
			thrown.message)
	}
	
	@Test def void testHelloHelper() {
		assertEquals("Hello", new HelloHelper().hello)
	}
}