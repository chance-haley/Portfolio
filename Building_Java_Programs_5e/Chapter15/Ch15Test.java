import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.*;
import java.lang.*;
@SuppressWarnings("unchecked")
/**
 * JUnit Tests for Chapter 15
 */

public class Ch15Test {
	/**
	 * Base ArrayStacks and arrays
	 */
	 static ArrayStack empty, ten, ten2, five;
	 
	/**
	 * Reset the base data structures just in case
	 */
	@BeforeEach 
	void reset(){
		empty = new ArrayStack();
		
		ten = new ArrayStack();
		for(int i=0;i<10;i++){
			ten.push(i);
		}
		
		ten2 = new ArrayStack();
		for(int i=0;i<10;i++){
			ten2.push(i);
		}
		five = new ArrayStack();
		for(int i=0;i<5;i++){
			five.push(i);
		}
		return;
	}
	
	/**
	 * JUnit calls equals(Object), not equals(ArrayStack) in assertEquals
	 */
	@Test 
	public void testExample(){		
		String x = new String("hello");
		Object y = new String("hello");
		assertEquals(x,y);
	}
	@Test
	public void testPeek(){

		Object a = five.peek();
		int b = 4;
		assertEquals(b,a);
		
	}
	@Test
	public void testEquals(){
		
		assertTrue(ten.equals(ten2));
		
		assertFalse(ten.equals(five));
		
	}
	@Test
	public void testClear(){

		five.clear();
		
		assertEquals(five,empty);
		
	}
	@Test
	public void testAddAll(){
		
		Integer[] test = new Integer[5];
		for(int i=5; i<10;i++){
			test[ i-5] = i;
		}
		
		five.addAll(test);
		
		assertEquals(ten,five);
		
	}
	@Test
	public void testPush(){ //will also test realloc
		
		for(int i=5 ; i<10; i++){ // will test push, should be equal to ten
			five.push(i);
		}
		assertEquals(ten,five);
		
		
	}
	@Test
	public void testPop(){
		
		for(int i=9; i>=0;i--){
			assertEquals(i,ten.pop());
			
		}
	}
	@Test
	public void testToString(){
		
		String test1 = "[4, 3, 2, 1, 0]";
		String test2 = "[9, 8, 7, 6, 5, 4, 3, 2, 1, 0]";
		
		assertEquals(test1,five.toString());
		assertEquals(test2,ten.toString());
	}
}
