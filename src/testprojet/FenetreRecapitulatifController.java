/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testprojet;

import java.net.URL;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nawhal
 */
public class FenetreRecapitulatifController implements Initializable {

    private HashMap<Terrain, Integer> terrains;
        public HashMap<Terrain, Integer> getTerrains() { return terrains; }
        public void setTerrains(HashMap<Terrain, Integer> d)
        {
            terrains = d;
            setLabelsTerrains();
        }
    private List<Dieu> dieux;
        public List<Dieu> getDieux() { return dieux; }
        public void setDieux(List<Dieu> l)
        { 
            dieux = l;
            setLabelDieux();
        }
    
    @FXML
    private Label lbDieux;
    @FXML
    private Label lbPlaine;
    @FXML
    private Label lbMontagne;
    @FXML
    private Label lbDesert;
    @FXML
    private Label lbCote;
    @FXML
    private Label lbForet;
    @FXML
    private Label lbTundra;
        
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
    }

    private void setLabelsTerrains() {
        lbPlaine.textProperty().set("Plaine x " + terrains.get(FabriqueTerrain.fabriquerTerrain("Plaine")));
        lbMontagne.textProperty().set("Montagne x " + terrains.get(FabriqueTerrain.fabriquerTerrain("Montagne")));
        lbDesert.textProperty().set("Désert x " + terrains.get(FabriqueTerrain.fabriquerTerrain("Désert")));
        lbCote.textProperty().set("Côte x " + terrains.get(FabriqueTerrain.fabriquerTerrain("Côte")));
        lbForet.textProperty().set("Forêt x " + terrains.get(FabriqueTerrain.fabriquerTerrain("Forêt")));
        lbTundra.textProperty().set("Forêt x " + terrains.get(FabriqueTerrain.fabriquerTerrain("Forêt")));
    }
    
    private void setLabelDieux()
    {
        String texte = "Dieux choisis : ";
        for (int i=0; i<dieux.size(); i++)
        {
            texte += dieux.get(i).getNom() + "(" + dieux.get(i).getTerrainPredilection() + ")";
            if (i != dieux.size()-1)
                texte += ", ";
        }
        lbDieux.textProperty().set(texte);
    }
    
    @FXML
    protected void handleButtonRecommencer(ActionEvent event) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("FenetreChoixDieu.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    
    @FXML
    protected void handleButtonValider(ActionEvent event) throws Exception
    {
        Monde m = new Monde(10);
        for(Case[] c : m.getDamier())
        {
            for(Case c2 : c)
            {
                if(c2==null)
                    continue;
                if (c2.getId() == 8)
                    c2.setPopulation(new Population("Humain des montagnes", 2, new Dieu("MontagneMan","Montagne", 0.8f, 1.f, 1.2f, 1.f), new Race("Humain", 1.f, 1.5f), c2));
                if (c2.getId()==2)
                    c2.setPopulation(new Population("Gnome", 2, new Dieu("Jean Patrik","Cavernes", 1.9f, 0.8f, 0.8f, 1.f, Color.BLUE), new Race("Humain", 1.f, 1.5f), c2));
                if (c2.getId()==6)
                    c2.setPopulation(new Population("jambon", 2, new Dieu("jean mahmoud","Cavernes", 1.1f, 0.8f, 1.f, 1.2f, Color.RED), new Race("Humain", 1.f, 1.5f), c2));
            }
        }
        GestionnaireDeMondeCaseParCase g = new GestionnaireDeMondeCaseParCase(m, 100);
        FXMLLoader fxmlLoader = new FXMLLoader();
        FenetreJeuController controller = new FenetreJeuController(g);
        fxmlLoader.setController(controller);
        fxmlLoader.setLocation(getClass().getResource("FenetreJeu.fxml"));
        Parent root = fxmlLoader.load();
        /////////////////End TEST Code////////////////////////
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        
        //Test a supprimer:
        g.LancerPartie();

        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    
    @FXML
    protected void handleButtonRetour(ActionEvent event) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("FenetreChoixTerrain.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    
    @FXML
    protected void handleButtonMenu(ActionEvent event) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("FenetrePrincipale.fxml"));
        Stage stage = new Stage();
        root.setStyle("-fx-background-image: url('/Design/Labelas.jpg');"
                + "-fx-background-size: cover;"
                + "-fx-background-repeat : no-repeat;");
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();

        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
}
