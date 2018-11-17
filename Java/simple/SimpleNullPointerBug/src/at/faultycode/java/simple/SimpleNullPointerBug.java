package at.faultycode.java.simple;

import java.util.logging.Logger;

public class SimpleNullPointerBug {

	private static final Logger LOGGER = Logger.getLogger(SimpleNullPointerBug.class.getName());
	
	public static void main(String[] args) {
		
		String message = null;
		if (args.length == 2){
			message = message.concat("We have a problem here.");
		} else {
			message = "No bug occurred! Try another number of arguments.";
		}
		
		LOGGER.info(message);
	}

}
