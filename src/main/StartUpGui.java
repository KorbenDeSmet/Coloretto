package main;

import gui.WelkomScherm;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartUpGui extends Application{
    @Override
    public void start(Stage stage) {
    	WelkomScherm welkom = new WelkomScherm();
        Scene scene = new Scene(welkom, 750, 400);
        stage.setTitle("Coloretto");
        stage.setScene(scene);
        stage.setMaximized(false);
        stage.show();
    }
    
    public static void main(String[] args){
        launch(args);
    }
}
