package domein;

import java.util.List;

import domein.Spel;

public class DomeinController {

	private Spel spel;
	
	public void startSpel() {
		this.spel = new Spel();
	}
	
	public void spelersToevoegen(List<String> namenSpelers) {
		spel.spelersToevoegen(namenSpelers);
	}
	
	public void spelersStartInventoryGeven() {
		spel.spelersStartInventoryGeven();
	}
	
	public String neemKaart() {
		return spel.neemKaart();
	}
	
	public void stapelsAanmaken() {
		spel.stapelsAanmaken();
	}
	
	public List<Stapel> stapelsTonen() {
		return spel.stapelsTonen();
	}
	
	public int getDeck() {
		return spel.getDeck().size();
	}
	
	public void plaatsKaartOpStapel(int stapelNR, Kaart inHand) {
		spel.plaatsKaartOpStapel(stapelNR, inHand);
	}
	
	public void stapelNemen(int nummerVanSpeler, int stapelNR) {
		spel.stapelNemen(nummerVanSpeler, stapelNR);
	}
	
	public String scoreBerekenen(Speler speler) {
		return spel.scoreBerekenen(speler);
	}
	
	public void shuffleLijstVanSpelers() {
		spel.shuffleSpelers();
	}
	
	public List<Speler> getSpelers() {
		return spel.getSpelers();
	}
	
	public List<Stapel> getStapels() {
		return spel.getStapels();
	}
	
	//mogelijk .getkleur() weglaten en type veranderen naar Kaart
	public Kaart getInHand() {
		return spel.getInHand();
	}
	
	public boolean stapelIsFull(int stapel) {
		return spel.stapelIsFull(stapel);
	}
	
	public void assignJoker(Speler speler, String nieuweKleur) {
		spel.assignJoker(speler, nieuweKleur);
	}
	public int aantalJokers(Speler speler) {
		return spel.aantalJokers(speler);
	}
	
	public String aantalStapelsToString() {
		return spel.aantalStapelsToString();
	}
	
	public boolean isStapelVol(int stapel) {
		return spel.isStapelVol(stapel-1);
	}
	
	public List<Kaart> getInventaris(int speler) {
		return spel.getInventaris(speler);
	}
}
