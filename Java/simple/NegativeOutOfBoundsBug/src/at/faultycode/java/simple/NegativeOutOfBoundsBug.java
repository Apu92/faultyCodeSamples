package at.faultycode.java.simple;

import java.util.logging.Logger;

public class NegativeOutOfBoundsBug {

	private static final Logger LOGGER = Logger
			.getLogger(NegativeOutOfBoundsBug.class.getName());


	public static void main(String[] args) {

		final String invalidArg = args[-1];
		LOGGER.info(invalidArg);
	}

}
