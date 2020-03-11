package domein;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import domein.Kaart;
import domein.Speler;

public class Spel {
	//attributen
	private List<Kaart> deck = new ArrayList<Kaart>();
	//getters en setters
		
	//functies
	public String scoreBerekenen (Speler speler) {
		/////JOKERS BESTAAN NIET MEER, ze zijn veranderd in de kaarten die de spelers gekozen heeft.
		int punten = 0;
		int[] arraySorteerAantal = new int[8];
		String[] arraySorteerKleur = new String[8];
		boolean gesorteerd = false;
		int temp = 0;
		String temp2;

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
			int[] arrayMetScores = new int[]{1, 3, 6, 10, 15, 21};
			punten += arrayMetScores[arraySorteerAantal[i-1]-1];
		}
		//alle kaarten die na de eerste 3 (grootste/gesorteerd) komen worden opgeteld en afgetrokken van punten
		
		
		return String.format("%s heeft %n punten!", speler, punten);
	}
}
