/**
 * Error Handling
 * Create three new types of exceptions. Write a class with a method that throws all three. 
 * In main( ), call the method but only use a single catch clause that will catch all three types of exceptions. 
 * Add a finally clause and verify that your finally clause is executed, even if a NullPointerException is thrown.
 * 
 */
package assignments;

/**
 * creates a custom exception ExceptionOne
 * 
 * @author vangaru
 *
 */
@SuppressWarnings("serial")
class ExceptionOne extends Exception {
	ExceptionOne(String message) {
		super(message);
	}
}

/**
 * create a custom exception ExceptionTwo
 * 
 * @author vangaru
 *
 */
@SuppressWarnings("serial")
class ExceptionTwo extends Exception {
	ExceptionTwo(String message) {
		super(message);
	}
}

/**
 * creates a custom exception ExceptionThree
 * 
 * @author vangaru
 *
 */
@SuppressWarnings("serial")
class ExceptionThree extends Exception {
	ExceptionThree(String message) {
		super(message);
	}
}

public class ErrorHandling {
	public static void main(String[] args) {
		try {
			// makes a call to the method1
			method1();
		} catch (Exception e) {
			System.out.println(e.getMessage() + " is thrown");
			System.out.println(e.getMessage() + " is caught");
		} finally {
			System.out.println("finally block executed");
		}

	}

	/**
	 * This method throws the three custom exceptions which are created above
	 * 
	 * @throws ExceptionOne
	 * @throws ExceptionTwo
	 * @throws ExceptionThree
	 */
	private static void method1() throws ExceptionOne, ExceptionTwo, ExceptionThree {
		throw new NullPointerException("Null pointer exception");
	}

}
