package worldsimulator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Cedric
 */
public class WorldSimulator extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/vue/FenetrePrincipale.fxml"));
        
        root.setStyle("-fx-background-image: url('/design/Labelas.jpg');"
                + "-fx-background-size: cover;"
                + "-fx-background-repeat : no-repeat;");
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
