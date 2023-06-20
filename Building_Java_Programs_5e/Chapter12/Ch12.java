import java.util.*;
public class Ch12{
	
	public static void main(String[]args){
		
		int testnum = 12345;
		System.out.println(sumTo(2));
		
		
		System.out.println(doubleDigits(testnum));
		System.out.println("");
		System.out.println(permut(2,2));
		System.out.println(permut(3,1));
		System.out.println(permut(5,2));
		System.out.println(permut(5,3));
		System.out.println(permut(5,5));
		
		List<String> names = new ArrayList<String>(List.of("Chance","Buddy","Haley","Cole"));
		
		//subsets(names);
	}
	
	public static void subsets(List<String> names){ //not completed :(
		int length = names.size();
		if(length==0){
			System.out.println(names); //ending condition for recursive loop
			return;
		}
		
		if(length==1){// next easiest case 
			System.out.println(names);
			names.remove(length-1); // removing last element from list
		}
		
		helper2(names);
		names.remove(length-1);
		subsets(names); //enter again with last element removed until size is 1
		
	}
	
	private static void helper2(List<String> names){ // I will use this helper method to print all the variations of a list
		
		List<String> copy = new ArrayList<String>(names); // copy of list
		
		int length = names.size(); //need to pass this into another method to use tail recursion
		
		
	
	}
	
	private static void helper2(List<String> names, int len){
		//len = i in a forloop
		
		if(len<0) return; //end my tail recursion
		
		List<String> show = new ArrayList<String>(names);
		
		show.remove(len); //removing different elements, not sure how this will function recursively
		
		System.out.println(show); //print out new list
		
		helper2(names,len-1); // loops with len - 1 
	}
	
	
	/**
	 * This method will return the number of unique permutation of r items from a group of n items.
	 * This can be represented by: number of permutations = n!/(n-r)! 
	 * 
	 * Example: a input (5,3) will return 60 or 5!/2!.
	 * @param n the number of total objects or items you want to mix.
	 * @param r the number of item in each group you want to create. This should be smaller than n.
	 * @return the number of unique possibilities to mix the items into smaller groups.
	 * */
	public static int permut(int n, int r){
		int output = 0;
		int top =n;
		int bottom = (n-r);
		
		if(r>n){
			throw new IllegalArgumentException("r should be a smaller value than n");
		}
		
		if(r==0){ //mathematically true shortcut
			return 1;
		}
		if(r==1){ //mathematically true shortcut
			return n;
		}
		
		output = (factorial(top))/factorial(bottom);
		
		
		return output;
	}
	
	private static int factorial(int number){
		
		if(number == 0){ //exits recursive function
			return 1;
		}
		int number1 = number-1; //number -1
		return number*factorial(number1);
		
	}
	
	/**
	 * This method will sum the first n reciprocals .
	 * 
	 * Example: 2 withh return 1.5
	 * @param n the number of reciprocals in descending order.
	 * @return a float that is the sum of all the reciprocals.
	 * */
	public static float sumTo(int n){
		
		if(n<0){
			throw new IllegalArgumentException("Only enter positive integers please.");
		}
		
		if(n==0){
			return 0;
		}
		
		float output = 1/(float)n;
		
		n--;
		
		
		
		return output + sumTo(n);
	}
	
	
	/**
	 * returns an integer with every value repeated twice in the same order.
	 * 
	 * Example: 12345 will return 1122334455
	 * @param n the integer in question.
	 * @return n but with every value repeated twice in the same order.
	 * */
	public static int doubleDigits(int n){
		int output = 0;
		boolean isNeg = false; //checking negative for adding sign later
		if(n<0){
			isNeg = true;
			n = Math.abs(n);
		}
		String numbs = Integer.toString(n); //converting int to string
		String output1 = helper(numbs); //running method to return string w/ each value repeated in same order
		output = Integer.parseInt(output1);
		
		if(isNeg==true){
			output = 0 - output; // turning result negative
		}

		return output  ; // completed thank you 2nd method!
	}
	
	private static String helper(String numbers){
		String numbers2 = "";
		int length = numbers.length();
		char add = ' ';
		
		
		
		if(length<=0||numbers.equals("")){
			return "";
		}
		if(length>0){ // runs if a number exists
			add = numbers.charAt(length-1); //finds numbers at end of index in character format
			
			for(int i=0;i<length-1;i++){ //rebuilding number without the last number
				numbers2 += numbers.charAt(i);
			}
			numbers=numbers2;
		}
		
		//System.out.println(numbers);
		return helper(numbers) +add +add  ; //will add the last number twice when complete will return string will each value doubled
		
		
	}
	
	
}
