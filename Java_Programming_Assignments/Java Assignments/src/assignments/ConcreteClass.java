/**
 * Create three interfaces, each with two methods. 
 * Inherit a new interface that combines the three, adding a new method. 
 * Create a class by implementing the new interface and also inheriting from a concrete class. 
 * Now write four methods, each of which takes one of the four interfaces as an argument. 
 * In main( ), create an object of your class and pass it to each of the methods.
 */
package assignments;

public class ConcreteClass implements Interface {

	@Override
	public void method1() {
		System.out.println("method1 of InterfaceOne");
	}

	@Override
	public void method2() {
		System.out.println("method2 of InterfaceOne");

	}

	@Override
	public void method3() {
		System.out.println("method3 of InterfaceTwo");

	}

	@Override
	public void method4() {
		System.out.println("method4 of InterfaceTwo");

	}

	@Override
	public void method5() {
		System.out.println("method5 of InterfaceThree");

	}

	@Override
	public void method6() {
		System.out.println("method6 of InterfaceThree");

	}

	@Override
	public void method7() {
		System.out.println("method7 of Interface");

	}

}
