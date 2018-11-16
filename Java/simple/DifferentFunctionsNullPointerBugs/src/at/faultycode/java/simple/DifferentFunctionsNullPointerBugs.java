package at.faultycode.java.simple;

public class DifferentFunctionsNullPointerBugs {

	public static void main(String[] args) {
		
		String argMessage = createArgumentString(args);
		printMessageToConsole(argMessage);
		
		String argList = createArgumentList(args);
		printMessageToConsole(argList);
	}
	
	public static String createArgumentString(String[] args) {
		String message = null;
		if (args.length == 1) {
			message = args.length + " argument is specified.";
		} else if (args.length > 1){
			message = args.length + " arguments are specified.";
		}
		
		return message;
	}
	
	public static String createArgumentList(String[] args) {
		String message = null;
		String argumentLines = "";
		for (String arg : args) {
			argumentLines += "  " + arg + System.lineSeparator();
		}
		
		if (!argumentLines.isEmpty()) {
			message = argumentLines;
		}
		return message;
	}
	
	private static void printMessageToConsole(String message) {
		if (!message.isEmpty()) {
			System.out.println(message);
		}
	}

}
