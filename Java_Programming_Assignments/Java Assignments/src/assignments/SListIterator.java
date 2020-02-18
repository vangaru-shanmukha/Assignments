/**
 * Generics, Arrays and Containers
 * Create a generic, singly linked list class called SList, which, to keep things simple, does not implement the List interface.
 * Each Link object in the list should contain a reference to the next element in the list, but not the previous one (LinkedList, in contrast, is a doubly linked list, which means it maintains links in both directions).
 * Create your own SListIterator which, again for simplicity, does not implement ListIterator. The only method in SList other than toString( ) should be iterator( ), which produces an SListIterator.
 * The only way to insert and remove elements from an SList is through SListIterator. Write code to demonstrate SList.
 */
package assignments;

/**
 * This class provides an iterator object and performs insertions and deletions
 * on the list
 * 
 * @author vangaru
 *
 * @param <T>
 */
public class SListIterator<T> {
	SList<T> slist;
	SListNode<T> head;

	/**
	 * This constructor is used to initialize the slist
	 * 
	 * @param slist
	 */
	SListIterator(SList<T> slist) {
		this.slist = slist;
		head = slist.head;
	}

	/**
	 * This method is used to insert a node into the list
	 * 
	 * @param data
	 */
	public void insert(T data) {
		SListNode<T> node = new SListNode<T>(data);
		if (head == null) {
			head = node;
		} else {
			SListNode<T> temp = head;
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			temp.setNext(node);
		}
		slist.head = head;
	}

	/**
	 * This method is used to remove a node from the list
	 * 
	 * @param data
	 * @return
	 */
	public SListNode<T> remove(T data) {
		SListNode<T> node = slist.head;
		SListNode<T> deleteNode = null;
		if (node == null)
			throw new NullPointerException("Element not found!");
		else if (node.getData() == data) {
			slist.head = node.getNext();
			return node;
		} else {
			while (node.getNext() != null && node.getNext().getData() != data) {
				node = node.getNext();
			}
			deleteNode = node.getNext();
			node.setNext(node.getNext().getNext());
			node = node.getNext();
		}
		return deleteNode;
	}

	/**
	 * This method is used to check whether there are any nodes
	 * 
	 * @return
	 */
	public boolean hasNext() {
		if (head != null)
			return true;
		return false;
	}

	/**
	 * This method returns the next node
	 * 
	 * @return
	 */
	public SListNode<T> next() {
		SListNode<T> node = head;
		head = head.getNext();
		return node;
	}
}
