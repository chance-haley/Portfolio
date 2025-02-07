//Author: Chance Haley
import java.util.*;

public class Characters{

		//basics
	public String name;
	public String race;
	public int[] HP; // CurrentHP / MaxHP
	public Items[] loadout; //1=weapon 2=off-hand 3=armor
	public int age;
	public String titles;

	//constructor
	public Characters(){

		this.name ="";
		this.race = "Not quite sure.?";

	}
	public Characters(String name,int race,Items[] loadout, int hp){

		int[] basehp = {hp,hp};

		this.name =name;
		if(race==1){
			this.race = "Common Human";
		}else{
			this.race= "Gifted Human";
		}
		int[] baseHP= {100,100};
		this.HP= basehp;
		this.loadout=loadout;

	}

	public String getHP(){
		String cHP = Integer.toString(HP[0]);
		String maxHP = Integer.toString(HP[1]);

		return "HP: " + "[" + cHP + "]/[" + maxHP + "]";
	}





}

