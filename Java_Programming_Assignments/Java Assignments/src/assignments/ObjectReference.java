/**
 * Create a class with a constructor that takes a String argument. 
 * During construction, print the argument. 
 * Create an array of object references to this class, but don’t actually create objects to assign into the array. 
 * When you run the program, notice whether the initialization messages from the constructor calls are printed.
 * Complete the previous exercise by creating objects to attach to the array of references.
 */
package assignments;

public class ObjectReference {

	ObjectReference(String argument) {
		System.out.println("String argument: " + argument);
	}

	public static void main(String[] args) {
		ObjectReference[] objectReferences = new ObjectReference[2];
		/**
		 * When the above line gets executed, initialization messages from the
		 * constructor are not printed
		 */
		objectReferences[0] = new ObjectReference("1");
		objectReferences[1] = new ObjectReference("2");
		/**
		 * The above two lines make the initialization messages from the constructor to
		 * be printed
		 */
	}

}
