package at.faultycode.java.simple;

import java.util.logging.Logger;

/**
 * @author MaAb
 */
public class SwitchNullPointerBug {

	/** Default Java logger **/
	private static final Logger LOGGER = Logger
			.getLogger(SwitchNullPointerBug.class.getName());

	private SwitchNullPointerBug() {}
	
	/**
	 * Entry point of program
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String message = null;
		switch (args.length) {
		case 1:
			message = "1 argument is specified.";
			break;
		case 2:
			message = "2 arguments are specified";
			break;
		case 3:
			message = message.replace('2', '3');
			break;
		default:
			message = "No bug occurred! Try another number of arguments.";
			break;
		}

		LOGGER.info(message);
	}
}
