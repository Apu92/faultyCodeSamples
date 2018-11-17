package at.faultycode.java.simple;

import java.util.logging.Logger;

public class OfByOneBug {

	private static final Logger LOGGER = Logger.getLogger(OfByOneBug.class.getName());
	
	public static void main(String[] args) {

		for (int i = 0; i <= args.length; i++) {
			String arg = args[i];
			LOGGER.info(i + ": " + arg);
		}
	}

}
