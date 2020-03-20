package ui;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import domein.DomeinController;

public class ColorettoApplicatie {
	
	public static void main(String[] args) {
		// sysout + naamArray werkt perfect	
		DomeinController domeinController = new DomeinController();

		Scanner scanner = new Scanner(System.in);
		
		domeinController.startSpel();
		
		System.out.println("Welkom, met hoeveel willen jullie spelen? (4/5):");
		int aantalSpelers = scanner.nextInt();
		boolean status = false;
		while (!status) {
				if 	(aantalSpelers == 4 || aantalSpelers == 5) {
					status = true;
				} else {
					System.out.println("Sorry, maar dit is geen geldige invoer!");
					System.out.println("Het aantal spelers moet 4 of 5 zijn");
					System.out.println("Met hoeveel willen jullie spelen?:");
					aantalSpelers = scanner.nextInt();
				}
		}
		
		List<String> spelers = new ArrayList<String>();
		for (int i = 0; i < aantalSpelers; i++) 
		{
			System.out.printf("Wat is de naam van speler %d ?:", (i + 1));
			spelers.add(scanner.nextLine());
		}
		
		domeinController.spelersToevoegen(spelers);
		domeinController.spelersStartInventoryGeven();
		
		domeinController.stapelsAanmaken();
		
		//random startspeler
		domeinController.shuffleLijstVanSpelers();
		System.out.printf("De Beginnende speler is %s", domeinController.getLijstVanSpelers().get(0).getNaam());
		
		//zeker zijn dat er een true waarde aan de boolean wordt gegeven als er minder dan x aantal kaarten in het deck zitten
		boolean rondeStatus = false;
		while (!rondeStatus) {
			if (domeinController.getDeck() > 16) {
				for (int i = 0; i < domeinController.getLijstVanSpelers().size(); i++) {
					System.out.print(domeinController.getLijstVanStapels().get(i).getStapel());
				}
				domeinController.neemKaart();
				domeinController.getLijstVanStapels();
				System.out.println("Op welke stapel wilt u de kaart leggen? (1-2-3-4-5)");
				int stapelNR = scanner.nextInt();
				
				domeinController.plaatsKaartOpStapel(stapelNR, domeinController.getInHand());				
				
				for (int i = 0; i < domeinController.getLijstVanSpelers().size()-1; i++) {
					//Controlleren of deze print werkt, anders foreach lus maken
					System.out.print(domeinController.getLijstVanStapels());
					System.out.println("Wilt u een kaart nemen of een stapel nemen? (1-2)");
					int kaartOfSTapel = 0;
					if (kaartOfSTapel == 1) {
						domeinController.neemKaart();
						for (int x = 0; x < domeinController.getLijstVanStapels().size(); x++) {
							System.out.print(domeinController.getLijstVanStapels().get(x).getStapel());
						}
						System.out.println("Op welke stapel wilt u de kaart leggen? (1-2-3-4-5)");
						int stapelNRtwee = scanner.nextInt();

						domeinController.plaatsKaartOpStapel(stapelNRtwee, domeinController.getInHand());				
					} else if (kaartOfSTapel == 2) {
						for (int x = 0; x < domeinController.getLijstVanStapels().size(); x++) {
							System.out.print(domeinController.getLijstVanStapels().get(x).getStapel());
						}
						System.out.println("Welke stapel wilt u nemen? (1-2-3-4-5)");
						int stapelNRtwee = scanner.nextInt();
						domeinController.stapelNemen(i, stapelNRtwee);
					}
					
				}
				
			} else {
				System.out.println("Dit is de laatste ronde!");
				System.out.print(domeinController.getLijstVanStapels());
				System.out.println("Wilt u een kaart nemen of een stapel nemen? (1-2)");
				int kaartOfSTapel = 0;
				if (kaartOfSTapel == 1) {
					domeinController.neemKaart();
					for (int x = 0; x < domeinController.getLijstVanStapels().size(); x++) {
						System.out.print(domeinController.getLijstVanStapels().get(x).getStapel());
					}
					System.out.println("Op welke stapel wilt u de kaart leggen? (1-2-3-4-5)");
					int stapelNRtwee = scanner.nextInt();

					domeinController.plaatsKaartOpStapel(stapelNRtwee, domeinController.getInHand());				
				} else if (kaartOfSTapel == 2) {
					for (int x = 0; x < domeinController.getLijstVanStapels().size(); x++) {
						System.out.print(domeinController.getLijstVanStapels().get(x).getStapel());
					}
					System.out.println("Welke stapel wilt u nemen? (1-2-3-4-5)");
					int stapelNRtwee = scanner.nextInt();
					int laatsteSpeler = domeinController.getLijstVanSpelers().size();
					domeinController.stapelNemen(laatsteSpeler, stapelNRtwee);
				}
				
				
				rondeStatus = false;
			}
		}
		
		//for lus schrijven om alle spelers automatisch af te drukken
		//en van groot naar klein :(
		//domeinController.scoreBerekenen(speler);
		
		scanner.close();
	}	
}
