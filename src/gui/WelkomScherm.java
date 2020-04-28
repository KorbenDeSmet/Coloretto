package gui;


import javafx.application.Platform;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import domein.DomeinController;

public class WelkomScherm extends Pane {
	//DomeinController domeinController = new DomeinController();
	public WelkomScherm () {
		
		Label lblwelkom = new Label("welkom bij javafx");
		
		//	menubar maken 
		
		 MenuBar menubar = new MenuBar ();
		 Menu filemenu = new Menu("menu");
		 MenuItem infoMenuItem = new MenuItem("info");
		 MenuItem highscoreMenuItem = new MenuItem("highscore");
		 MenuItem exitMenuItem = new MenuItem("exit");
		 aboutMenuItem.setOnAction(this::aboutClicked);
		 exitMenuItem.setOnAction( new EventHandler<ActionEvent>() {
			 @Override
			 public void handle(ActionEvent e) {
				 Platform.exit();
			 } 	 
		 } ) ;
				
			//toolbar
		 	
		 Button btnRed = new Button("with");
		 Button btnGreen = new Button("green"); 
		 Button btnBlue = new Button("blue"); 
		 Button btnBlack = new Button("black");
		 ToolBar tooolBar = new ToolBar( new Label("background color")
				 				,btnRed,btnGreen,btnBlue,btnBlack);
		 toolBar.setOrientation(Orientation.HORIZONTAL);
				 
		 
	
		
	}	
	
}
