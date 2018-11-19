package at.faultycode.java.simple;

import java.util.logging.Logger;

public class PositiveOutOfBoundsBug {

	private static final Logger LOGGER = Logger
			.getLogger(PositiveOutOfBoundsBug.class.getName());


	public static void main(String[] args) {

		final String[] osNames = { "Windows", "Linux", "Mac" };
		LOGGER.info(osNames[3]);
	}

}
