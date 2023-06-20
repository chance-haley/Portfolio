/**
 * @author Chance Haley
 */

import java.util.*;
import java.io.*;

public class Ch06{
	public static void main(String[]args)throws FileNotFoundException{
		
		File coins = new File("coins.txt");
		File words = new File("words.txt");
		File duplicates = new File("duplicates.txt");
		File jwock = new File("Jabberwock.txt");
		
		Scanner input = new Scanner(coins);
		Scanner input2 = new Scanner(words);
		Scanner input3 = new Scanner(duplicates);
		Scanner input5 = new Scanner(jwock);
		
		countCoins(input);
		System.out.println("");
		wordWrap(input2);
		System.out.println("");
		System.out.println("");
		printDuplicates(input3);
		System.out.println("");
		System.out.println("");
		inputStats(input5);
		
	}
	
	public static void wordWrap(Scanner input2){
		int y = 0;
		while( input2.hasNext() ){
			
			String word = input2.next()+ " ";  // <== help from Charles
			
			int wordlength= word.length();
				if(y>=60){
					System.out.println("");
					y=0;
				}
			y+= wordlength;
			// y += 1; // added for extra spaces after each word // with help from Charles in class was able to add spaces to my strings instead.
				
				if( y>=60){
					
					
					int x = word.length() -(y - 60); // gives how many characters over the word is
					String halfword1 = word.substring(0,x); // string we need before /n
					String halfword2 = word.substring(x, wordlength); // string we need after /n
					System.out.print(halfword1);
					/* while( halfword2.length()>=1 & halfword2.charAt(0)== ' '){
						halfword2 = halfword2.substring(1,1);
					} */
					System.out.println("");
					y=0;
					System.out.print(halfword2);
					y+= halfword2.length() ;
					word = input2.next()+ " "; // moving cursor
					wordlength= word.length();
					y+= wordlength;
				}
			//y += 1; // added for extra spaces after each word // needs to happen before the y>60 check <== wrong
			System.out.print(word);
			//System.out.print(y + " "); for testing
		}
	}
	
	public static void printDuplicates(Scanner input3) throws FileNotFoundException{
		
		//while(input3.hasNextLine()){
			//String line = input3.nextLine();
			//line = line.trim()
			
		
		
		File duplicates2 = new File("duplicates.txt");
		//try {
		Scanner input4 = new Scanner(duplicates2);
		/* }catch(FileNotFoundException fnfe){
			System.err.println("File must exist. Please enter correct file path.");
			return;
		} */
		
		
		int y = 0;
		while(input4.hasNextLine()){
			String line1 = input4.nextLine();
			String line = line1.trim(); // doesn't fix problem
			int z = line.length();
			//System.out.println(z); testing
			
			
		
		int x = 1;
		String word2 = "";
		while(input3.hasNext()){
			String word1 = word2;
			word2 = input3.next();
			y += word2.length();
			while(word1.equals(word2) & input3.hasNext() ){
				x++;
				word1 = word2;
				word2 = input3.next();
				y += word2.length();
				if(input3.hasNext()){
				}else{
				x++;
				}
			}
			
			if(x>1){
				System.out.print(word1 + "*" + x + " ");
				x=1;
			}
			if(y>=z-7){
			System.out.println("");
			line = input4.nextLine();
			z = line.length();
			y=0;
			
				}
			}	
		}
	}

	public static void inputStats(Scanner input5)throws FileNotFoundException{
	
	File jwok2 = new File("Jabberwock.txt");
	Scanner input6 = new Scanner(jwok2);
	
	String biggestline = "";
	int biggestlength = 0;
	int x=1;
	int y =0;
		while(input6.hasNextLine()){
			String line = input6.nextLine();
			int length = line.length();
			StringTokenizer linelength = new StringTokenizer(line);
			int tokens = linelength.countTokens();
			if( linelength.hasMoreTokens()){
				String token1 = linelength.nextToken();
				if(token1.length()>y){
					y = token1.length();
				}
				
			}
			
			if( length> biggestlength){
				biggestline = line;
				biggestlength = length;
			}
			//String word = input5.next();
			//int wordlength = word.length();
			
			
			System.out.println("Line " + x + " has " +tokens + " tokens. (Longest = " + y + ")");
			x++;
			
		}
		System.out.println("Longest line: " + biggestline);
	}
	
	public static void countCoins(Scanner input){
		
		double sum = 0.0;
		
		while( input.hasNextInt()){
		
		int x = input.nextInt();
		
		String name = input.next().toLowerCase();
			if(name.equals("pennies")){
				sum += x *.01;
			}
			if(name.equals("nickels")){
				sum += Math.round(x *.05); // Math.round fixes double rounding error, added it into dimes and quarters because why not. Breaks on pennies
			}
			if(name.equals("dimes")){
				sum += Math.round(x *.1);
			}
			if(name.equals("quarters")){
				sum += Math.round(x *.25);
			}
		}
		System.out.println("Total moolah baby: $" + sum);
	}
}
