/**
 * Create an inheritance hierarchy of Rodent: Mouse, Gerbil, Hamster,etc. 
 * In the base class, provide methods that are common to all Rodents, and override these in the derived classes to perform different behaviors depending on the specific type of Rodent. 
 * Create an array of Rodent, fill it with different specific types of Rodents, and call your base-class methods to see what happens. 
 * Make the methods of Rodent abstract whenever possible and all classes should have default constructors that print a message about that class.
 * 
 * Note:- Most of the Rodents vary with their tail length,color etc.
 */
package assignments;

public abstract class Rodent {
	private int tailLength;
	Rodent(int length)
	{
		System.out.println("In Rodent constructor and has a tail length " + length);
		this.tailLength = length;
	}
	public void setTailLength(int length)
	{
		this.tailLength = length;
	}
	public int getTailLength()
	{
		return this.tailLength;
	}
	public abstract void shout();
	public void eat()
	{
		System.out.println("Rodent is eating");
	}
}
