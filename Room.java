import java.util.*;

public class Room{

	public int roomID;
	
	public String desc;
	
	public List<String> options;
	
	public List<Option> options2;
	
	protected int[] connections;
	
	
	//added based on feedback from Dr. Adrian. Attempting to make Room class act as a node.
	protected Room[] connections1;
	
	public boolean goNorth;
	public boolean goSouth;
	public boolean goWest;
	public boolean goEast;
	
	
	//constructor
	public Room(int roomID, int connection1, int connection2, int connection3, int connection4, String desc, List<String> options, List<Option> options2){
		this.roomID=roomID;
		this.options = options;
		this.options2 = options2;
		int[] con = new int[4];
		con[0] = connection1;
		con[1] = connection2;
		con[2] = connection3;
		con[3] = connection4;
		this.connections = con;
		
		this.desc = desc;
		
		this.goNorth=false;
		this.goEast=false;
		this.goSouth=false;
		this.goWest=false; 
		
		if (connection1 != -1) this.goNorth=true;
		if (connection2 != -1) this.goEast=true;
		if (connection3 != -1) this.goSouth=true;
		if (connection4 != -1) this.goWest=true;
		
	}
	//default constructor
	public Room(){
		
		this.roomID=-1;
		
		this.options = new LinkedList<String>();
		
		int[] con = new int[4];
		con[0] = -1;
		con[1] = -1;
		con[2] = -1;
		con[3] = -1;
		this.connections = con;
		
		this.desc = desc;
		
		this.goNorth=false;
		this.goEast=false;
		this.goSouth=false;
		this.goWest=false; 
	}
	
	// legacy before I changed method to enterRoom to be in Map.java under a different structure of a recursive method with a getter for the room.
	
	/* public int enterRoom(Adventurer player){
		Scanner console = new Scanner(System.in);
		int choice=0;
		
		//adding see character/inventory to every option
		int a = options.size()+2;
		String[] options1 = new String[a];
		
		for(int i=0; i<options.size();i++){
			options1[i] = options.get(i);
		}
		options1[a-2] = "See stats";
		options1[a-1] = "See inventory";
		
		
		do{
			System.out.println(desc);
			space(1);
			choice = Advent.choose(options1,console);
			if(choice == options.size()){ //see stats
				Advent.clearCon();
				System.out.print(player.getStats());
				Advent.cont(console);
			}
				
			if(choice == options.size()+2){ //see inventory
				Advent.clearCon();
				player.seeInventory();
				Advent.cont(console);
			}
			Advent.clearCon();
		}while(choice<1 || choice> options.size());
		
	return choice;
	}
	
	public String getRoom(){
	
	return desc;
	}
	
	
	//utility
	
	public static void printCenter(String words){ //assumes a 100 character wide console,, from Advent.java
		
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
	public static void space(){
		for(int i=0; i<=15;i++){
			System.out.println("");
		}
		
	}
	public static void space(int lines){
		for(int i=0; i<=lines;i++){
			System.out.println("");
		}
	}
	* */
}
