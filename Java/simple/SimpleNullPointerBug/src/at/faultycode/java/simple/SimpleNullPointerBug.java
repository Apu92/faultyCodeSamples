package at.faultycode.java.simple;

public class SimpleNullPointerBug {

	public static void main(String[] args) {
		
		String message = null;
		if (args.length == 2){
			message = message.concat("We have a problem here.");
		} else {
			message = "No bug occurred! Try another number of arguments.";
		}
		
		System.out.println(message);
	}

}
