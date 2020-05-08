package main;

import gui.Hoofdpaneel;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartUpGui extends Application{
    @Override
    public void start(Stage stage) {
    	Hoofdpaneel root = new Hoofdpaneel();
        Scene scene = new Scene(root, 750, 400);
        stage.setTitle("Coloretto");
        stage.setScene(scene);
        stage.setMaximized(false);
        stage.show();
    }
    
    public static void main(String[] args){
        launch(args);
    }
}
