/**
 * <insert_comment_summary_here>
 * 
 * @author Chance Haley
 */

import java.util.*;

public class Ch05{
	public static void main(String[]args){
		
		
		printFactors(15);
		System.out.println(" ");
		printFactors(24);
		System.out.println(" ");
		
		//threeHeads(1);
		
		System.out.println(" ");
		
		System.out.print(digitSum(29107));
		System.out.println(" ");
		System.out.print(digitSum(-29107));
		System.out.println(" ");
		System.out.print(digitSum(12345));
		System.out.println(" ");
		System.out.print(digitSum(0));
		System.out.println(" ");
		System.out.println(isAllVowels("aeiou"));
		System.out.println(isAllVowels("EeIou"));
		System.out.println(isAllVowels("Yorkie"));
		//System.out.println(isAllVowels("null")); breaks program now, didn't before I added exception.
		//System.out.println(isAllVowels(null));
		
		//Random rand = new Random(); need inside of method
		
	}
	
	public static boolean isAllVowels( String str){
		if(str== null){
			throw new IllegalArgumentException("Please don't do this, try again");
		}
		int y = 0; char a = ' '; int x= str.length();
		//int x= str.length();
		for(int i=x-1; i>=0; i--){
		Character.toLowerCase(str.charAt(i)); //making case insensitive
	}
		//char a = ' ';
			for( int i= x-1; i>=0;i--){
				
				 a = str.charAt(i);
				if( a == 'a' || a== 'e' || a== 'i' || a== 'o' || a== 'u'){
					y +=2;
				}else{
					y +=1;
				}
			}
		if(y%2==0){
			return true;
		}else{
			return false;
		
	}
}
	
	public static int digitSum(int x){
		int y = 0;
		//int y = abs(x); // converting negative values (doesn't work for some reason, have to do it manually)
		if(x>0){
			 y= x;
		}else{ 
			 y= -x;
		}  // should be converted now to all positive
			int a = y/10000;
			
			int b = y/1000 - (10*a);
			
			int c = y/100 -(100*a + 10*b);
			
			int d = y/10 - (1000*a + 100*b + 10*c);
			
			int e = y - (10000*a + 1000*b + 100*c +10*d);
			
			int f = a+b+c+d+e;
			
			return f;
	
		
		
		
	}
	
	
	public static void threeHeads(int w){
		int y = 0;
		
		Random rand = new Random(w);
		
		do{
			int x = rand.nextInt(2); // 0=T 1=H
			if(x==0){
				System.out.print("T ");
				y = 0;
			}
			if(x==1){
				System.out.print("H ");
				y++;
			}
				
			
			
		}while( y<3 );
		
	System.out.println(" ");
	System.out.println("Three heads in a row! That's a 1/8 chance. You're lucky!");
	
}
	
	public static void printFactors(int x){
		
		int y= 1;
		//double z= x%y; doesnt work
		if(x<=0){
			throw new IllegalArgumentException("Must be a positive integer.");
		}
		while(y<x){ // could use (y<2x)? maybe saves processing power
			if(x%y==0){
				System.out.print( y + " and ");
			
					}
					y++;
				}
				System.out.print(x); // fencepost!
		}
		
}
