package at.faultycode.java.simple;

import java.util.logging.Logger;

/**
 * @author MaAb
 */
public class OfByOneBug {

	/** Default Java logger **/
	private static final Logger LOGGER = Logger
			.getLogger(OfByOneBug.class.getName());

	private OfByOneBug() {}
	
	/**
	 * Entry point of program
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i = 0; i <= args.length; i++) {
			String arg = args[i];
			LOGGER.info(i + ": " + arg);
		}
	}
}
