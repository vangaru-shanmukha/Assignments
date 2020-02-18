/**
 * Create a Cycle class, with subclasses Unicycle, Bicycle and Tricycle. 
 * Add a balance( ) method to Unicycle and Bicycle, but not to Tricycle. 
 * Create instances of all three types and upcast them to an array of Cycle. 
 * Try to call balance( ) on each element of the array and observe the results. 
 * Downcast and call balance( ) and observe what happens.
 */
package assignments;

public class Unicycle extends Cycle{
	Unicycle()
	{
		System.out.println("Unicycle constructor is called");
	}
	public void balance()
	{
		System.out.println("balance method of Unicycle");
	}
}
