import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.*;
import java.lang.*;
/**
 * JUnit Test class for Searching and Sorting
 */
public class Ch13Test {
	/**
	 * Base lists
	 */
	static List<Integer> sorted, reverse, empty, single; 
	
	/**
	 * Reset the base lists just in case
	 */
	@BeforeEach 
	void reset(){
		sorted = new ArrayList<>(Arrays.asList(9001,9002,9003,9004,9005));
		reverse = new ArrayList<>(Arrays.asList(9005,9004,9003,9002,9001));
		empty = new ArrayList<>();
		single = new ArrayList<>(Arrays.asList(9003));
	}
	
	/**
	 * Tests iterative binary search using sorted list
	 */
	@Test 
	public void testItrBinary() throws IllegalArgumentException{
		assertTrue(itrBinary(sorted, 9003), "contained this value");
		assertFalse(itrBinary(sorted, -1), "did not contain this value");
		assertThrows(IllegalArgumentException.class, ()->{itrBinary(null, 3);}, "null is not a valid parameter");
	}
	
	/**
	 * Tests descending bubble using the base lists
	 */
	@Test 
	public void testDescendBubble() throws IllegalArgumentException{
		assertEquals(empty, descendBubble(empty), "empty list should not break things");
		assertEquals(single, descendBubble(single), "single list should not break things");
		assertEquals(reverse, descendBubble(reverse), "reverse list should still be reversed");
		assertEquals(reverse, descendBubble(sorted), "sorted should not break things");
		assertThrows(IllegalArgumentException.class, ()->{descendBubble(null);}, "null is not a valid parameter");
	}
	
	/**
	 * Tests selectionHi using the base lists
	 */
	@Test 
	public void testSelectionHi() throws IllegalArgumentException{
		assertEquals(empty, selectionHi(empty), "empty list should not break things");
		assertEquals(single, selectionHi(single), "single list should not break things");
		assertEquals(sorted, selectionHi(reverse), "should sort a reversed list");
		assertEquals(sorted, selectionHi(sorted), "sorted list should not break things");
		assertThrows(IllegalArgumentException.class, ()->{selectionHi(null);}, "null is not a valid parameter");
	}
	
	/**
	 * Tests randomQuick using the base lists
	 */
	@Test 
	public void testRandomQuick() throws IllegalArgumentException{
		assertEquals(empty, randomQuick(empty), "empty list should not break things");
		assertEquals(single, randomQuick(single), "single list should not break things");
		assertEquals(sorted, randomQuick(reverse), "should sort a reversed list");
		assertEquals(sorted, randomQuick(sorted), "sorted list should not break things");
		assertThrows(IllegalArgumentException.class, ()->{randomQuick(null);}, "null is not a valid parameter");
	}
	
	/**
	 * An iterative implementation of binary search.
	 * 
	 * Precondition: list must be sorted.
	 * 
	 * @param sorted The list to be searched
	 * @param number The number to find
	 * @return True if the number exists in the list, false otherwise
	 * @throws IllegalArgumentException if the list is null
	 */
	public static boolean itrBinary(List<Integer> nums, int x) throws IllegalArgumentException{ //write correct sorts
		if(nums==null|| nums.contains(null)){
			throw new IllegalArgumentException("Please enter a valid list.");
		}
		int len = nums.size();
		int start, end, mid,flag;
		start = 0;
		end = len;
		flag=0;
		
		while(flag==0){
			mid = (start + end)/2;
			if(nums.get(mid)==x) return true; //need to ensure this runs before I return false
			if(end-start==1) return false;
			if(nums.get(mid)>x){
				start = start; // returns bottom half of array
				end = mid;
			}
			if(nums.get(mid)<x){ //returns top half of array
				start = mid;
				end = end;
			}
		}
		return false;
	}
	
	/**
	 * Sorts a list using bubble sort in descending order rather than ascending order.
	 * 
	 * @param list The list that needs to be sorted.
	 * @return The sorted list
	 * @throws IllegalArgumentException if the list is null
	 */
	public static List<Integer> descendBubble(List<Integer> list) throws IllegalArgumentException{
		if(list==null|| list.contains(null)){
			throw new IllegalArgumentException("Please enter a valid list.");
		}
		int[] nums = new int[list.size()];
		for(int i =0; i<list.size();i++){
			nums[i] = list.get(i);
		}
		for(int i=0; i<nums.length;i++){
			 for(int j= nums.length-1; j>0;j--){
				 if(nums[j]>nums[j-1]){
					 swap(nums, j ,j-1);
				 }
			 }
		 }
		 list.clear();
		 for(int i = 0;i<nums.length-1;i++){
			 list.add(nums[i]);
		 }
		 
		 return list;
	}
	
	/**
	 * Sorts a list by selecting for the highest value each iteration.
	 * 
	 * @param list The list that needs to be sorted.
	 * @return The sorted list
	 * @throws IllegalArgumentException if the list is null
	 */
	public static List<Integer> selectionHi(List<Integer> list) throws IllegalArgumentException{
		if(list==null|| list.contains(null)){
			throw new IllegalArgumentException("Please enter a valid list.");
		}
		int[] nums = new int[list.size()];
		for(int i =0; i<list.size();i++){
			nums[i] = list.get(i);
		}
		for(int i=0; i<nums.length;i++){
			int maxIndex = i;
			for(int j= i; j< nums.length; j++){
				if(nums[j] < nums[maxIndex]){
					maxIndex =j;
				
				}
			}
			swap(nums, i, maxIndex);
		}
		list.clear();
		 for(int i = 0;i<nums.length;i++){
			 list.add(nums[i]);
		 }
		 
		 return list;
	}
	
	/**
	 * Sorts a list using quicksort with a random pivot.
	 * 
	 * @param list The list that needs to be sorted.
	 * @return The sorted list
	 * @throws IllegalArgumentException if the list is null
	 */
	public static List<Integer> randomQuick(List<Integer> list) throws IllegalArgumentException{
		
		
		
		return new ArrayList<Integer>(list);
	}
	
	/**
	 * Swaps two elements in an array.
	 * 
	 * @param array The array you want to edit.
	 * @param i the index of the first element you are swapping
	 * @param j the index of the second element you are swapping
	 * @return The list with the elements swapped
	 * @throws IllegalArgumentException if the list is null
	 */
	 private static void swap(int[] array, int i, int j){
		 int temp = array[i];
		 array[i] = array[j];
		 array[j] = temp;
	 }
}
