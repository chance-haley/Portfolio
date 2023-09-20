//Author: Chance Haley
import java.util.*;
import java.io.*;
public class Central{

	/**
	 * This acts as my only main that runs all the logic through it. (except testing mains in other classes)
	 *
	 * @throws FileNotFoundException in case of error retrieving rooms.txt.
	 * */
	public static void main(String[]args)throws FileNotFoundException{
		Scanner scan = new Scanner(System.in);

		System.out.print("This game is formatted to be played in fullscreen. \nIt is recommended to maximixe the window in the top right.");
		Act1.space(2);
		Act1.cont(scan);

		//returns your player after intro act
		Adventurer player = Advent.intro();

		//Adventurer nimawak = Act12.act12();


		  /*/tester character
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
*/


		//Starts Map1
		player = Act1.act1(player);
	}
}
