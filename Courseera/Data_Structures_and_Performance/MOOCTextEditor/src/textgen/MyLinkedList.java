package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		size = 0;
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		if (element == null) {
			throw new NullPointerException();
		}
        LLNode<E> n = new LLNode<E>(element);
        tail.prev.next = n;
        n.next = tail;
        n.prev = tail.prev;
        tail.prev = n;
        size++;
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		LLNode<E> n = head;
		for (int i = 0; i <= index; i++) {
			n = n.next;
		}
		return n.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		if(element == null)
			throw new NullPointerException("null elements are not allowed");
		if(index > size())
			throw new IndexOutOfBoundsException("Index out of bounds");
		LLNode<E> headNode = head;
		LLNode<E> node = new LLNode<E>(element);
		for(int i=0; i<index; i++)
			headNode = headNode.next;
		node.prev = headNode;
		node.next = headNode.next;
		headNode.next.prev = node;
		headNode.next = node;
		size++;
	}


	/** Return the size of the list */
	public int size() 
	{
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		LLNode<E> headNode = head;
		for(int i=0;i<index;i++)
			headNode = headNode.next;
		E dataField = headNode.next.data;
		headNode.next.next.prev = headNode;
		headNode.next = headNode.next.next;
		size--;
		return dataField;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Index out of bounds .....");
		if(element == null)
			throw new NullPointerException("null elements are not allowed");
		LLNode<E> headNode = head;
		for(int i=0;i<=index;i++)
			headNode = headNode.next;
		E dataField = headNode.data;
		headNode.data = element;
		return dataField;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
