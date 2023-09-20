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
}
