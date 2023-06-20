//author is Chance Haley
import java.util.*;
import java.io.*;
public class Advent{
	/**
	 * The introduction sequence where you will create your character.
	 * 
	 * @return Adventurer this will be the character you create through your decisions
	 */
	public static Adventurer intro(){
		Scanner console = new Scanner(System.in);
		
		printCenter("--------------------------------------------------");
		printCenter("");
		printCenter("");
		printCenter("Before Earth");
		printCenter("");
		printCenter("");
		printCenter("--------------------------------------------------");
		cont(console);
		clearCon();
		
		printCenter("Sixty-six million years ago.");
		printCenter("Somewhere in the Gulf of Mexico...");
		cont(console);
		clearCon();
		
		
		printCenter("You awaken from a violent dream of a distant future.");
		printCenter("You are a member of the Bula Bula tribe.");
		cont(console);
		clearCon();
		
		printCenter("For centuries your people have thrived in the Drywoods");
		printCenter("around the center of the island.");
		printCenter("Bula Bula is the ruling tribe of the federation:");
		printCenter("An enormous mighty empire that spans most of the island.");
		cont(console);
		clearCon();
		
		printCenter("Now your people are engulfed in a civil war.");
		printCenter("Fueled by decades of jealousness,");
		printCenter("the Comms(short for Common people) have rallied behind");
		printCenter("a new clan chief with distant claim to the throne.");
		cont(console);
		clearCon();
		
		printCenter("They demand equal treatment and representation within the tribal Counsel.");
		printCenter("For years, neglect and greed have led to widespread corruption within");
		printCenter("the vast federation.");
		printCenter("With most Comms already at a natural disadvantage,");
		printCenter("they are feeling the full effects of the tribal corruption.");
		cont(console);
		clearCon();
		
		printCenter("It is up to you to decide the fate of the island.");
		printCenter("Do you have what it takes?");
		cont(console);
		clearCon();
		
		//placeholder character creation
		String booyah= "";
		Items[] base2 = new Items[1];
		String[] base1 = new String[5];
		int[] base= {10,10,10,10,5}; // base stats //tbc
		Adventurer player = new Adventurer( booyah, "Unknown", base2, base, base1);
		
		printCenter("First, what is your name? (name will appear exactly as entered)");
		space();
		
		int n=0;
		while(n !=1){
			System.out.print("My name is..."); //choosing name
			player.name= console.nextLine();
			clearCon();
			printCenter("Your name is " + player.name + "?");
			space();
			n = yesno(console);
			if(n==2){
				printCenter("Forgotten your own name? Try again...");
				space();
			}
			
		}	
		
		clearCon();
		printCenter("Oh, a legendary name for such a low-life.");
		cont(console);
		clearCon();
		printCenter("");
		
		printCenter("Now tell me, " + player.name + " were you born gifted?"); //choosing race
		space();
		int a = yesno(console);
		clearCon();
		if(a==1){
			player.stats[4] += 5;
			player.race= "Gifted Human";
			printCenter("You are a rare individual.");
		}
		if(a==2){ 
			player.race= "Common Human";
			printCenter("You are among the many.");
		}
		cont(console);
		clearCon();
		
		printCenter("There are several stories on the island, interwebbed like the energy that connects us.");
		printCenter("Your upbringing is not unimportant and confers more than just physical or mental strength.");
		printCenter("Now, tell me, who were your parents?"); //choosing starting cond.
		space(5);
		printCenter("note: by default you will be given 5 points to allocate and 10/10/10/10 stats");
		String[] family = {"Orphan - (-1) All skills, (+15) Max HP\n",
						"Farmers - (+2) Strength, (+2) Agility\n",
						"Hunters - (+3) Strength, (+1) Intelligence, (+1) Agility, (-2) Charisma\n",
						"Weavers - (+1) All skills, (-10) Max HP\n",
						"Scribes - (-3) Strength, (+5) intelligence, (+1) Agility\n",
						"Outlaws - (+2) All skills, (+50) chips, (-10) Max HP"};
		int aa = choose(family,console);
		clearCon();
		if(aa==1){
			printCenter("You grew up without the love of parents.");
			printCenter("The tribe raised you, but no one could love you.");
			printCenter("You've learned to endure more than most.");
			player.stats[0] -= 1;
			player.stats[1] -= 1;
			player.stats[2] -= 1;
			player.stats[3] -= 1;
			player.HP[1]+=15;
			player.HP[0]+=15;
		}
		if(aa==2){
			printCenter("Your parent were farmers.");
			printCenter("They grew delicious awa to sustain the tribe.");
			printCenter("They are unremarkable to many, but special to few.");
			printCenter("You've worked your body well for the trials ahead...");
			player.stats[0] += 2;
			player.stats[3] += 2;
		}
		if(aa==3){
			printCenter("Your parents were mighty hunters for the tribe.");
			printCenter("They brought back many delicious meals for the tribe.");
			printCenter("The best things they brought to you was love and devotion.");
			printCenter("You spent much of your childhood isolated from the the other children.");
			printCenter("You are well prepared for the trails ahead...");
			player.stats[0] += 3;
			player.stats[1] -= 2;
			player.stats[2] += 1;
			player.stats[3] += 1;
		}
		if(aa==4){
			printCenter("Your parents were skilled weavers of many useful items.");
			printCenter("They can turn most branches into many fibers and then transform those.");
			printCenter("You have had to work most of your childhood and are well rounded.");
			player.stats[0] += 1;
			player.stats[1] += 1;
			player.stats[2] += 1;
			player.stats[3] += 1;
			player.HP[1]-=10;
			player.HP[0]-=10;
		}
		if(aa==5){
			printCenter("You were lucky enough to be born to a scribe.");
			printCenter("They hope their genetics have run into you.");
			printCenter("You spent much of your childhood reading and learning about various minucia.");
			player.stats[0] -= 3;
			player.stats[2] += 5;
			player.isScribe = true;
		}
		if(aa==6){
			printCenter("Your parents(if you ever knew them) were outlaws.");
			printCenter("Whether they raided with the Chicawa pirate,");
			printCenter("or held up caravans of goods.");
			printCenter("It makes no difference, you are extremely travelled for your age and equally wise.");
			printCenter("You are left with a debilitating injury from living a rough life.");
			player.stats[0] += 2;
			player.stats[1] += 2;
			player.stats[2] += 2;
			player.stats[3] += 2;
			player.HP[1]-=10;
			player.HP[0]-=10;
			player.money = 50;
			player.isOutlaw = true;
		}
		//need to add functionality for choices here, moving along for now. //done! 12/3/22
		// 0=strength, 1=Charisma, 2=Intelligence 3= Agility
		cont(console);
		clearCon();
		printCenter("Regardless, what you were before no longer matters.");
		printCenter("Like many others, you were asked to join the militias.");
		printCenter("Reluctantly or not, you had to agree.");
		printCenter("If that wasn't bad enough, like every other");
		printCenter("\"Water Waster\" you were placed into a caparde.");
		printCenter("You now walk among the living dead.");
		cont(console);
		clearCon();
		
		printCenter("");
		printCenter("*You will now finish creating your character.*");
		printCenter("Through your choices so far, these are your stats:");
		space(2);
		System.out.print(player.getStats1());
		cont(console);
		clearCon();
		
		printCenter("Please spend all your available points to continue.");
		
		do{ //level up system
			player.lvlup(player.stats);
		}while(player.stats[4]>0);
		
		printCenter("It's a cold wet morning.");
		printCenter("You are standing in a puddle waiting.");
		printCenter("\"Next!\"");
		printCenter("You hear it like ticking clock, faint but steady.");
		cont(console);
		clearCon();
		
		printCenter("In this life, nothing is free.");
		printCenter("\"Next!\"");
		space(1);
		printCenter("Every recruit is given 50 chips.");
		player.money+=50;
		printCenter("Even with 1000 chips you would be unprepared.");
		printCenter("The Ruai herd you like shepards, hovering with");
		printCenter("the largest shields and strongest spears.");
		printCenter("You aren't given the privilege of losing them in battle.");
		cont(console);
		clearCon();
		
		printCenter("\"Next!\"");
		cont(console);
		clearCon();
		
		printCenter("First you must prove yourself through duel with only a hatchet.");
		printCenter("Two enter as Water Wasters.");
		printCenter("One leaves as Yunta.");
		printCenter("That is the way of the warrior.");
		printCenter("The way of the island.");
		printCenter("\"Next!\"");
		printCenter("");
		cont(console);
		clearCon();
		
		Items[] bad = new Items[3]; //setting up first battle equipment
		Hatchet hatchet = new Hatchet();
		Armor armor = new Armor();
		Weapons empty = new Weapons();
		bad[0]= hatchet;
		bad[1]= empty;
		bad[2]= armor;
		player.loadout= bad;
		Characters enemy1 = new Characters( "A Desperate Man" , 1 ,bad,20); //first encounter
		
		battle(player,enemy1); //battle 1
		
		
		return player;
	}
	/**
	 * Places you into a battle with another character.
	 * 
	 * @param player the player's adventurer
	 * @param guy the enemy character
	 */
	public static void battle(Adventurer player, Characters guy){
		Scanner console = new Scanner(System.in);
		Random rand = new Random();
		Weapons pweapon = (Weapons) player.loadout[0];
		Weapons pweapon2 =(Weapons) player.loadout[1];
		Weapons gweapon = (Weapons) guy.loadout[0];
		Weapons gweapon2 = (Weapons) guy.loadout[1];
		Armor parmor = (Armor) player.loadout[2];
		Armor garmor = (Armor) guy.loadout[2];
		int intiDodge= parmor.dodgeDice;
		int intiDodge2= garmor.dodgeDice;
		
		printCenter("You have entered battle with: " + guy.name);
		cont(console);
		
		do{
			System.out.print(player.getHP());
			printCenter("Please select a combat action.");
			space(3);
			int pdmg = pweapon.damage(player.stats) + pweapon2.damage(player.stats);
			int gdmg = gweapon.damage(player.stats) + gweapon2.damage(player.stats);
			int gdef = garmor.defense;
			int pdef = parmor.defense;
			
			String[] options = {"Attack with your " + pweapon.name,"Brace yourself for the next attack",};
			String[] options2 = {"Attack with your " + pweapon.name,"Brace yourself for the next attack","See stats"};
			
			int d = choose(options2, console);
			int a= 0;
			
			// allow player to see stats at beginning of turn, may add loadout later
			
			if(d==3){
				System.out.print(player.getStats()); //prints player stats
				space(1);
				cont(console);
				clearCon();
				a = choose(options,console);
			}
			if(d==1){
				a=1;
			}
			if(d==2){
				a=2;
			}

			//attack
			if(a==1){
				clearCon();
				int dodged = 0;
				
				pdmg -= gdef;
				
				//if defense>attack dmg=0
				if(pdmg<0){ 
					pdmg = 0;
				}
				// dodge
				for(int i=0; i<garmor.dodgeDice; i++){
					
					int b = rand.nextInt(6)+1;
					dodged += b;
				}
				if(dodged >= 10){
					pdmg = 0;
					printCenter("While you were attacking the enemy performed an incredible maneuver.");
				}else{
					printCenter("You land an average attack.");
				}
				guy.HP[0] -= pdmg; 	//reduce enemy hp by dmg
				
				//reset dodge and defense bonuses of enemy after turn
				garmor.dodgeDice = intiDodge2;
				gdef = garmor.defense;
				
				printCenter("You attacked for: " + Integer.toString(pdmg) + " damage."); //Displays dmg done by player
				space(2);
				
				
				//Display enemy health to player
				
				
				if(guy.HP[0]/10>=7){ 
					
					printCenter("The enemy is unwavering.");
					
				}
				if(guy.HP[0]/10<7 && guy.HP[0]/10>4 ){ 
					
					printCenter("The enemy is beginning to faulter.");
					
				}
				if(guy.HP[0]/10<=4 && guy.HP[0]/10>=2 ){
					
					printCenter("The enemy is limping.");
					
				}
				if(guy.HP[0]/10 <=1){ 
					
					printCenter("The enemy looks totally beaten and bloody.");
					
				}
				cont(console);
				clearCon();
				
			}
			//defense
			if(a==2){
				clearCon();
				pdef += rand.nextInt(6)+1;
				printCenter("You have defended increasing defense significantly.");
				space(5);
				cont(console);
				clearCon();
			}
			
			printCenter("The enemy prepares to attack.");
			if(guy.HP[0]<0){
				 printCenter("But he falls down convulsing and his mouth fills with foam.");
				 printCenter("You feel the pity inside you shrink as you turn to the guards.");
				 printCenter("Next!");
			 }
			cont(console);
			clearCon();
			// enemy turn
			//skip if dead
			if(guy.HP[0]<0){
				return;
			}
			int logic = rand.nextInt(11);
			
			//attack
			if(logic>=5){
				int dodged = 0;
				gdmg -= pdef;
					
				//if defense>attack dmg=0
				if(gdmg<0){ 
					gdmg = 0;
				}
				
				// dodge
				for(int i=0; i<parmor.dodgeDice; i++){
						
					int b = rand.nextInt(6)+1;
					dodged += b;
				}
				if(dodged >= 10){
					gdmg = 0;
					printCenter("While the enemy attacked you performed an incredible maneuver.");
				}else{
					printCenter("The enemy's strike lands true.");
				}
				player.HP[0] -= gdmg; 	//reduce enemy hp by dmg
					
				printCenter("You were attacked for: " + Integer.toString(gdmg) + " damage."); //states dmg
				cont(console);
				clearCon();
					
				//reset dodge and bonuses after turn
				parmor.dodgeDice = intiDodge;
				pdef = parmor.defense;
				}
				//defend
				if(logic<5){
					gdef += rand.nextInt(6)+1;
					printCenter("They are studying your movement and anticipating your next attack");
					cont(console);
					clearCon();
				}
				if(player.HP[0]<=0){
					printCenter("You died in a manner suitable to your name: horribly.");
					space(3);
					printCenter("GAME OVER");
					cont(console);
					clearCon();
					return;
				}
		}while(guy.HP[0]>0);
		
		
		
	}
	//legacy code
	/*
	public static int rollDice(){ //doesn't work when called twice within same method, generates same dice--dont use
		Random rand = new Random();
		int c = rand.nextInt(7)+1;
		return c;
	}
	* */
	/**
	 * Clears the console of all text.
	 *
	 */
	public static void clearCon(){  //assumes 50 line tall console
		for(int i=0; i<=50;i++){
			System.out.println("");
		}
	}
	/**
	 * This is create 15 empty lines on the console to help you space out text.
	 */
	public static void space(){
		for(int i=0; i<=15;i++){
			System.out.println("");
		}
		
	}
	/**
	 * Creates empty lines to print onto the console.
	 * 
	 * @param lines the amount of blank lines you wish to print to the console.
	 */
	public static void space(int lines){
		for(int i=0; i<=lines;i++){
			System.out.println("");
		}
		
	}
	/** Prints your string to the center of the console
	 * 
	 * @param words The String of words you wish to print on the center of the console
	 * 			do not use String of characters greater than 100
	*/
	public static void printCenter(String words){ //assumes a 100 character wide console
		
		int x = words.length();
		int y = (100-x);
		int z= y/2;
		
		for(int i=z; i>0; i--){
			System.out.print(" ");
		}
			System.out.print(words);
		for(int i=z; i>0; i--){
			System.out.print(" ");
		}
		System.out.println("");
		
	}
	/**
	 * Pauses the game to allow the player to read text, then continues.
	 * 
	 * @param scan the user's keyboard inputs
	 */
	public static void cont(Scanner scan){
		
		for(int i=0; i<=15;i++){
		System.out.println("");
	}
		System.out.println("Enter any key to continue...");
		String next = scan.nextLine();
		
	}
	/**
	 * Prints out a series of choices and allows the user to pick a number corresponding to an option
	 * 
	 * @return int an integer that represents the choice of the user
	 * 
	 * @param options the String[] of options that you wish the user to choose from
	 * @param console the user's keyboard inputs
	 */
	public static int choose( String[] options,Scanner console){ // n is number of options
		
		int choice = 0;
		Exception iae = new IllegalArgumentException();
		int n = options.length;
		do{
			System.out.println("Please choose an option below:\n");
			try{
			for(int i=1; i<=n;i++){
			
			System.out.println("("+i+") -" + options[i-1]); //prints out the number and corresponding option
			System.out.println("");
			}
			choice = Integer.parseInt(console.nextLine());
		}catch (Exception e){
			clearCon();
			System.out.println("Please enter the number of a valid option.");
			space(2);
		}
		
		}while(choice<1||choice>n);
		
		return choice;
	
	}
	/**
	 * Asks the user to enter either one for yes, or two for no
	 * 
	 * @return int an integer that represents the choice of the user
	 * 
	 * @param console the user's keyboard inputs
	 */
	public static int yesno(Scanner console){
		
		String[] yesno1 = {"Yes.", "No."};
		int yesno2 = choose(yesno1, console);  //1 = yes, 2 = no
		
		clearCon();
		return yesno2;
	}
}


