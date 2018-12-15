package at.faultycode.java.simple;

import java.util.logging.Logger;

/**
 * @author MaAb
 */
public class ForNullPointerBug {

	/** Default Java logger **/
	private static final Logger LOGGER = Logger
			.getLogger(ForNullPointerBug.class.getName());

	private ForNullPointerBug() {}
	
	/**
	 * Entry point of program
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String message = null;
		for (int i = 0; i < args.length; i++) {
			message += String.format("%d: %s; ", i, args[i]);
		}

		if (!message.isEmpty()) {
			LOGGER.info(message);
		}
	}
}
