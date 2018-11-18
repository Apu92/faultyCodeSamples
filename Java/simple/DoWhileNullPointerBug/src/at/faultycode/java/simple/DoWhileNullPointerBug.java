package at.faultycode.java.simple;

import java.util.Arrays;
import java.util.logging.Logger;

public class DoWhileNullPointerBug {

	private static final Logger LOGGER = Logger.getLogger(DoWhileNullPointerBug.class.getName());

	public static void main(String[] args) {
		String[] arguments = Arrays.copyOf(args, args.length + 1);
		String message = "";
		
		int i = 0;
		do {
			message = arguments[i];
			i++;
		} while (i < args.length);

		if (!message.isEmpty()) {
			LOGGER.info(message);
		}
	}

}
