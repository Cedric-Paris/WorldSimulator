package vue;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import metier.AfficheurMonde;
import metier.Dieu;
import metier.GestionnaireDeMonde;
import metier.Observable;
import metier.Observer;

/**
 *
 * @author Cedric
 */
public class FenetreJeuController implements Initializable, Observer {
    
    @FXML
    private GridPane gpLegende;
    
    @FXML
    private Canvas canevas;
    
    @FXML
    private GridPane gpCanevas;
    
    private List<Label> labelsDieux = new ArrayList<>();
    
    private GestionnaireDeMonde gestionnaire;
    private List<Dieu> dieux;
    
    
    public FenetreJeuController(GestionnaireDeMonde gestionnaire, List<Dieu> dieux)
    {
        gestionnaire.enregistrer(this);
        this.gestionnaire = gestionnaire;
        this.dieux = dieux;
    }
    
    @Override
    public void mettreAJour(Observable obj, Object param)
    {
        Platform.runLater(new Runnable() {//Necessaire car snapshot ne peut être appelé que si on est dans le javafx thread
            @Override
            public void run() { 
                AfficheurMonde.drawMonde(gestionnaire.getMonde().getDamier(), canevas, gestionnaire.getMonde().getHauteurLogique(), gestionnaire.getMonde().getLargeurLogique());
            }
        });
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mettreAJour(null, null);
        canevas.widthProperty().bind(gpCanevas.widthProperty());
        canevas.heightProperty().bind(gpCanevas.heightProperty());
        
        setLegendes();
        
        for (int i=0; i<dieux.size(); i++)
        {
            labelsDieux.get(i).setText(dieux.get(i).getNom().split(",")[0]);
            labelsDieux.get(i).setTextFill(dieux.get(i).getCouleur());
        }
    }
    
    
    private void setLegendes()
    {
        Label currentLabel = new Label();
        for (int i=0; i<dieux.size(); i++)
        {
            currentLabel.setAlignment(Pos.CENTER);
            labelsDieux.add(currentLabel);
            if (i != 0)
            {
                gpLegende.addColumn(i);
                gpLegende.getColumnConstraints().add(new ColumnConstraints(10.0, 100.0, Double.POSITIVE_INFINITY, Priority.SOMETIMES, HPos.CENTER, true));
            }
            gpLegende.add(currentLabel, i, 0);
            currentLabel = new Label();
        }
    }
}