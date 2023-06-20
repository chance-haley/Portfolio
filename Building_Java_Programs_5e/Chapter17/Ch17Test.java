import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.*;
import java.lang.*;
/**
 * JUnit Tests for Chapter 17
 */

public class Ch17Test {
BinarySearchTree test,test2,test3,test4,test5, test6, testnull, testnull2;
	/**
	 * Reset the base data structures just in case
	 */
	@BeforeEach 
	void reset(){
		test = new BinarySearchTree();
		test2 = new BinarySearchTree();
		test3 = new BinarySearchTree();
		test4 = new BinarySearchTree();
		test5 = new BinarySearchTree();
		test6 = new BinarySearchTree();
		testnull = new BinarySearchTree();
		testnull2 = new BinarySearchTree();
		
		test.add(25);
		test.add(14);
		test.add(30);
		test.add(35);
		test.add(29);
		test.add(31);
		test.add(42);
		test.add(7);
		test.add(15);
		
		test2.add(80);
		test2.add(60);
		test2.add(65);
		test2.add(64);
		test2.add(92);
		test2.add(89);
		
		test3.add(25);
		test3.add(14);
		test3.add(30);
		test3.add(35);
		test3.add(29);
		test3.add(31);
		test3.add(42);
		test3.add(7);
		test3.add(15);
		test3.add(28);
		
		test4.add(25);
		test4.add(14);
		test4.add(30);
		test4.add(35);
		test4.add(29);
		
		test5.add(25);
		test5.add(14);
		test5.add(30);
		test5.add(35);
		test5.add(29);
		test5.add(31);
		test5.add(42);
		test5.add(7);
		test5.add(15);
		
		test6.add(25);
		test6.add(30);
		test6.add(29);
		test6.add(31);
		test6.add(15);
		
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
	public void testIsFull(){
		assertTrue(test.isFull());
		assertFalse(test2.isFull());
		assertTrue(test4.isFull());
		assertTrue(testnull.isFull());
	}
	@Test
	public void testRemoveLeaves(){
		test3.removeLeaves();
		assertTrue(test3.equals(test4));
	}
	@Test
	public void testEquals(){
		assertTrue(test.equals(test5));
		assertTrue(testnull.equals(testnull2));
		assertFalse(test.equals(42));
		assertFalse(test.equals("42"));
	}
	@Test
	public void testTrim(){
		test.trim(31,15);
		assertTrue(test.equals(test6));
		
	}
}
