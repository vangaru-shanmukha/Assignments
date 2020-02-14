/**
 * Write a java function that checks if the input string contains all the letters of the alphabet a-z (case-insensitive). 
 * Write time and space complexity of your solution as comments in the source file.
 * Time complexity : O(n)
 * Space complexity : 2*n+67 (Linear space complexity)
 * where n is the length of the text
 */
package assignments;

import java.util.Scanner;

public class TimeAndSpaceComplexity {
	/**
	 * This method is used to decide whether the text contains all the alphabets or
	 * not
	 * 
	 * @param text
	 * @return boolean
	 */
	public static boolean isHavingAllLetters(String text) {
		boolean result = false;
		int numOfCharacters = 0;
		// converting the text to lower case
		text = text.toLowerCase();
		// creating an array of size 26 to keep track of the alphabets that are visited
		int contains[] = new int[26];
		// iterating over the text
		for (int index = 0; index < text.length(); index++) {
			char character = text.charAt(index);
			// if the position in the contains array is false we set it to true and
			// increment numOfCharacters
			if (contains[(int) (character) - (int) ('a')] == 0) {
				contains[(int) (character) - (int) ('a')] = 1;
				numOfCharacters = numOfCharacters + 1;
			}
		}
		// if numOfCharacters is equal to 26 we make result true else false
		if (numOfCharacters == 26) {
			result = true;
		} 
		return result;
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the text: ");
		String text = sc.next();
		System.out.println("Text: " + text);
		if (isHavingAllLetters(text))
			System.out.println("Yes, the entered text contains all the letters");
		else
			System.out.println("No, the entered text does not contain all the letters");
		System.out.println("Time complexity: O(n); where n is the length of the string");
		System.out.println("Space complexity: 2*n+67 (Linear space complexity); where n is the length of the string");
	}

}
