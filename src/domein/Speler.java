package domein;

import java.util.ArrayList;
import java.util.List;

public class Speler {
	//attributen
	private String naam ="";
	private List<Kaart> inventaris= new ArrayList<Kaart>();
	private int score = 0;
	
	//constructors
	public Speler(String naam) 
	{
		setNaam(naam);
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	//getters en setters
	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public List<Kaart> getInventaris() {
		return inventaris;
	}

	//functies
	public void kaartToevoegenAanInventaris(Kaart kaart) {
		inventaris.add(kaart);
	}
	
	public void stapelToevoegenAanInventaris(Stapel stapel) {
		for (Kaart kaart : stapel.getKaarten()) {
			inventaris.add(kaart);
		}
	}
	
	public int aantalJokers() {
		int aantalJokers = 0;
		for (Kaart kaart : inventaris) {
			if (kaart.getKleur() == "Joker")
				aantalJokers++;
		}
		return aantalJokers;
	}
}
