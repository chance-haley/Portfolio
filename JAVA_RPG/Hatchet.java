import java.util.*;
public class Hatchet extends Weapons{

	public Hatchet(int quality, int[] durability){
		this.name="Worn hatchet";
		this.type = "Weapon";
		this.weapType = "Axe";
		this.damage = 25+((25/5)*quality);
		this.defenseA=15;
		int[] defRange= {0,1};
		this.range=defRange;
		this.desc="A worn and dull wooden handled hatchet won in the pit.";
		this.desc1="NA";
		this.isSpecial=false;
		this.value=40+(40*quality);
		this.handsUsed=1;
		this.quality=quality;
		this.durability=durability;
		String[] baseAttacks = {"Overhand Strike","Right Slash","Left Slash","Overhead Parry", "Right Torso Parry","Left Torso Parry","Leap Strike","Step Strike"};
		this.attacks=baseAttacks;

		//String modifers;

		//String prereqs;

		Combos combos;

	}




	/* Legacy code, may use for reference later
	 *
	protected int damage(Adventurer player){

		Random rand = new Random();
		int output = 0;

		for(int i=1; i<=1; i++){ //dice dmg

			int a = rand.nextInt(6) +1;
			output += a;
		}

		return output;
	}

	protected int defence(int[] stats){
		return stats[3]/6;
	}
	* */

}
