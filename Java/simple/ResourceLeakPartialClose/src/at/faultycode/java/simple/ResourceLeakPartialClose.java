package at.faultycode.java.simple;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author MaAb
 */
public final class ResourceLeakPartialClose {

	/** Default Java logger **/
	private static final Logger LOGGER = Logger
			.getLogger(ResourceLeakPartialClose.class.getName());

	private ResourceLeakPartialClose() {}
	
	/**
	 * Entry point of program
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String fileContent = "HelloWorld!";
		File out = new File("output.txt");

		try {
			OutputStream os = Files.newOutputStream(out.toPath());
			os.write(fileContent.getBytes(StandardCharsets.UTF_8));
			os.close();
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, "IO exception occurred!", e);
		}
	}
}
