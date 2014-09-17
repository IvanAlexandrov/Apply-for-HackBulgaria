
/*
 * DashInsert
 * 
 * You have to implement a function with the following signature - dashInsert(num)
 * 
 * The argument num is of type integer.
 * The function should return a string
 * 
 * Insert dashes '-' between each two neighboring odd numbers in num.
 * 
 * Don't count zero as an odd number.
 * 
 * You can use any language you know.
 * 
 * Examples:
 * 
 * dashInsert(99946)
 * "9-9-946"
 * dashInsert(56730)
 * "567-30"
 * 
 */

import java.util.Scanner;

public class DashInserter {

	private static String dashInsert(int num) {
		String result = "";
		String strNum = Integer.toString(num);
		char firstDigit, secondDigit;
		for (int i = 0, j = 1; i < strNum.length(); i += 2, j += 2) {
			firstDigit = strNum.charAt(i);
			secondDigit = (j < strNum.length()) ? strNum.charAt(j) : 0;
			if (isOdd(firstDigit) && isOdd(secondDigit)) {
				if (i != 0 && (isOdd(strNum.charAt(i - 1)))) {
					result += "-";
				}
				result += (firstDigit + "-" + secondDigit);
			} else if (isOdd(firstDigit) && !isOdd(secondDigit)) {
				if (i != 0 && (isOdd(strNum.charAt(i - 1)))) {
					result += ("-");
				}
				result += (firstDigit + "" + secondDigit);
			} else if (secondDigit == 0) {
				result += (firstDigit);
			} else {
				result += (firstDigit + "" + secondDigit);
			}
		}

		return result.trim(); // If not trimmed result may look like this:
							  // "89-9-523-1^@" ;
	}

	private static boolean isOdd(char num) {
		if (num != 0 && num % 2 != 0) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = 0;
		while (true) {
			System.out
					.println("Type an integer (between 0 and +-2147483647) or [q] / [quit] to exit:");
			String str = scan.nextLine();
			if (str.equalsIgnoreCase("q") || str.equalsIgnoreCase("quit")) {
				System.out.println("Program finished");
				scan.close();
				System.exit(0);
			} else {
				try {
					num = Integer.parseInt(str);
				} catch (NumberFormatException nfex) {
					System.err.println(nfex.getClass().getName() + "\n"
							+ nfex.getMessage());
				}
				System.out.printf("Result is: \"%s\"%n", dashInsert(num));
			}
		}
	}

}
