//Author: Chance Haley
import java.util.*;
import java.io.*;
public class Central{
	
	/**
	 * This acts as my only main that runs all the logic through it. (except testing mains in other classes)
	 * 
	 * @throws FileNotFoundException in case of error.
	 * */
	public static void main(String[]args)throws FileNotFoundException{
		Scanner scan = new Scanner(System.in);
		
		//returns your player after intro act
		//Adventurer player = Advent.intro();
		
		
		//Adventurer nimawak = Act12.act12();
		//setting up tester character
		String booyah= "Tester";
		Items[] base2 = new Items[1];
		
		String[] base1 = new String[5];
		int[] base= {10,10,10,10,5}; // base stats //tbc
		Adventurer player = new Adventurer( booyah, "Unknown", base2, base, base1);
		
		Items[] bad = new Items[3]; //setting up first battle equipment
		Hatchet hatchet = new Hatchet();
		Armor armor = new Armor();
		Weapons empty = new Weapons();
		bad[0]= hatchet;
		bad[1]= empty;
		bad[2]= armor;
		player.loadout= bad;
		
		//returns your player after act 1
		player = Act1.act1(player);
	}
}
