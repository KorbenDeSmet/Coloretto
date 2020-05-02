package gui;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import domein.*;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import java.util.Map;
import domein.*;
import java.util.ArrayList;
import java.util.List;

public class ingame extends GridPane{

	DomeinController domeinController = new DomeinController();
	
	//alle fotos aan de bepaalde kaartnaam mappen 
	private static final Map<String, Image> kaarten = new HashMap<String, Image>();
	public ingame (List<String> KAARTTYPES) {
		
	
		kaarten.put("+2", new Image(getClass().getResourceAsStream("/fotos/+2.GIF")));
		kaarten.put("blauw", new Image(getClass().getResourceAsStream("/fotos/-blauw.GIF")));
		kaarten.put("bruin", new Image(getClass().getResourceAsStream("/fotos/bruin.GIF")));
		kaarten.put("geel", new Image(getClass().getResourceAsStream("/fotos/geel.GIF")));
		
		kaarten.put("groen", new Image(getClass().getResourceAsStream("/fotos/groen.GIF")));
		kaarten.put("joker", new Image(getClass().getResourceAsStream("/fotos/joker.GIF")));
		kaarten.put("orange", new Image(getClass().getResourceAsStream("/fotos/orange.GIF")));
		kaarten.put("paars", new Image(getClass().getResourceAsStream("/fotos/paars.GIF")));
		kaarten.put("rood", new Image(getClass().getResourceAsStream("/fotos/rood.GIF")));
	}

}
