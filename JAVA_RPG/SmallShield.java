import java.util.*;
public class SmallShield extends Weapons{
	
	
	public void SmallShield(){
		this.name= "Small Shield";
		this.desc= "A relatively puny shield";
		this.value=25;
		this.handsUsed=1;
		
		
	}
	protected int damage(){
		
		return 0;
	}
	
	protected int defence(int[] stats){
		int output=0;
		output += stats[0]/5;
		output += stats[3]/6;
		return output;
		
	}
	
	
}
