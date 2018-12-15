package at.faultycode.java.simple;

import java.util.logging.Logger;

/**
 * @author MaAb
 */
public final class IfNullPointerBug {

	/** Default Java logger **/
	private static final Logger LOGGER = Logger
			.getLogger(IfNullPointerBug.class.getName());

	private IfNullPointerBug() {}
	
	/**
	 * Entry point of program
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String message = null;
		if (args.length == 2) {
			message = message.concat("We have a problem here.");
		} else {
			message = "No bug occurred! Try another number of arguments.";
		}
		
		LOGGER.info(message);
	}
}
