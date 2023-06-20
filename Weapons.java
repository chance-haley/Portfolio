import java.util.*;
public class Weapons extends Items{
	//inherits name, type, desc and value
	public int damage;
	
	public int defenseA;
	
	public int handsUsed;
	
	public boolean isSpecial;
	
	//constructor

	
	public Weapons(){
	this.name= "Nothing";
	this.desc= "FYI: It's nothing";
	this.desc1= "Does 0 dmg";	
	this.value=0;
	this.damage=0;
	this.defenseA=0;
	this.handsUsed= 1;
}
	



	protected int damage(int[] stats){
		
		return 0;
	}
	
	protected int defenseA(int[] stats){
		return stats[3]/6;
	}
}


