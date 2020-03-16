package domein;

import java.util.ArrayList;
import java.util.Arrays;
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
	
	//constructors 	
	public Spel()
	{
		for (String kleur : Kaart.getKleurenlijst()) {
			for (int i = 0; i < KAARTEN_PER_KLEUR; i++)
				deck.add(new Kaart(kleur));
		}
		for (int i = 0; i < AANTAL_JOKERS; i++) {
			deck.add(new Kaart("joker"));
		}
		for (int i = 0; i < AANTAL_PLUS2; i++) {
			deck.add(new Kaart("+2"));
		}
		Collections.shuffle(deck);
	}
	//getters en setters
		
	//functies
	public void spelersToevoegen(int nummer, String naam1, String naam2, String naam3, String naam4, String naam5){
		if (nummer == 4) {
			Speler speler1 = new Speler(naam1);
			Speler speler2 = new Speler(naam2);
			Speler speler3 = new Speler(naam3);
			Speler speler4 = new Speler(naam4);
			lijstVanSpelers.add(speler1);
			lijstVanSpelers.add(speler2);
			lijstVanSpelers.add(speler3);
			lijstVanSpelers.add(speler4);
		} else if (nummer == 5) {
			
			Speler speler1 = new Speler(naam1);
			Speler speler2 = new Speler(naam2);
			Speler speler3 = new Speler(naam3);
			Speler speler4 = new Speler(naam4);
			Speler speler5 = new Speler(naam5);
			lijstVanSpelers.add(speler1);
			lijstVanSpelers.add(speler2);
			lijstVanSpelers.add(speler3);
			lijstVanSpelers.add(speler4);
			lijstVanSpelers.add(speler5);
		}
	}
	
	public String neemKaart() {		
		//kaart nemen
		int laatsteKaart = 0;
		laatsteKaart = tempDeck.size()-1;
		inHand = tempDeck.get(laatsteKaart);
		//kaart in inHand steken en uit array halen
		tempDeck.remove(laatsteKaart);
		//kaart tonen
		return inHand; 
	}
	
	public List<Stapel> stapelsTonen() {
		return lijstVanStapels;
	}
	
	public void plaatsKaartOpStapel(String stapel, Kaart inHand){
		//stapel kiezen
		switch(stapel) {
		  case "stapel1":
			lijstVanStapels.get(0).stapel.add(inHand);
		    break;
		  case "stapel2":
			lijstVanStapels.get(1).stapel.add(inHand);
		    break;
		  case "stapel3":
			lijstVanStapels.get(2).stapel.add(inHand);
			break;
		  case "stapel4":
			lijstVanStapels.get(3).stapel.add(inHand);
			break;
		  case "stapel5":
			lijstVanStapels.get(4).stapel.add(inHand);
			break;
		}
	}
	
	public void stapelNemen(int nummerVanSpeler, String stapel) {
		switch(stapel) {
		  case "stapel1":
			  lijstVanSpelers.get(nummerVanSpeler-1).stapelToevoegenAanInventaris(lijstVanStapels.get(0).getStapel());
			  lijstVanStapels.get(0).stapel.clear();
		    break;
		  case "stapel2":
			  lijstVanSpelers.get(nummerVanSpeler-1).stapelToevoegenAanInventaris(lijstVanStapels.get(1).getStapel());
			  lijstVanStapels.get(1).stapel.clear();
		    break;
		  case "stapel3":
			  lijstVanSpelers.get(nummerVanSpeler-1).stapelToevoegenAanInventaris(lijstVanStapels.get(2).getStapel());
			  lijstVanStapels.get(2).stapel.clear();
			break;
		  case "stapel4":
			  lijstVanSpelers.get(nummerVanSpeler-1).stapelToevoegenAanInventaris(lijstVanStapels.get(3).getStapel());
			  lijstVanStapels.get(3).stapel.clear();
			break;
		  case "stapel5":
			  lijstVanSpelers.get(nummerVanSpeler-1).stapelToevoegenAanInventaris(lijstVanStapels.get(4).getStapel());
			  lijstVanStapels.get(4).stapel.clear();
			break;
		}
	}
	 	
	public void stapelsAanmaken() {
		if (lijstVanSpelers.size() == 4) {
			Stapel stapel1 = new Stapel(1);
			Stapel stapel2 = new Stapel(2);
			Stapel stapel3 = new Stapel(3);
			Stapel stapel4 = new Stapel(4);
			lijstVanStapels.add(stapel1);
			lijstVanStapels.add(stapel2);
			lijstVanStapels.add(stapel3);
			lijstVanStapels.add(stapel4);
		} else if (lijstVanSpelers.size() ==5) {
			Stapel stapel1 = new Stapel(1);
			Stapel stapel2 = new Stapel(2);
			Stapel stapel3 = new Stapel(3);
			Stapel stapel4 = new Stapel(4);
			Stapel stapel5 = new Stapel(5);
			lijstVanStapels.add(stapel1);
			lijstVanStapels.add(stapel2);
			lijstVanStapels.add(stapel3);
			lijstVanStapels.add(stapel4);
			lijstVanStapels.add(stapel5);
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
}
