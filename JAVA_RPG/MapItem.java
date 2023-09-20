import java.util.*;
import java.io.*;
public class MapItem extends Items{
	//inherits name, type, desc and value and usable


	//constructor


	public MapItem(){
	this.name= "Map";
	this.type= "Misc";
	this.desc= "A map of the local area.";
	this.desc1= "Originally a template of an old hunters map constantly being revised by the scribes.";
	this.value=0;
	this.useable=true;
	}

	@Override public void useItem(Adventurer player)throws FileNotFoundException{ //used in Adventurer.Java called by Map.Java in RunMap
		player.showMap();
	}

}


