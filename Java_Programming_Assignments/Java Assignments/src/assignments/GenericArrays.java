/**
 * Generics, Arrays and Containers
 * Create a generic, singly linked list class called SList, which, to keep things simple, does not implement the List interface.
 * Each Link object in the list should contain a reference to the next element in the list, but not the previous one (LinkedList, in contrast, is a doubly linked list, which means it maintains links in both directions).
 * Create your own SListIterator which, again for simplicity, does not implement ListIterator. The only method in SList other than toString( ) should be iterator( ), which produces an SListIterator.
 * The only way to insert and remove elements from an SList is through SListIterator. Write code to demonstrate SList.
 */
package assignments;

public class GenericArrays {

	public static void main(String[] args) {
		// Creating a integer list of nodes
		SList<Integer> slist = new SList<Integer>();
		// getting the iterator object for the list
		SListIterator<Integer> iterator = slist.iterator();
		// inserting the elements into the list
		iterator.insert(2);
		System.out.println("2 is inserted");
		iterator.insert(3);
		System.out.println("3 is inserted");
		iterator.insert(4);
		System.out.println("4 is inserted");
		// removing the elements from the list
		System.out.println(iterator.remove(2) + " is removed");
		// getting the iterator object to iterate over the list
		SListIterator<Integer> iterator1 = new SListIterator<Integer>(slist);
		System.out.println("Elements in the list are:");
		while (iterator1.hasNext())
			System.out.println(iterator1.next());
	}

}
