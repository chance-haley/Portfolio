import java.util.*;
public class Quest{

int questID;
String name;
String[] desc;
boolean active;
int states;
int stateIn;

//default constructor
public Quest(){
	
	this.questID = 0000;
	this.name = "DefaultQuest";
	String def = "Defaultdesc";
	String def1 = "Defaultdesc2";
	String[] def12 = new String[2];
	def12[0]= def;
	def12[1]= def1;
	this.desc = def12;
	this.active = false;
	this.states = 2;
	this.stateIn = 0;
	
}

public Quest(int questID,String name, String[] desc,int states){

	this.questID = questID;
	this.name = name;
	this.desc = desc;
	this.active = false;
	this.states = states;
	this.stateIn = 0;
	
	
}
	
	
}





