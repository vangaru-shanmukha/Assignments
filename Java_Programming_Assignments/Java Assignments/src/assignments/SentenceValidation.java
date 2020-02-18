/**
 * Using the documentation for java.util.regex.Pattern as a resource, write and test a regular expression that checks a sentence to see that it begins with a capital letter and ends with a period.
 */
package assignments;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceValidation {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the sentence to validate: ");
		String sentence = sc.nextLine();
		boolean result = isValidSentence(sentence);
		if (result)
			System.out.println("Yes, the sentence starts with a capital letter and ends with a period(.)");
		else
			System.out.println("No, the sentence starts with a capital letter and ends with a period(.)");
	}

	/**
	 * This method is used to check whether the sentence starts with a capital
	 * letter and ends with a period(.)
	 * 
	 * @param sentence
	 * @return boolean
	 */
	private static boolean isValidSentence(String sentence) {
		Pattern pattern = Pattern.compile("^[A-Z]+[a-zA-Z | \\s]*\\.$");
		Matcher matcher = pattern.matcher(sentence);
		if (matcher.find())
			return true;
		return false;
	}

}
