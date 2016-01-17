package testprojet;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nawhal
 */
public class FenetreChoixTerrainController implements Initializable {
    
    private HashMap<Terrain, Integer> terrains = new HashMap<>();
    
    @FXML
    private Spinner<Integer> spTerrain0;
    @FXML
    private Spinner<Integer> spTerrain1;
    @FXML
    private Spinner<Integer> spTerrain2;
    @FXML
    private Spinner<Integer> spTerrain3;
    @FXML
    private Spinner<Integer> spTerrain4;
    @FXML
    private Spinner<Integer> spTerrain5;
    
    private final List<Spinner> spTerrains = new ArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        spTerrains.add(0, spTerrain0);
        spTerrains.add(1, spTerrain1);
        spTerrains.add(2, spTerrain2);
        spTerrains.add(3, spTerrain3);
        spTerrains.add(4, spTerrain4);
        spTerrains.add(5, spTerrain5);
        initializeSpinners();
    }
    
    private void test()
    {
        List<Terrain> l = new LinkedList<>();
        FabriqueTerrain.ajouterTerrain("Plaine", 1.2f, 1f);
        FabriqueTerrain.ajouterTerrain("Montagne", 0.9f, 1.3f);
        FabriqueTerrain.ajouterTerrain("Désert", 0.9f, 0.9f);
        FabriqueTerrain.ajouterTerrain("Côte", 1.3f, 1f);
        FabriqueTerrain.ajouterTerrain("Forêt", 1.1f, 1.3f);
        FabriqueTerrain.ajouterTerrain("Tundra", 0.9f, 1f);
        l.add(FabriqueTerrain.fabriquerTerrain("Plaine"));
        l.add(FabriqueTerrain.fabriquerTerrain("Montagne"));
        l.add(FabriqueTerrain.fabriquerTerrain("Désert"));
        l.add(FabriqueTerrain.fabriquerTerrain("Côte"));
        l.add(FabriqueTerrain.fabriquerTerrain("Forêt"));
        l.add(FabriqueTerrain.fabriquerTerrain("Tundra"));
    }
    
    private void initializeSpinners()
    {
        for (int i=0; i<spTerrains.size(); i++)
        {
            spTerrains.get(i).setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 20, 5, 1));
        }
    }
    
    @FXML
    protected void handleButtonReinitialiser(ActionEvent event)
    {
        initializeSpinners();
    }
    
    @FXML
    protected void handleButtonAleatoire(ActionEvent event)
    {
        Random generateurDeNombresAleatoires = new Random();
        for (int i=0; i<6; i++)
        {
            spTerrains.get(i).getValueFactory().setValue(generateurDeNombresAleatoires.nextInt(15));
        }
    }
    
    @FXML
    protected void handleButtonValider(ActionEvent event) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("FenetreRecapitulatif.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        
        terrains.put(FabriqueTerrain.fabriquerTerrain("Plaine"), (Integer) spTerrains.get(0).getValueFactory().getValue());
        terrains.put(FabriqueTerrain.fabriquerTerrain("Montagne"), (Integer) spTerrains.get(1).getValueFactory().getValue());
        terrains.put(FabriqueTerrain.fabriquerTerrain("Désert"), (Integer) spTerrains.get(2).getValueFactory().getValue());
        terrains.put(FabriqueTerrain.fabriquerTerrain("Côte"), (Integer) spTerrains.get(3).getValueFactory().getValue());
        terrains.put(FabriqueTerrain.fabriquerTerrain("Forêt"), (Integer) spTerrains.get(4).getValueFactory().getValue());
        terrains.put(FabriqueTerrain.fabriquerTerrain("Tundra"), (Integer) spTerrains.get(5).getValueFactory().getValue());
        
        //qqc.terrains = terrains;
        
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    
    @FXML
    protected void handleButtonRetour(ActionEvent event) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("FenetreChoixDieu.fxml"));
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