import java.util.*;
import java.io.*;
public class Act12{

public static Adventurer act12()throws FileNotFoundException{
	Scanner console = new Scanner(System.in);
	
	//start of Nimawak storyline
	
	//setting up Nimawak character

		Items[] base2 = new Items[1];
		
		String[] base1 = new String[5];
		int[] base= {12,19,12,13,0}; // base stats
		Adventurer nimawak = new Adventurer( "Nimawak", "Common Human", base2, base, base1);
		
		Items[] bad = new Items[3]; //setting up equipment
		Hatchet hatchet = new Hatchet();
		Armor armor = new Armor();
		Weapons empty = new Weapons();
		bad[0]= hatchet;
		bad[1]= empty;
		bad[2]= armor;
		nimawak.loadout= bad;
	
	Advent.clearCon();
	Advent.printCenter("You awaken from a terrible dream of another on the island.");
	Advent.printCenter("You're name is Nimawak and you are an orphan.");
	Advent.printCenter("You are one of a few non-gifted's that are smart enough to work as a scribe.");
	Advent.printCenter("You grew up before the gifted's were even discovered.");
	Advent.printCenter("A relic of a time when experience was linked to intelligence.");
			Advent.cont(console);
		Advent.clearCon();
		
	Advent.printCenter("You have travelled onto the Great Peninsula and witnessed many beasts and peoples.");
	Advent.printCenter("The water around the island is calm and safe. But venture onto the land beyond the horizon");
	Advent.printCenter("Onto the great big landmass known as the Great Peninsula, you are no longer safe.");
	Advent.printCenter("There are no human villages, instead you are in the territory of wild animals.");
	Advent.printCenter("There is no spear large enough to protect you, instead you must become like a wild animal.");
	Advent.printCenter("Both predator and prey.");
			Advent.cont(console);
		Advent.clearCon();
	Advent.printCenter("You've always adapted well, maybe that's why you are able to inform so many non-gifted's,");
	Advent.printCenter("despite their lower intelligence about complex ideas very simply, to the ire of your collegues.");
	Advent.printCenter("You believe that knowledge is power, and that hoarding it behind complex words is not beneficial.");
	Advent.printCenter("You have always stepped infront of the scribes and kept the people informed.");
	Advent.printCenter("Even as the tensions rose over the last decade, you still remained steadfast in helping everybody.");
	Advent.printCenter("");
	
			Advent.cont(console);
		Advent.clearCon();
	Advent.printCenter("Renown in the village for your intelligence you are working hard in the library.");
	Advent.printCenter("and you are on the verge of a breakthrough...");
	Advent.printCenter("And not just a way to conserve energy for a long time using chemical reactions.");
	Advent.printCenter("You have discovered that light itself has properties that make it useful.");
	Advent.printCenter("Over the last decade your people have developed glass as a means to focus light from far away objects.");
	Advent.printCenter("Using glass you can collect light and see far away objects, this works especially well at night");
	Advent.printCenter("when there is little blue in the sky from the sun.");
	Advent.printCenter("This has been known for atleast a decade, and we can clearly now see celestial objects.");
	Advent.printCenter("What is hidden from public view is that we ourselves can create light just like a sun.");
	Advent.printCenter("And when we do so, it is so powerful and energentic that it destroys islands.");
			Advent.cont(console);
		Advent.clearCon();
	Advent.printCenter("The scribes found out about the technology from deap sea survivors who say that it awakened a \"powerful spirit\" that");
	Advent.printCenter("roared and spewed invisible spears into everyone around, killing them slowly and painfully from the inside.");
	Advent.printCenter("Most arrived sick and not one has been nursed into good health, it is all very secretive.");
	
	
	//first choice of new storyline
	
	Advent.printCenter("");
	
	
	return nimawak;
}




}
