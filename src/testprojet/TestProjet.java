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
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Cedric
 */
public class TestProjet extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        //TestAffichageMonde(stage);
        TestAffichageMenu(stage);//Pour lancer le test du menu
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);       
    }
    
    
    private void TestAffichageMonde(Stage stage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("FenetreChoixDieu.fxml"));
        //////////////////TEST Code///////////////////////////
        Monde m = new Monde(100);
        for(Case[] c : m.getDamier())
        {
            for(Case c2 : c)
            {
                if(c2==null)
                    continue;
                if (c2.getId() == 9)
                    c2.setPopulation(new Population("Humain des montagnes", 2, new Dieu("MontagneMan","Montagne", 0.8f, 1.f, 1.5f, 1.f), new Race("Humain", 1.f, 1.5f), c2));
                if (c2.getId()==8)
                    c2.setPopulation(new Population("Gnome", 2, new Dieu("Jean Patrik","Cavernes", 1f, 0.8f, 1.f, 1.f, Color.BLUE), new Race("Humain", 1.f, 1.5f), c2));
            }
        }
        GestionnaireDeMondeCaseParCase g = new GestionnaireDeMondeCaseParCase(m, 100);
        FXMLLoader fxmlLoader = new FXMLLoader();
        FXMLDocumentController controller = new FXMLDocumentController(g);
        fxmlLoader.setController(controller);
        fxmlLoader.setLocation(getClass().getResource("FXMLDocument.fxml"));
        Parent root = fxmlLoader.load();
        /////////////////End TEST Code////////////////////////
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        
        //Test a supprimer:
        g.LancerPartie();
    }
    
    private void TestAffichageMenu(Stage stage) throws Exception {
        
    }
    
    private static void test() {
        
        int tour=1;
        Monde alpha = new Monde(28);
        Case c = new Case(alpha, 1);
        FabriqueTerrain.ajouterTerrain("Montagne", 0.9f, 1.2f);
        c.setTerrain(FabriqueTerrain.fabriquerTerrain("Montagne"));
        Population[] pops = {new Population("Humain des montagnes", 2, new Dieu("MontagneMan","Montagne", 0.8f, 1.f, 1.5f, 1.f), new Race("Humain", 1.f, 1.5f), c),
                             new Population("Gnome des plaines", 2,new Dieu("PlaineMan","Montagne", 1.5f, 1.f, 0.8f, 1.f), new Race("Gnome", 1.2f, 1.f), c)};
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
        alpha.showDamier();
        Case beta = new Case(alpha,7);
        System.out.println("\ntest trouver voisin de la case "+beta.getId()+"");
        beta.showVoisin();
    }
}