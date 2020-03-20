package ui;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

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
		Random randomGenerator = new Random();
		//0- aantal in nextint(x - 1)
		int startSpeler = randomGenerator.nextInt(domeinController.getLijstVanSpelers().size());
		System.out.printf("De Beginnende speler is %s", domeinController.getLijstVanSpelers().get(startSpeler).getNaam());
		
		//zeker zijn dat er een true waarde aan de boolean wordt gegeven als er minder dan x aantal kaarten in het deck zitten
		boolean rondeStatus = false;
		boolean alleSpelersZijnGeweest = false;
		while (!rondeStatus) {
			if (domeinController.getDeck() > 16) {
				while (!alleSpelersZijnGeweest) {
					
				}
				
				
				
			} else {
				System.out.println("Dit is de laatste ronde!");
				
				
				
			}
			
		}
		
		//for lus schrijven om alle spelers automatisch af te drukken
		//en van groot naar klein :(
		//domeinController.scoreBerekenen(speler);
		
		scanner.close();
	}	
}
