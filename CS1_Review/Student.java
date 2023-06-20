/**
 * Representation of a Student
 * 
 * A student has a name, current year, and array of grades. Once a student 
 * has been created, it should not be changed hence the lack of setX methods.
 */
 import java.util.*;
public class Student implements Comparable<Student>{
	private String givenName, familyName;
	private int year;
	private String[] grades;
	
	
	//constructor needs to remove void keyword to work properly
	public Student(String givenName, String familyName, int year, String[] grades){
		if(givenName == null){ 
			givenName= "";
		}
		if(familyName == null){ 
			familyName= "";
		}
		if(year<0) year=0;
		if(grades == null) grades = new String[0];
		
		this.givenName = givenName.toLowerCase(); //change the given to lower or upper case.
		this.familyName = familyName.toUpperCase();
		this.year = year;
		this.grades = grades;
	}
	//need no-args constructor
	public Student(){
		String[] baseGrade = {"0","0"};
		this.givenName = "";
		this.familyName = "";
		this.year = 0;
		this.grades = baseGrade;
		
		
		
	}
	
	public String getGiven(){  //changing to give you a different variable so you can't change it.
		String gName = this.givenName;
		
		return gName;
	}
	
	public String getFamily(){
		String fName = this.familyName;
		
		return fName;
	}
	
	public int getYear(){
		return this.year;
	}
	
	public String[] getGrades(){
		
		return Arrays.copyOf(this.grades,this.grades.length);
	}
	
	public double average(){
		double total = 0.0;
		for(String grade:grades){
			total += Integer.parseInt(grade);
		}
		return total/grades.length;
	}
	
	public String toString(){
		String padding = (this.year < 10) ? " " : "";
		return this.familyName + ", " + this.givenName + "\n" +
				"Year: " + padding + this.year + "\t" + 
				"Average: " + String.format("%.2f",this.average());
	}
	
	public int compareTo(Student other){
		return this.familyName.compareTo(other.getFamily());
	}
}
