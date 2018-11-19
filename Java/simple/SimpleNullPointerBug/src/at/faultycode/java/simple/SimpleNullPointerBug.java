package at.faultycode.java.simple;

import java.util.logging.Logger;

public class SimpleNullPointerBug {

	private static final Logger LOGGER = 
			Logger.getLogger(SimpleNullPointerBug.class.getName());
	
	public static void main(String[] args) {
		String message = null;
		message = message.format("%d argument(s) are entered!", args.length);

		LOGGER.info(message);
	}

}
