/**
 * Student Directory 
 * 
 * Can create a sorted array of Students given a file and print them.
 */

import java.io.*;
import java.util.*;
public class StudentDirectory{
	
	public static void main(String[]args)throws FileNotFoundException{
		
		ArrayList<Student> dir= buildDirectory("students.txt");
		
		System.out.println(dir);
		
	}
	
	public static ArrayList<Student> buildDirectory(String fileName) throws FileNotFoundException{ // need to move the scanner to initialize outside of try loop. Need to add try loop to prevent FNFE
		if(fileName== null) throw new IllegalArgumentException("file must exist"); //Throw IAE
		File file  = new File(fileName);
		Scanner scan = new Scanner(file);
		
		int len = scan.nextInt();
		//Student[] directory = new Student[len]; //needs to be len-1
		ArrayList<Student> directory = new ArrayList<>();
		for(int i = 0; i < len; i++){ //need to remove <= because len-1
			String givenName = scan.next();
			String familyName = scan.next();
			int year = scan.nextInt();
			String[] grades = scan.nextLine().trim().split(" ");
			directory.add(new Student(givenName, familyName, year, grades));
		}
		//Collections.sort(directory);
		directory.sort(Comparator.reverseOrder());
		return directory;
	}
	
	public static void printDirectory(ArrayList<Student> directory){
		if(directory == null) throw new IllegalArgumentException(); //throw IAE
		for(int i = 0; i < directory.size(); i++){ // need to change i to be 0
			System.out.println(directory.get(i).toString()+"\n");
		}
	}
}
