package at.faultycode.java.simple;

public class OfByOneBug {

	public static void main(String[] args) {

		for (int i = 0; i <= args.length; i++) {
			String arg = args[i];
			System.out.println(i + ": " + arg);
		}
	}

}
