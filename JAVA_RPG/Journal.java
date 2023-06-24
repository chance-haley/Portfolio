import java.util.*;
public class Journal{


	public List<String> quests;


//default constructor
	public Journal(){
		
		this.quests = new ArrayList<String>();
		
	}

	public void seeJournal(){
		Scanner console = new Scanner(System.in);
		Act1.printCenter("Your journal says...");
		
		for(String quest: quests){
			System.out.println(quest);
		}
		Advent.cont(console);	
		
		
	}

}
