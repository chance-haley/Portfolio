import java.util.NoSuchElementException;
/**
 * Class LinkedIntList can be used to store a list of integers.
 */

public class LinkedIntList {
	private ListNode front;  // first value in the list

	/** constructs an empty list */
	public LinkedIntList() {
		front = null;
	}
	
	/** 
	 * @return the current number of elements in the list 
	 */
	public int size() {
		int count = 0;
		ListNode current = front;
		while (current != null) {
			current = current.getNext();
			count++;
		}
		return count;
	}

	/**
	 * Give the element at an index
	 * @param index assumes 0 &lt;= index &lt; size()
	 * @return the integer at the given index in the list 
	 * @throws IllegalArgumentException if index is not valid
	 */
	public int get(int index) {
		if(index < 0 || index >= size()){
			throw new IllegalArgumentException();
		}
		return nodeAt(index).getData();
	}

	/**
	 * Create a logical representation of the list
	 * 
	 * @return a comma-separated, bracketed version of the list
	 */
	public String toString() {
		if (front == null) {
			return "[]";
		} else {
			String result = "[" + front.getData();
			ListNode current = front.getNext();
			while (current != null) {
				System.out.println(current.getData());
				result += ", " + current.getData();
				current = current.getNext();
			}
			result += "]";
			return result;
		}
	}
	
	/**
	 * Search the list for a value.
	 * 
	 * @param value the value to find
	 * @return the position of the first occurrence of the given value (-1 if not found)
	 */
	public int indexOf(int value) {
		int index = 0;
		ListNode current = front;
		while (current !=  null) {
			if (current.getData() == value) {
				return index;
			}
			index++;
			current = current.getNext();
		}
		return -1;
	}

	/** 
	 * Appends the given value to the end of the list
	 * @param value the value to be added
	 */
	public void add(int value) {
		if (front == null) {
			front = new ListNode(value);
		} else {
			ListNode current = front;
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(new ListNode(value));
		}
	}

	/**
	 * Inserts the given value at the given index
	 * assumes 0 &lt;= index &lt;= size()
	 * @param index the index to insert at
	 * @param value the value to insert
	 * @throws IllegalArgumentException if index is not valid
	 */
	public void add(int index, int value) {
		if(index < 0 || index > size()){
			throw new IllegalArgumentException();
		}
		if (index == 0) {
			front = new ListNode(value, front);
		} else {
			ListNode current = nodeAt(index - 1);
			current.setNext(new ListNode(value, current.getNext()));
		}
	}

	/**
	 * Removes value at the given index
	 * 
	 * @param index the index to remove assuming 0 &lt;= index &lt; size()
	 * @throws IllegalArgumentException if index is not valid
	 */
	public void remove(int index) {
		if(index < 0 || index >= size()){
			throw new IllegalArgumentException();
		}
		if (index == 0) {
			front = front.getNext();
		} else {
			ListNode current = nodeAt(index - 1);
			current.setNext(current.getNext().getNext());
		}
	}
	/**
	 * This method will add a ListNode to front of the LinkedList 
	 * 
	 * @param value the element that you wish to add to the front of the LinkedList.
	 * */
	public void push(int value){
		ListNode current = front;
		
		ListNode temp = new ListNode(value,current);
		
		front = temp;
		
	}
	/**
	 * This method will return the nest element of the list and remove it from the Array Stack.
	 * 
	 * @return the element that is next in the linkedList.
	 * */
	public int pop(){
		if(front ==null) throw new NoSuchElementException();
		ListNode current = front;
		
		int data = front.getData();
		
		front = front.getNext();
		return data;
	}
	/**
	 * This method will double the size of my LinkedList by replacing every integer in the list with two of that integer.
	 * 
	 * Example: an inputted list with the values [0,1,2,3] will become [0,0,1,1,2,2,3,3].
	 * */
	public void stutter(){
		
		int size = size();
		for(int i =0; i<size*2; i=i+2){
				
			add(i, get(i));
		}
	}
	/**
	 * Will compare two LinkedIntLists and return true if they are equal in size and order of elements.
	 * 
	 * @param list the list which you are seeking to compare.
	 * @return true if they are functionally equivalent, otherwise return false
	 */
	public boolean equals(LinkedIntList list){
		if(list ==null) throw new IllegalArgumentException("Invalid list");
		if(list.size() != size()) return false;
		for(int i = size()-1; i>=0;i--){
			
			int list1 = get(i);
			int list2 = list.get(i);
			if(list1 != list2) return false;
		}
		
		
		return true;
	}
	/**
	 * This method will double the size of my LinkedList by appending a copy of the original sequence to the back of the list.
	 * 
	 * Example: an inputted list with the values [0,1,2,3] will become [0,1,2,3,0,1,2,3].
	 * */
	public void doubleList(){
		if(front ==null) throw new NoSuchElementException();
		ListNode current = front; //reference to original list
		ListNode copy = new ListNode(front.getData());  //reference to new list
		ListNode copyfront = copy; //holds reference for beginning of new list
		
		
		while(current.getNext() !=null){
			current = current.getNext();
			
			copy.setNext(new ListNode(current.getData()));
			
			copy  = copy.getNext();
		}
		current.setNext(copyfront);
		
		
	}
	// pre : 0 <= i < size()
	// post: returns a reference to the node at the given index
	private ListNode nodeAt(int index) {
		ListNode current = front;
		for (int i = 0; i < index; i++) {
			current = current.getNext();
		}
		return current;
	}

	public static void main(String[]args){
		
		LinkedIntList test = new LinkedIntList();
		
		for(int i=0; i<10;i++){
			test.push(i);
		}
		System.out.println(test);
		
		
		for(int i=0; i<10;i++){
			test.pop();
			System.out.println(test);
		}
	}
	
	public ListNode getFront(){
		
		
		
		return front;
	}
}
