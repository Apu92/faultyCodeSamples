package at.samplecode.main;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import hellonullpointer.handlers.SampleHandler;

public class SampleHandlerTest {

	@Test
	public void eventNamePrintTest() {
		SampleHandler.printEventName("Event");
		assertTrue(true);
	}

}
