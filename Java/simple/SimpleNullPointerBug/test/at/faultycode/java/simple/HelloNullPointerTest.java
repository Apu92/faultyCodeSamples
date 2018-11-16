package at.faultycode.java.simple;

import org.junit.jupiter.api.Test;

import at.faultycode.java.simple.SimpleNullPointerBug;

public class HelloNullPointerTest {

	@Test
	void mainOneArgumentTest() {
		SimpleNullPointerBug.main(new String[] {"arg1"});
	}
}
