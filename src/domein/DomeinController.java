package domein;

import java.util.List;

public class DomeinController {
	
	private Spel spel;
	
	public void startSpel() {
		this.spel = new Spel();
	}
	
	/* wordt automatisch uitgevoerd in de constructor van klasse Spel
	public void deckAanmaken() {
		spel.deckAanmaken();
	}*/
	
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
	
	public void plaatsKaartOpStapel(int stapelNR, Kaart inHand) {
		spel.plaatsKaartOpStapel(stapelNR, inHand);
	}
	
	public void stapelNemen(int nummerVanSpeler, int stapelNR) {
		spel.stapelNemen(nummerVanSpeler, stapelNR);
	}
	
	public String scoreBerekenen(Speler speler) {
		return spel.scoreBerekenen(speler);
	}
	
	public List<Kaart> getDeck(){
		return spel.getDeck();
	}
	
	public List<Speler> getLijstVanSpelers() {
		return spel.getLijstVanSpelers();
	}
	
	public List<Stapel> getLijstVanStapels() {
		return spel.getLijstVanStapels();
	}
	
	//mogelijk .getkleur() weglaten en type veranderen naar Kaart
	public String getInHand() {
		return spel.getInHand().getKleur();
	}
}
