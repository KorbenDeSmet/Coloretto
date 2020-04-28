/*package main;

import domein.Spel;
import gui.WelkomScherm;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartUpGui extends Application{
    @Override
    public void start(Stage stage) {
    	WelkomScherm welkom = new WelkomScherm();
        Scene scene = new Scene(welkom);
        stage.setTitle("Coloretto");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }
    
    public static void main(String[] args){
        launch(args);
    }
}
*/

package main;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import gui.WelkomScherm;

public class StartUpGui extends Application {
	@Override
	public void start(Stage Stage) {
		WelkomScherm welkom = new WelkomScherm();
		Scene scene = new Scene(welkom, 500,300);
		//scene.getStylesheets().add(getClass().getResource("/css/main.css").toExternalForm());
		Stage.setScene(scene);
		Stage.setMaximized(true);
		Stage.setTitle("Coloretto");
		Stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
*/