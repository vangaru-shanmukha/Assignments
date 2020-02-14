/**
 * Using TextFile and a Map<Character,Integer>, create a program that takes the file name as a command line argument and counts the occurrence of all the different characters. 
 * Save the results in a text file.
 */
package assignments;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CharacterOccurrencesInaFile {

	/**
	 * This method is used to get the character occurrences in a file
	 * 
	 * @param file
	 * @return map with key - character, value - integer
	 * @throws IOException
	 */
	public static Map<Character, Integer> getOccurrences(FileReader file) throws IOException {
		Map<Character, Integer> occurrences = new HashMap<Character, Integer>();
		int character = -1;
		while ((character = file.read()) != -1) {
			if (occurrences.containsKey((char) (character))) {
				occurrences.put((char) (character), occurrences.get((char) (character)) + 1);
			} else {
				occurrences.put((char) (character), 1);
			}
		}
		return occurrences;
	}

	/**
	 * This method is used to write the output to a file
	 * 
	 * @param occurrences
	 * @param file
	 * @throws IOException
	 */
	public static void printOccurrencesToFile(Map<Character, Integer> occurrences, File file) throws IOException {
		FileWriter fileWriter = new FileWriter("test1.txt");
		for (Map.Entry<Character, Integer> map : occurrences.entrySet()) {
			String fileContent = "Character " + map.getKey() + " occurred " + map.getValue() + " times.\n";
			fileWriter.write(fileContent);
		}
		fileWriter.close();
	}

	public static void main(String[] args) throws IOException {
		FileReader file = new FileReader("test.txt");
		Map<Character, Integer> occurrences = getOccurrences(file);
		File file1 = new File("test1.txt");
		printOccurrencesToFile(occurrences, file1);
	}

}
