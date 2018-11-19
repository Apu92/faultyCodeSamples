package at.faultycode.java.simple;

import java.util.logging.Logger;

public class WhileNullPointerBug {

	private static final Logger LOGGER = 
			Logger.getLogger(WhileNullPointerBug.class.getName());

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
