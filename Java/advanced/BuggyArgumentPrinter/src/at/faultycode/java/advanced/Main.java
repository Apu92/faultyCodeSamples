package at.faultycode.java.advanced;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author MaAb
 */
public class Main {
	
	/** Default Java logger **/
	private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
	
	private static final Random RANDOM = new Random();
	
	/**
	 * Entry point of program
	 * 
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) {
		LOGGER.info("Start program...");
		final ArgumentPrinter argPrinter = new ArgumentPrinter();
		for (int i = 0; i < 5; i++) {
			if (generateRandomInteger() > 0)
				LOGGER.log(Level.INFO, "Log file path: '{0}'", argPrinter.initLogFile().toString());
			Object[] testArguments = i == 0 ? args : generateRandomArgs();
			argPrinter.setArguments(testArguments, 5);
			argPrinter.logAll();
			LOGGER.log(Level.INFO, "{0}: iteration..", i);
		}
	}
	
	private static Object[] generateRandomArgs() {
	  int numArgs = RANDOM.nextInt(10);
	  if (numArgs > 0) { return new Object[numArgs]; }
	  return null;
	}
	
	private static Integer generateRandomInteger() {
		Integer randomValue = Integer.valueOf(RANDOM.nextInt(2));
		if (randomValue > 0)
			return randomValue;
		return null;
	}
}
