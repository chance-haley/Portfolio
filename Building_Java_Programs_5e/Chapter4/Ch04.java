import java.util.*;
public class Ch04{
	
	public static void main(String[]args){
		
		printRange(19,11);
		printRange(8,8);
		printRange(2,10);
		 
		 Scanner console= new Scanner(System.in);
		 
		 longestName(console,4);
		 
		 System.out.println(wordCount("This should be four!    "));
		 System.out.println(wordCount("This should be like   more than four! but like ten.   "));
		 System.out.println(wordCount("This should be a five!    "));
		 
		 System.out.println(quadrant(0,0));
		 System.out.println(quadrant(0,-1));
		 System.out.println(quadrant(-1,1));
		 System.out.println(quadrant(-1,0));
		 
	}
	
	public static int quadrant(double x, double y){
		
		int output = 0;
		
		if( x>=0 && y>=0){
			output=1;
		}
		if(x<0 && y>=0){
			output=2;
		}
		if(x<0 && y<0){
			output=3;
		}
		if(x>=0 && y<0){
			output=4;
		}
			
		
		return output;
	}
	
	public static void printRange(int x, int y){
		
		if(x<y){
			for( int i=x; i<=y; i++){
				System.out.print(i + " ");
			}
			System.out.println(" ");
		}
		else if (x>y){
			for( int i=x; i>=y; i--){
				System.out.print(i + " ");
			}
			System.out.println(" ");
		}
		else{
			System.out.println(x);
		}	
	}
	public static void longestName(Scanner scan,int x){
		System.out.println("Please enter your names below to find the longest.");
		
		
		String output= "";
		//char a= ""
		for(int i=1; i<=x; i++){
			System.out.print("name #" + i + "? ");
			String str= scan.next();
			if(str.length() > output.length()){
				output = str;
			}
			//output = output.lowercase();
			//output2 = output substring(0,1)
			
		}
		System.out.println("The longest name is " + output + "'s name.");
	}
	
	public static int wordCount(String str){
		
		int output = 0;
		
		if( str.charAt(0) != ' ' ){
			output +=1;
			}
			
		for(int i=0; i< str.length()-1; i++){
			
			if( str.charAt(i) == ' ' && str.charAt(i+1) != ' '){
				output +=1;
				
			}
		}
		return output;	
	}
}
