/**
 * Create a class in a package yourname.assignment.data containing an int and a char member variables that are not initialized, add a method to print these variables. 
 * Add another method in the same class with two local variables and print their values without initializing them.
 */
package assignments;

public class Data {
	int integer;
	char character;

	public void print() {
		System.out.println("Integer: " + integer);
		System.out.println("Character: " + character);
	}

	public void printLocal() {
		String s;
		boolean bool;
		/**
		 * System.out.println("String local variable : " + s);
		 * System.out.println("Boolean local variable : " + bool);
		 * 
		 * The above lines throws a compilation error because local variables are not
		 * initialized with default values as with the instance members.
		 */
	}
}
