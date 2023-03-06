import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;






class BasicDoubleLinkedList_STUDENT_Test {

	BasicDoubleLinkedList<Double> linkedDouble;
	DoubleComparator comparatorD;
	
	@BeforeEach
	void setUp() throws Exception {
		linkedDouble = new BasicDoubleLinkedList<Double>();
		linkedDouble.addToEnd(2.0);
		linkedDouble.addToEnd(5.0);
		comparatorD = new DoubleComparator();
	}

	@AfterEach
	void tearDown() throws Exception {
		linkedDouble = null;
		comparatorD = null;
	}


	@Test
	public void testGetSize() {
		assertEquals(2,linkedDouble.getSize());
		linkedDouble.addToEnd(3.0);
		assertEquals(3,linkedDouble.getSize());
	}
	
	@Test
	public void testAddToEnd() {
		assertEquals(5.0, linkedDouble.getLast());
		linkedDouble.addToEnd(7.0);
		assertEquals(7.0, linkedDouble.getLast());
	}
	
	@Test
	public void testAddToFront() {
		assertEquals(2.0, linkedDouble.getFirst());
		linkedDouble.addToFront(14.7);
		assertEquals(14.7, linkedDouble.getFirst());
	}
	
	@Test
	public void testGetFirst() {
		assertEquals(2.0, linkedDouble.getFirst());
		linkedDouble.addToFront(8.3);
		assertEquals(8.3, linkedDouble.getFirst());
	}

	@Test
	public void testGetLast() {
		assertEquals(5.0, linkedDouble.getLast());
		linkedDouble.addToEnd(3.2);
		assertEquals(3.2, linkedDouble.getLast());
	}
	
	
	@Test
	public void testToArrayList()
	{
		ArrayList<Double> list;
		linkedDouble.addToFront(9.0);
		linkedDouble.addToEnd(4.0);
		list = linkedDouble.toArrayList();
		assertEquals(9.0,list.get(0));
		assertEquals(2.0,list.get(1));
		assertEquals(5.0,list.get(2));
		assertEquals(4.0,list.get(3));
	}
	
	@Test
	public void testIteratorSuccessfulNext() {
		linkedDouble.addToFront(1.1);
		linkedDouble.addToEnd(2.2);
		ListIterator<Double> iterator = linkedDouble.iterator();
		
		assertEquals(true, iterator.hasNext());
		assertEquals(1.1, iterator.next());
		assertEquals(2.0, iterator.next());
		assertEquals(5.0, iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals(2.2, iterator.next());
	}
	
	
	
	@Test
	public void testIteratorSuccessfulPrevious() {
		linkedDouble.addToFront(1.1);
		linkedDouble.addToEnd(2.2);
		ListIterator<Double> iterator = linkedDouble.iterator();
		
		assertEquals(true, iterator.hasNext());
		assertEquals(1.1, iterator.next());
		assertEquals(2.0, iterator.next());
		assertEquals(5.0, iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals(2.2, iterator.next());
		
		assertEquals(true, iterator.hasPrevious());
		assertEquals(2.2, iterator.previous());
		assertEquals(5.0, iterator.previous());
		assertEquals(2.0, iterator.previous());
		assertEquals(1.1, iterator.previous());
	}
	
	//comparatorD   linkedDouble 2.0, 5.0
	
	
	
	private class DoubleComparator implements Comparator<Double>
	{

		@Override
		public int compare(Double arg0, Double arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}
}
