import java.util.*;
public class Armor extends Items{
	// inherits name, desc, and value
	int defense;
	String modifers;
	int clumbsiness;
	int dodgeDice;

	public Armor(){

		this.name = "Hairy Body";
		this.type = "Armor";
		this.desc = "You are without armor or clothes.";
		this.clumbsiness=0;
		this.weight=0;
		this.useable=false;
		this.defense = 0;
		this.dodgeDice=2;


	}

	public void armorAbility(){

		dodgeDice =3;

	}
}
