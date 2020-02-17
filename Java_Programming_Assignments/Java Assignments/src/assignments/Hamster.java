/**
 * Create an inheritance hierarchy of Rodent: Mouse, Gerbil, Hamster,etc. 
 * In the base class, provide methods that are common to all Rodents, and override these in the derived classes to perform different behaviors depending on the specific type of Rodent. 
 * Create an array of Rodent, fill it with different specific types of Rodents, and call your base-class methods to see what happens. 
 * Make the methods of Rodent abstract whenever possible and all classes should have default constructors that print a message about that class.
 */
package assignments;

public class Hamster extends Rodent{

	Hamster(int length) {
		super(length);
		System.out.println("In Hamster constructor and has a tail length " + length);
	}

	@Override
	public void shout() {
		System.out.println("Hamster is making noise");
		
	}
	@Override
	public void eat()
	{
		System.out.println("Hamster is eating");
	}
}
