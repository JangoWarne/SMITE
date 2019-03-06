package uk.ac.glos.ct5057.assignment.s1609415;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This class extends application
 * it launches the SMITE application
 * it loads the Screen.fxml scene
 *
 * @author  Joshua Walker
 * @version 1.0
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        Parent mainScene = FXMLLoader.load(getClass().getResource("/ui/Screen.fxml"));
        stage.setTitle("Shipping Management In a Terrestrial Environment");
        stage.setResizable(false);
        stage.setScene(new Scene(mainScene, 1400, 1000));
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
