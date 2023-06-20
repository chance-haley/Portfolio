import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.*;
import java.lang.*;

/**
 * JUnit Tests for Chapter 16
 */
public class Ch16Test {

static LinkedIntList test,test2,test3, test4, nulltest, nulltest2;
	/**
	 * Reset the base data structures just in case
	 */
	@BeforeEach 
	void reset(){
		nulltest = new LinkedIntList();
		nulltest2 = new LinkedIntList();
		test = new LinkedIntList();
		test2 = new LinkedIntList();
		test3 = new LinkedIntList();
		test4 = new LinkedIntList();
		test3.add(42);
		for(int i = 0; i<5;i++){
			test.add(i);
			test2.add(i);
			test3.add(i);
			test4.add(i);
		}
		for(int i = 0; i<5;i++){
			test4.add(i);
		}
		return;
	}
	
	/**
	 * An empty JUnit test case
	 */
	@Test 
	public void testExample(){		
		assertTrue(true);
	}
	@Test
	public void testStutter(){
		LinkedIntList answer = new LinkedIntList();
		for(int i=0; i<5;i++){ 
		answer.add(i);
		answer.add(i);
	}	
		test.stutter();
		nulltest.stutter();
		
		assertTrue(answer.equals(test));
	}
	@Test
	public void testPush(){
		LinkedIntList answer = new LinkedIntList();
		answer.add(42);
		nulltest.push(42);
		test2.push(42);
		assertTrue(test3.equals(test2));
		assertTrue(answer.equals(nulltest));
	}
	@Test
	public void testPop(){
		for(int i=0; i<5;i++){
			assertEquals(i,test.pop());
		}
		
		assertThrows(NoSuchElementException.class, ()->{nulltest.pop();});
		
	}
	@Test
	public void testDoubleList(){
		
		test.doubleList();
		assertTrue(test4.equals(test));
		assertThrows(NoSuchElementException.class, ()->{nulltest.doubleList();});
		
	}
	@Test
	public void testEquals(){
		
		assertTrue(test.equals(test2));
		assertThrows(IllegalArgumentException.class, ()->{nulltest.equals(null);});
		assertTrue(nulltest.equals(nulltest2));
		assertFalse(test.equals(42));
		assertFalse(test.equals("42"));
	}
}
