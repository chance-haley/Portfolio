import java.util.*;
import java.io.*;
public class AdvancedChar{
//elements, modifers, attributes, traits(perks), proficiencies and combos
	Traits traits;
	Attributes[] attributes;
	Perks perks;
	int stamina;
//constructor
	public AdvancedChar(){

	//creating attributes for new character/NPC
	Attributes strength = new Attributes(0,5,false);
	Attributes charisma = new Attributes(1,5,false);
	Attributes intelligence = new Attributes(2,5,false);
	Attributes agility = new Attributes(3,5,false);
	Attributes avail = new Attributes(4,5,true);

	}


	//getters


	public String getAttr(){
		Scanner console = new Scanner(System.in);
		int[] stats1= Arrays.copyOf(stats,stats.length); // prevents user tampering

		if(stats[4]>0){ 								// can level up once you gain points and check stats
			String[] options = {"Level up!","Continue to see stats"};

				int a = Advent.choose(options,console);

				if(a==1){
					lvlup(stats);
				}
				Advent.clearCon();
		}

		return getName1() + "\t|" + "Chips: " + money + "|\t|" + getLoadout() + "|" + "\n" + getHP()
				+ "\n\tStrength: " + stats1[0] + "\t\t*This stat makes you feel powerful.*"
				+ "\n\tCharisma: " + stats1[1] + "\t\t*This stat somehow makes you feel more charming... strange.*"
				+ "\n\tIntelligence: " + stats1[2] + "\t*This stat makes you feel insightful.*"
				+ "\n\tAgility: " + stats1[3] + "\t\t*This stat makes you feel more spider-like.*"
				+ "\n\tAvailable Points: " + stats1[4] + "\t*Stat points available to spend*";
		}
}