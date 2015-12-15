/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testprojet;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Cedric
 */
public class TestProjet extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //launch(args);
        int tour=1;
        Population[] pops = {new Population("Humain des montagnes", 2, new Dieu("MontagneMan","Montagne", 0.8f, 1.f, 1.5f, 1.f), new Race("Humain", 1.f, 1.5f)),
                             new Population("Gnome des plaines", 2,new Dieu("PlaineMan","Montagne", 1.5f, 1.f, 0.8f, 1.f), new Race("Gnome", 1.2f, 1.f))};
        System.out.println("Deux pop:\n");
        while(true)
        {
            System.out.println("\nTour n°"+tour);
            for(Population p : pops)
            {
                p.grandir();
                System.out.println("Population du dieu '"+p.getDieuPop().getNom()+"' : "+p.getNombreHabitants()+" unités.");
            }
            tour++;
            if(tour==10) break;
        }
        //test monde
        
        System.out.println("\n\n Test création de monde");
        Monde alpha = new Monde(28);
        Case beta = new Case(alpha,7);
        System.out.println("\ntest trouver voisin de la case "+beta.getId()+"");
        beta.showVoisin();
        
    }
    
}