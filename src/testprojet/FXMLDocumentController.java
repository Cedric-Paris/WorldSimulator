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
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

/**
 *
 * @author Cedric
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Canvas canevas;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        Hexagon.draw(canevas, 100, 100, 100, 200, Color.BLUE, 0.8);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Hexagon.draw(canevas, 100, 100, 100, 200, Color.RED);
    }    
    
}
