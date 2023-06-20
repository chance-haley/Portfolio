/**
 * <insert_comment_sumamry_here>
 * 
 * @author Chance Haley
 */
import java.util.*;
import java.io.*;
public class TimeSpan{
	
	private int hours;
	private int minutes;
	
	public TimeSpan(int hours, int minutes){
		this.hours = 0;
		this.minutes = 0;
		add(hours,minutes);
		
		
		/* if(hours<0 || minutes<0){
			throw new IllegalArgumentException("Please enter two positive values");
		}
		
		this.hours = hours + minutes/60;
		this.minutes = minutes % 60; */ // reconstructed this code and made it initialize to 0 and call add.
	}
	public void add(TimeSpan span){
		
		this.hours += hours;
		this.minutes += minutes;
		
		//converts each 60 minutes into one hour
		this.hours += this.minutes/60;
		this.minutes = this.minutes%60;
		
	}
	public void subtract(TimeSpan span){
		
		if(minutes>this.minutes && this.hours>0){
			this.hours--;
			this.minutes += 60;
			this.minutes = this.minutes - minutes;
		}else{ // returns 0 if it would be negative
			this.hours = 0;
			this.minutes = 0;
		}
			
		if(hours>this.hours){ // returns 0 when hrs subtracted are greater than hrs. ie if it would be negative
			this.hours = 0;
			this.minutes = 0;
		}else{
			this.hours = this.hours - hours;
		}
		
	}
	public void scale(int factor){
		
		int c = this.hours * factor;
		int b = this.minutes * factor;
		
		this.hours = c + b/60;
		this.minutes = b%60;
	}
		
	
	public void add(int hours, int minutes){
		
		if(hours<0 || minutes<0){
			throw new IllegalArgumentException("Please enter two positive values");
		}
		this.hours += hours;
		this.minutes += minutes;
		
		//converts each 60 minutes into one hour
		this.hours += this.minutes/60;
		this.minutes = this.minutes%60;
	}
	public String toString() {
		return hours + "h " + minutes + "m";
	}
	
	public static void main(String[]args){
		
		TimeSpan test = new TimeSpan(2,30);
		TimeSpan test1 = new TimeSpan(5,60);
		System.out.println(test.toString());
	}

}
