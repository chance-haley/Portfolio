import java.util.*;
import java.io.*;
public class Adventurer extends Characters //implements Comparable<Adventurer>
	{
//inherits basic ( title, name, race, age, HP, dice, loadout, stats, stamina )
//elements
	//utility
	public int roomIn;
	public boolean onMap;
	public boolean isNPC;
	public boolean alive; //gameover
	//loadout
	public int money;
	List<Items> inventory = new ArrayList<>();
	public int lvl;
	public int exp;
	public int expneeded;
	public int[] stats; // 0=strength, 1=Charisma, 2=Intelligence 3=Agility 4=points
	//advanced
	public AdvancedChar advanced;
	public Attributes attr;
	//player specific
	public Journal journal;

//constructors

	public Adventurer()throws FileNotFoundException{
		this.name = "";
		this.race= "";
		this.loadout = new Items[1];
		this.stats= new int[1];
		this.exp= 0;
		this.journal = new Journal();

	}
	public Adventurer(String name, String race, Items[] loadout, int[] stats,boolean isNPC, Attributes attr)throws FileNotFoundException{
		int[] basehp = {100,100};

		this.name = name;
		this.race = race;
		this.loadout = loadout;
		this.stats = stats; //0=strength, 1=Charisma, 2=Intelligence 3= Agility 4= points
		this.attr=attr;
		this.exp = 0;
		this.HP = basehp;
		this.money = 0;
		this.onMap = true;
		this.alive=true;
			//player specific creation
		if(!isNPC){
			this.journal = new Journal();
		}

	}

		//Character creation/lvlup

	/**
	 * Allows the user to select stats and spend stat points leveling up
	 *
	 * @param init an int[] that contains the initial stats of the player
	 */
	public void lvlup(int[] init){

		int[] copy = Arrays.copyOf(init,init.length); // used to reset char

		int points = init[4];
		Scanner console = new Scanner(System.in);


		do{
			Advent.printCenter(getStats1());
			Advent.space(1);
			Advent.printCenter(" To Spend points please select the stat to level up and the amount(up to 5 at a time)");
			Advent.space(1);

			String[] stat = {"Strength","Charisma","Intelligence","Agility","See Stats"};
			String[] amount = {"1","2","3","4","5"};
			Advent.printCenter("------------------------------------------------------");

			int a = Advent.choose(stat,console);
			Advent.space(10);
			if(a==1){
				Advent.printCenter("Your current Strength is " + stats[0]);
				Advent.printCenter("How much would you like to increase your strength by?(max 20)");
				int b = Advent.choose(amount,console);

				if(b+stats[0] > 20|| b>points){
					Advent.printCenter("This would place you above the 20 point max or spend more points than you have.");
					Advent.printCenter("Please try again");
					Advent.cont(console);
					stats[0] -=b;
					points +=b;
					stats[4]+=b;
				}
				stats[0]+=b;
				points -=b;
				stats[4] -=b;
				}
			if(a==2){
				Advent.printCenter("Your current Charisma is " + stats[1]);
				Advent.printCenter("How much would you like to increase your Charisma by?(max 20)");
				int b = Advent.choose(amount,console);

				if(b+stats[1] > 20|| b>points){
					Advent.printCenter("This would place you above the 20 point max or spend more points than you have.");
					Advent.printCenter("Please try again");
					stats[1] -=b;
					points +=b;
					stats[4]+=b;
				}
				stats[1]+=b;
				points -=b;
				stats[4] -=b;
				}
			if(a==3){
				Advent.printCenter("Your current Intelligence is " + stats[2]);
				Advent.printCenter("How much would you like to increase your Intelligence by?(max 20)");
				int b = Advent.choose(amount,console);

				if(b+stats[2] > 20|| b>points){
					Advent.printCenter("This would place you above the 20 point max or spend more points than you have.");
					Advent.printCenter("Please try again");
					stats[2] -=b;
					points +=b;
					stats[4]+=b;
				}
				stats[2]+=b;
				points -=b;
				stats[4] -=b;
				}
			if(a==4){
				Advent.printCenter("Your current Agility is " + stats[3]);
				Advent.printCenter("How much would you like to increase your Agility by?(max 20)");
				int b = Advent.choose(amount,console);

				if(b+stats[3] > 21|| b>points+1){
					Advent.clearCon();
					Advent.printCenter("This would place you above the 20 point max or spend more points than you have.");
					Advent.printCenter("Please try again");
					stats[3] -=b;
					points +=b;
					stats[4]+=b;
				}
				stats[3]+=b;
				points -=b;
				stats[4] -=b;
				}
			if(a==5){
				System.out.print(getStats1());
				Advent.cont(console);
			}



		}while(points>0);

		Advent.clearCon();
		Advent.printCenter("Here are your finished stats:");
		Advent.space(2);
		System.out.print(getStats1());
		Advent.space(2);
		Advent.printCenter("Are you happy with your choices?");

		int reset = Advent.yesno(console);
		if(reset ==2){
			stats = copy;
		}
	}

		//inventory manangment

	public void attacks(){
		Weapons weapon = (Weapons) loadout[0];
		Weapons weapon2 =(Weapons) loadout[1];
		List<String> attacks= Arrays.asList(weapon.attacks);
		for(String attack2:weapon2.attacks){
			if(attacks.contains(attack2)){
			}else{
				attacks.add(attack2);
			}
		}

	}

	public void seeInventory()throws FileNotFoundException{
		Act1.clearCon();
		Scanner console = new Scanner(System.in);
		Act1.printCenter("This is what you are wearing.");
		System.out.println("\n\t\t\t\t" + "Chips: " + money + "\t|" + getLoadout() + "|");
		System.out.println(""); //padding
		Act1.printCenter("These are the items you carry on your person... for now.");
		for(Items item: inventory){
			System.out.println("\n\t\t" + item.name + "\t" + item.desc );
		}
		Act1.space(2); //padding
		changeEquipOrUse();
		Advent.cont(console);
	}
	public void changeEquipOrUse()throws FileNotFoundException{
		Scanner console = new Scanner(System.in);
		Act1.printCenter("Would you like to change your equipped items or use an item?");
		String[] options2 = {"Change Equipment","Use Item","Done"};
		int choice = Act1.choose(options2,console);
		if(choice==1){ //change equipment
			boolean notFinished = true;
			while(notFinished==true){
				System.out.print( getLoadout() );
				Act1.space(2);
				Act1.printCenter("What would item would you like to replace?");
				String[] options = {"Main Hand","Off-hand","Armor","Done"};

				int changeThis = Advent.choose(options,console);

				if(changeThis==1){ //main hand
					Act1.printCenter("You currently have " + loadout[0].name + " equipped.");
					Act1.printCenter("You can choose to equipped the following");

					List<Weapons> equipable = new ArrayList<>();
					List<String> weaponNamesAndDesc = new ArrayList<>();
					int counter = 0;
					for(Items item: inventory){
						if(item.type.equals("Weapon") && counter<5){
							equipable.add((Weapons)item);
							counter++;
						}
					}
					if(counter == 0){ //no available items to equip
						Act1.printCenter("You have no other items to equip.");
						return;
					}
					for(Weapons getItemName:equipable){
						String temp = getItemName.name + ": " + getItemName.desc;
						weaponNamesAndDesc.add(temp);
					}
					String[] options3 = new String[weaponNamesAndDesc.size()];
					for(int i=0; i<weaponNamesAndDesc.size();i++){
						options3[i] = weaponNamesAndDesc.get(i);
					}
					int a = Act1.choose(options3,console); //max 5 maybe less

					Weapons equipMe = equipable.get(a);
					Weapons addMe = (Weapons)loadout[0];

					this.loadout[0] = equipMe;
					this.inventory.remove(equipMe);
					this.inventory.add(addMe);
				}
				if(changeThis==2){ //off hand
					Act1.printCenter("You currently have " + loadout[1].name + " equipped.");
					Act1.printCenter("You can choose to equipped the following");

					List<Weapons> equipable = new ArrayList<>();
					List<String> weaponNamesAndDesc = new ArrayList<>();
					int counter = 0;
					for(Items item: inventory){
						if(item.type.equals("Weapon") && counter<5){
							equipable.add((Weapons)item);
							counter++;
						}
					}
					if(counter == 0){ //no available items to equip
						Act1.printCenter("You have no other items to equip.");
						return;
					}
					for(Weapons getItemName:equipable){
						String temp = getItemName.name + ": " + getItemName.desc;
						weaponNamesAndDesc.add(temp);
					}
					String[] options3 = new String[weaponNamesAndDesc.size()];
					for(int i=0; i<weaponNamesAndDesc.size();i++){
						options3[i] = weaponNamesAndDesc.get(i);
					}
					int a = Act1.choose(options3,console); //max 5 maybe less

					Weapons equipMe = equipable.get(a);
					Weapons addMe = (Weapons)loadout[1];

					this.loadout[1] = equipMe;
					this.inventory.remove(equipMe);
					this.inventory.add(addMe);
				}
				if(changeThis==3){ //armor
					Act1.printCenter("You currently have " + loadout[2].name + " equipped.");
					Act1.printCenter("You can choose to equipped the following");

					List<Armor> equipable = new ArrayList<>();
					List<String> armorNamesAndDesc = new ArrayList<>();
					int counter = 0;
					for(Items item: inventory){
						if(item.type.equals("Armor") && counter<5){
							equipable.add((Armor)item);
							counter++;
						}
					}
					if(counter == 0){ //no available items to equip
						Act1.printCenter("You have no other items to equip.");
						return;
					}
					for(Armor getItemName:equipable){
						String temp = getItemName.name + ": " + getItemName.desc;
						armorNamesAndDesc.add(temp);
					}
					String[] options3 = new String[armorNamesAndDesc.size()];
					for(int i=0; i<armorNamesAndDesc.size();i++){
						options3[i] = armorNamesAndDesc.get(i);
					}
					int a = Act1.choose(options3,console); //max 5 maybe less

					Armor equipMe = equipable.get(a);
					Armor addMe = (Armor)loadout[2];

					this.loadout[2] = equipMe;
					this.inventory.remove(equipMe);
					this.inventory.add(addMe);
				}
				if(changeThis==4){ //done
					notFinished = false;
				}
			}
		}
		//need to finish
		if(choice==2){ //use item
			List<Items> usables = new ArrayList<>();
			for(Items item: inventory){
				if(item.useable==true){
					usables.add(item);
				}
			}
			if(usables.size()>0){
				Act1.printCenter("What item would you like to use?");
				String[] options3 = new String[usables.size()];
				for(int i=0; i<usables.size();i++){
					options3[i] = usables.get(i).name;
				}
				int choice2 = Act1.choose(options3,console);
				usables.get(choice2-1).useItem(this);
			}else{
				Act1.printCenter("You have no usable items.");
			}
		}
		if(choice==3){ return;} //Done
	}
	public void addInventory(Items item){
		inventory.add(item);
	}
	public void subInventory(Items item){
		inventory.remove(item);
	}

		//Map interfaces

	public void showMap()throws FileNotFoundException{
		Scanner console = new Scanner(System.in);
		String templateNum = "";
		switch(roomIn){
			case 1,2,3: templateNum= "16"; break;
			case 4,5: templateNum= "14"; break;
			case 6,7,8,12,13: templateNum= "17"; break;
			case 9: templateNum= "13"; break;
			case 10: templateNum= "15"; break;
			case 11,14: templateNum= "19"; break;
			case 15,16: templateNum= "18"; break;
			case 17,18: templateNum= "20"; break;
			case 19,20: templateNum= "10"; break;
			case 21,22: templateNum= "1"; break;
			case 23,24,25: templateNum= "21"; break;
			case 26: templateNum= "9"; break;
			case 27: templateNum= "8"; break;
			case 28,29,35: templateNum= "2"; break;
			case 30,31: templateNum= "22"; break;
			case 32,33: templateNum= "11"; break;
			case 34: templateNum= "7"; break;
			case 36,37,42,43,47: templateNum= "6"; break;
			case 38,44: templateNum= "5"; break;
			case 39,40,45,48: templateNum= "4"; break;
			case 41,46,49: templateNum= "3"; break;
			default: templateNum= "";
		}

		File mapTempl = new File("maptemplate" + templateNum + ".txt");
		Scanner	scan = new Scanner(mapTempl);
		scan.nextLine(); 	//removes header from text file
		while(scan.hasNextLine()){
			String line = scan.nextLine();
			System.out.print(line);	//prints map line by line from text file
			System.out.println();
		}
		String next = console.nextLine(); //exits map
	}

		//getter methods

	/**
	 * returns the name of the player
	 *
	 * @return String the name of the Adventurer instance
	 */
	public String getName(){
		return name;
	}
	/**
	 * returns the race of the player
	 *
	 * @return String the race of the Adventurer instance
	 */
	public String getRace(){
		return race;
	}

	/**
	 * Prints the stats of the Adenturer instance
	 *
	 * @return String the stats of the Adventurer instance
	 */
	public String getStats(){
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

	//used instead of getStats to prevent loop after leveling up.

	public String getStats1(){ //doesn't loop for lvlup
		Scanner console = new Scanner(System.in);
		int[] stats1= Arrays.copyOf(stats,stats.length); // prevents user tampering

		return getName1() + "\n" + getHP()
				+ "\n\tStrength: " + stats1[0] + "\t\t*This stat makes you feel powerful.*"
				+ "\n\tCharisma: " + stats1[1] + "\t\t*This stat somehow makes you feel more charming... strange.*"
				+ "\n\tIntelligence: " + stats1[2] + "\t*This stat makes you feel insightful.*"
				+ "\n\tAgility: " + stats1[3] + "\t\t*This stat makes you feel more spider-like.*"
				+ "\n\tAvailable Points: " + stats1[4] + "\t*Stat points available to spend*";
	}


	public String getLoadout(){
		return "Main-Hand: " + loadout[0].name + "  |" + "  Off-Hand: " + loadout[1].name + "|" + "  Armor: " + loadout[2].name;
	}
	public String toString(){

		return "Name: " + name + "\nRace: " + race; //tbc

	}
	public String getName1(){

		return "Name: " + name + "\nRace: " + race; //tbc

	}
	public String getHP(){
		String cHP = Integer.toString(HP[0]);
		String maxHP = Integer.toString(HP[1]);

		return "HP: " + "\tCurrent:" + cHP + "\n\tMaximum:" + maxHP + "\n";
	}
	public int getStrength(){
		return stats[0];
	}
	public int getChar(){
		return stats[1];
	}
	public int getIntel(){
		return stats[2];
	}
	public int getAgil(){
		return stats[3];
	}

	//setter methods

	public void setName(String name){
		this.name=name;
	}
	public void setRace(String race){

		this.race=race;
	}
	public void setLoadout(Items[] loadout){

		this.loadout=loadout;
	}
	public void setStats(int[] stats){
		this.stats=stats;
	}

}

