package vue;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import metier.Dieu;
import metier.FabriqueTerrain;
import metier.MondeInfos;

/**
 * FXML Controller class
 *
 * @author Nawhal
 */
public class FenetreChoixDieuController implements Initializable {

    private MondeInfos infosMonde;
        public void setInfosMonde(MondeInfos infosMonde)
        {
            this.infosMonde = infosMonde;
            setComboBoxsToInfosMonde();
        }
    
    private List<Dieu> dieux = new LinkedList();
    
    private List<String> valeursOriginelles = new ArrayList();
    private List<String> imagesDieux = new ArrayList();
    
    private boolean changing = true;
    
    ObservableList<String> dieuxObservables = FXCollections.observableArrayList();
    
    @FXML
    private ComboBox cbDieu0;
    @FXML
    private ComboBox cbDieu1;
    @FXML
    private ComboBox cbDieu2;
    @FXML
    private ComboBox cbDieu3;
    @FXML
    private ComboBox cbDieu4;
    @FXML
    private ComboBox cbDieu5;
    @FXML
    private ComboBox cbDieu6;
    @FXML
    private ComboBox cbDieu7;
    
    @FXML
    private ImageView ivDieu0;
    @FXML
    private ImageView ivDieu1;
    @FXML
    private ImageView ivDieu2;
    @FXML
    private ImageView ivDieu3;
    @FXML
    private ImageView ivDieu4;
    @FXML
    private ImageView ivDieu5;
    @FXML
    private ImageView ivDieu6;
    @FXML
    private ImageView ivDieu7;
    
    private final List<ComboBox> cbDieux = new ArrayList();
    private final List<ImageView> ivDieux = new ArrayList();
    
    public FenetreChoixDieuController(List<Dieu> dieux)
    {
        this.dieux = dieux;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        infosMonde = new MondeInfos();

        initializeCbDieux();
        initializeIvDieux();
        setValuesToDefault();
        initializeList();
    }
    
    private void initializeCbDieux()
    {
        cbDieux.add(0, setChangeListener(cbDieu0));
        cbDieux.add(1, setChangeListener(cbDieu1));
        cbDieux.add(2, setChangeListener(cbDieu2));
        cbDieux.add(3, setChangeListener(cbDieu3));
        cbDieux.add(4, setChangeListener(cbDieu4));
        cbDieux.add(5, setChangeListener(cbDieu5));
        cbDieux.add(6, setChangeListener(cbDieu6));
        cbDieux.add(7, setChangeListener(cbDieu7));
    }
    
    private void initializeIvDieux()
    {
        ivDieux.add(0, ivDieu0);
        ivDieux.add(1, ivDieu1);
        ivDieux.add(2, ivDieu2);
        ivDieux.add(3, ivDieu3);
        ivDieux.add(4, ivDieu4);
        ivDieux.add(5, ivDieu5);
        ivDieux.add(6, ivDieu6);
        ivDieux.add(7, ivDieu7);
    }
    
    private void initializeList()
    {
        dieuxObservables.clear();
        setListToDefault(dieuxObservables);
        setDieuxToComboBox();
        
        for (int i=0; i<cbDieux.size(); i++)
        {
            cbDieux.get(i).getSelectionModel().select(-1);
        }
        for (int i=0; i<ivDieux.size(); i++)
        {
            ivDieux.get(i).setImage(new Image(getClass().getClassLoader().getResource("Design/DieuDefaut.jpg").toExternalForm()));
        }
    }
    
    private void setComboBoxsToInfosMonde()
    {
        for (int i=0; i<cbDieux.size(); i++)
        {
            if (i < infosMonde.getDieux().size() && infosMonde.getDieux().get(i) != null)
                cbDieux.get(i).getSelectionModel().select(infosMonde.getDieux().get(i).getNom());
            else
                cbDieux.get(i).getSelectionModel().select(-1);
        }
    }
    
    private void setListToDefault(List l)
    {
        for (int i=0; i<valeursOriginelles.size(); i++)
            l.add(i, valeursOriginelles.get(i));
    }
    
    private void setValuesToDefault()
    {
        for (int i=0; i<dieux.size(); i++)
            valeursOriginelles.add(i, dieux.get(i).getNom());
        valeursOriginelles = Collections.unmodifiableList(valeursOriginelles);
        for (int i=0; i<dieux.size(); i++)
            imagesDieux.add(i, dieux.get(i).getImage());
        imagesDieux = Collections.unmodifiableList(imagesDieux);
        
    }
    
    private void setDieuxToComboBox()
    {
        ComboBox cbCourante;
        Object selectionne;
        int indexOfSelectionne;
        for (int i=0; i<cbDieux.size(); i++)
        {
            cbCourante = cbDieux.get(i);
            if (cbCourante != null)
            {
                changing = false;
                selectionne = cbCourante.getSelectionModel().getSelectedItem();
                cbCourante.setItems(FXCollections.observableArrayList(dieuxObservables));
                indexOfSelectionne = valeursOriginelles.indexOf(selectionne);
                if (selectionne != null && !cbCourante.getItems().contains(selectionne))
                {
                    if (indexOfSelectionne < cbCourante.getItems().size())
                        cbCourante.getItems().add(indexOfSelectionne, selectionne);
                    else
                        cbCourante.getItems().add(cbCourante.getItems().size(), selectionne);
                }
                cbCourante.getSelectionModel().select(selectionne);
                changing = true;
            }
        }
    }
    
    private ComboBox setChangeListener(ComboBox cb)
    {
        cb.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if (changing)
                {
                    if (oldValue != null && oldValue != newValue && oldValue != "")
                    {
                        if (!dieuxObservables.contains((String) oldValue))
                        {   
                            Platform.runLater(() -> {
                                int indexOfOldValue = valeursOriginelles.indexOf(oldValue);
                                if (indexOfOldValue < dieuxObservables.size())
                                    dieuxObservables.add(indexOfOldValue, (String) oldValue);
                                else
                                    dieuxObservables.add(dieuxObservables.size(), (String) oldValue);
                                setDieuxToComboBox();
                            }) ;
                        }
                    }


                    if (newValue != null && newValue != oldValue && newValue != "")
                    {
                        if (dieuxObservables.contains((String) newValue))
                        {
                            setRightImage(cb, (String) newValue);
                            Platform.runLater(() -> {
                                dieuxObservables.remove((String) newValue);
                                setDieuxToComboBox();
                            }) ;
                        }
                    }
                }
            }
        });
        return cb;
    }
    
    private void setRightImage(ComboBox cb, String dieu)
    {
        ivDieux.get(cbDieux.indexOf(cb)).setImage(new Image(getClass().getClassLoader().getResource(imagesDieux.get(valeursOriginelles.indexOf(dieu))).toExternalForm()));
    }
    
    @FXML
    protected void handleButtonReinitialiser(ActionEvent event)
    {
        initializeList();
    }
    
    @FXML
    protected void handleButtonAleatoire(ActionEvent event)
    {
        initializeList();
        
        List<String> dieuxDejaChoisis = new ArrayList<>();
        Random generateurDeNombresAleatoires = new Random();
        int indexAleatoire = -1;
        String dieu;
        for (int i=0; i<(3+generateurDeNombresAleatoires.nextInt(cbDieux.size()-2)); i++)
        {
            indexAleatoire = generateurDeNombresAleatoires.nextInt(cbDieux.get(i).getVisibleRowCount());
            dieu = dieuxObservables.get(indexAleatoire);
            while(dieuxDejaChoisis.contains(dieu))
            {    
                indexAleatoire = generateurDeNombresAleatoires.nextInt(cbDieux.get(i).getVisibleRowCount());
                dieu = dieuxObservables.get(indexAleatoire);
            }
            cbDieux.get(i).getSelectionModel().select(dieu);
            dieuxDejaChoisis.add(dieu);
        }
    }
    
    @FXML
    protected void handleButtonValider(ActionEvent event) throws Exception
    {
        infosMonde.getDieux().clear();
        
        for (int i=0; i<cbDieux.size(); i++)
        {
            if (cbDieux.get(i).getSelectionModel().getSelectedIndex() > -1)
            {    
                infosMonde.getDieux().add(
                    dieux.get(valeursOriginelles.indexOf(cbDieux.get(i).getSelectionModel().getSelectedItem())));
            }
        }
        
        if (infosMonde.getDieux().size() < 2)
            return;
        
        if (infosMonde.getTerrains().isEmpty())
        {
            infosMonde.getTerrains().put(FabriqueTerrain.fabriquerTerrain("Plaine"), 5);
            infosMonde.getTerrains().put(FabriqueTerrain.fabriquerTerrain("Montagne"), 5);
            infosMonde.getTerrains().put(FabriqueTerrain.fabriquerTerrain("Désert"), 5);
            infosMonde.getTerrains().put(FabriqueTerrain.fabriquerTerrain("Côte"), 5);
            infosMonde.getTerrains().put(FabriqueTerrain.fabriquerTerrain("Forêt"), 5);
            infosMonde.getTerrains().put(FabriqueTerrain.fabriquerTerrain("Tundra"), 5);
        }
        
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
    protected void handleButtonRetour(ActionEvent event) throws Exception
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