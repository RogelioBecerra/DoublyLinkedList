import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * The BasicDoubleLinkedList class
 * @author rogeliobecerra
 *
 * @param <T> data type
 */
public class BasicDoubleLinkedList <T> implements Iterable<T> {

	 int size = 0;
	 Node<T> head;
	 Node<T> tail;
		
	/**
	 * Constructor 
	 */
	public BasicDoubleLinkedList() {
		head = null;
		tail = null;
	}
	
	
	/**
	 * The Node Class
	 * @author rogeliobecerra
	 *
	 * @param <T> - the data type of the DoubleLinkedList
	 */
	protected class Node<T>{
		T data;
		Node<T> prev = null;
		Node<T> next = null;
		
		/**
		 * Constructor - sets data value
		 * @param data - value
		 */
		public Node(T data)
		{
			this.data = data;
		}
	}
	
	/**
	 * Adds an element to the end of the list and updated the size of the list
	 * @param data - value
	 */
	public void addToEnd(T data)
	{
		
		if(size == 0)
		{
			head = new Node<T>(data);
			tail = head;
		}
		else {
			Node<T> after = new Node<T>(data);
			tail.next = after;
			after.prev = tail;
			tail = after;
		}
		size++;
	}
	
	/**
	 * Adds element to the front of the list and updated the size of the list
	 * @param data - value
	 */
	public void addToFront(T data) {
		
		if(size == 0)
		{
			head = new Node<T>(data);
			tail = head;
		}
		else {
			Node<T> before = new Node<T>(data);
			head.prev = before;
			before.next = head;
			head = before;
		}
		size++;
	}
	
	/**
	 * Returns the data in the head Node but does not remove the first element from the list.
	 * @return the data in the first Node
	 */
	public T getFirst() {
		if(size !=0)
		return head.data;
		else {
			return null;
		}
	}
	
	/**
	 * Returns the data in the tail Node but does not remove the last element from the list.
	 * @return the data in the last Node
	 */
	public T getLast() {
		if(size !=0)
			return tail.data;
		else 
			return null;
			
	}
	
	/**
	 * Returns the number of nodes
	 * @return size of linkedList
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * Removes and returns the first element from the list
	 * @return data element or null
	 */
	public T retrieveFirstElement() {
		if(size == 0) {
			return null;
		}
		
		T val = head.data;
		head = head.next;
		head.prev = null;
		size--;
		
		return val;
	}
	
	/**
	 * Removes and returns the last element from the list
	 * @return data element or null
	 */
	public T retrieveLastElement() { 
		if(size == 0)
			return null;
		
		T val = tail.data;
		tail = tail.prev;
		tail.next = null;
		
		size--;
		
		return val;
	}
	
	/**
	 * Convert the data in the linked list elements into an ArrayList 
	 * @return ArrayList version of LinkedList
	 */
	public ArrayList<T> toArrayList(){
		ArrayList<T> al = new ArrayList<>();
		Node<T> temp = head;
		
		for(int i = 0; i < size; i++)
		{
			al.add(temp.data);
			temp = temp.next;
		}
		return al;
	}
	
	/**
	 * Removes the first instance of the targetData from the list
	 * @param targetData - data searching for 
	 * @param comparator - the comparator to determine equality of data elements
	 * @return - a node containing the targetData or null
	 */
	public Node<T> remove (T targetData, Comparator<T> comparator)
	{
		Node<T> temp = head;
		
		for(int i = 0; i < size; i++)
		{
			if(comparator.compare(targetData, temp.data) == 0)
				{
					if(temp == head)
					{
						retrieveFirstElement();
					}
					else if(temp == tail)
					{
						retrieveLastElement();
					}
					else
					{
						temp.prev.next = temp.next;
						temp.next.prev = temp.prev;
						temp.next = null;
						temp.prev = null;
						
						size--;
					}
					
					return temp;
				}
			else 
				temp = temp.next;
		
			
		}
		return null;
	}
	
	/**
	* This method returns an object of the DoubleLinkedListIterator
	* @return an DoubleLinkedListIterator object
	*/
	public ListIterator<T> iterator(){
		DoubleLinkedListIterator obj = new DoubleLinkedListIterator();
		return obj;
	
	}
	
	
	/**
	 * The DoubleLinkedListIterator has the next(), hasNext(), previous(), and hasPrevious() methods. implements the ListIterator<t> class
	 * @author rogeliobecerra
	 * 
	 */
	protected class DoubleLinkedListIterator implements ListIterator<T>{ 
		
		 Node<T> pointer;
		 Node<T> end;
		 int iSize;
		 int iCount = 0;
		
		/**
		 * Constructed
		 */
		public DoubleLinkedListIterator() {
			iSize = size;
			pointer = head;
			end = tail;
		}
		
		/**
		 * checks if the current node has a next
		 */
		@Override
		public boolean hasNext() {
			if(pointer != null)
				return true;
				
			return false;
		}

		/**
		 * Returns the next element in the list and advances the pointer position.
		 */
		@Override
		public T next() {
			
			if(pointer == null) {
				throw new NoSuchElementException();
			}
			else {
				
				T val = pointer.data;
				pointer = pointer.next;
				return val;
			}
		}

		/**
		 * Checks if the current node has a previous
		 */
		@Override
		public boolean hasPrevious() {
			if(pointer != head )
				return true;
			
			return false;
		}

		/**
		 * Returns the prev element in the list and moves back the pointer by one position
		 */
		@Override
		public T previous() {
			if(pointer == tail.next) {				
				pointer = tail;	
				T val = pointer.data;
				return val;
			}
			
			if(pointer.prev != null) {
				pointer = pointer.prev;
				T val = pointer.data;
				return val;
			}
			throw new NoSuchElementException();
		}

		/**
		 * throws UnsupportedOperationException
		 */
		@Override
		public int nextIndex() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		/**
		 * throws UnsupportedOperationException
		 */
		@Override
		public int previousIndex() throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}

		/**
		 * throws UnsupportedOperationException
		 */
		@Override
		public void remove() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
			
		}

		/**
		 * throws UnsupportedOperationException
		 */
		@Override
		public void set(T e) throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
			
		}

		/**
		 * throws UnsupportedOperationException
		 */
		@Override
		public void add(T e) throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
			
		}
		
	}
	
	
}
