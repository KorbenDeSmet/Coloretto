package domein;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Kaart {
	private String kleur;
	private static final List<String> KLEURENLIJST = new ArrayList<>(
			Arrays.asList("Rood", "Paars", "Blauw", "Groen", "Bruin", "Oranje", "Geel", "+2", "Joker")
	);
	
	public Kaart(String kleur) {
		setKleur(kleur);
	}

	public String getKleur() {
		return kleur;
	}

	public void setKleur(String kleur) {
		if (KLEURENLIJST.contains(kleur))
			this.kleur = kleur;
		else
			throw new IllegalArgumentException("Foute invoer!");
	}
	
	@Override
	public String toString() {
			return this.kleur;
	}
}
