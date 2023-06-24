import java.util.*;
import java.io.*;
public class Shopkeeper{
	
	String name;
	String desc;
	List<Items> toSell;
	double gouge1;
	boolean wontsell;
	
	public Shopkeeper(){
		this.name = "null shopkeeper";
		this.desc= "If you see this, then I messed up";
		List<Items> inv = new LinkedList<Items>();
		this.toSell= inv;
	}
	public Shopkeeper(String name, String desc, List<Items> toSell){
		this.name = name;
		this.desc=desc;
	
		this.toSell= toSell;
		gouge1= 1.0;
		wontsell=false;
	}
	/* legacy code:
	 * 
	public void runShop(Adventurer player, Option root){
		Scanner console = new Scanner(System.in);
		Option temp = root;
		
		do{
			String[] options = new String[temp.choices.size()];
			
			Advent.printCenter(temp.desc);
			
			for(int i =0; i<temp.choices.size()-1;i++){
				Option temp2 = temp.choices.get(i);
				options[i] = temp2.desc;
			}
			
			int a = Advent.choose(options,console);
			
			root = temp.choices.get(a-1);
			temp = root;
		} while(!temp.isEnd());
		
		Advent.printCenter(temp.desc);
		Advent.cont(console);
		
		if(temp.desc.equals("Please look at my goods")){
			shop(player);
		}
	}
	**/
	
	/**
	 * When an option node has the keyword "shop" in the effect, you will be taken to the shop interface
	 * This method contains the logic and interface that you use in shopping
	 * 
	 * @param player the adventurer/player character
	 */
	public void shop(Adventurer player){
		Scanner console = new Scanner(System.in);
		boolean bought= false;
		double gouge = 1.0;
		if(this.wontsell){
			Advent.printCenter("Do not try my patience, be gone.");
			return;
		}
		if(gouge1!= 1.0){
			gouge=gouge1;
		}
		
		Advent.printCenter("These are the items I have for sell");
		Advent.space(3);
		System.out.println("Your chips: " + Integer.toString(player.money));
		
		//creating options for choose method
		String[] toStringInv = new String[toSell.size()+1];
		for(int i = 0; i< toSell.size(); i++){
			Items temp = toSell.get(i);
			toStringInv[i] = temp.type + "\t\t\t" + temp.name + "\t\t\t" + Integer.toString((int)Math.round((double)temp.value * gouge));
		}
		toStringInv[toSell.size()] = "Leave shop";
		
		System.out.println("    | Type \t\t |\t Name  \t\t|\tPrice \t|");
		int input = Advent.choose(toStringInv, console);
		
		if(input == toSell.size()+1){ //exit shop
			if(bought){
				Advent.printCenter("\"Thank you for your time and chips traveller.\"");
				return;
			}else{
				Advent.printCenter("\"I suppose my wears are for a finer clientelle.\"");
				return;
			}
		 }
		Items choice = toSell.get(input-1);
		int price = (int)Math.round((double)choice.value * gouge);
		Advent.clearCon();
		//creating options for second choose method
		String[] buy = { "Buy " + choice.name, "return"};
		
		System.out.println(toStringInv[input-1]);
		Advent.printCenter(choice.desc);
		
		int input2 = Advent.choose(buy,console); //1=buy 2=return
		
		if(input2==2){ //resursive looping
			shop(player);
			return;
		}
		if(price>player.money){ //cannot afford
			Advent.clearCon();
			Advent.printCenter("\"Hah! Why do you waste my time with goods beyond your meagerness?\"");
			Advent.cont(console);
		}
		if(price<=player.money){
			player.money -= price;
			player.inventory.add(choice);
			toSell.remove(choice);
			Advent.printCenter("\"Thank you for your business, this may be a fruitful relationship\"");
			Advent.cont(console);
			Advent.printCenter("You have acquired: " + choice.name);
		}
		
		//creating options for after buying
		String[] afterbuy = { "Continue shopping", "Leave shop" };
		
		int input3 = Advent.choose(afterbuy,console); //1=continue 2=leave
		
		if(input3==2){
			if(bought){
				Advent.printCenter("\"Thank you for your time and chips traveller.\"");
				return;
			}else{
				Advent.printCenter("\"I suppose my wears are for a finer clientelle.\"");
				return;
			}
		}
		if(input3==1){
			shop(player);
			return;
		}
	}
	
}
