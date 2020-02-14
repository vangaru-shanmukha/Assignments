/*
 * Create a java program to search through the home directory and look for files that match a regular expression. 
 * The program should be able to take inputs repeatedly and should print out the full absolute path of the matching files found.
 */
package assignments;

import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindAbsolutePathOfFile {
	/**
	 * This method is used to check whether file name matches with fileNameRegex
	 * 
	 * @param file
	 * @param fileNameRegex
	 *            is the regular expression
	 * @return true if the file name matches with fileNameRegex else false
	 */
	public static boolean isMatched(File file, String fileNameRegex) {
		Pattern pattern = Pattern.compile(fileNameRegex);
		Matcher m = pattern.matcher(file.getName());
		if (m.find())
			return true;
		return false;
	}

	/**
	 * This method is used to find the absolute path of the files matching the
	 * regular expression
	 * 
	 * @param filePath
	 *            is the path of the file
	 * @param fileNameRegex
	 *            is the regular expression entered by the user
	 */
	public static void findPath(File filePath, String fileNameRegex) {
		// iterating over the list of files present in the filePath directory
		for (File f : filePath.listFiles()) {
			// if the file name starts with '.' we ignore them
			if (!f.getName().startsWith(".")) {
				// if the file name does not start with '.' and is a directory
				if (f.isDirectory())
					// making the recursive call to findPath()
					findPath(f, fileNameRegex);
				// if the file name does not start with '.' and is not a directory
				else {
					// checking whether the file name matches the entered regular expression
					if (isMatched(f, fileNameRegex))
						// if matched print the absolute path of the file
						System.out.println(f.getAbsolutePath());
				}
			}
		}
	}

	@SuppressWarnings("resource")
	public static void main(String args[]) {
		// To get the user name of the system
		String username = System.getProperty("user.name");
		// Setting the root directory
		File filePath = new File("/home/" + username + "/");
		// Taking the input from the user to continue the search or not
		Scanner sc = new Scanner(System.in);
		System.out.println("Would like to search[Y/N]?:");
		String decision = sc.next();
		// The user will be allowed to search the directory as long as he enters y or Y
		while (decision.equals("Y") || decision.equals("y")) {
			// Getting the regular expression from the user
			System.out.print("Enter the regular expression:");
			String fileNameRegex = sc.next();
			// method to find the absolute path of the files with the entered regular
			// expression
			findPath(filePath, fileNameRegex);
			// user will be asked to enter his opinion to carry on the search
			System.out.println("Would like to search[Y/N]?:");
			decision = sc.next();
		}
		System.out.println("Program terminated");
	}
}