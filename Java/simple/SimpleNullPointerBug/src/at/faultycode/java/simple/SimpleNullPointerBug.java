package at.faultycode.java.simple;

import java.util.logging.Logger;

public class SimpleNullPointerBug {

	private static final Logger LOGGER = Logger.getLogger(SimpleNullPointerBug.class.getName());
	
	public static void main(String[] args) {
		
		String message = null;
		LOGGER.info(message.toString());
	}

}
