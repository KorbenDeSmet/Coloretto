package gui;


import domein.DomeinController;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.GridPane;

public class WelkomScherm extends GridPane {
	DomeinController domeinController = new DomeinController();
	public WelkomScherm () {
		
		Label lblwelkom = new Label("welkom bij javafx");
		super.add(lblwelkom, 1, 1);
			
		//menubar maken 
		
		 MenuBar menuBar = new MenuBar ();
		 Menu fileMenu = new Menu("menu");
		 MenuItem infoMenuItem = new MenuItem("info");
		 MenuItem highScoreMenuItem = new MenuItem("highscore");
		 MenuItem exitMenuItem = new MenuItem("exit");
		 exitMenuItem.setAccelerator(KeyCombination.keyCombination("Ctrl+x"));
		 
		 fileMenu.getItems().addAll(infoMenuItem, new SeparatorMenuItem(),highScoreMenuItem, new SeparatorMenuItem(),  exitMenuItem);
		 menuBar.getMenus().add(fileMenu);
		 
		 //infoMenuItem.setOnAction(this::aboutClicked);
		 super.getChildren().addAll();
		 exitMenuItem.setOnAction( new EventHandler<ActionEvent>() {
			 @Override
			 public void handle(ActionEvent e) {
				 Platform.exit();
			 } 	 
		 });
				
			/*toolbar
		 	
		 Button btnRed = new Button("with");
		 Button btnGreen = new Button("green"); 
		 Button btnBlue = new Button("blue"); 
		 Button btnBlack = new Button("black");
		 ToolBar tooolBar = new ToolBar( new Label("background color")
				 				,btnRed,btnGreen,btnBlue,btnBlack);
		 toolBar.setOrientation(Orientation.HORIZONTAL);
			*/	 
		 
	
		
	}	
	
}
