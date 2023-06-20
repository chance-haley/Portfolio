import java.util.*;
import java.io.*;
public class Option{
	
	Option root;
	
	int id;
	
	String desc;
	
	String effect;
	
	Shopkeeper local;
	
	List<Option> choices;
	
	/**
	 * Tells you if this Option node has any children.
	
	 * 
	 * @return true if there is no further nodes, false otherwise
	 */
	public boolean isEnd(){
		if(this.choices.isEmpty()) return true;
		
		return false;
	}
		
		
	public Option(){
		List<Option> choices1 = new LinkedList<Option>();
		this.desc = "Empty Option";
		this.choices = choices1;
		this.effect = "empty";
	}
	
	public Option(String desc, String effect){
		List<Option> choices1 = new LinkedList<Option>();
		
		this.desc = desc;
		this.choices = choices1;
		this.effect = effect;
		this.root=this;
	}
	
	public void add(Option node, boolean prereq){
		if(prereq==true){
			this.choices.add(node);
		}
	}
	
	//legacy code no longer used
	/*
	public void runNode(Adventurer player){
		Scanner console = new Scanner(System.in);
		//System.out.println(this.effect);
		Option temp1 = root;
		do{
			Option temp = this;
			String[] options = new String[temp.choices.size()];
			
			Advent.printCenter(temp.desc);
			
			System.out.println(temp.choices.size()); //for testing, not showing up so not entering do/while loop
			
			for(int i =0; i<temp.choices.size()-1;i++){
				Option temp2 = temp.choices.get(i);
				options[i] = temp2.effect;
			}
			
			int a = Advent.choose(options,console);
			if(this.effect.equals("store")){
				local.runShop(player, temp);
				System.out.println("12345");
				return;
			}
			if(this.effect.equals("choice")){
				
			}
			
			root = temp.choices.get(a-1);
			temp = root;
		} while(!isEnd());
		
	}
	* */
	
/**
	 * Will print out a list your current node's childrens effect and ask the user to pick one.
	 * After picking an option, the user will be taken to that new node unless it is an ending node. Then either a special case will happen,
	 * or you will be returned to the room you entered the Option Tree from.
	 * 
	 * @param player the player character
	 * @param root the Option node you are currently in.
	 */
	public void runTree(Adventurer player,Option root){
		Scanner console = new Scanner(System.in);
		Option temp = root;
		
			//will store your possible choices in the tree
			String[] options = new String[temp.choices.size()];
			
			Advent.printCenter(temp.desc); //print out description of current node
			int size = temp.choices.size();
			choices = temp.choices; //this fixed alot of my bugs
			//System.out.println("number of choices - " + size);
			for(int i =0; i<size;i++){
				Option temp2 = temp.choices.get(i);
				options[i] = temp2.effect;
				//System.out.println(temp2.desc);
			}
			//System.out.println(options);
			int a = Advent.choose(options,console);
			//System.out.println(temp.choices.size());
			
			temp = choices.get(a-1);
		if(temp.effect.equals("shop")){
			local.shop(player);
			//System.out.println("12345");
			return;
		}
		
		if(temp.isEnd()) return; //breaks recursion
		
		runTree(player, temp);

	}
}



