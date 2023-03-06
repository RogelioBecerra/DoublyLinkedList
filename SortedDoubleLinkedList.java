import java.util.Comparator;
import java.util.ListIterator;



/**
 * The SortedDoubleLinkedList class
 * @author rogeliobecerra
 *
 * @param <T> data type
 */
public class SortedDoubleLinkedList <T> extends BasicDoubleLinkedList<T>{

	BasicDoubleLinkedList<T> list;
	Comparator<T> compObj;
	
	/**
	 * Creates an empty list that is associated with the specified comparator
	 * @param compareableObject -  a compareable obj
	 */
	public SortedDoubleLinkedList(Comparator<T> compareableObject) {
		list = new BasicDoubleLinkedList<>();
		compObj = compareableObject;
		
	}
	
	/**
	 * Inserts the specified element at the correct position in the sorted list
	 * @param data - a value
	 */
	public void add(T data) {
		
		if(list.getSize() == 0) 
		{
			list.addToFront(data);
			return;
		}	
		
			if(compObj.compare(data,list.tail.data) > 0)
			{
				list.addToEnd(data);
				return;
			}
			
			else if(compObj.compare(data,list.head.data) < 0)
			{
				list.addToFront(data);
				return;
			}
			else
			{
				Node<T> temp = head;
				for(int i = 0; i < list.size; i++)
				{
					if(compObj.compare(data,list.head.data) < 0)
					{
						Node<T> newNode = new Node<>(data);
						temp.prev.next = newNode;
						temp.prev = newNode;
						list.size++;
						
						return;
					}
					temp = temp.next;
				}
			}
			
			
		
		
		
	}
	
	/**
	 * This operation is invalid for a sorted list. Throws exception if called in SortedDoubleLinkedList.
	 * @param data - a value
	 */
	@Override
	public void addToEnd(T data) {
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	
	/**
	 * This operation is invalid for a sorted list. throws exception if called in SortedDoubleLinkedList.
	 * @param data - a value
	 */
	@Override
	public void addToFront(T data) {
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	
	
	/**
	* This method returns an object of the DoubleLinkedListIterator
	* @return object of the DoubleLinkedListIterator
	*/
	public ListIterator<T> iterator(){
		return super.iterator();
	}
	
	/**
	 *  Removes the first instance of the targetData from the list
	 *  @param data - a value
	 *  @param comparator - a comparator obj
	 *  @return  the removed node
	 */
	public Node<T> remove(T data,Comparator<T> comparator){
		return super.remove(data, comparator);
		
	}
	
	
}
