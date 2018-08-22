package at.samplecode.main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class HelloResourceLeak {

	public static void main(String[] args) {

		handleErrorPrintMessageToFile("Hello World!" + System.lineSeparator());
	}
	
	private static void handleErrorPrintMessageToFile(final String message) {
		try {
			printMessageToFile(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void printMessageToFile(final String message) throws IOException {
		if (message == null) {
			return;
		}
		
		FileOutputStream fos = new FileOutputStream(new File("output.txt"));
		fos.write(message.getBytes());
		fos.close();
	}

}
