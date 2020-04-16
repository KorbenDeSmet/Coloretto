package ui;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import domein.DomeinController;

public class ColorettoApplicatie {
	
	public static void main(String[] args) {
		//problemen met die max limiet van een stapel te implementeren
		DomeinController domeinController = new DomeinController();

		Scanner scannerInt = new Scanner(System.in);
		Scanner scannerString = new Scanner(System.in);
		
		domeinController.startSpel();
		
		System.out.print("Welkom, met hoeveel willen jullie spelen? (4/5): ");
		int aantalSpelers = scannerInt.nextInt();
		System.out.println();
		boolean status = false;
		while (!status) {
				if 	(aantalSpelers == 4 || aantalSpelers == 5) {
					status = true;
				} else {
					System.out.println("Sorry, maar dit is geen geldige invoer!");
					System.out.println("Het aantal spelers moet 4 of 5 zijn");
					System.out.print("Met hoeveel willen jullie spelen?: ");
					aantalSpelers = scannerInt.nextInt();
					System.out.println();
				}
		}
		List<String> spelers = new ArrayList<String>();
		for (int i = 0; i < aantalSpelers; i++) 
		{
			System.out.printf("Wat is de naam van speler %d?: ", (i + 1));
			spelers.add(scannerString.nextLine());
		}
		System.out.println();
		
		domeinController.spelersToevoegen(spelers);
		domeinController.spelersStartInventoryGeven();
		
		domeinController.stapelsAanmaken();
		
		//random startspeler
		domeinController.shuffleLijstVanSpelers();
		System.out.printf("De beginnende speler is %s! %n", domeinController.getSpelers().get(0).getNaam());
		//zeker zijn dat er een true waarde aan de boolean wordt gegeven als er minder dan x aantal kaarten in het deck zitten
		boolean rondeStatus = false;
		
		for (int i = 0; i < domeinController.getSpelers().size(); i++) {
			System.out.print("Stapel " + (i+1) +": " + domeinController.getStapels().get(i).getKaarten());
			System.out.println();
		}
		domeinController.neemKaart();
		domeinController.getStapels();
		System.out.printf("Op welke stapel wilt u de kaart (%s) leggen? %s: ",domeinController.getInHand(), domeinController.aantalStapelsToString());
		int stapelNR = scannerInt.nextInt();
		System.out.println();
		
		domeinController.plaatsKaartOpStapel(stapelNR, domeinController.getInHand());				
		
		while (!rondeStatus) {
			if (domeinController.getDeck() > 16) {
				for (int i = 0; i < domeinController.getSpelers().size()-1; i++) {
					
					System.out.printf("%s is aan de beurt! %n", domeinController.getSpelers().get(i+1).getNaam());
					//Controlleren of deze print werkt, anders foreach lus maken
					for (int a = 0; a < domeinController.getStapels().size(); a++) {
						System.out.print("Stapel " + (a+1) +": " + domeinController.getStapels().get(a).getKaarten());
						System.out.println();
					}
					int kaartOfStapel = 0;
					System.out.print("Wilt u een kaart nemen of een stapel nemen? (1-2): ");
					kaartOfStapel = scannerInt.nextInt();
					
					if (kaartOfStapel == 1) {
						domeinController.neemKaart();
						boolean loop = false;
						while (!loop) {
							System.out.printf("Op welke stapel wilt u de kaart (%s) leggen? %s: ",domeinController.getInHand(), domeinController.aantalStapelsToString());
							int stapelNRtwee = scannerInt.nextInt();
							System.out.println();
							
							
							
							if (domeinController.getStapels().get(stapelNRtwee).isFull()==true)
								System.out.println("Deze stapel zit helaas al vol.");
							else {
								domeinController.plaatsKaartOpStapel(stapelNRtwee, domeinController.getInHand());
								loop = true;
							}
							/*if (domeinController.stapelIsFull(stapelNRtwee) == true) {
								System.out.println("Deze stapel zit helaas al vol.");
							} else {
								domeinController.plaatsKaartOpStapel(stapelNRtwee, domeinController.getInHand());
								loop = true;
							}*/
						}				
					} else if (kaartOfStapel == 2) {
						System.out.printf("Op welke stapel wilt u de kaart (%s) leggen? %s: ",domeinController.getInHand(), domeinController.aantalStapelsToString());
						int stapelNRtwee = scannerInt.nextInt();
						System.out.println();
						domeinController.stapelNemen(i, stapelNRtwee);
					}
					
				}
				
			} else {
				System.out.println("Dit is de laatste ronde!");
				System.out.print(domeinController.getStapels());
				System.out.print("Wilt u een kaart nemen of een stapel nemen? (1-2): ");
				System.out.println();
				int kaartOfSTapel = 0;
				if (kaartOfSTapel == 1) {
					domeinController.neemKaart();
					for (int x = 0; x < domeinController.getStapels().size(); x++) {
						System.out.print(domeinController.getStapels().get(x).getKaarten());
						System.out.println();
					}
					boolean loop2 = false;
					while (!loop2) {
						System.out.printf("Op welke stapel wilt u de kaart (%s) leggen? %s: ",domeinController.getInHand(), domeinController.aantalStapelsToString());
						int stapelNRtwee = scannerInt.nextInt();
						System.out.println();
						if (domeinController.stapelIsFull(stapelNRtwee) == true) {
							System.out.println("Deze stapel zit helaas al vol.");
						} else {
							domeinController.plaatsKaartOpStapel(stapelNRtwee, domeinController.getInHand());
							loop2 = true;
						}
					}		
				} else if (kaartOfSTapel == 2) {
					for (int x = 0; x < domeinController.getStapels().size(); x++) {
						System.out.print(domeinController.getStapels().get(x).getKaarten());
					}
					System.out.printf("Op welke stapel wilt u de kaart (%s) leggen? %s: ",domeinController.getInHand(), domeinController.aantalStapelsToString());
					int stapelNRtwee = scannerInt.nextInt();
					System.out.println();
					
					int laatsteSpeler = domeinController.getSpelers().size();
					domeinController.stapelNemen(laatsteSpeler, stapelNRtwee);
				}
				
				
				rondeStatus = false;
			}
		}
		for (int i = 0; i < domeinController.getSpelers().size(); i++) {
			System.out.print("Speler " + domeinController.getSpelers().get(i).getNaam() + "Heeft " + domeinController.aantalJokers(domeinController.getSpelers().get(i)) + "Jokers");
			for (int z = 0; z < domeinController.aantalJokers(domeinController.getSpelers().get(i)); z++) {
				System.out.println("Welk kleur wilt u deze Joker geven?");
				String kleur = scannerString.nextLine();
				domeinController.assignJoker(domeinController.getSpelers().get(i), kleur);
				System.out.println();
			}
		}		
		
		//van groot naar klein sorteren :(
		for (int j = 0; j < domeinController.getSpelers().size(); j++) {
			domeinController.scoreBerekenen(domeinController.getSpelers().get(j));
		}
		
		scannerInt.close();
		scannerString.close();
	}	
}
