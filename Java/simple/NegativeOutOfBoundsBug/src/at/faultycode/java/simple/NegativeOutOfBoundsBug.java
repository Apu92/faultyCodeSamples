package at.faultycode.java.simple;

import java.util.logging.Logger;

/**
 * @author MaAb
 */
public class NegativeOutOfBoundsBug {
	
	/** Default Java logger **/
	private static final Logger LOGGER = Logger
			.getLogger(NegativeOutOfBoundsBug.class.getName());

	private NegativeOutOfBoundsBug() {}

	/**
	 * Entry point of program
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		final String invalidArg = args[-1];
		LOGGER.info(invalidArg);
	}
}
