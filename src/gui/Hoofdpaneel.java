package gui;


import domein.DomeinController;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class Hoofdpaneel extends GridPane {
	DomeinController domeinController = new DomeinController();
	
	private WelkomScherm ws = new WelkomScherm(this);
	private Spel spel = new Spel(this);
	
	private Label lblWelkom;
	private Button btnStart;
	
	public Hoofdpaneel() {
		domeinController.startSpel();
		super.setPadding(new Insets(10, 10, 10, 10));
		super.setVgap(5);
		super.setHgap(5);	
		super.setAlignment(Pos.CENTER); 
		
		lblWelkom = new Label("Welkom bij Coloretto!");
		super.add(lblWelkom, 1, 1);
		
		btnStart = new Button("Nieuw spel starten!");
		super.add(btnStart, 1, 2);
		btnStart.setOnAction(this::toonWelkomScherm);
	}	
	
	public void toonWelkomScherm(ActionEvent event) {
		getChildren().remove(lblWelkom);
		getChildren().remove(btnStart);
		getChildren().add(ws);
	}
	
	public void toonSpel() {
		getChildren().remove(ws);
		getChildren().add(spel);
	}
}
