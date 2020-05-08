package gui;


import domein.DomeinController;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class Hoofdpaneel extends GridPane {
	DomeinController domeinController = new DomeinController();
	
	private WelkomScherm ws = new WelkomScherm(this);
	private Spel spel = new Spel(this);
	
	private Button btnStart;
	
	public Hoofdpaneel() {
		super.setPadding(new Insets(10, 10, 10, 10));
		super.setVgap(5);
		super.setHgap(5);	
		
		btnStart = new Button("Start spel!");
		super.add(btnStart, 1, 1);
		btnStart.setOnAction(this::toonWelkomScherm);
	}	
	
	public void toonWelkomScherm(ActionEvent event) {
		getChildren().remove(btnStart);
		getChildren().add(ws);
	}
	
	public void toonSpel() {
		getChildren().remove(ws);
		getChildren().add(spel);
	}
}
