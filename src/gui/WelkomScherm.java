package gui;

import java.util.ArrayList;
import java.util.List;
import domein.DomeinController;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class WelkomScherm extends GridPane {
	
	private Hoofdpaneel hoofdpaneel;
	private List<String> spelers = new ArrayList<String>();
	private TextField txtNaam1;
	private TextField txtNaam2;
	private TextField txtNaam3;
	private TextField txtNaam4;
	private TextField txtNaam5;
	private Boolean vijfdeSpeler = false;
	
	
	public WelkomScherm (Hoofdpaneel hoofdpaneel) {
		this.hoofdpaneel = hoofdpaneel;
		Label lblNaam1 = new Label("Naam 1:");
		super.add(lblNaam1, 1, 3);
		txtNaam1 = new TextField();
		super.add(txtNaam1, 2, 3);
		
		Label lblNaam2 = new Label("Naam 2:");
		super.add(lblNaam2, 1, 4);
		txtNaam2 = new TextField();
		super.add(txtNaam2, 2, 4);
		
		Label lblNaam3 = new Label("Naam 3:");
		super.add(lblNaam3, 1, 5);
		txtNaam3 = new TextField();
		super.add(txtNaam3, 2, 5);
		
		Label lblNaam4 = new Label("Naam 4:");
		super.add(lblNaam4, 1, 6);
		txtNaam4 = new TextField();
		super.add(txtNaam4, 2, 6);
		
		Label lblNaam5 = new Label("Naam 5:");
		super.add(lblNaam5, 1, 7);
		txtNaam5 = new TextField();
		super.add(txtNaam5, 2, 7);
		Label lblOptioneel = new Label("(optioneel)");
		super.add(lblOptioneel, 3, 7);
		
		Button btnSubmit = new Button("Volgende");
		super.add(btnSubmit, 1, 9);		
		btnSubmit.setOnAction(this::toonSpel);
	}	
	
    private void toonSpel(ActionEvent event) {
    	spelers.add(txtNaam1.getText());
    	spelers.add(txtNaam2.getText());
    	spelers.add(txtNaam3.getText());
    	spelers.add(txtNaam4.getText());
    	if (txtNaam5.getText().isEmpty() == false)
    		{
    		spelers.add(txtNaam5.getText());
    		vijfdeSpeler = true;
    		}
    	hoofdpaneel.dc.spelersToevoegen(spelers);
    	hoofdpaneel.dc.spelersStartInventoryGeven();
    	hoofdpaneel.dc.stapelsAanmaken();
    	hoofdpaneel.dc.shuffleLijstVanSpelers();
    	
        hoofdpaneel.toonSpel();
    }
	
}