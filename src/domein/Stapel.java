package domein;

import java.util.ArrayList;
import java.util.List;

import domein.Kaart;

public class Stapel extends Spel{

	//attributen
	private int nummer;
	List<Kaart> Kaarten;

	//constructors
	public Stapel(int nummer) {
		this.Kaarten = new ArrayList<Kaart>();
		this.nummer = nummer;
	}
	
	//getters en setters
	public List<Kaart> getKaarten() {
		return Kaarten;
	}

	public void setKaarten(List<Kaart> stapel) {
		this.Kaarten = stapel;
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
		getKaarten().add(kaart);
	}
	
	public boolean isEmpty() {
		return getKaarten().isEmpty();
	}
	
	public boolean isFull() {
		return getKaarten().size() == 3;
	}
}
