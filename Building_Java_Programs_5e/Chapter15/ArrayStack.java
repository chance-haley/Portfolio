import java.util.*;
@SuppressWarnings("unchecked")
public class ArrayStack<E>{
	private E[] data;
	private int front,back,size;
	private static final int DEFAULT = 10;
	
	//constructor
	public ArrayStack(){
		data = (E[]) new Object[DEFAULT];
		front = 0;
		back = 0;
		size = 0;
		
	}
	/**
	 * This method will add an element to the Array Stack 
	 * @param E the element that you wish to add to the top of the stack.
	 * */
	public void push(E element){
		size++;
		data[front++] = element;
		
		if(size==data.length){
			realloc(size*2);
		}
	}
	//memory allocation
	
	private void realloc(int newCap){
		E[] temp = (E[])new Object[newCap];
		
		for(int i=0; i<size;i++){
			temp[i] = data[i];
		}
		data = temp;
	}
	//self explanatory
	/**
	 * This method will return whether your Array Stack is has any elements.
	 * @return true if the Array Stack has no elements.
	 * */
	public boolean isEmpty(){
		return size==0;
	}
	//remove element
	/**
	 * This method will return the top element of the stack and remove it from the Array Stack.
	 * @return the element at the top of the Stack.
	 * */
	public E pop(){
		if(isEmpty()){
			throw new NoSuchElementException();
		}
		if(size<data.length/4 && size > DEFAULT * 2){
			realloc(data.length/2);
		}
		size--;
		E element = data[front-1];
		data[front--] = null;
		
		return element;
	}
	//see next element
	/**
	 * This method will return the top element of the stack but, will not remove it from the Array Stack.
	 * @return the element at the top of the Stack.
	 * */
		public E peek(){
		if(isEmpty()){
			return null;
		}
		return data[front-1];
	}
	//print Stack
	/**
	 * This method will allow the Array Stack to be printed overriding/creating it's toString() 
	 * @return a String representation of the Stack.
	 * */
	public String toString(){
		if(isEmpty()){
			return "[]";
		}
		String output = "[";
		for(int i = 0;i< size;i++){
			output += data[(front-i-1)] + ", ";
			
			
		}
		output = output.substring(0, output.length()-2);
		return output + "]";
		
	}
	//reset Stack
	/**
	 * This method will remove all elements from the Stack by creating a new Stack.
	 * */
	public void clear(){
		data = (E[]) new Object[DEFAULT];
		front = 0;
		back = 0;
		size = 0;
		
	}
	/**
	 * This method will add an element Array to the Array Stack 
	 * @param E[] the element array that you wish to add to the top of the stack.
	 * */
	public void addAll(E[] elements){
		if(elements == null) throw new IllegalArgumentException();
		for(E element : elements){
			push(element);
		}
		
	}
	/**
	 * This method will return true if two ArrayStacks are equal in elements and order. 
	 * @param other the Object, in this case another ArrayStack, you wish to compare.
	 * @return true if the Array Stacks are equal in elements and order.
	 * */
	public boolean equals(Object other){ //must use object class
		
		if(other instanceof ArrayStack){
			//return this.size() == ((ArrayStack) other).size() && //compare size and short circuit if wrong size
			return this.toString().equals(other.toString()); //this is such a hack, remember this!
		}
		
		return false;
	}
	
	
	public static void main(String[]args){
		
		ArrayStack as = new ArrayStack();
		System.out.println(as);
		
		for(int i=0; i<=5; i++){
			
		as.push(i);
		}
		System.out.println(as);
		System.out.println(as.peek());
		System.out.println(as.pop());
		System.out.println(as);
		System.out.println(as.peek());
		for(int i=0; i<5;i++){
			as.pop();
		}
		System.out.println(as);
		
		for(int i=0; i<20; i++){
			as.push(i);
		}
		System.out.println(as);
		for(int i=0; i<11; i++){
			as.pop();
		}
		System.out.println(as);
		System.out.println(as.peek());
		System.out.println(as.pop());
		as.clear();
		System.out.println(as);
		ArrayStack as2 = new ArrayStack();
		
		for(int i=0; i<9; i++){
			as2.push(i);
		}
		System.out.println(as2);
		System.out.println(as.equals(as2));
		as2.clear();
		System.out.println(as.equals(as2));
	}
	
}
