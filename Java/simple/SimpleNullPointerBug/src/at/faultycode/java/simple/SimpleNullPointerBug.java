package at.faultycode.java.simple;

import java.util.logging.Logger;

/**
 * @author MaAb
 */
public final class SimpleNullPointerBug {

	/** Default Java logger **/
	private static final Logger LOGGER = Logger
			.getLogger(SimpleNullPointerBug.class.getName());

	private SimpleNullPointerBug() {}

	/**
	 * Entry point of program
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Object obj = null;
		final String message = obj.toString();

		LOGGER.info(message);
	}
}
