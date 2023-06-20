import java.util.*;
import java.io.*;
public class Map{
	
	String mapName;
	List<Room> rooms; 
	
	//constructor
	public Map(String mapName){
		this.mapName= mapName;
	}
	
	/**
	 * This method creates the map used in Act1 using a txt file called rooms.txt
	 * 
	 * @throws FileNotFoundException in case of errors
	 */
	public void createConnections()throws FileNotFoundException{
		
		List<Room> map = new ArrayList<Room>();
		
		File rooms3 = new File("rooms.txt");
		Scanner	scan = new Scanner(rooms3);

		while(scan.hasNextLine()){
			
			String line = scan.nextLine();
			
			String[] line1 = line.split("~");
			
			String header = line1[0];
			
			List<Option> options2 = new LinkedList<Option>(); 
			
			for(int i=1;i<line1.length-1;i++){
				Option temp = new Option(line1[i], "interact");
				options2.add(temp);
			}
			
			String[] header1 = header.split("@");
			int roomid = Integer.parseInt(header1[0]);
			
			int connectionN = Integer.parseInt(header1[1]);
			int connectionE = Integer.parseInt(header1[2]);
			int connectionS = Integer.parseInt(header1[3]);
			int connectionW = Integer.parseInt(header1[4]);
			List<String> options = new LinkedList<String>();
				options.add("Move North");
				options.add("Move East");
				options.add("Move South");
				options.add("Move West");
			for(int i= 0; i<line1.length-1; i++){
				String temp = "";
				temp = options.get(i);
				options.remove(temp);
				temp = line1[i+1];
				options.add(temp);
			}
			Room temp = new Room(roomid,connectionN,connectionE,connectionS,connectionW, header1[5] , options, options2);
			map.add(temp);
		}
		this.rooms = map;
	}
	/**
	 * This method will run the map logic of the game
	 * 
	 * @return String currently a placeholder that will print to the screen saying you win or lose
	 * 
	 * @param player the adventurer/player character
	 * @param root the starting room of the map, will be updated recursively as program runs
	 */
	public String runMap(Adventurer player, Room root){
			Scanner console = new Scanner(System.in);
			
			if( root.roomID==47) return "You win"; //exits recursive loop, currently set as a placeholder
			
			Advent.printCenter(root.desc);
			space();
			
			Room output = choose(player, root,console);
				
			return runMap(player,output);
			
	}
	/**
	 * Prints out a move option and other options that exists from the room's options[] and asks the player to choose one.
	 * 
	 * @return Room the room that you will be moving into
	 * 
	 * @param player the adventurer/player character
	 * @param current the Room the player is currently in
	 * @param console the user's keyboard inputs
	 */
	private Room choose(Adventurer player, Room current,Scanner console){ // n is number of options
		int choice = 0;
		Exception iae = new IllegalArgumentException();
		int n = current.options.size()-3;
		do{
			System.out.println("Please choose an option below:\n");
			try{
			System.out.println("("+1+") -" + "Move");
			for(int i=2; i<=n;i++){
			
			System.out.println("("+i+") -" + current.options.get(i+2)); //prints out the number and corresponding option
			System.out.println("");
			}
			choice = Integer.parseInt(console.nextLine());
		}catch (Exception e){
			clearCon();
			System.out.println("Please enter the number of a valid option.");
			space(2);
		}
		
		}while(choice<1||choice>n);
		
		if(choice ==1){
			return move(current,console);
		}
		if(choice>1){
			
			runRoom(player, current, choice-2, console);
		}
		
		
		return current;
	
	}
	/**
	 * When the player choose an option besides move, the player is "moved" to a corresponding Option node that is chosen (he will return back after exiting the option logic)
	 * 
	 * @param player the adventurer/player character
	 * @param current the Room the player is currently in
	 * @param choice an integer that corresponds to the user's choice from the option[]
	 * @param console the user's keyboard inputs
	 */
	private void runRoom(Adventurer player, Room current, int choice, Scanner console){
		
		Option temp = current.options2.get(choice);
		
		
		
		temp.runTree(player,temp);
		
	}
	
	/**
	 * When the player chooses move, the player is given the choice of available rooms to move into. This will print out those choices and
	 * allow the user to select a new room to move into or stay in their current room.
	 * 
	 * @return Room the room that you will be moving into
	 * 
	 * @param current the Room the player is currently in
	 * @param console the user's keyboard inputs
	 */
	private Room move(Room current, Scanner console){
		int ways = 0;
		List<Integer> way = new LinkedList<Integer>();
		
		for(int i = 0; i <= 3; i++){
			if(current.connections[i] != -1){
				way.add(i);
				ways++;
			}
		}
		
		int choice = 0;
		Exception iae = new IllegalArgumentException();
		Room output = new Room();
			do{
				System.out.println("Please choose an option below:\n");
				try{
					
				for(int i=1; i<=ways;i++){
				
				System.out.println("("+i+") -" + current.options.get(way.get(i-1))); //prints out the number and corresponding option
				System.out.println("");
				}
				System.out.println("("+ (ways+1)+") -" + "Go Back");
				System.out.println("");
				choice = Integer.parseInt(console.nextLine());
			}catch (Exception e){
				clearCon();
				System.out.println("Please enter the number of a valid option.");
				space(2);
			}
			}while(choice<1||choice>ways+1);
			
			if(choice==ways+1) return current;
			int output1 = current.connections[way.get(choice-1)];
			output = getRoom(output1);
			
		return output;
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
	/**
	 * Returns the room that corresponds to a RoomID
	 * 
	 * @return Room the room that corresponds to the roomID entered
	 * 
	 * @param roomid The integer ID of the room you want to return
	 */
	public Room getRoom(int roomid){
		
		Room output = rooms.get(roomid-1);
		return output;
	}
}
