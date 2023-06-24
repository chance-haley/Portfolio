import java.util.*;
public class Adventurer extends Characters //implements Comparable<Adventurer>
	{
	public Room roomIn;
	public boolean onMap;
	public int money;
	public int exp;
	public int lvl;
	public int expneeded;
	public Journal quests;
	public boolean canSwim;
	public boolean isGifted;
	public boolean isOutlaw;
	public boolean isScribe;
	public boolean isOrphan;
	public boolean isHunter;
	public boolean isWeaver;
	public boolean isFarmer;
	public String[] perks; // 0-none 1-Can talk to animals 2-can equip large weapons 3- Can lockpick 4- gain 2 HP potions 5- Armor Piecing
	
	
	List<Items> inventory = new ArrayList<>(); //new before an array
	
	//constructors
	public Adventurer(){
		this.name = "";
		this.race= "";
		this.loadout = new Items[1];
		this.stats= new int[1]; 
		this.perks=new String[1];
		this.exp= 0;
		
		
	}
	public Adventurer(String name, String race, Items[] loadout, int[] stats, String[] perks){
		int[] basehp = {100,100};
		
		this.name = name;
		this.race = race;
		this.loadout = loadout;
		this.stats = stats; //0=strength, 1=Charisma, 2=Intelligence 3= Agility 4= points
		this.perks = perks;
		this.exp = 0;
		this.HP = basehp;
		this.money = 0;
		this.onMap = true;
		this.quests = new Journal();
		
		
	}
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
		}
		
		return getName1() + "\n" + getHP()
				+ "\n\tStrength: " + stats1[0] + "\t\t*This stat makes you feel powerful.*"
				+ "\n\tCharisma: " + stats1[1] + "\t\t*This stat somehow makes you feel more charming... strange.*"
				+ "\n\tIntelligence: " + stats1[2] + "\t\t*This stat makes you feel insightful.*"
				+ "\n\tAgility: " + stats1[3] + "\t\t*This stat makes you feel more spider-like.*"
				+ "\n\tAvailable Points: " + stats1[4] + "\t\t*Stat points available to spend*";
	}
	public String getStats1(){ //doesn't loop for lvlup
		Scanner console = new Scanner(System.in);
		int[] stats1= Arrays.copyOf(stats,stats.length); // prevents user tampering
		
		return getName1() + "\n" + getHP()
				+ "\n\tStrength: " + stats1[0] + "\t\t*This stat makes you feel powerful.*"
				+ "\n\tCharisma: " + stats1[1] + "\t\t*This stat somehow makes you feel more charming... strange.*"
				+ "\n\tIntelligence: " + stats1[2] + "\t\t*This stat makes you feel insightful.*"
				+ "\n\tAgility: " + stats1[3] + "\t\t*This stat makes you feel more spider-like.*"
				+ "\n\tAvailable Points: " + stats1[4] + "\t\t*Stat points available to spend*";
	}
	
	
	public String getLoadout(){
		return "";
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
	
	//inventory manangment
	
	public void seeInventory(){
		Scanner console = new Scanner(System.in);
		Act1.printCenter("These are the items you call yours... for now.");
		
		for(Items item: inventory){
			System.out.print(item.name + "\t" + item.desc + "\n");
		}
		Advent.cont(console);
		
		//need to add functionality to change loadout from this screen
	}
	public void addInventory(Items item){
		inventory.add(item);
	}
	public void subInventory(Items item){ 
		inventory.remove(item);
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
	public void setPerks(String[] perks){
		this.perks=perks;
	}
		
}

