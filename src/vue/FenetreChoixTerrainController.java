package vue;

import java.net.URL;
import java.util.ArrayList;
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
import metier.FabriqueTerrain;
import metier.MondeInfos;
import metier.ValeursParDefaut;

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
    
    /**
     * On initialise la liste de spinners, pour pouvoir les modifier plus facilement par la suite, on les initialise et on réinitialise
     * infosMonde afin d'avoir un fonctionnement normal du bouton Réinitialiser.
     */
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
        reinitializeInfosMondeTerrains();
    }
    
    /**
     * Initialise les ValueFactory des Spinners de la Fenêtre.
     */
    private void initializeSpinners()
    {
        for (int i=0; i<spTerrains.size(); i++)
        {
            spTerrains.get(i).setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 20, 5, 1));
        }
        setSpinnersToInfosMonde();
    }
    
    /**
     * Si on a déjà renseigné les nombres de terrains à infosMonde, ces nombres seront rechargés dans les Spinners.
     * Sinon, on charge les valeurs de base des Spinners.
     */
    private void setSpinnersToInfosMonde()
    {
        spTerrains.get(0).getValueFactory().setValue(infosMonde.getTerrains().get(FabriqueTerrain.fabriquerTerrain("Plaine")));
        spTerrains.get(1).getValueFactory().setValue(infosMonde.getTerrains().get(FabriqueTerrain.fabriquerTerrain("Montagne")));
        spTerrains.get(2).getValueFactory().setValue(infosMonde.getTerrains().get(FabriqueTerrain.fabriquerTerrain("Désert")));
        spTerrains.get(3).getValueFactory().setValue(infosMonde.getTerrains().get(FabriqueTerrain.fabriquerTerrain("Côte")));
        spTerrains.get(4).getValueFactory().setValue(infosMonde.getTerrains().get(FabriqueTerrain.fabriquerTerrain("Forêt")));
        spTerrains.get(5).getValueFactory().setValue(infosMonde.getTerrains().get(FabriqueTerrain.fabriquerTerrain("Tundra")));
    }
    
    /**
     * Réinitialise les nombres de terrains dans infosMonde à leurs valeurs par défaut (ici 5)
     */
    private void reinitializeInfosMondeTerrains()
    {
        infosMonde.getTerrains().clear();
        infosMonde.getTerrains().put(FabriqueTerrain.fabriquerTerrain("Plaine"), 5);
        infosMonde.getTerrains().put(FabriqueTerrain.fabriquerTerrain("Montagne"), 5);
        infosMonde.getTerrains().put(FabriqueTerrain.fabriquerTerrain("Désert"), 5);
        infosMonde.getTerrains().put(FabriqueTerrain.fabriquerTerrain("Côte"), 5);
        infosMonde.getTerrains().put(FabriqueTerrain.fabriquerTerrain("Forêt"), 5);
        infosMonde.getTerrains().put(FabriqueTerrain.fabriquerTerrain("Tundra"), 5);
    }
    
    /**
     * Récupère dans infosMonde les nombres de terrains indiqués par l'utilisateur dans les Spinners.
     */
    private void setInfosMondeToSpinner()
    {        
        infosMonde.getTerrains().put(FabriqueTerrain.fabriquerTerrain("Plaine"), (Integer) spTerrains.get(0).getValue());
        infosMonde.getTerrains().put(FabriqueTerrain.fabriquerTerrain("Montagne"), (Integer) spTerrains.get(1).getValue());
        infosMonde.getTerrains().put(FabriqueTerrain.fabriquerTerrain("Désert"), (Integer) spTerrains.get(2).getValue());
        infosMonde.getTerrains().put(FabriqueTerrain.fabriquerTerrain("Côte"), (Integer) spTerrains.get(3).getValue());
        infosMonde.getTerrains().put(FabriqueTerrain.fabriquerTerrain("Forêt"), (Integer) spTerrains.get(4).getValue());
        infosMonde.getTerrains().put(FabriqueTerrain.fabriquerTerrain("Tundra"), (Integer) spTerrains.get(5).getValue());
    }
    
    /**
     * Appelée lors de l'appui du bouton Réinitialiser, cette méthode réinitialise les valeurs des Spinners.
     */
    @FXML
    protected void handleButtonReinitialiser(ActionEvent event)
    {
        initializeSpinners();
    }
    
    /**
     * Appelée lors de l'appui du bouton Aléatoire, cette méthode met un nombre aléatoire
     * entre 0 et 10 dans chacun des Spinners.
     * Pourquoi 10 alors que la valeur maximale est 20? Parce que au de-là de 60 cases (et même avant!), la simulation devient très longue.
     */
    @FXML
    protected void handleButtonAleatoire(ActionEvent event)
    {
        Random generateurDeNombresAleatoires = new Random();
        for (int i=0; i<6; i++)
        {
            spTerrains.get(i).getValueFactory().setValue(generateurDeNombresAleatoires.nextInt(10));
        }
    }
    
    /**
     * Appelée lors de l'appui du bouton Valider, cette méthode lance la Fenêtre récapitulative
     * en lui passant toutes les informations données par l'utilisateur (dans infosMonde).
     */
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
        
        if (nombreCases < infosMonde.getDieux().size())
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
    
    /**
     * Appelée lors de l'appui du bouton Retour, cette méthode lance la Fenêtre de choix de dieux en lui 
     * passant la liste de dieux dans lequel l'utilisateur pourra choisir ses dieux. On lui passe aussi 
     * les informations déjà données par l'utilisateur afin qu'elle puisse les recharger par la suite.
     */
    @FXML
    protected void handleButtonRetour(ActionEvent event) throws Exception
    {
        setInfosMondeToSpinner();
        
        FXMLLoader fxmlLoader = new FXMLLoader();
        FenetreChoixDieuController controller = new FenetreChoixDieuController(ValeursParDefaut.listeDieux());
        fxmlLoader.setController(controller);
        fxmlLoader.setLocation(getClass().getResource("FenetreChoixDieu.fxml"));
        
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        controller.setInfosMonde(infosMonde);

        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    
    /**
     * Appelée lors de l'appui du bouton Menu, cette méthode ramène l'utilisateur au Menu.
     */
    @FXML
    protected void handleButtonMenu(ActionEvent event) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("FenetrePrincipale.fxml"));
        Stage stage = new Stage();
        root.setStyle("-fx-background-image: url('/design/Labelas.jpg');"
                + "-fx-background-size: cover;"
                + "-fx-background-repeat : no-repeat;");
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();

        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
}