import java.util.*;
public class Ch11{
	
	public static void main(String[]args){
		
		List<Integer> ints1 = new ArrayList<Integer>(List.of(41,43,42,8,8,8));
		List<Integer> ints2 = new ArrayList<Integer>(List.of(-10,69,10,24,25,0,1,8,20,83));
		List<Integer> ints5 = new ArrayList<Integer>(List.of(10,8,12,14,98,42));
		
		Set<Integer> ints3 = new HashSet<Integer>();
		Set<Integer> ints4 = new HashSet<Integer>();
		
		List<Integer> test = alternate(ints1,ints2);
		List<Integer> test2 = alternate(ints2,ints1);
		System.out.println(test);
		System.out.println(test2);
		
		List<Integer> test3= sortAndRemoveDuplicates(ints1);
		List<Integer> test4= sortAndRemoveDuplicates(ints2);
		System.out.println(test3);
		System.out.println(test4);
		
		
		ints3.addAll(ints1);
		ints4.addAll(ints5);
		
		System.out.println(hasOdd(ints3));
		System.out.println(hasOdd(ints4));
		Map<String,String> map1 = new HashMap<String,String>();
		
		//map1.put("Marty","206-9024");
		//map1.put("Newton","123-4567");
		//map1.put("Hawking","123-4577");
		//map1.put("Smith","949-0504");
		System.out.println(map1);
		
		System.out.println(is1to1(map1));
		
	}
	
	public static boolean is1to1( Map<String,String> map1){
		List<String> seeDupes = new ArrayList<String>();
		
		Set<String> compare = new HashSet<String>();
		
		for(Map.Entry<String,String> entry : map1.entrySet()){
			
			//System.out.println(map1.get(entry)); // testing
			//System.out.println(map1.get(entry.getValue())); // returns null for some reason? --> Values do not point to keys
			seeDupes.add(map1.get(entry.getKey())); //returns the value for each key , if I add all them to a list, I should easily see duplicates.
		}
		int listSize = seeDupes.size();
		compare.addAll(seeDupes);
		int setSize = compare.size();
		
		if(listSize==setSize){ //Me + Tutor worked out the logic to find duplicates
			return true;
		}
		
		
			
			return false;
	}
	
	public static boolean hasOdd(Set<Integer> ints1){
		
		if(ints1.isEmpty()){ //check for empty set, not really needed but a good failsafe
			return false;
		}
		
		int k = 0; //counter will increment if any odds are found
		
		for(int num : ints1){
			
			if(num % 2==1){
				k++;
			}
		}
		
		if(k>0){
			return true;
		}
		
		return false;
	}
	
	public static List<Integer> sortAndRemoveDuplicates(List<Integer> ints1){

		Set<Integer> set1 = new HashSet<Integer> ();
		
		set1.addAll(ints1);
		
		List<Integer> output = new ArrayList<Integer>();
		
		output.addAll(set1);
		
		Collections.sort(output);
		
		
		return output;
	}
	
	
	
	public static List<Integer> alternate(List<Integer> ints1,List<Integer> ints2){
		
		int length1 = ints1.size();
		int length2 = ints2.size();
		
		List<Integer> output = new ArrayList<Integer>();
		
		if(length1>length2){ //case 1: list1>list2
			
			int k = 0; //iterator for adding extra elements
			
			for(int i =0; i<length2;i++){
				output.add(ints1.get(i));
				output.add(ints2.get(i));
				k++;
				
			}
			for(int i=k;i<length1;i++){ //adding extra elements
			output.add(ints1.get(i));
			
			}
		}
				// now we recreate this but change the variables for the case: list1<list2
		if(length1<length2){ //case 2: list1<list2
			
			int k = 0; //iterator for adding extra elements
			
			for(int i =0; i<length1;i++){
				output.add(ints1.get(i));
				output.add(ints2.get(i));
				k++;
				
			}
			for(int i=k;i<length2;i++){ //adding extra elements
			output.add(ints2.get(i));
			
			}
				
		}
		// the third case is when list1=list2, just the same idea without adding extra elements
		if(length1==length2){
			for(int i =0; i<length1;i++){
				output.add(ints1.get(i));
				output.add(ints2.get(i));
			}
			
		}
		
		return output;
	}
	
}
