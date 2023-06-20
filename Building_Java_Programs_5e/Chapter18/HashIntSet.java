import java.util.*;
/**
 * Implements a set of integers using a hash table.
 * The hash table uses separate chaining to resolve collisions.
 * 
 * @see <a href="https://www.buildingjavaprograms.com/code-files/5ed/ch18/HashIntSet.java">original source code</a>
 */
public class HashIntSet {
	private static final double MAX_LOAD_FACTOR = 0.75;
	private HashEntry[] elementData;
	private int size;
	
	/**
	 * Constructs an empty set.
	 */
	public HashIntSet() {
		elementData = new HashEntry[10];
		size = 0;
	}
	/**
	 * checks if two HashIntSets are functionally equal
	 * 
	 * @param other1 the HashIntSet you are comparing too
	 * @return true if the two HashIntSets are functionally equal, false otherwise
	 */
	public boolean equals(Object other1){
		HashIntSet other = (HashIntSet)other1;
		List<Integer> tester = new ArrayList<Integer>();
		List<Integer> tester2 = new ArrayList<Integer>();
		if(size != other.size) return false;
		if (!isEmpty()) {
			
			for (int i = 0; i < elementData.length; i++) {
			
				HashEntry current = elementData[i];
				HashEntry current1 = other.elementData[i];
				while(current != null){
					tester.add(current.data);

					current = current.next;
				}
			}
			for (int i = 0; i < other.elementData.length; i++) {
			
				HashEntry current1 = other.elementData[i];
				while(current1 != null){
					tester2.add(current1.data);

					current1 = current1.next;
				}
			}
			//System.out.println(tester);
			//System.out.println(tester2);
			
			Collections.sort(tester); Collections.sort(tester2);
			return tester.equals(tester2);
		}
		if(other.isEmpty() && isEmpty()) return true;
	return false;
	}
	/**
	 * Checks another HashIntSet and retains all the integers that are contained in both lists.
	 * 
	 * @Example  an original set of [0,2,4] and a parameter set of [0,1,2,3] will transform the original set to [0,2].
	 * 
	 * @param other1 the HashIntSet you will check from
	 */
	public void retainAll(Object other1){
		HashIntSet other = (HashIntSet)other1;
		
		List<Integer> tester2 = new ArrayList<Integer>();
		List<Integer> tester = new ArrayList<Integer>();
		
		if(isEmpty()) return;
		
		for (int i = 0; i < elementData.length; i++) {
			
				HashEntry current = elementData[i];
				HashEntry current1 = other.elementData[i];
				while(current != null){
					tester.add(current.data);

					current = current.next;
				}
			}
			for (int i = 0; i < other.elementData.length; i++) {
			
				HashEntry current1 = other.elementData[i];
				while(current1 != null){
					tester2.add(current1.data);

					current1 = current1.next;
				}
			}
			//System.out.println(tester);
			//System.out.println(tester2);
			for( int element : tester){
				if(!tester2.contains(element)){
					remove(element);
				}
			}
	}
	
	
	/**
	 * Adds the given element to this set, if it was not already
	 * contained in the set.
	 * 
	 * @param value The value to add
	 */
	public void add(int value) {
		if (!contains(value)) {
			if (loadFactor() >= MAX_LOAD_FACTOR) {
				rehash();
			}
			
			// insert new value at front of list
			int bucket = hashFunction(value);
			elementData[bucket] = new HashEntry(value, elementData[bucket]);
			size++;
		}
	}
	
	/**
	 *  Removes all elements from the set.
	 */
	public void clear() {
		for (int i = 0; i < elementData.length; i++) {
			elementData[i] = null;
		}
		size = 0;
	}
	
	/**
	 * Checks if the set contains a value
	 * 
	 * @param value the value in question
	 * @return true if the given value is found in this set
	 */
	public boolean contains(int value) {
		int bucket = hashFunction(value);
		HashEntry current = elementData[bucket];
		while (current != null) {
			if (current.data == value) {
				return true;
			}
			current = current.next;
		}
		return false;
	}
	
	/**
	 * Checks if the set is empty
	 * 
	 * @return true if there are no elements in this queue.
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * Removes the given value if it is contained in the set.
	 * If the set does not contain the value, has no effect.
	 * 
	 * @param value the value in question
	 */
	public void remove(int value) {
		int bucket = hashFunction(value);
		if (elementData[bucket] != null) {
			// check front of list
			if (elementData[bucket].data == value) {
				elementData[bucket] = elementData[bucket].next;
				size--;
			} else {
				// check rest of list
				HashEntry current = elementData[bucket];
				while (current.next != null && current.next.data != value) {
					current = current.next;
				}
				
				// if the element is found, remove it
				if (current.next != null && current.next.data == value) {
					current.next = current.next.next;
					size--;
				}
			}
		}
	}
	
	/**
	 * Gives the set's size
	 * 
	 * @return the number of elements in the queue.
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Create a logical representation of the contents of the set
	 * @return a string representation of this set, such as "[10, 20, 30]". The elements are not guaranteed to be listed in sorted order or the same order for equal Sets.
	 */
	public String toString() {
		String result = "[";
		boolean first = true;
		if (!isEmpty()) {
			for (int i = 0; i < elementData.length; i++) {
				HashEntry current = elementData[i];
				while (current != null) {
					if (!first) {
						result += ", ";
					}
					result += current.data;
					first = false;
					current = current.next;
				}
			}
		}
		return result + "]";
	}
	
	
	// Returns the preferred hash bucket index for the given value.
	private int hashFunction(int value) {
		return Math.abs(value) % elementData.length;
	}
	
	private double loadFactor() {
		return (double) size / elementData.length;
	}
	
	// Resizes the hash table to twice its former size.
	private void rehash() {
		// replace element data array with a larger empty version
		HashEntry[] oldElementData = elementData;
		elementData = new HashEntry[2 * oldElementData.length];
		size = 0;

		// re-add all of the old data into the new array
		for (int i = 0; i < oldElementData.length; i++) {
			HashEntry current = oldElementData[i];
			while (current != null) {
				add(current.data);
				current = current.next;
			}
		}
	}
	
	// Represents a single value in a chain stored in one hash bucket.
	private class HashEntry {
		public int data;
		public HashEntry next;

		public HashEntry(int data) {
			this(data, null);
		}

		public HashEntry(int data, HashEntry next) {
			this.data = data;
			this.next = next;
		}
	}
	
	public static void main(String[]args){
		
		HashIntSet test = new HashIntSet();
		HashIntSet test2 = new HashIntSet();
		HashIntSet test3 = new HashIntSet();
		
		for(int i = 0; i<=25; i= i+5){
			test.add(i);
			test2.add(i);
		}
		for(int i = 0; i<6; i++){
			test3.add(i);
		}
		System.out.println(test);
		System.out.println(test2);
		System.out.println(test3);
		//System.out.println(test.equals(test2));
		//System.out.println(test.equals(test3));
		test.retainAll(test3);
		System.out.println(test);
		
		
	}
}
