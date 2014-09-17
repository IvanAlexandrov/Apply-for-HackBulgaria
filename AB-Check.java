
/*
 * 
 * You have the implement a function, with the following signature: ABCheck(str).
 * 
 * The argument str is of type string.
 * 
 * The function should return true if the characters a and b are separated by exactly 3 places anywhere in the string at least once.
 * 
 * Otherwise return false
 * 
 * For example - "lane borrowed" would result in true because there is exactly three characters between a and b.
 * 
 * You can use any language you know.
 * 
 * Examples:
 * 
 * ABCheck("after badly") # false
 * ABCheck("Laura sobs") # true
 *  
 */

import java.util.Scanner;

public class SpaceBetweenChars {

	private static boolean ABCheck(String str) {

		int aPos = str.indexOf('a');
		int bPos = str.indexOf('b');
		char chA = 'a';
		char chB = 'b';
		int space = 0;

		// Check if neither A nor B are presented in given string
		if (aPos == -1 || bPos == -1) {
			return false;
		} else {
			// If checks are passed going to find space between A and B
			// Assuming that the position of A must precede B because of the
			// function name
			for (int i = 0; i < str.length(); i++) {

				if (str.charAt(i) == chA) {
					str = str.substring(i);

					for (int j = 1; j < str.length(); j++) {
						if (str.charAt(j) == chB && space == 3) {
							return true;
						} else if (str.charAt(j) != chB) {
							space++;
							if (space > 3) {
								space = 0;
								break;
							}
						}
					}
				}
			}
		}
		return false;
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
				System.out.println("Result is: " + ABCheck(str));
			}
		}
	}
	
	
}
