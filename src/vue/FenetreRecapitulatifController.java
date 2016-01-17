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

    private void setLabelsTerrains() {
        lbPlaine.textProperty().set("Plaine x " + infosMonde.getTerrains().get(FabriqueTerrain.fabriquerTerrain("Plaine")));
        lbMontagne.textProperty().set("Montagne x " + infosMonde.getTerrains().get(FabriqueTerrain.fabriquerTerrain("Montagne")));
        lbDesert.textProperty().set("Désert x " + infosMonde.getTerrains().get(FabriqueTerrain.fabriquerTerrain("Désert")));
        lbCote.textProperty().set("Côte x " + infosMonde.getTerrains().get(FabriqueTerrain.fabriquerTerrain("Côte")));
        lbForet.textProperty().set("Forêt x " + infosMonde.getTerrains().get(FabriqueTerrain.fabriquerTerrain("Forêt")));
        lbTundra.textProperty().set("Tundra x " + infosMonde.getTerrains().get(FabriqueTerrain.fabriquerTerrain("Tundra")));
    }
    
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
    
    private void setGridToRightSize()
    {
        gpGrid.getRowConstraints().get(0).setMinHeight(30*infosMonde.getDieux().size());
    }
    
    @FXML
    protected void handleButtonRecommencer(ActionEvent event) throws Exception
    {
        FXMLLoader fxmlLoader = new FXMLLoader();
        FenetreChoixDieuController controller = new FenetreChoixDieuController(MondeInfos.listeDieux());
        fxmlLoader.setController(controller);
        fxmlLoader.setLocation(getClass().getResource("FenetreChoixDieu.fxml"));
        
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    
    @FXML
    protected void handleButtonValider(ActionEvent event) throws Exception
    {        
        Dieu dieuCourant;
        for (int i=0; i<infosMonde.getDieux().size(); i++)
        {
            dieuCourant = infosMonde.getDieux().get(i);
            System.out.println("Dieu = " + dieuCourant.getNom());
            infosMonde.getPopulations().put(
                    dieuCourant, 
                    MondeInfos.populationParDieu()
                            .get(dieuCourant.getNom()));
        }
        
        
        Monde m = new Monde(infosMonde);
        GestionnaireDeMondeCaseParCase g = new GestionnaireDeMondeCaseParCase(m, 100);
        FXMLLoader fxmlLoader = new FXMLLoader();
        FenetreJeuController controller = new FenetreJeuController(g);
        fxmlLoader.setController(controller);
        fxmlLoader.setLocation(getClass().getResource("FenetreJeu.fxml"));
        Parent root = fxmlLoader.load();
        root.setStyle("-fx-background-image: url('/Design/GameBackground.jpg');"
                + "-fx-background-size: cover;"
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
        
        g.LancerPartie();

        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    
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
