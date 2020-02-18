/**
 * Create three interfaces, each with two methods. 
 * Inherit a new interface that combines the three, adding a new method. 
 * Create a class by implementing the new interface and also inheriting from a concrete class. 
 * Now write four methods, each of which takes one of the four interfaces as an argument. 
 * In main( ), create an object of your class and pass it to each of the methods.
 */
package assignments;

public class InterfaceTesting extends ConcreteClass implements Interface {
	public void testMethod1(InterfaceOne i1) {
		i1.method1();
	}

	public void testMethod2(InterfaceTwo i2) {
		i2.method3();
	}

	public void testMethod3(InterfaceThree i3) {
		i3.method5();
	}

	public void testMethod4(Interface i) {
		i.method2();
	}

	public static void main(String args[]) {
		InterfaceTesting interfaceTesting = new InterfaceTesting();
		interfaceTesting.testMethod1(interfaceTesting);
		interfaceTesting.testMethod2(interfaceTesting);
		interfaceTesting.testMethod3(interfaceTesting);
		interfaceTesting.testMethod4(interfaceTesting);
	}
}
