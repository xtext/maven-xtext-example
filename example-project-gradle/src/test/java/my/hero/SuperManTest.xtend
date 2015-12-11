package my.hero

import org.junit.Test
import static org.junit.Assert.*
import my.pack.Foo

class SuperManTest {
	
	@Test def void testSimple() {
		assertEquals("Hello I can fly!", new my.company.Superman().helloSuperman)
	}
	
	@Test def void testFoo() {
		assertEquals("hello", new Foo().x)
	}
}