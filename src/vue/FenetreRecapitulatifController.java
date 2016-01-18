package vue;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import metier.Dieu;
import metier.FabriqueTerrain;
import metier.GestionnaireDeMondeCaseParCase;
import metier.Monde;
import metier.MondeInfos;
import metier.ValeursParDefaut;

/**
 * FXML Controller class
 *
 * @author Nawhal
 */
public class FenetreRecapitulatifController implements Initializable {

    private MondeInfos infosMonde;
    
    @FXML
    private GridPane gpGrid;
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
    
    /**
     * @param infosMonde permet de récupérer les informations données par l'utilisateur précédemment
     */
    public FenetreRecapitulatifController (MondeInfos infosMonde)
    {
        this.infosMonde = infosMonde;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        setLabelDieux();
        setLabelsTerrains();
        setGridToRightSize();
    }

    /**
     * Affiche pour chaque terrain combien vont être créés dans le jeu.
     */
    private void setLabelsTerrains() {
        lbPlaine.textProperty().set("Plaine x " + infosMonde.getTerrains().get(FabriqueTerrain.fabriquerTerrain("Plaine")));
        lbMontagne.textProperty().set("Montagne x " + infosMonde.getTerrains().get(FabriqueTerrain.fabriquerTerrain("Montagne")));
        lbDesert.textProperty().set("Désert x " + infosMonde.getTerrains().get(FabriqueTerrain.fabriquerTerrain("Désert")));
        lbCote.textProperty().set("Côte x " + infosMonde.getTerrains().get(FabriqueTerrain.fabriquerTerrain("Côte")));
        lbForet.textProperty().set("Forêt x " + infosMonde.getTerrains().get(FabriqueTerrain.fabriquerTerrain("Forêt")));
        lbTundra.textProperty().set("Tundra x " + infosMonde.getTerrains().get(FabriqueTerrain.fabriquerTerrain("Tundra")));
    }
    
    /**
     * Affiche la liste de dieux sélectionnés auparavant.
     */
    private void setLabelDieux()
    {
        String texte = "";
        for (int i=0; i<infosMonde.getDieux().size(); i++)
        {    
            texte += infosMonde.getDieux().get(i).getNom() + " (" + infosMonde.getDieux().get(i).getTerrainPredilection() + ")\n";
        }
        texte += "\n";
        lbDieux.textProperty().set(texte);
    }
    
    /**
     * Change la taille de la ligne où se situe la liste de dieux afin de pouvoir tous les voir sans avoir à agrandir la fenêtre.
     */
    private void setGridToRightSize()
    {
        gpGrid.getRowConstraints().get(0).setMinHeight(25*infosMonde.getDieux().size());
    }
    
    /**
     * Appelée lors de l'appui du bouton Recommencer, cette méthode ramène l'utilisateur à la fenêtre de choix de dieux avec infosMonde réinitialisé.
     */
    @FXML
    protected void handleButtonRecommencer(ActionEvent event) throws Exception
    {
        FXMLLoader fxmlLoader = new FXMLLoader();
        FenetreChoixDieuController controller = new FenetreChoixDieuController(ValeursParDefaut.listeDieux());
        fxmlLoader.setController(controller);
        fxmlLoader.setLocation(getClass().getResource("FenetreChoixDieu.fxml"));
        
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    
    /**
    * Appelée lors de l'appui du bouton Valider, cette méthode recupère les populations correspondant aux dieux sélectionnés précédemment,
    * créé le Gestionnaire de Monde grâce auquel l'utilisateur pourra jouer et redirige vers FenetreJeu qui lancera le jeu.
     */
    @FXML
    protected void handleButtonValider(ActionEvent event) throws Exception
    {        
        Dieu dieuCourant;
        for (int i=0; i<infosMonde.getDieux().size(); i++)
        {
            dieuCourant = infosMonde.getDieux().get(i);
            infosMonde.getPopulations().put(dieuCourant, ValeursParDefaut.populationParDieu().get(dieuCourant.getNom()));
        }
        
        
        Monde m = new Monde(infosMonde);
        GestionnaireDeMondeCaseParCase g = new GestionnaireDeMondeCaseParCase(m, 100);
        FXMLLoader fxmlLoader = new FXMLLoader();
        FenetreJeuController controller = new FenetreJeuController(g, infosMonde.getDieux());
        fxmlLoader.setController(controller);
        fxmlLoader.setLocation(getClass().getResource("FenetreJeu.fxml"));
        Parent root = fxmlLoader.load();
        root.setStyle("-fx-background-image: url('/design/GameBackground.jpg');"
                + "-fx-background-size: 100% 100%;"
                + "-fx-background-repeat : no-repeat;");
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
           
            @Override
            public void handle(WindowEvent we) {
                Platform.exit();
                System.exit(0);
            }
        }); 
        stage.show();
        
        g.lancerPartie();

        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    
    /**
     * Appelée lors de l'appui du bouton Retour, cette méthode ramène l'utilisateur à la fenêtre de choix de terrains en ayant conservé
     * les informations précedemment saisies dans infosMonde.
     */
    @FXML
    protected void handleButtonRetour(ActionEvent event) throws Exception
    {
        FXMLLoader fxmlLoader = new FXMLLoader();
        FenetreChoixTerrainController controller = new FenetreChoixTerrainController(infosMonde);
        fxmlLoader.setController(controller);
        fxmlLoader.setLocation(getClass().getResource("FenetreChoixTerrain.fxml"));
        
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

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
