package testprojet;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;

/**
 *
 * @author Cedric
 */
public class FenetreJeuController implements Initializable, Observer {
    
    @FXML
    private Canvas canevas;

    private GestionnaireDeMonde gestionnaire;
    
    
    public FenetreJeuController(GestionnaireDeMonde gestionnaire)
    {
        gestionnaire.enregistrer(this);
        this.gestionnaire = gestionnaire;
    }
    
    @Override
    public void mettreAJour(Observable obj, Object param)
    {
        System.out.println("Changement");
        Platform.runLater(new Runnable() {//Necessaire car snapshot ne peut être appelé que si on est dans le javafx thread
            @Override
            public void run() { 
                AfficheurMonde.drawMonde(gestionnaire.getMonde().getDamier(), canevas, gestionnaire.getMonde().getHauteurLogique(), gestionnaire.getMonde().getLargeurLogique());
            }
        });
        //AfficheurMonde.drawMonde(gestionnaire.getMonde().getDamier(), canevas, gestionnaire.getMonde().getHauteurLogique(), gestionnaire.getMonde().getLargeurLogique());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mettreAJour(null, null);
    }    
    
}
