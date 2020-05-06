package gui;


import domein.DomeinController;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.GridPane;

public class WelkomScherm extends GridPane {
	DomeinController domeinController = new DomeinController();
	
	
	
	public WelkomScherm () {
		super.setPadding(new Insets(10, 10, 10, 10));
		super.setVgap(5);
		super.setHgap(5);
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
		
		//menubar maken 
		/* MenuBar menuBar = new MenuBar ();
		 Menu fileMenu = new Menu("menu");
		 MenuItem infoMenuItem = new MenuItem("info");
		 MenuItem highScoreMenuItem = new MenuItem("highscore");
		 MenuItem exitMenuItem = new MenuItem("exit");
		 exitMenuItem.setAccelerator(KeyCombination.keyCombination("Ctrl+x"));
		 
		 fileMenu.getItems().addAll(infoMenuItem, new SeparatorMenuItem(),highScoreMenuItem, new SeparatorMenuItem(),  exitMenuItem);
		 menuBar.getMenus().add(fileMenu);
		 
		 //infoMenuItem.setOnAction(this::infoClicked);
		 exitMenuItem.setOnAction( new EventHandler<ActionEvent>() {
			 @Override
			 public void handle(ActionEvent e) {
				 Platform.exit();
			 } 	 
		 });
		 this.getChildren().add(menuBar);*/
						
	}	
	
}
