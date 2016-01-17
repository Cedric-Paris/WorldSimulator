/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    private void GoToNewGame(ActionEvent event) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("FenetreChoixDieu.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    
    @FXML
    private void GoToCredit(ActionEvent event)
    {
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
    }    
    
}
