package at.faultycode.java.simple;

import java.util.logging.Logger;

/**
 * @author MaAb
 */
public class WhileNullPointerBug {

	/** Default Java logger **/
	private static final Logger LOGGER = Logger
			.getLogger(WhileNullPointerBug.class.getName());

	private WhileNullPointerBug() {}
	
	/**
	 * Entry point of program
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String message = "No arguments are specified!";

		int i = 0;
		while (i < args.length) {
			message = null;
			i++;
		}

		if (!message.isEmpty()) {
			LOGGER.info(message);
		}
	}
}
