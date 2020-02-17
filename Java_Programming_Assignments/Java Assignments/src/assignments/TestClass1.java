/**
 * Create a class with an inner class that has a non-default constructor (one that takes arguments). 
 * Create a second class with an inner class that inherits from the first inner class.
 */
package assignments;

public class TestClass1 {
	class InnerClass
	{
		int data;
		InnerClass(int data)
		{
			this.data = data;
		}
	}
}
