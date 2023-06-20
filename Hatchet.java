import java.util.*;
public class Hatchet extends Weapons{

	public Hatchet(){
		this.name="Hatchet";
		this.type = "Weapon";
		this.desc="A worn and dull wooden handled hatchet used by warriors of the island.";
		this.desc1="Rolls 1 dice + Str/3 + Agl/4 total dmg.";
		this.value=40;
		this.handsUsed=1;
	}
		
		
	
	
	
	protected int damage(int[] stats){
		
		Random rand = new Random();
		int output = 0;
		
		for(int i=1; i<=1; i++){ //dice dmg
			
			int a = rand.nextInt(6) +1;
			output += a;
		}
		output+= stats[0]/3;  //strength scaling
		output += stats[3]/4; //agility scaling
		return output;
	}
	
	protected int defence(int[] stats){
		return stats[3]/6;
	}
}
