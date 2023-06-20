public class Items{
	
	public String name;
	
	public String type;
	
	public String desc;
	
	public String desc1;
	
	public int value;
//default constructor
public Items(){
	this.name= "Nothing";
	
	this.type = "misc";
	
	this.desc= "FYI: It's nothing";
	
	this.desc1= "It might be something, but probably not.";	
	
	this.value=0;
}
public Items(String name,String type, String desc, int value){
	
	this.name = name;
	this.type = type;
	this.desc = desc;
	this.value=value;
}



//getter methods
	public String getName(){
		return name;
	}



//setter methods
	public void setName(String name){
		this.name=name;
	}
}
	
