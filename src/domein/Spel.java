 package domein;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import domein.Kaart;
import domein.Speler;
import domein.Stapel;

public class Spel {
	//attributen
	private List<Kaart> deck = new ArrayList<Kaart>();
	private List<Speler> spelers = new ArrayList<Speler>();
	private List<Stapel> stapels = new ArrayList<Stapel>();
	public static int KAARTEN_PER_KLEUR = 9;
	public static int AANTAL_JOKERS = 3;
	public static int AANTAL_PLUS2 = 10;
	private Kaart inHand;
	
	//constructors 	
	public Spel() {
		deckAanmaken();
	}
	
	//getters en setters
	public List<Speler> getSpelers() {
		return spelers;
	}

	public List<Kaart> getDeck() {
		return deck;
	}

	public List<Stapel> getStapels() {
		return stapels;
	}

	public Kaart getInHand() {
		return inHand;
	}
	
	/* niet zeker of deze functie nodig is
	public void setInHand(Kaart inHand) {
		this.inHand = inHand;
	}*/
	
	//functies
	public void deckAanmaken() {
		for (String kleur : Kaart.getKleuren()) {
			for (int i = 0; i < KAARTEN_PER_KLEUR; i++)
				deck.add(new Kaart(kleur));
		}
		for (int i = 0; i < AANTAL_JOKERS; i++) {
			deck.add(new Kaart("Joker"));
		}
		for (int i = 0; i < AANTAL_PLUS2; i++) {
			deck.add(new Kaart("+2"));
		}
		Collections.shuffle(deck);
	}

	public void spelersToevoegen(List<String> namenSpelers){
		for (String naam : namenSpelers) {
			Speler speler = new Speler(naam);	
			spelers.add(speler);
		}
	}
	
	public void shuffleSpelers() {
		Collections.shuffle(spelers);
	}
	
	public void spelersStartInventoryGeven() {
		for (Speler spelerDieKaartKrijgt : spelers) {
			boolean status = false;
			while (!status) {
				for (Speler spelerChecken : spelers) {
					if (spelerDieKaartKrijgt.getInventaris() == spelerChecken.getInventaris()) {
						spelerDieKaartKrijgt.kaartToevoegenAanInventaris(deck.get(deck.size()-1));
						deck.remove(deck.size()-1);
						status = true;
					} else {
						Collections.shuffle(deck);
					}
				}
			}
		}
	}
	
	public String neemKaart() {		
		//twijfelgeval of ik de kleur of het object moet tonen
		inHand = deck.get(deck.size()-1);
		deck.remove(deck.size()-1);
		return inHand.getKleur(); 
	}
	
	public List<Stapel> stapelsTonen() {
		return stapels;
	}
	
	public void plaatsKaartOpStapel(int stapel, Kaart inHand){
		//stapel kiezen
		switch(stapel) {
		  case 1:
			  stapels.get(0).Kaarten.add(inHand);
		    break;
		  case 2:
			  stapels.get(1).Kaarten.add(inHand);
		    break;
		  case 3:
			  stapels.get(2).Kaarten.add(inHand);
			break;
		  case 4:
			  stapels.get(3).Kaarten.add(inHand);
			break;
		  case 5:
			  stapels.get(4).Kaarten.add(inHand);
			break;
		}
	}
	
	public void stapelNemen(int nummerVanSpeler, int stapelNR) {
		switch(stapelNR) {
		  case 1:
			  spelers.get(nummerVanSpeler).stapelToevoegenAanInventaris(stapels.get(0));
			  stapels.get(0).Kaarten.clear();
			  stapels.remove(0);
		    break;
		  case 2:
			  spelers.get(nummerVanSpeler).stapelToevoegenAanInventaris(stapels.get(1));
			  stapels.get(1).Kaarten.clear();
			  stapels.remove(1);
		    break;
		  case 3:
			  spelers.get(nummerVanSpeler).stapelToevoegenAanInventaris(stapels.get(2));
			  stapels.get(2).Kaarten.clear();
			  stapels.remove(2);
			break;
		  case 4:
			  spelers.get(nummerVanSpeler).stapelToevoegenAanInventaris(stapels.get(3));
			  stapels.get(3).Kaarten.clear();
			  stapels.remove(3);
			break;
		  case 5:
			  spelers.get(nummerVanSpeler).stapelToevoegenAanInventaris(stapels.get(4));
			  stapels.get(4).Kaarten.clear();
			  stapels.remove(4);
			break;
		}
	}
	 	
	public void stapelsAanmaken() {
		for (int i = 0; i < spelers.size(); i++) {
			Stapel stapel = new Stapel(i);
			stapels.add(stapel);
		}
	}
	
	public String scoreBerekenen (Speler speler) {
		/////JOKERS BESTAAN NIET MEER, ze zijn veranderd in de kaart die de speler gekozen heeft.
		int pluspunten = 0;
		int minpunten = 0;
		int totaalpunten = 0;
		int[] arraySorteerAantal = new int[8];
		String[] arraySorteerKleur = new String[8];
		boolean gesorteerd = false;
		int temp = 0;
		String temp2;
		int[] arrayMetScores = new int[]{1, 3, 6, 10, 15, 21};

		int countRood = Collections.frequency(speler.getInventaris(),"Rood");
		int countPaars = Collections.frequency(speler.getInventaris(),"Paars");
		int countBlauw = Collections.frequency(speler.getInventaris(),"Blauw");
		int countGroen = Collections.frequency(speler.getInventaris(),"Groen");
		int countBruin = Collections.frequency(speler.getInventaris(),"Bruin");
		int countOranje = Collections.frequency(speler.getInventaris(),"Oranje");
		int countGeel = Collections.frequency(speler.getInventaris(),"Geel");
		int countPlusTwee = Collections.frequency(speler.getInventaris(),"+2");
		arraySorteerAantal[0] = countRood;
		arraySorteerAantal[1] = countPaars;
		arraySorteerAantal[2] = countBlauw;
		arraySorteerAantal[3] = countGroen;
		arraySorteerAantal[4] = countBruin;
		arraySorteerAantal[5] = countOranje;
		arraySorteerAantal[6] = countGeel;
		//arraySorteerAantal[7] = countPlusTwee;
		
		arraySorteerKleur[0] = "Rood";
		arraySorteerKleur[1] = "Paars";
		arraySorteerKleur[2] = "Blauw";
		arraySorteerKleur[3] = "Groen";
		arraySorteerKleur[4] = "Bruin";
		arraySorteerKleur[5] = "Oranje";
		arraySorteerKleur[6] = "Geel";
		//arraySorteerKleur[7] = "+2";
		
		//bubble sort
		//sorting algorithm: https://stackabuse.com/sorting-algorithms-in-java/
		while (!gesorteerd) {
			gesorteerd = true;
			for (int i = 0; i < arraySorteerAantal.length-1; i++) {
				if (arraySorteerAantal[i] > arraySorteerAantal[i+1]) {
					
					temp = arraySorteerAantal[i];
					arraySorteerAantal[i] = arraySorteerAantal[i+1];
					arraySorteerAantal[i+1] = temp;
					
					temp2 = arraySorteerKleur[i];
					arraySorteerKleur[i] = arraySorteerKleur[i+1];
					arraySorteerKleur[i+1] = temp2;
					
					gesorteerd = false;
				}
			}
		}
		for (int i = 0; i < 3; i++) {
			pluspunten += arrayMetScores[arraySorteerAantal[i-1]-1];
		}
		//alle kaarten die na de eerste 3 (grootste/gesorteerd) komen worden opgeteld en afgetrokken van punten
		for (int i = 2; i < arraySorteerKleur.length; i++) {
			minpunten += arrayMetScores[arraySorteerAantal[i-1]-1];
		}
		totaalpunten = pluspunten - minpunten + (countPlusTwee*2);
		
		return String.format("%s heeft %n punten!", speler, totaalpunten);
	}
	
	public void assignJoker(Speler speler, String nieuweKleur) {
		//new kaart??
			speler.getInventaris().remove(new Kaart("joker"));
			speler.getInventaris().add(new Kaart(nieuweKleur));
	}
	public int aantalJokers(Speler speler) {
		return speler.aantalJokers();
	}
	
	public boolean stapelIsFull(int stapel) {
		return stapels.get(stapel).isFull();
	}
	
	public String aantalStapelsToString() {
		String output = "";
		switch (stapels.size()) {
		case 5:
			output = "(1-2-3-4-5)";
			break;
		case 4:
			output = "(1-2-3-4)";
			break;
		case 3:
			output = "(1-2-3)";
			break;
		case 2:
			output = "(1-2)";
			break;
		case 1:
			output = "Neem stapel 1";
			break;
		}
		return output;
	}
	
	public boolean isStapelVol(int stapel) {
		boolean value;
		if (stapels.get(stapel).isFull() == true)
			value = true;
		else value = false;
		return value;
	}
}
