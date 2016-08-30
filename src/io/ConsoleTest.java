package io;

import java.io.Console;

public class ConsoleTest {

	public static void main(String[] args) {
		Console console = System.console();
		console.writer().println("Testing console");
		final String userName = console.readLine("Enter your username ");
		
		console.writer().println("The username is: " + userName);
	}

}
