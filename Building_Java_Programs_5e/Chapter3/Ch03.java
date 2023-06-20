//@author is Chance Haley
import java.util.Scanner;

public class Ch03{
	
	public static void main(String[]args){
		
		
		Scanner gthang = new Scanner(System.in);
		
		printPowersOfN(3,2);
		
		printPowersOfN(9,2);
		
		printPowersOfN(6,3);
		
		printPowersOfN(10,2);
		
		area(50);
		
		sphereVolume(50);
		
		processName(gthang);
		
		
	}
	
	
			public static void printPowersOfN(int n, int i){
				
				double x= Math.pow(n,i);
				System.out.println(x);
				
				
			}
			
			
			public static void area(double r){
				
				double x= Math.PI * r * r;
				System.out.println(x);
				
			}
		
			public static void sphereVolume(double r){
				
				double x= (4.0/3.0)* Math.PI * (r * r * r);
				System.out.println(x);
				
			}
			
			public static void processName(Scanner console){
				
		
				
				System.out.println("Please enter your full name (first/last):");
		
				String input = console.next();
				String input2= console.next();
				System.out.println(" ");
				
				
				System.out.print("Hello there " + input + " " + input2 + "! I'm your doppleganger! My name is "); // having some fun
				//String x= input.endsWith(" ");
				
				//String y= input.startsWith(" ");
				
				System.out.println( input2 + ", " + input + ".");
					
				}
				
				/*
				public static void savingsTable(){
					
					
					
					
				}
				
				public static double round2(double n){
					
					return Math.round(n *100.0) / 100.0;
				}
				
				public static double interest(){ // formula for interest: amount= principal( 1 + annual rate as decimal)^n years
					
					
					
				*/	
					
		} 
				
		
			
				
				
		
		

	
	
