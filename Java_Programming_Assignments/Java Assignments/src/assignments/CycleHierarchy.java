/**
 * Create a Cycle class, with subclasses Unicycle, Bicycle and Tricycle. 
 * Add a balance( ) method to Unicycle and Bicycle, but not to Tricycle. 
 * Create instances of all three types and upcast them to an array of Cycle. 
 * Try to call balance( ) on each element of the array and observe the results. 
 * Downcast and call balance( ) and observe what happens.
 */
package assignments;

public class CycleHierarchy {
	public static void main(String args[])
	{
		Cycle cycle[] = new Cycle[3];
		cycle[0] = new Unicycle();
		cycle[1] = new Bicycle();
		cycle[2] = new Tricycle();
		/**
		 * cycle[0].balance()
		 * The above statement will result a compile time error because the compiler searches for the method 
		 * balance in Cycle class during compilation and calls the Unicycle balance method during runtime.
		 * Since the compiler will not be able to find the balance method in Cycle class during compile time 
		 * it throws an error!!
		 */
		((Unicycle)(cycle[0])).balance();
		((Bicycle)(cycle[1])).balance();
		/**
		 * ((Tricycle)(cycle[2])).balance();
		 * The above statement will result a compile time error because the compiler couldn't find the balance method
		 * in Tricycle class
		 */
	}
}
