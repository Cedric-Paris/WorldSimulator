package testprojet;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
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
    
    private MondeInfos infosMonde;
    
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
    
    public FenetreChoixTerrainController(MondeInfos infosMonde)
    {
        this.infosMonde = infosMonde;
    }
    
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
    
    private void initializeSpinners()
    {
        for (int i=0; i<spTerrains.size(); i++)
        {
            spTerrains.get(i).setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 20, 5, 1));
        }
        setSpinnersToInfosMonde();
    }
    
    private void setSpinnersToInfosMonde()
    {
        spTerrains.get(0).getValueFactory().setValue(infosMonde.getTerrains().get(FabriqueTerrain.fabriquerTerrain("Plaine")));
        spTerrains.get(1).getValueFactory().setValue(infosMonde.getTerrains().get(FabriqueTerrain.fabriquerTerrain("Montagne")));
        spTerrains.get(2).getValueFactory().setValue(infosMonde.getTerrains().get(FabriqueTerrain.fabriquerTerrain("Désert")));
        spTerrains.get(3).getValueFactory().setValue(infosMonde.getTerrains().get(FabriqueTerrain.fabriquerTerrain("Côte")));
        spTerrains.get(4).getValueFactory().setValue(infosMonde.getTerrains().get(FabriqueTerrain.fabriquerTerrain("Forêt")));
        spTerrains.get(5).getValueFactory().setValue(infosMonde.getTerrains().get(FabriqueTerrain.fabriquerTerrain("Tundra")));
    }
    
    private void setInfosMondeToSpinner()
    {
        infosMonde.getTerrains().clear();
        
        infosMonde.getTerrains().put(FabriqueTerrain.fabriquerTerrain("Plaine"), (Integer) spTerrains.get(0).getValue());
        infosMonde.getTerrains().put(FabriqueTerrain.fabriquerTerrain("Montagne"), (Integer) spTerrains.get(1).getValue());
        infosMonde.getTerrains().put(FabriqueTerrain.fabriquerTerrain("Désert"), (Integer) spTerrains.get(2).getValue());
        infosMonde.getTerrains().put(FabriqueTerrain.fabriquerTerrain("Côte"), (Integer) spTerrains.get(3).getValue());
        infosMonde.getTerrains().put(FabriqueTerrain.fabriquerTerrain("Forêt"), (Integer) spTerrains.get(4).getValue());
        infosMonde.getTerrains().put(FabriqueTerrain.fabriquerTerrain("Tundra"), (Integer) spTerrains.get(5).getValue());
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
        int nombreCases = 0;
        
        nombreCases += (int) spTerrains.get(0).getValue();
        nombreCases += (int) spTerrains.get(1).getValue();
        nombreCases += (int) spTerrains.get(2).getValue();
        nombreCases += (int) spTerrains.get(3).getValue();
        nombreCases += (int) spTerrains.get(4).getValue();
        nombreCases += (int) spTerrains.get(5).getValue();
        
        if (nombreCases <= 0)
            return;
        
        setInfosMondeToSpinner();
        
        FXMLLoader fxmlLoader = new FXMLLoader();
        FenetreRecapitulatifController controller = new FenetreRecapitulatifController(infosMonde);
        fxmlLoader.setController(controller);
        fxmlLoader.setLocation(getClass().getResource("FenetreRecapitulatif.fxml"));
        
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    
    @FXML
    protected void handleButtonRetour(ActionEvent event) throws Exception
    {
        setInfosMondeToSpinner();
        
        FXMLLoader fxmlLoader = new FXMLLoader();
        FenetreChoixDieuController controller = new FenetreChoixDieuController(MondeInfos.listeDieux());
        fxmlLoader.setController(controller);
        fxmlLoader.setLocation(getClass().getResource("FenetreChoixDieu.fxml"));
        
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        controller.setInfosMonde(infosMonde);

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