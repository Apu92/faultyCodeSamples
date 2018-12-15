package at.faultycode.java.simple;

import java.util.logging.Logger;

/**
 * @author MaAb
 */
public class DoWhileNullPointerBug {

	/** Default Java logger **/
	private static final Logger LOGGER = Logger
			.getLogger(DoWhileNullPointerBug.class.getName());

	private static final String NO_ARGUMENTS = "No arguments are specified!";

	private DoWhileNullPointerBug() {}
	
	/**
	 * Entry point of program
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String message = "";

		int i = 0;
		do {
			message = args.length == 0 ? NO_ARGUMENTS : null;
			i++;
		} while (i < args.length);

		if (!message.isEmpty()) {
			LOGGER.info(message);
		}
	}
}
