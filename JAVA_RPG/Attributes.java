


public class Attributes{

	String name;//(Strength,Charisma,Intelligence,Agility)
	int type; // attribute (0=Strength,1=Charisma,2=Intelligence,3=Agility)
	int amount; //total skill points
	boolean spendable; //spendable points in attributes


	public Attributes(int type, int amount, boolean spendable){

	if(spendable==false){
		switch(type){
			case 0: this.name= "Strength";
			break;
			case 1: this.name = "Charisma";
			break;
			case 2: this.name = "Intelligence";
			break;
			case 3: this.name = "Agility";
			break;
			default: this.name = "Error points not assigned to type";
		}
	}else{
		this.name = "Available Points";
	}
	this.amount=amount;



	}


}

