/**@author Chance  Haley
 */

import java.util.*;
import java.io.*;

public class Ch07{
	public static void main(String[]args){
		
		int[] exampleset = {27,15, 15, 11, 27};  // tester
		int[] exampleset2 = {8, 10, 99, 42, 8, 15, 8, 8, 88}; // tester
		int[] exampleset3 = {8, 27, 15, 15, 11, 27, 8}; // tester
		int[] exampleset4 = {8, 8, 9, 19};
		int[] exampleset5 = {8, 27, 15, 8};
		int[][] exampleset6 = { exampleset4, exampleset5};
		int[][] exampleset7 = { exampleset, exampleset4};
		 
		System.out.println(mode(exampleset));
		System.out.println(mode(exampleset2));
		System.out.println(mode(exampleset3));
		//System.out.println(Arrays.toString(exampleset2));
		System.out.println("1");
		
		System.out.println(median(exampleset));
		System.out.println(median(exampleset2));
		System.out.println(median(exampleset3));
		System.out.println("2");
		
		append(exampleset4, exampleset5);
		append(exampleset5, exampleset4);
		System.out.println("3");
		
		matrixAdd(exampleset6, exampleset6);
		matrixAdd(exampleset6, exampleset7);
		
		//append(exampleset5, exampleset4);
		//append(exampleset5, exampleset4);
		
	}
	
	public static int[][] matrixAdd(int[][] set1, int[][] set2){
		int size = 0;
		
		if(set1.length != set2.length){
		}else{
			throw new IllegalArgumentException("The two matrices must be the same length");
			
			//Exception e = new Exception("The two matrices must be the same length");
			//return e;
		}
		
		for(int i=0; i<=1;i++){
			
			if(set1[i].length > size){
				size = set1[i].length;
			}
			if(set2[i].length > size){
				size = set2[i].length;	
			}
		}
		//recreate(set1,size); // used to fix unequal arrays
		//recreate(set2,size); //
		//System.out.println(size);
		//System.out.println(Arrays.deepToString(set1)); for testing
		//System.out.println(Arrays.deepToString(set2));
		
		int[][] output = new int[2][size];
		
		for(int i = 0; i<size;i++){
			output[0][i]= set1[0][i] + set2[0][i];
		}
		for(int i = 0; i<size; i++){
			output[1][i]= set1[1][i] + set2[1][i];
		}
		
		//System.out.println(Arrays.deepToString(set1));
		//System.out.println("");
		System.out.println(Arrays.deepToString(output));
		return output ;
	}
	 /* public static int[][] recreate(int[][] ary, int newsize){
		
		int[][] finished = new int[2][newsize];
		
		System.out.println(Arrays.deepToString(finished));
		
		for(int i=0; i<ary.length;i++){
			finished[0][i] = ary[0][i];
			finished[1][i] = ary[1][i];
			
		}
		return finished;
	}
	* */
	
	public static int[] append(int[] set1, int[] set2){
		
		int size1 = set1.length;
		int size2 = set2.length;
		int newsize = size1 + size2;
		
		int[] newset = new int[newsize];
		
		for( int i = 0; i< size1; i++){
			newset[i] = set1[i];
		}
		for( int i = 0; i < size2; i++){
			newset[i+size1] = set2[i];
		}
	System.out.println(Arrays.toString(newset)); // testing
	
		return newset;
	}
	
	
	public static int median(int[] median){
		
		Arrays.sort(median);
		int middle = (median.length/2);
		
		System.out.println(middle); // testing
		System.out.println(Arrays.toString(median)); // testing
		
		return median[middle];
	}
	
	
	
	public static int mode(int[] examplemode){
		int mode = 0;
		int mode1 = 0;
		 //int[] set = Arrays.copyOf(examplemode, examplemode.length); unnessesary
		int[] counter = new int[101];
		 
		for( int i=0; i < examplemode.length; i++){
			counter[examplemode[i]]++;
			
		}
		for(int i=0; i < counter.length; i++){
			int count1 = counter[i];
			if( count1> mode1){
				mode1= count1;
				mode= i;
			}
		}
		//System.out.println(Arrays.toString(set)); for testing
		//System.out.println(Arrays.toString(counter)); for testing
		return mode;
	}
}
