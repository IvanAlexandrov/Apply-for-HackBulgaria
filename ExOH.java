/*
 * ExOH
 * Implement a function with the following signature: ExOh(str)
 * str is of type string.
 * The function should return true if there is an equal number of x's and o's in str. It should return false otherwise.
 * 
 * Things to know:
 * 
 * Only these two letters will be entered in the string, no punctuation or numbers.
 * You don't have to check for valid input.
 * You can use any language you know.
 * 
 * Examples:
 * 
 * ExOh('xoxoox') # true
 * ExOh('oooxoo') # false
 * 
 */

import java.util.Scanner;

public class CharOcurrencyComparator {

	private static boolean Ex0h(String str) {
		int x = 0;
		int o = 0;
		char ch;
		
		for (int i = 0; i < str.length(); i++) {
			ch = str.charAt(i);
			if (ch == 'x') {
				x++;
			} else if (ch == 'o') {
				o++;
			} else {
				continue;
			}
		}
		
		if (x == o) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("Type a string or [q] / [quit] to exit:");
			String str = scan.nextLine();
			if (str.equalsIgnoreCase("q") || str.equalsIgnoreCase("quit")) {
				System.out.println("Program finished");
				scan.close();
				System.exit(0);
			} else {
				System.out.println("Result is: " + Ex0h(str));
			}
		}
	}
	
	
}
