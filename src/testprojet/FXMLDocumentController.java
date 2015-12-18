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
public class FXMLDocumentController implements Initializable, Observer {
    
    @FXML
    private Canvas canevas;

    private GestionnaireDeMonde gestionnaire;
    
    
    public FXMLDocumentController(GestionnaireDeMonde gestionnaire)
    {
        gestionnaire.enregistrer(this);
        this.gestionnaire = gestionnaire;
    }
    
    @Override
    public void mettreAJour()
    {
        System.out.println("Changement");
        AfficheurMonde.drawMonde(gestionnaire.getMonde().getDamier(), canevas, gestionnaire.getMonde().getHauteurLogique(), gestionnaire.getMonde().getLargeurLogique());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
