package my.hero

import my.company.Superman
import my.pack.Foo
import org.junit.Test

import static org.junit.Assert.*

class SuperManTest {
	
	@Test def void testSuperman() {
		assertEquals("Hello I can FLY!",
			new Superman().helloSuperman)
	}

	@Test def void testFoo() {
		assertEquals("hello", new Foo().x)
	}
}