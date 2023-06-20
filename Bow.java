import java.util.*;
public class Bow extends Weapons{
	
	public void Bow(){
		
		this.name= "Short Bow";
		this.desc= "An arced piece of wood with a hair string, it gets the job done.";
		this.value= 75;
		this.handsUsed=2;
	}
	
	
	protected int damage(int[] stats){
		Random rand = new Random();
		int output = 0;
		
		int dice1 = rand.nextInt(6)+1;
		
		if(dice1>=4){
		output+= stats[0]/6+1;  //strength scaling
		output += stats[3]/2+1; //agility scaling
		output += dice1;
		}else{ output+= 3*dice1;
		}
		
		return output;
	}
	
	protected int defence(int[] stats){
		return stats[3]/6;
	}
	
}
