package at.faultycode.java.simple;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ResourceLeakPartialClose {

	private static final Logger LOGGER = Logger
			.getLogger(ResourceLeakPartialClose.class.getName());


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
