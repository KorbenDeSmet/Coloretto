package gui;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class WelkomScherm extends GridPane {
	private Hoofdpaneel hoofdpaneel;
	
	public WelkomScherm (Hoofdpaneel hoofdpaneel) {
		this.hoofdpaneel = hoofdpaneel;
		Label lblwelkom = new Label("Welkom bij Coloretto, voer de namen in van de spelers!");
		super.add(lblwelkom, 3, 1);
		Label lblNaam1 = new Label("Naam 1:");
		super.add(lblNaam1, 1, 3);
		TextField txtNaam1 = new TextField();
		super.add(txtNaam1, 2, 3);
		
		Label lblNaam2 = new Label("Naam 2:");
		super.add(lblNaam2, 1, 4);
		TextField txtNaam2 = new TextField();
		super.add(txtNaam2, 2, 4);
		
		Label lblNaam3 = new Label("Naam 3:");
		super.add(lblNaam3, 1, 5);
		TextField txtNaam3 = new TextField();
		super.add(txtNaam3, 2, 5);
		
		Label lblNaam4 = new Label("Naam 4:");
		super.add(lblNaam4, 1, 6);
		TextField txtNaam4 = new TextField();
		super.add(txtNaam4, 2, 6);
		
		Label lblNaam5 = new Label("Naam 5:");
		super.add(lblNaam5, 1, 7);
		TextField txtNaam5 = new TextField();
		super.add(txtNaam5, 2, 7);
		Label lblOptioneel = new Label("(optioneel)");
		super.add(lblOptioneel, 3, 7);
		
		Button btnSubmit = new Button("Volgende");
		super.add(btnSubmit, 1, 9);		
		btnSubmit.setOnAction(this::toonSpel);
	}	
    private void toonSpel(ActionEvent event) {
        hoofdpaneel.toonSpel();
    }
	
}
