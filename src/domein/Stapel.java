package domein;

import java.util.ArrayList;
import java.util.List;

import domein.Kaart;

public class Stapel extends Spel{

	//attributen
	private int nummer;
	List<Kaart> stapel;

	//constructors
	public Stapel(int nummer) {
		this.stapel = new ArrayList<Kaart>();
		this.nummer = nummer;
	}
	
	//getters en setters
	public List<Kaart> getStapel() {
		return stapel;
	}

	public void setStapel(List<Kaart> stapel) {
		this.stapel = stapel;
	}
	
	public int getNummer() {
		return nummer;
	}

	public void setNummer(int nummer) {
		this.nummer = nummer;
	}

	//functies
	public void kaartToevoegen(Kaart kaart) 
	{
		getStapel().add(kaart);
	}
	
	public boolean isEmpty() {
		return getStapel().isEmpty();
	}
	
	public boolean isFull() {
		return getStapel().size() == 3;
	}
}
