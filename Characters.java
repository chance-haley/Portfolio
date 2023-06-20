//Author: Chance Haley
import java.util.*;

public class Characters{
	
	public String name;
	public String race;
	public int[] HP; // CurrentHP / MaxHP
	public int dice;
	public Items[] loadout; //1=weapon 2=off-hand 3=armor
	public int[] stats; // 0=strength, 1=Charisma, 2=Intelligence 3= Agility 4= points

	
	
	//variables
	//public static int[] baseHP= {100,100}; //breaks battle if used by the same character
	public static int[] baseStats = {10,10,10,10,10}; 
	
	
	//constructor
	public Characters(){
		
		this.name ="";
		this.race = "Not quite sure.?";
		this.HP= new int[1];
		
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
		this.stats=baseStats;

	}
	
	public String getHP(){
		String cHP = Integer.toString(HP[0]);
		String maxHP = Integer.toString(HP[1]);
		
		return "HP: " + "[" + cHP + "]/[" + maxHP + "]";
	}
	
	
	public int attack(){
		
		return 0;
	}
	
	public int defence(){
		
		return 0;
	}
	public String getName1(){
		
		return "Name: " + name + "\nRace: " + race; //tbc
		
	}
	
	
	
}

