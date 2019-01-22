package at.faultycode.java.advanced;

import java.util.logging.Logger;

/**
 * @author MaAb
 */
public final class Main {

	/** Default Java logger **/
	private static final Logger LOGGER = Logger
			.getLogger(Main.class.getName());
	
	/**
	 * Entry point of program
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		final IFileGenerator generatorA = new XMLFileGenerator();
		final IFileGenerator generatorB = new CSVFileGenerator();
		
		logDefaultDirectory(generatorA);
		logDefaultDirectory(generatorB);
		
		LOGGER.info(String.format("Default XML file name: ", 
				generatorA.getDefaultFileName().trim()));
		LOGGER.info(String.format("Default CSV file name: ", 
				generatorB.getDefaultFileName().trim()));
	}
	
	private static void logDefaultDirectory(IFileGenerator generator) {
		LOGGER.info(String.format("Default %s directory: %s", 
				generator.getName(),
				generator.getDefaultDirectory().getAbsolutePath()));
	}
}
