package at.faultycode.java.simple;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BasicJunit5Test {

	@Test
	void myFirstTest() {
		assertEquals(2, 1 + 1);
	}
}
