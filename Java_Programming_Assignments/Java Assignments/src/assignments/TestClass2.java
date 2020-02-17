/**
 * Create a class with an inner class that has a non-default constructor (one that takes arguments). 
 * Create a second class with an inner class that inherits from the first inner class.
 */
package assignments;

import assignments.TestClass1.InnerClass;

public class TestClass2 {
	class InnerClass2 extends InnerClass
	{

		InnerClass2(TestClass1 testClass1, int data) {
			testClass1.super(data);
		}
		
	}
}
