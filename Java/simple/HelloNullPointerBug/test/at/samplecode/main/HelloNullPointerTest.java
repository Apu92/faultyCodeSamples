package at.samplecode.main;

import org.junit.jupiter.api.Test;

public class HelloNullPointerTest {

	@Test
	void mainOneArgumentTest() {
		HelloNullPointerBug.main(new String[] {"arg1"});
	}
}
