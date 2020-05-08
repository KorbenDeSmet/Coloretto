package gui;
import java.util.HashMap;
import java.util.Map;
import domein.*;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;


public class Spel extends GridPane{

	DomeinController domeinController = new DomeinController();
	private Hoofdpaneel hoofdpaneel;

	//alle fotos aan de bepaalde kaartnaam mappen 
	private static final Map<String, Image> kaarten = new HashMap<String, Image>();
	
	public Spel (Hoofdpaneel hoofdpaneel) {
		this.hoofdpaneel = hoofdpaneel;

		kaarten.put("+2", new Image(getClass().getResourceAsStream("/fotos/+2.GIF")));
		kaarten.put("blauw", new Image(getClass().getResourceAsStream("/fotos/blauw.GIF")));
		kaarten.put("bruin", new Image(getClass().getResourceAsStream("/fotos/bruin.GIF")));
		kaarten.put("geel", new Image(getClass().getResourceAsStream("/fotos/geel.GIF")));
		kaarten.put("groen", new Image(getClass().getResourceAsStream("/fotos/groen.GIF")));
		kaarten.put("joker", new Image(getClass().getResourceAsStream("/fotos/joker.GIF")));
		kaarten.put("orange", new Image(getClass().getResourceAsStream("/fotos/orange.GIF")));
		kaarten.put("paars", new Image(getClass().getResourceAsStream("/fotos/paars.GIF")));
		kaarten.put("rood", new Image(getClass().getResourceAsStream("/fotos/rood.GIF")));
		
		
		
		/*Label lblSpelerAanDeBeurt = new Label(domeinController.getSpelers().get(0).getNaam());
		super.add(lblSpelerAanDeBeurt, 1, 1);
		String aantalSpelers = Integer.toString(domeinController.getSpelers().size());
		Label lblAantalSpelers = new Label(aantalSpelers);
		super.add(lblAantalSpelers, 2, 1);*/
	}

}
