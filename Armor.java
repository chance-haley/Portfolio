import java.util.*;
public class Armor extends Items{
	// inherits name, desc, and value
	int defense;
	int dodgeDice;
	
	public Armor(){
		
		this.name= "You are naked.";
		this.defense = 0;
		this.dodgeDice=2;
	}
	
	public void armorAbility(){
		
		dodgeDice =3;
		
	}
}
