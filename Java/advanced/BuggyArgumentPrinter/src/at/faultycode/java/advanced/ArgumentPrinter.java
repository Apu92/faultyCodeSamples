package at.faultycode.java.advanced;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author MaAb
 */
public class ArgumentPrinter {

	/** Default Java logger **/
	private static final Logger LOGGER = Logger.getLogger(ArgumentPrinter.class.getName());

	private Object[] args;
	private Integer maxArgs;

	public void setArguments(final Object[] args, Integer maxArgs) {
		this.args = new String[maxArgs]; this.maxArgs = maxArgs;
		initArgs(args, maxArgs);
	}

	private synchronized void initArgs(final Object[] args, final Integer maxNumArgs) {
		for (int i = 0; i < maxNumArgs; i++)
			this.args[i] = args[i];
	}
	
	public File initLogFile() {
		File logFile = new File("logFile.log");
		try {
			FileOutputStream fos = new FileOutputStream(logFile);
			fos.write("LogFile: ArgumentPrinter".getBytes(Charset.defaultCharset()));
			fos.close();
		} catch (IOException e) {
			// Ignore
			return null;
		}
		return logFile;
	}

	/**
	 * Logs the number of arguments and the content of each argument.
	 */
	public void logAll() {
		logNumberOfArguments(); logAllArguments();
	}

	private void logNumberOfArguments() {
		String formatString = createFormatStringNumArgs();
		if (!formatString.isEmpty())
			LOGGER.log(Level.INFO, formatString, args.length);
	}

	private void logArgumentContent(Integer index) {
		LOGGER.log(Level.INFO, "Arg[" + index + "]: '{0}'", args[index].toString());
	}

	private void logAllArguments() {
		for (int i = 0; i <= maxArgs; i++)
			logArgumentContent(i);
	}

	private String createFormatStringNumArgs() {
		if (args.length == 1) return "{0} argument is entered!"; 
		else if (args.length > 1) return "{0} argument(s) are entered!";
		return null;
	}
}
