import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.*;
import java.lang.*;
/**
 * JUnit Tests for Chapter 14
 */
@SuppressWarnings("deprecation")
public class Ch14Test {
	/**
	 * Base Stacks and Queues
	 */
	static Queue<Integer> emptyQueue, singleQueue, palindrome, notPalindrome;
	static Stack<Integer> emptyStack, singleStack, sortedStack, notSortedStack, 
						equalStack, minStack, minRemovedStack, minRemovedStack2;
	/**
	 * Reset the base data structures just in case
	 */
	@BeforeEach 
	void reset(){
		emptyQueue = new LinkedList<Integer>();
		singleQueue = new LinkedList<Integer>(List.of(1));
		palindrome = new LinkedList<Integer>(List.of(3, 8, 17, 9, 17, 8, 3));
		notPalindrome = new LinkedList<Integer>(List.of(3, 17, 9, 4, 17, 3));
		
		emptyStack = new Stack<Integer>();
		singleStack = new Stack<Integer>();singleStack.push(1);
		sortedStack = new Stack<Integer>();
		equalStack = new Stack<Integer>();
		notSortedStack = new Stack<Integer>();notSortedStack.push(1);
		List<Integer> sortedList = List.of(20, 20, 17, 11, 8, 8, 3, 2);
		for(int i: sortedList){
			sortedStack.push(i);notSortedStack.push(i);equalStack.push(i);
		}
		
		List<Integer> minList = List.of(2, 8, 3, 19, 2, 3, 2, 7, 12, -8, 4);
		minStack = new Stack<Integer>();
		minRemovedStack = new Stack<Integer>();
		minRemovedStack2 = new Stack<Integer>();
		for(int i: minList){
			minStack.push(i);minRemovedStack.push(i);minRemovedStack2.push(i);
			if(i == -8){
				minRemovedStack.pop();
				minRemovedStack2.pop();
			} else if(i == 2){
				minRemovedStack2.pop();
			}
		}		
		return;
	}
	
	/**
	 * Tests 14.5 equals
	 */
	@Test 
	public void testEquals(){
		assertTrue(equals(sortedStack, equalStack), "sorted == equal");
		assertFalse(equals(sortedStack, minStack), "sorted != min");
		assertEquals(sortedStack, equalStack, "sorted == equal again, ensure nothing changed");//ensure sorted is "unchanged"
		assertFalse(equals(emptyStack, singleStack), "empty != single");
		assertFalse(equals(null, emptyStack), "null != single");
		assertTrue(equals(null,null), "null == null");
	}
	
	/**
	 * Tests 14.8 isPalindrome
	 */
	@Test 
	public void testIsPalindrome(){
		assertTrue(isPalindrome(emptyQueue), "empty is palindrom");
		assertTrue(isPalindrome(palindrome), "palindrome is palindrom");
		assertTrue(isPalindrome(palindrome), "palindrome is palindrom again");//ensure palindrome is "unchanged"
		assertNotEquals(emptyQueue, palindrome, "empty != palindrome");
		assertTrue(isPalindrome(singleQueue), "single is palindrome");
		assertFalse(isPalindrome(notPalindrome), "not palindrome is not palindrome");
		assertThrows(IllegalArgumentException.class, ()->{isPalindrome(null);}, "null is invalid input");
	}
	
	/**
	 * Tests 14.15 isSorted
	 */
	@Test 
	public void testIsSorted(){
		assertTrue(isSorted(sortedStack), "sorted is sorted");
		assertEquals(sortedStack, equalStack, "sorted should not have been changed");//ensure sortedStack is "unchanged"
		assertFalse(isSorted(notSortedStack), "not sorted is not sorted");
		assertTrue(isSorted(emptyStack),"empty is sorted");
		assertTrue(isSorted(singleStack), "single is sorted");
		assertThrows(IllegalArgumentException.class, ()->{isSorted(null);}, "null is invalid input");
	}
	
	/**
	 * Tests 14.19 removeMin
	 */
	@Test 
	public void testRemoveMin(){
		assertEquals(-8, removeMin(minStack), "should have removed -8");
		assertEquals(minStack, minRemovedStack, "min == minRemoved");
		assertEquals(2, removeMin(minStack), "should have removed 2");
		assertEquals(minStack, minRemovedStack2, "min == minRemoved2");
		assertThrows(IllegalArgumentException.class, ()->{removeMin(null);}, "null is invalid input");
		assertThrows(IllegalArgumentException.class, ()->{removeMin(emptyStack);}, "empty is invalid input");
	}

	/**
	 * Checks if two stacks of Integers have the same sequence of Integers.
	 * 
	 * You can use one stack as auxillary storage. Both stacks should look 
	 * as they did before the method was called.
	 * 
	 * @param s1 The first stack
	 * @param s2 The second stack
	 * @return true if the stacks have the same sequence
	 */
	public static boolean equals(Stack<Integer> s1, Stack<Integer> s2){
		if(s1==null && s2==null) return true;
		
		if(s1==null || s2==null|| s1.size()!=s2.size()) return false; //if not same size return false
		
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		int flag = 0;
		
		while( !s1.isEmpty()){
		list1.add(s1.pop());
		}
		
		while( !s2.isEmpty()){
		list2.add(s2.pop());
		}
		System.out.println(list1);
		System.out.println(list2);
		if(list1.equals(list2)) flag =1;
		
		for(Integer num: list1){
			s1.push(num);
		}
		for(Integer num: list2){
			s2.push(num);
		}
		if(flag==1) return true;
		return false;
	}
	
	/**
	 * Checks if a queue of Integers has the same sequence forwards and backwards.
	 * 
	 * Use one stack as auxilary storage. The queue needs to look as 
	 * it did prior to this function call after it returns.
	 * 
	 * @param q The candidate palindrome
	 * @return true if the queue is a palindrome
	 * @throws IllegalArgumentException if the queue is null
	 */
	public static boolean isPalindrome(Queue<Integer> q){
		if(q==null) throw new IllegalArgumentException("Please enter a valid queue");
		Stack<Integer> stack = new Stack<>();
		int size= q.size();
		int[] nums = new int[size];
		int flag = 0;
		for(int i=0; i< size;i++){ //adding each elements from queue to stack and rebuilding queue
			Integer temp= q.remove();
			stack.push(temp);
			nums[i] = temp;
		}
		for(int i= 0; i<size;i++){ //rebuilding queue in proper order
			q.add(nums[i]);
		}
		for(int i=0; i<size/2;i++){ //comparing num[] to Stack
			
			if(nums[i] != stack.pop()) return false; 
		}
		
		return true;
	}
	/**
	 * Checks if a stack of Integers is sorted
	 * 
	 * Use one queue or stack, but not both, as auxilary storage. 
	 * The stack needs to look as it did prior to this function call after it returns.
	 * 
	 * @param s The candidate sorted stack
	 * @return true if the stack is sorted
	 * @throws IllegalArgumentException if the stack is null
	 */
	public static boolean isSorted(Stack<Integer> s){
		if(s==null) throw new IllegalArgumentException("Please enter a valid stack");
		int size = s.size();
		Stack<Integer> q = new Stack<>();
		List<Integer> check1 = new ArrayList<>(); 
		List<Integer> check2 = new ArrayList<>(); 
		
		for(int i =0; i<size;i++){
			Integer temp = s.pop();
			q.push(temp);
			check1.add(temp);
		}
		for(int i = 0; i<size;i++){
			s.push(q.pop());
		}
		check2.addAll(check1);
		Collections.sort(check2);
		if(check1.equals(check2)) return true;
		
		return false;
	}
	
	/**
	 * Removes the minimum value from a stack.
	 * 
	 * Use one queue as auxilary storage. 
	 * The stack needs to maintain relative ordering sans min(s).
	 * 
	 * @param s The stack to have elements removed
	 * @return the smallest element in the stack
	 * @throws IllegalArgumentException if the stack is null or empty
	 */
	public static int removeMin(Stack<Integer> s){
		if(s==null || s.isEmpty()) throw new IllegalArgumentException("Please enter a valid stack");
		int initsize = s.size();
		int newsize = s.size()-1;
		int flag = 0;
		int min = Integer.MAX_VALUE;
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=0; i< initsize; i++){ //traverse stack and find min, then rebuild
			int temp = s.pop();
			if(temp<min){
				min= temp;
			}
			q.add(temp);
		}
		for(int i=0; i< initsize; i++){
			int temp = q.remove();
			if(temp!=min){ //move all elements except min to auxillary storage
				s.add(temp);
			} 
		}
		System.out.println(s);
		newsize = s.size();
		int[] temp = new int[s.size()];
		
		for(int i=0; i<newsize;i++){ //move into auxillary array to swap order back to original
			temp[i] = s.pop();
		}
		System.out.println(Arrays.toString(temp));
		for(int i=0; i<newsize;i++){
			s.push(temp[i]);
		}
		System.out.println(s);
		
		return min;
	}
}
