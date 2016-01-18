package vue;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nawhal
 */
public class FenetreCreditsController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    /**
     * Appelée lors de l'appui du bouton Menu, cette méthode ramène l'utilisateur au Menu.
     */
    @FXML
    private void handleButtonMenu(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FenetrePrincipale.fxml"));
        Stage stage = new Stage();
        root.setStyle("-fx-background-image: url('/design/Labelas.jpg');"
                + "-fx-background-size: cover;"
                + "-fx-background-repeat : no-repeat;");
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();

        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    
}
