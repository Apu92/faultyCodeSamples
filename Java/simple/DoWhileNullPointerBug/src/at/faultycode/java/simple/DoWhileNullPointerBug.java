package at.faultycode.java.simple;

import java.util.logging.Logger;

public class DoWhileNullPointerBug {

	private static final Logger LOGGER = Logger
			.getLogger(DoWhileNullPointerBug.class.getName());

	private static final String NO_ARGUMENTS = "No arguments are specified!";


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
