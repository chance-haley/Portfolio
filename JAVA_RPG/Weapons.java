import java.util.*;
public class Weapons extends Items{
	//inherits name, type, desc and value
	int damage;
	String weapType;
	int defenseA;
	String modifers;
	int handsUsed;
	int[] range;
	boolean isSpecial;
	String prereqs;
	Combos combos;
	String[] attacks;
	int quality; //allows 0-2, 3 options for:| 0  poor | 1  average | 2  well-made |
	int[] durability;

	//constructor


	public Weapons(){
	this.name= "Nothing";
	this.type= "Weapon";
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


