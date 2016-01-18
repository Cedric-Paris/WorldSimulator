package vue;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import metier.ValeursParDefaut;

/**
 * FXML Controller class
 *
 * @author Laurent
 */
public class FenetrePrincipaleController implements Initializable {

    /**
     * Appelée lors de l'appui du bouton Nouvelle Partie, cette méthode lance la Fenêtre de choix de dieux
     * en lui passant la liste de dieux dans lequel l'utilisateur pourra choisir ses dieux.
     */
    @FXML
    protected void goToNewGame(ActionEvent event) throws Exception
    {
        FXMLLoader fxmlLoader = new FXMLLoader();
        FenetreChoixDieuController controller = new FenetreChoixDieuController(ValeursParDefaut.listeDieux());
        fxmlLoader.setController(controller);
        fxmlLoader.setLocation(getClass().getResource("FenetreChoixDieu.fxml"));
        
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    
    /**
     * Appelée lors de l'appui du bouton Crédits, cette méthode lance la Fenêtre de crédits.
     */
    @FXML
    protected void goToCredit(ActionEvent event) throws Exception
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FenetreCredits.fxml"));
        Parent root = fxmlLoader.load();
        root.setStyle("-fx-background-image: url('/design/Credits.jpg');"
                + "-fx-background-size: cover;"
                + "-fx-background-repeat : no-repeat;");
        
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    
    @FXML
    protected void quit(ActionEvent event)
    {
        Alert alert = new Alert(AlertType.NONE);
        alert.setTitle("Quitter?");
        alert.setContentText("Êtes-vous sûr de vouloir quitter?");
        ButtonType boutonOui = new ButtonType("Oui");
        ButtonType boutonRetour = new ButtonType("Retour");
        alert.getButtonTypes().setAll(boutonOui, boutonRetour);
        
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == boutonOui)
        {
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        ValeursParDefaut.initialiserTerrains();
    }
}
