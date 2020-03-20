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
	private List<Speler> lijstVanSpelers = new ArrayList<Speler>();
	private List<Stapel> lijstVanStapels = new ArrayList<Stapel>();
	private static final int KAARTEN_PER_KLEUR = 9;
	private static final int AANTAL_JOKERS = 3;
	private static final int AANTAL_PLUS2 = 10;
	private Kaart inHand;
	
	//constructors 	
	public Spel() {
		deckAanmaken();
	}
	
	//getters en setters
	public List<Speler> getLijstVanSpelers() {
		return lijstVanSpelers;
	}

	public List<Kaart> getDeck() {
		return deck;
	}

	public List<Stapel> getLijstVanStapels() {
		return lijstVanStapels;
	}

	public Kaart getInHand() {
		return inHand;
	}
	
	/* niet zeker of deze functie nodig is
	public void setInHand(Kaart inHand) {
		this.inHand = inHand;
	}*/

	public static int getKaartenPerKleur() {
		return KAARTEN_PER_KLEUR;
	}

	public static int getAantalJokers() {
		return AANTAL_JOKERS;
	}

	public static int getAantalPlus2() {
		return AANTAL_PLUS2;
	}
	
	//functies
	public void deckAanmaken() {
		for (String kleur : Kaart.getKleurenlijst()) {
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
			lijstVanSpelers.add(speler);
		}
	}
	
	public void shuffleLijstVanSpelers() {
		Collections.shuffle(lijstVanSpelers);
	}
	
	public void spelersStartInventoryGeven() {
		for (Speler spelerDieKaartKrijgt : lijstVanSpelers) {
			boolean status = false;
			while (!status) {
				for (Speler spelerChecken : lijstVanSpelers) {
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
		return lijstVanStapels;
	}
	
	public void plaatsKaartOpStapel(int stapel, Kaart inHand){
		//stapel kiezen
		switch(stapel) {
		  case 1:
			lijstVanStapels.get(0).stapel.add(inHand);
		    break;
		  case 2:
			lijstVanStapels.get(1).stapel.add(inHand);
		    break;
		  case 3:
			lijstVanStapels.get(2).stapel.add(inHand);
			break;
		  case 4:
			lijstVanStapels.get(3).stapel.add(inHand);
			break;
		  case 5:
			lijstVanStapels.get(4).stapel.add(inHand);
			break;
		}
	}
	
	public void stapelNemen(int nummerVanSpeler, int stapelNR) {
		switch(stapelNR) {
		  case 1:
			  lijstVanSpelers.get(nummerVanSpeler-1).stapelToevoegenAanInventaris(lijstVanStapels.get(0));
			  lijstVanStapels.get(0).stapel.clear();
		    break;
		  case 2:
			  lijstVanSpelers.get(nummerVanSpeler-1).stapelToevoegenAanInventaris(lijstVanStapels.get(1));
			  lijstVanStapels.get(1).stapel.clear();
		    break;
		  case 3:
			  lijstVanSpelers.get(nummerVanSpeler-1).stapelToevoegenAanInventaris(lijstVanStapels.get(2));
			  lijstVanStapels.get(2).stapel.clear();
			break;
		  case 4:
			  lijstVanSpelers.get(nummerVanSpeler-1).stapelToevoegenAanInventaris(lijstVanStapels.get(3));
			  lijstVanStapels.get(3).stapel.clear();
			break;
		  case 5:
			  lijstVanSpelers.get(nummerVanSpeler-1).stapelToevoegenAanInventaris(lijstVanStapels.get(4));
			  lijstVanStapels.get(4).stapel.clear();
			break;
		}
	}
	 	
	public void stapelsAanmaken() {
		for (int i = 0; i < lijstVanSpelers.size(); i++) {
			Stapel stapel = new Stapel(i);
			lijstVanStapels.add(stapel);
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
}
