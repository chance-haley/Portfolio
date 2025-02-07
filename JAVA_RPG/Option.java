import java.util.*;
import java.io.*;
public class Option{

	Option root;

	int id;

	String desc;

	String choice;

	String effect;

	Shopkeeper shopkeeper;

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

	public Option(String desc, String effect, String choice){
		List<Option> choices1 = new LinkedList<Option>();

		this.desc = desc;
		this.choices = choices1;
		this.effect = effect;
		this.choice = choice;
		this.root=this;
	}

	public void add(Option node, boolean prereq){
		if(prereq==true){
			this.choices.add(node);
		}
	}



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

		if(temp.desc.toLowerCase().equals("na")){ //skips nodes that add effects without a desc. ie quest completion nodes or leaving node
		}else{
			Advent.printCenter(temp.desc); //print out description of current node
		}
		Advent.space(5);
		int size = temp.choices.size();
		choices = temp.choices;
		for(int i =0; i<size;i++){	//Gets the choices you have at a node
			Option temp2 = temp.choices.get(i);
			options[i] = temp2.choice;
		}

		//area to place special cases using effect string

		StringTokenizer st = new StringTokenizer(temp.effect);
		int words = st.countTokens();
		//System.out.println("effect:" + temp.effect);

		//single word effects
		if(words==1){

			if(temp.effect.trim().toLowerCase().equals("shop")){
				//System.out.println("shop word effect");
				shopkeeper.shop(player);
				return;
			}
		}
		//double word effects
		if(words==2){
			String word1 = st.nextToken();
			String word2 = st.nextToken();

			if(word1.equals("pay")){
				player.money -= Integer.parseInt(word2);
			}
			if(word1.equals("dmg")){
				player.HP[0] -= Integer.parseInt(word2);
			}

		}
		//triple word effects
		if(words==3){
			String word1 = st.nextToken();
			String word2 = st.nextToken();
			String word3 = st.nextToken();

			if(word1.equals("quest")){
				if(word2.equals("activate")){
				Quest changeThis = player.journal.quests.get(Integer.parseInt(word3));
				changeThis.active=true;
				}
			} //word2 = QuestID word3= state to be in
			if(word1.equals("changestate")){
			Quest changeThis = player.journal.quests.get(Integer.parseInt(word2));
			changeThis.stateIn= Integer.parseInt(word3);
			}
		}

		//end special effect section

		//breaks recursion
		if(this.isEnd()) return;

		//selects next node
		int a = Advent.choose(options,console);

		Advent.clearCon();

		runTree(player, choices.get(a-1));

	}
}



