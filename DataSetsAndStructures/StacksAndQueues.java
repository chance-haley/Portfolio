import java.util.*;
public class StacksAndQueues{
	
	public static void main(String[]args){
	
	
		Stack<Integer> stack = new Stack<>(); //tend to reverse order
		Queue<Integer> queue = new LinkedList<>(); //tend to preserve order
		for(int i = 0; i<10;i++){
			stack.push(i);
			queue.add(i);
		}
		System.out.println(stack);
		for(int i = 0; i<5;i++){
			System.out.println(stack.pop());
			System.out.println(queue.remove());
		}
		
		System.out.println(stack);
		System.out.println(queue);
		printStack(stack);
		System.out.println(stack);
		printQueue(queue);
		System.out.println(queue);
	}
	
	public static void printStack(Stack<Integer> stack){
		Stack<Integer> copy = new Stack<>();
		
		while(!stack.isEmpty()){
			Integer temp = stack.pop();
			System.out.println(temp);
			copy.push(temp);
		}
		while(!copy.isEmpty()){
			stack.push(copy.pop());
		}
	}
	public static void printQueue(Queue<Integer> queue){
		Queue<Integer> copy = new LinkedList<>();

		while(!queue.isEmpty()){
			Integer temp = queue.remove();
			System.out.println(temp);
			copy.add(temp);
		}
		while(!copy.isEmpty()){
			queue.add(copy.remove());
		}
		
		
		for(int i =0; i<queue.size();i++){ //2nd way to do this
			System.out.println(queue.peek());
			queue.add(queue.remove());
		}
	}
}
