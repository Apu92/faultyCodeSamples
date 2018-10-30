package at.faultycode.simple;

public class PositiveOutOfBoundsBug {

	public static void main(String[] args) {
		
		final String[] osNames = {"Windows", "Linux", "Mac"};
		System.out.println(osNames[3]);
	}

}
