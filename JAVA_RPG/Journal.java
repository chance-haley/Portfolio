import java.util.*;
import java.io.*;
public class Journal{


	public List<Quest> quests;


//default constructor config w/ text file called quests.txt
	public Journal()throws FileNotFoundException{
		
		List<Quest> quests = new ArrayList<Quest>();
		
		File quests1 = new File("quests.txt");
		Scanner	scan = new Scanner(quests1);
		
		scan.nextLine();
		
		while(scan.hasNextLine()){
			
			// 0~Placeholder~3~ --> what is inside String line.
			
			String line = scan.nextLine();
			String[] line1 = line.split("~"); //always a size 3 array
			
			int questID = Integer.parseInt(line1[0]);
			String questName = line1[1];
			int states = Integer.parseInt(line1[2]);
			String[] desc = new String[states];
			for(int i=0; i<states;i++){
				String line2 = scan.nextLine();
				desc[i] = line2;
			}
			Quest temp1 = new Quest(questID,questName,desc,states);
			quests.add(temp1);
		}

		this.quests=quests;
	}
	public void seeJournal(){
		Scanner console = new Scanner(System.in);
		Act1.printCenter("Your journal says...");
		
		for(Quest quest: quests){
			if(quest.active == true){
				System.out.print( quest.questID + ": ");
				System.out.println(quest.desc[quest.stateIn]);
			}
		}
	}
}
