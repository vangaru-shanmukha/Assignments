/**
 * Write a java function that will ping any host ( given as input ) and computes the median of the time taken to ping.
 * Use the system ping utility, do not use any deprecated methods.
 */
package assignments;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ping {
	@SuppressWarnings("resource")
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		// scanning the hostname from the user
		String hostname = sc.next();
		// create the ping command as a list of strings
		Ping ping = new Ping();
		List<String> commands = new ArrayList<String>();
		commands.add("ping");
		commands.add("-c");
		commands.add("5");
		commands.add(hostname);
		ping.doCommand(commands);
	}

	public void doCommand(List<String> command) throws IOException {
		String s = null;
		// creating a process builder to execute the commands
		ProcessBuilder pb = new ProcessBuilder(command);
		Process process = pb.start();
		// creating a buffered reader for reading the output produced by executing the
		// command
		BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
		System.out.println("Here is the standard output of the command:\n");
		// storing the output lines in a arraylist
		ArrayList<String> list = new ArrayList<String>();
		while ((s = stdInput.readLine()) != null) {
			list.add(s);
		}
		// getting the line that contains the round trip time
		String rtt = list.get(list.size() - 1);
		// splitting the line based on = and spaces
		String strings[] = rtt.split("[= | \\s+]");
		// storing the key values (min,max,avg,mdev)
		String keys[] = strings[1].split("/");
		// storing the values for the above keys
		String values[] = strings[4].split("/");
		// printing the keys along with their values
		for (int i = 0; i < keys.length; i++) {
			System.out.println(keys[i] + " " + values[i]);
		}
	}
}
