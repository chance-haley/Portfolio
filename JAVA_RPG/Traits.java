import java.util.*;
import java.io.*;
public class Traits{
//important
	public boolean isGifted;
//background
	public boolean isOutlaw;
	public boolean isScribe;
	public boolean isOrphan;
	public boolean isHunter;
	public boolean isWeaver;
	public boolean isFarmer;
//health
	public boolean ill;
	public boolean disfigured;
	public boolean maimed;
	public boolean onehand;
	public boolean wounded;
	public boolean blind;
	public boolean pox;
//negative
	public boolean killer;
	public boolean blastphemous;
//decision
	public boolean canSwim;
//dialogue
	public boolean student;
	public boolean linguist;
//combat
	public boolean agressive;
	public boolean cautious;
	public boolean reckless;
//misc
	public boolean tall;
	public boolean midget;
	public boolean lucky;

//constructor
	public Traits(){
		this.isGifted=false;

		this.isOutlaw=false;
		this.isScribe=false;
		this.isOrphan=false;
		this.isHunter=false;
		this.isWeaver=false;
		this.isFarmer=false;

		this.ill=false;
		this.disfigured=false;
		this.maimed=false;
		this.onehand=false;
		this.wounded=false;
		this.blind=false;
		this.pox=false;

		this.killer=false;
		this.blastphemous=false;

		this.canSwim=false;

		this.student=false;
		this.linguist=false;

		this.agressive=false;
		this.cautious=false;
		this.reckless=false;

		this.tall=false;
		this.midget=false;
		this.lucky=false;
	}
}

