package at.faultycode.java.advanced;

import java.util.Random;
import java.util.logging.Logger;

/**
 * @author MaAb
 */
public class Main {
	
	/** Default Java logger **/
	private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
	
	private static final Random random = new Random();
	
	/**
	 * Entry point of program
	 * 
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		LOGGER.info("Start program...");
		Thread t1, t2;
		for (int i = 0; i < 5; i++) {
		  final ArgumentPrinter argPrinter = new ArgumentPrinter();
		  Object[] t1Args = i == 0? args : generateRandomArgs();
      t1 = new Thread(new Runnable() {
        @Override
        public void run() {
          argPrinter.setArguments(t1Args, Integer.valueOf(5)); argPrinter.logAll();
        }
      });
      t2 = new Thread(new Runnable() {
        @Override
        public void run() {
          argPrinter.setArguments(generateRandomArgs(), Integer.valueOf(10)); argPrinter.logAll();
        }
      }); t1.start(); t2.start(); LOGGER.info(i + ": iteration.."); t1.join(); t2.join();
    }
	}
	
	private static Object[] generateRandomArgs() {
	  int numArgs = random.nextInt(10);
	  if (numArgs > 0) { return new Object[numArgs]; }
	  return null;
	}
}
