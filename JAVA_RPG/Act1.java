import java.util.*;
import java.io.*;
public class Act1{
	
	/**
	 * The second act of the game, contains more usage of complex Java tools.
	 * 
	 * @return Adventurer the player characters state after exiting act 1
	 * 
	 * @param player the adventurer/player character state before entering act1, from Advent.java
	 * @throws FileNotFoundException in case of errors
	 */
	public static Adventurer act1(Adventurer player)throws FileNotFoundException{
		Scanner console = new Scanner(System.in);
	
		Advent.clearCon();
		Advent.printCenter("After the battle you eagerly join up with the rest of the lucky few who managed to best their opponents.");
		Advent.printCenter("You are quickly ran threw a system of pipes overhead that spray down warm water to bathe off the blood.");
		Advent.printCenter("You are then given to your Comparde for training.");
		Advent.cont(console);
		Advent.clearCon();
		Advent.printCenter("You're Comparde is led by a man named Boko Uno.");
		Advent.printCenter("The first weeks are a series of increasingly bizzare training exercises.");
		Advent.printCenter("Your first serious dilemma occurs on the 2nd week of training.");
		Advent.cont(console);
		Advent.clearCon();
		Advent.printCenter("Your bunkmate and cousin, Carlos has started to become very ill.");
		Advent.printCenter("He vomits and your whole room is punished for his inability to participate in runs and weapon training.");
		Advent.cont(console);
		Advent.clearCon();
		
		Option sick = new Option("You and your bunkmates confer about what to do about Carlos. As his blood you have final call.", "root", "NA");
		Option diagnose = new Option("You decide to try and find out what ails Carlos.", "check", "Try to diagnose him.");
		Option getHelp = new Option("You decide to take Carlos to the medicinal hut.", "check", "Take him to a doctor, this may be expensive.");
		Option doNothing = new Option("You decide to let Chance decide what happens next, you will do nothing.", "leave","There is nothing more we can do.");
		Option killHim = new Option("You decide to end his life, whether out of mercy or spite is unknown.", "leave", "We must destroy the weak to make the whole stronger, kill him in his sleep");
		
		Option ptdiagnose = new Option("Obvious Carlos has wet-lung, which can be treated hastely with bloodletting.", "NA", "You are able to diagnose him successfully. (INT pass)");
		Option ftdiagnose = new Option("You try to deduce the cause without any fruitful conclusions.","NA","You are unable to diagnose him (INT fail)");
		
		
		
		Advent.printCenter("You will now be taken to act 1 map, this is still a work in progress");
		
		
		Map level1= new Map("Rupor Village");
		level1.createConnections();
		
		
		//added shop to node 14 for testing, will initate some of my option logic but fails in some respects, found going N->W->N
		
		Option shop = new Option("You enter a shop", "root","NA" );
		Option outlaw = new Option("I recogonize your face, grown a bit but still ugly all the same. Best have loads of coin to shop here", "check", "Looks like he recognizes you");
		Option ptest = new Option("I guess people can change, alright I'll not gouge you for all your chips, son","NA", "Try to convince him he's mistaken(CHR)");
		Option ftest = new Option("Ha! You best remember your place loser! Leave me.", "leave", "leave");
		Option newface = new Option("Nice to see a new face, what can I do for you?", "NA", "Say hello to shopkeeper!");
		Option shophere = new Option("Please look at my goods!", "shop", "Open shop");
		Option shopherefail = new Option("The shopkeeper looks visible upset.", "shop", "Open shop");
		List<Items> firstshop = new LinkedList<Items>();
		firstshop.add( new Hatchet());
		firstshop.add( new GuardArmor());
		firstshop.add( new Bow());
		shop.local = new Shopkeeper("Bob", "A stall which sells weaver goods", firstshop);
		//returns to shop if you pass test as outlaw
		ptest.add(shophere,player.isOutlaw);
		//will only add 1 depending on prereqs
		shop.add(outlaw, player.isOutlaw);
		shop.add(newface, !player.isOutlaw);
		//will only add 2 depending on prereqs
		if(player.stats[1]< 10){
			outlaw.add(ftest, player.isOutlaw);
		}
		else if(player.stats[1]>= 10){
			outlaw.add(shopherefail, player.stats[1] >= 10); //should raise prices but need to implement
		}
		else{ 
			outlaw.add(ptest, player.stats[1] > 14);
		}
		//you are allowed to shop as a newface
		newface.add(shophere,true);
		
		Room temp = level1.rooms.get(14);
		temp.options.add("Enter shop");
		temp.options2.add(shop);
		
		Room start = level1.rooms.get(21);
		
		level1.runMap(player,start);
		 
		printCenter("");
		
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
			printCenter(player.getHP());
			printCenter("Please select a combat action.");
			space(3);
			int pdmg = pweapon.damage(player.stats) + pweapon2.damage(player.stats);
			int gdmg = gweapon.damage(player.stats) + gweapon2.damage(player.stats);
			int gdef = garmor.defense;
			int pdef = parmor.defense;
			
			String[] options = {"Attack with your " + pweapon.name,"Brace yourself for the next attack",};
			String[] options2 = {"Attack with your " + pweapon.name,"Brace yourself for the next attack","See Stats"};
			
			int d = choose(options2, console);
			int a= 0;
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


			if(a==1){ //attack
				clearCon();
				int dodged = 0;
				
				pdmg -= gdef;
				
				if(pdmg<0){ //if defense>attack dmg=0
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
				
				if(guy.HP[0]/10>=7){ //Display enemy health to player
					
					printCenter("The enemy is unwavering.");
					
				}
				if(guy.HP[0]/10<7 && guy.HP[0]/10>4 ){ //Display enemy health to player
					
					printCenter("The enemy is beginning to faulter.");
					
				}
				if(guy.HP[0]/10<=4 && guy.HP[0]/10>=2 ){ //Display enemy health to player
					
					printCenter("The enemy is limping.");
					
				}
				if(guy.HP[0]/10 <=1){ //Display enemy health to player
					
					printCenter("The enemy looks totally beaten and bloody.");
					
				}
				cont(console);
				clearCon();
				
			}
			if(a==2){ //defense
				clearCon();
				pdef += rand.nextInt(6)+1;
				printCenter("You have defended increasing defense significantly.");
				space(5);
				cont(console);
				clearCon();
			}
			
			printCenter("The enemy prepares to attack.");
			cont(console);
			clearCon();
			// enemy turn
			//skip if dead
			if(guy.HP[0]<0){
				return;
			}
			int logic = rand.nextInt(51)+ rand.nextInt(51) - (guy.HP[1]-guy.HP[0])/5;
			if(logic>=25){ //attack
				int dodged = 0;
				gdmg -= pdef;
					
				if(gdmg<0){ //if defense>attack dmg=0
					gdmg = 0;
				}
				// dodge
				for(int i=0; i<parmor.dodgeDice; i++){
						
					int b = rand.nextInt(6)+1;
					dodged += b;
				}
				if(dodged >= 10){
					gdmg = 0;
					printCenter("While the enemy attacked, you performed an incredible maneuver.");
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
				if(logic<25){ //defend
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
	public static int choose(String[] options,Scanner console){ 
		
		int choice = 0;
		Exception iae = new IllegalArgumentException();
		int n = options.length;
		do{
			System.out.println("Please choose an option below:\n");
			try{
			for(int i=1; i<=n;i++){
			
			System.out.println("("+i+")- " + options[i-1]); //prints out the number and corresponding option
			System.out.println("");
			}
			choice = Integer.parseInt(console.nextLine());
		}catch (Exception e){
			clearCon();
			System.out.println("Improper imput. Please enter the number of a valid option.");
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
		int yesno2 = choose( yesno1, console);  //1 = yes, 2 = no
		
		clearCon();
		return yesno2;
	}
}

