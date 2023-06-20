import java.util.*;

public class Ch14{
	
	public static void main(String[]args){
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=1;i<5;i++){
			stack1.push(i);
			stack2.push(i);
		}
		stack1.push(-1);
		stack1.push(-8);
		stack1.push(1);
		
	System.out.println(stack1);
	removeMin(stack1);
	
	System.out.println(stack1);
	}
	public static boolean isPalindrome(Queue<Integer> q){
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
		System.out.println(q);
		return true;
	}
	
	public static boolean equals(Stack<Integer> s1, Stack<Integer> s2){
		
		if(s1.size()!=s2.size()) return false; //if not same size return false
		
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
	public static int removeMin(Stack<Integer> s){
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
		//System.out.println(s);
		newsize = s.size();
		int[] temp = new int[s.size()];
		
		for(int i=0; i<newsize;i++){ //move into auxillary array to swap order back to original
			temp[i] = s.pop();
		}
		//System.out.println(Arrays.toString(temp));
		for(int i=0; i<newsize;i++){
			s.push(temp[i]);
		}
		//System.out.println(s);
		
		return min;
	}
	
}
