import java.util.*;
public class Ch16{
	
	public static void main(String[]args){
		
		LinkedIntList test = new LinkedIntList();
		LinkedIntList test2 = new LinkedIntList();
		for(int i = 0; i<5;i++){
			test.add(i);
			test2.add(i);
		}
		System.out.println(test);
		test.doubleList();
		System.out.println(test);
	}
	
	
	public static LinkedList<Integer> stutter(LinkedList<Integer> list){
		
		int size = list.size();
			for(int i =0; i<size*2; i=i+2){
				
				list.add(i,list.get(i));
			}
		
		return list;
	}
}
