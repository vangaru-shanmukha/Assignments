/**
 * Create main class in package yourname.assignment.main, create object of first class and call both the methods to print the values. 
 * Create object of second class using static method and then call the other method to print the String.
 * 
 * One or more tasks mentioned above are not possible in JAVA, comment that part of the code with block comments and add the explanation for the same.
 */
package assignments;

public class Main {

	public static void main(String[] args) {
		// creating a Data object
		Data data = new Data();
		/**
		 * This statement compiles fine because instance members are assigned with
		 * default values Ex: integer is assigned with 0 character is assigned with '
		 * '(empty char)
		 */
		data.print();
		/**
		 * This statement throws a compilation error because local variables are not
		 * initialized with default values
		 */
		// data.printLocal();
		// creating a Singleton object
		Singleton singleton = new Singleton();
		/**
		 * This gives a warning (because static methods can be called using the class
		 * name) but it works fine. But it throws a compile time error because we try to
		 * access a non-static member (string) in static context. Which is not possible.
		 * (i.e) We cannot access non-static members from a static context and we can
		 * access a static or a non-static member from the non-static context. Because
		 * of which the call to nonStaticMethod compiles fine.
		 */
		singleton.staticMethod("string parameter");
		singleton.nonStaticMethod();
	}

}
