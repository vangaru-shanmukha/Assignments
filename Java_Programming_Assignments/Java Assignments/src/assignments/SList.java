/**
 * Generics, Arrays and Containers
 * Create a generic, singly linked list class called SList, which, to keep things simple, does not implement the List interface.
 * Each Link object in the list should contain a reference to the next element in the list, but not the previous one (LinkedList, in contrast, is a doubly linked list, which means it maintains links in both directions).
 * Create your own SListIterator which, again for simplicity, does not implement ListIterator. The only method in SList other than toString( ) should be iterator( ), which produces an SListIterator.
 * The only way to insert and remove elements from an SList is through SListIterator. Write code to demonstrate SList.
 */
package assignments;

/**
 * This class creates a list of nodes
 * 
 * @author vangaru
 *
 * @param <T>
 */
public class SList<T> {
	public SListNode<T> head;

	/**
	 * This method returns an iterator to iterate over the list
	 * 
	 * @return SListIerator<T>
	 */
	public SListIterator<T> iterator() {
		return new SListIterator<T>(this);
	}

	/**
	 * This method returns a string of all the nodes in the list
	 */
	public String toString() {
		SListNode<T> temp = head;
		String result = "";
		while (temp != null) {
			result = result + temp.getData() + " ";
			temp = temp.getNext();
		}
		return result;
	}
}

/**
 * This a node class containing data and next pointer
 * 
 * @author vangaru
 *
 * @param <T>
 */
class SListNode<T> {
	private T data;
	private SListNode<T> next;

	SListNode() {
		this.data = null;
		this.next = null;
	}

	SListNode(T data) {
		this.data = data;
		this.next = null;
	}

	public SListNode<T> getNext() {
		return this.next;
	}

	public void setNext(SListNode<T> next) {
		this.next = next;
	}

	public T getData() {
		return this.data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String toString() {
		String result = "";
		result = result + data;
		return result;
	}
}