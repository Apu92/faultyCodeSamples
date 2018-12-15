package at.faultycode.java.simple;

import java.util.logging.Logger;

/**
 * @author MaAb
 */
public final class PositiveOutOfBoundsBug {

	/** Default Java logger **/
	private static final Logger LOGGER = Logger
			.getLogger(PositiveOutOfBoundsBug.class.getName());

	private PositiveOutOfBoundsBug() {}
	
	/**
	 * Entry point of program
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		final String[] osNames = { "Windows", "Linux", "Mac" };
		LOGGER.info(osNames[3]);
	}
}
