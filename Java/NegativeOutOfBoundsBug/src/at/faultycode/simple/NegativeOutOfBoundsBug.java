package at.faultycode.simple;

public class NegativeOutOfBoundsBug {

	public static void main(String[] args) {
		
		final String invalidArg = args[-1];
		System.out.println(invalidArg);
	}

}
