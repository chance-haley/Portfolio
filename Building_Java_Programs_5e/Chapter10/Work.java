import java.util.*;

public class Work{
	
	public static void main(String[]args){
		
		ArrayList<String> text = new ArrayList<>();
		
		text.add("Hello");
		text.add("there,");
		text.add("I'm");
		text.add("Chance.");
		// System.out.println(text); used for testing
		//doubleList(text);
		
		
		ArrayList<Integer> list = new ArrayList<>();
		list.add(19); list.add(12); list.add(193); list.add(73); list.add(2); list.add(42); list.add(42);

		System.out.println(list);
		minToFront(list);
		
		System.out.println(list);
		
		stutter(text,4);
		System.out.println(text);
		
		filterRange(list,3,12);
		System.out.println(list);
		
	}
	
	public static ArrayList<Integer> filterRange(ArrayList<Integer> numbers, int min, int max){
		if(numbers.isEmpty()|| numbers.contains(null)){
			throw new IllegalArgumentException("Please enter a valid list.");
		}
		
		ArrayList<Integer> remove = new ArrayList<>(); //create an array of ints to remove
		
		for(int i = min; i<=max;i++){
			remove.add(i);
		}
		
		numbers.removeAll(remove);
		
		return numbers;
	}
	
	
	
	
	public static ArrayList<String> stutter(ArrayList<String> words, int k){
		if(words.isEmpty()|| words.contains(null)){
			throw new IllegalArgumentException("Please enter a valid list.");
		}
		
		int size = (words.size())*k;
		
		if(k<=0){
			words.clear();
			return words;
		}
		for(int i=0; i<size;i=i+k){
			
			System.out.println(i);
			/* if(i==size){ //makes the last words not index out of bounds // not needed when properly indexed
				i--;
			} */
			String copyThis = words.get(i);
			
			for(int j=1; j<k;j++){
			words.add(i,copyThis);
			}
		}
		
		
		
		
		return words;
	}
	
	public static ArrayList<Integer> minToFront(ArrayList<Integer> list){
		
		if(list.isEmpty()|| list.contains(null)){
			throw new IllegalArgumentException("Please enter a valid list.");
		}
		
		int index = -1;
		Integer min = Integer.MAX_VALUE;
		
		for(int i=0;i<list.size();i++){
			int numb1=list.get(i);
			if(numb1<min){
				index=i; //save index so i can switch later
				min= numb1;
			}
		}
		
		list.remove(min);
		list.add(0,min);
		
		return list;
	}
	
	
	
	public static ArrayList<String> doubleList(ArrayList<String> text){
		
		if(text.isEmpty()|| text.contains(null)){
			throw new IllegalArgumentException("Please enter a valid list.");
		}
		int size = text.size();
		
		for(int i=0; i<size*2; i = i+2){
			
			String addThis = text.get(i);
			text.add(i+1,addThis);
			
		}
		
		//System.out.println(text); used for testing
		
		
		return text;
	}
	
}
