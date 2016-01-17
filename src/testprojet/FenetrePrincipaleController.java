package testprojet;

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
 * @author Laurent
 */
public class FenetrePrincipaleController implements Initializable {

    @FXML
    protected void GoToNewGame(ActionEvent event) throws Exception
    {
        FXMLLoader fxmlLoader = new FXMLLoader();
        FenetreChoixDieuController controller = new FenetreChoixDieuController(MondeInfos.listeDieux());
        fxmlLoader.setController(controller);
        fxmlLoader.setLocation(getClass().getResource("FenetreChoixDieu.fxml"));
        
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    
    @FXML
    protected void GoToCredit(ActionEvent event)
    {
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        FabriqueTerrain.ajouterTerrain("Plaine", 1.2f, 1f);
        FabriqueTerrain.ajouterTerrain("Montagne", 0.9f, 1.3f);
        FabriqueTerrain.ajouterTerrain("Désert", 0.9f, 0.9f);
        FabriqueTerrain.ajouterTerrain("Côte", 1.3f, 1f);
        FabriqueTerrain.ajouterTerrain("Forêt", 1.1f, 1.3f);
        FabriqueTerrain.ajouterTerrain("Tundra", 0.9f, 1f);
    }
    
}
