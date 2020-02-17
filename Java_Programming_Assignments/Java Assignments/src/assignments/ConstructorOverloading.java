/**
 * Create a class with two (overloaded) constructors. 
 * Using this, call the second constructor inside the first one.
 */
package assignments;

public class ConstructorOverloading {

	ConstructorOverloading()
	{
		System.out.println("No parameter constructor called");
	}
	ConstructorOverloading(int a)
	{
		this();
		System.out.println("One parameter constructor called");
	}
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ConstructorOverloading constructorOverloading = new ConstructorOverloading(2);
	}

}
