package at.samplecode.main;

public class HelloOutOfBoundsBug {

	public static void main(String[] args) {
		
		final String invalidArg = args[-1];
		System.out.println(invalidArg);
	}

}
