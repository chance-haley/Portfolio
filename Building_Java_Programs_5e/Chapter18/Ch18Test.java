import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.*;
import java.lang.*;
/**
 * JUnit Tests for Chapter 18
 */

public class Ch18Test {
	
HashIntSet test, test2, test3, nulltest, nulltest2, key1;
PriorityQueue<Integer> tester, tester2, nulltester, nulltester2, key2, key3;

	/**
	 * Reset the base data structures just in case
	 */
	@BeforeEach 
	void reset(){
		
		test = new HashIntSet();
		test2 = new HashIntSet();
		test3 = new HashIntSet();
		nulltest = new HashIntSet();
		nulltest2 = new HashIntSet();
		key1 = new HashIntSet();
		
		tester = new PriorityQueue<Integer>();
		tester2 = new PriorityQueue<Integer>();
		nulltester = new PriorityQueue<Integer>();
		nulltester2 = new PriorityQueue<Integer>();
		key2 = new PriorityQueue<Integer>();
		key3 = new PriorityQueue<Integer>();
		
		for(int i = 0; i<=25; i= i+5){
			test.add(i);
			test2.add(i);
			tester.add(i);
			key2.add(i);
			key2.add(i);
		}
		for(int i=0; i<=10; i++){
			tester2.add(i);
			test3.add(i);
			key3.add(i);
			key3.add(i);
		}
		
		key1.add(0);
		key1.add(5);
		key1.add(10);
		
		return;
	}
	/**
	 * replaces every value in the Priority Queue with two occurences of that value.
	 * 
	 * @Example an input of [0,1,2,3] will be turned into [0,0,1,1,2,2,3,3].
	 * 
	 * @param queue the priority queue you wish to change
	 */
	public static void stutter(PriorityQueue<Integer> queue){
		Queue<Integer> aux = new LinkedList<Integer>();
		int size = queue.size();
		
		if(queue.isEmpty()) return;
		
		for(int i=0; i<size; i++){
			int temp = queue.remove();
			aux.add(temp);
			aux.add(temp);
		}
		
		while(!aux.isEmpty()){
			queue.add(aux.remove());
		}
		
	}
	/**
	 * Checks if the queue contains a sequence of consecutive integers starting from the front of the queue
	 * 
	 * @Example an input of [0,1,2,3] will return true
	 * @Example an input of [4,6,7,9] will return false
	 * 
	 * @param queue the priority queue you are interested in
	 * @return true if the queue contains a sequence of consecutive integers, false otherwise
	 */
	public static boolean isConsecutive(PriorityQueue<Integer> queue){
		Queue<Integer> aux = new LinkedList<Integer>();
		int var = 0;
		boolean output = true; 
		boolean first = true;
		int size = queue.size();
		
		if(queue.isEmpty()) return true;
		
		for( int i = 0; i<size; i++){
			
			if(!first){
				
				int var2 = queue.remove();
				aux.add(var2);
				var++;
				if(var2 != var){
					output = false;
				}
				//System.out.println("var2 = " + var2 + " var = " + var); used for testing
			}else{
				var = queue.remove(); //should equal largest number in queue
				aux.add(var);
				first=false;
			}
		}
		for( int i = 0; i<size; i++){
			queue.add(aux.remove());
		}
		return output;
	}
	/**
	 * An empty JUnit test case
	 */
	@Test 
	public void testExample(){
		assertTrue(true);
	}
	@Test
	public void testEquals(){
	
		assertEquals(test,test2);
		assertFalse(test.equals(test3));
		assertFalse(test.equals(nulltest));
		assertEquals(nulltest,nulltest2);
	}
	@Test
	public void testIsConsecutive(){
		
		assertFalse(isConsecutive(tester));
		assertTrue(isConsecutive(tester2));
		assertTrue(isConsecutive(nulltester));
		
	}
	@Test
	public void testRetainAll(){
		
		test.retainAll(test3);
		assertEquals(key1,test);
		
		test2.retainAll(nulltest);
		assertEquals(nulltest2,test2);
		
		nulltest.retainAll(test);
		assertEquals(nulltest2,nulltest);
	}
	@Test
	public void testStutter(){
		
		stutter(tester);
		assertEquals(key2,tester);
		
		stutter(tester2);
		assertEquals(key3,tester2);
		
		stutter(nulltester);
		assertEquals(nulltester2,nulltester);
		
	}
}
