/**
 * Create an inheritance hierarchy of Rodent: Mouse, Gerbil, Hamster,etc. 
 * In the base class, provide methods that are common to all Rodents, and override these in the derived classes to perform different behaviors depending on the specific type of Rodent. 
 * Create an array of Rodent, fill it with different specific types of Rodents, and call your base-class methods to see what happens. 
 * Make the methods of Rodent abstract whenever possible and all classes should have default constructors that print a message about that class.
 */
package assignments;

import java.util.ArrayList;

public class RodentHierarchy {

	public static void main(String[] args) {
		ArrayList<Rodent> list = new ArrayList<Rodent>();
		list.add(new Mouse(2));
		list.add(new Gerbil(3));
		list.add(new Hamster(4));
		for(Rodent rodent : list)
		{
			rodent.eat();
			rodent.shout();
		}
	}

}
