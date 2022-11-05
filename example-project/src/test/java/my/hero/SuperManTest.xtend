package my.hero

import org.junit.Test
import static org.junit.Assert.*
import my.pack.HelloHelper

class SuperManTest {
	
	@Test def void testSimple() {
		assertEquals("Hello I can FLY!", new my.company.Superman().helloSuperman)
	}
	
	@Test def void testFoo() {
		assertEquals("Hello", new HelloHelper().hello)
	}
}