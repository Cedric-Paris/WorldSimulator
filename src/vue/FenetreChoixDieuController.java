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
    
    /**
     * Il faut savoir qu'on a pas le droit de sélectionner plusieurs fois le même dieu.
     * C'est pour ceci qu'il y a une liste de dieux encore sélectionnables.
     */
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
    /**
     * On récupère les informations déjà données (ou pas) par l'utilisateur, on initialise la liste
     * de Comboboxs ainsi que celle d'ImageViews, on initialise valeursOriginelles et on met les valeurs
     * des ComboBoxs et des ImageViews à leur valeur par défaut.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        infosMonde = new MondeInfos();

        initializeCbDieux();
        initializeIvDieux();
        setValuesToDefault();
        initializeList();
    }
    
    /**
     * Initialise la liste de ComboBoxs.
     */
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
    
    /**
     * Initialise la liste d'ImageViews.
     */
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
    
    /**
     * On réinitialise la liste de Dieux encore choisissables par l'utilisateur ainsi que les listes des ComboBoxs
     * puis on met à leur valeur par défaut les ComboBoxs.
     */
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
            ivDieux.get(i).setImage(new Image(getClass().getClassLoader().getResource("design/DieuDefaut.jpg").toExternalForm()));
        }
    }
    
    /**
     * Si on a déjà renseigné les dieux sélectionnés à infosMonde, ces dieux seront rechargés dans les ComboBoxs.
     * Sinon, on charge les valeurs de base des ComboBoxs.
     */
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
    
    /**
     * On met dans l les valeurs originelles des Dieux.
     * @param l liste de dieux
     */
    private void setListToDefault(List l)
    {
        for (int i=0; i<valeursOriginelles.size(); i++)
            l.add(i, valeursOriginelles.get(i));
    }
    
    /**
     * On initialise valeursOriginelles et imagesDieux qui nous serviront de référence par la suite et on
     * d'assure qu'elles ne soient pas modifiables.
     */
    private void setValuesToDefault()
    {
        for (int i=0; i<dieux.size(); i++)
            valeursOriginelles.add(i, dieux.get(i).getNom());
        valeursOriginelles = Collections.unmodifiableList(valeursOriginelles);
        for (int i=0; i<dieux.size(); i++)
            imagesDieux.add(i, dieux.get(i).getImage());
        imagesDieux = Collections.unmodifiableList(imagesDieux);
        
    }
    
    /**
     * Change les listes des ComboBoxs afin qu'elles correspondent à
     * dieuxObservables, la liste des dieux encore sélectionnables.
     */
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
                changing = false; // On empêche le changeListener de se déclencher alors qu'on change les listes des ComboBoxs
                selectionne = cbCourante.getSelectionModel().getSelectedItem(); // On récupère l'objet sélectionné
                cbCourante.setItems(FXCollections.observableArrayList(dieuxObservables)); // On change la liste de la ComboBox en la liste de dieux encore sélectionnables
                indexOfSelectionne = valeursOriginelles.indexOf(selectionne);
                if (selectionne != null && !cbCourante.getItems().contains(selectionne)) // Pour des soucis de lisibilité, on rajoute le Dieu sélectionné à la liste de dieux sélectionnables
                {
                    if (indexOfSelectionne < cbCourante.getItems().size())
                        cbCourante.getItems().add(indexOfSelectionne, selectionne);
                    else
                        cbCourante.getItems().add(cbCourante.getItems().size(), selectionne);
                }
                cbCourante.getSelectionModel().select(selectionne); // On resélectionne l'objet sélectionné, comme si de rien n'était
                changing = true;
            }
        }
    }
    
    /**
     * Met un changeListener à la ComboBox passée en paramètre et retournée par la suite.
     * Le changeListener sera appelé dès que la valeur sélectionnée dans cb change. 
     * La valeur est considérée comme changée quand on réinitialise la liste des dieux
     * encore sélectionnables, d'où le besoin du booléen changing afin de ne pas déclencher
     * des appels à la chaîne de cette fonction pour rien.
     */
    private ComboBox setChangeListener(ComboBox cb)
    {
        cb.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if (changing)
                {
                    if (oldValue != null && oldValue != newValue)
                    {
                        if (!dieuxObservables.contains((String) oldValue)) // Si le dieu sélectionné auparavant n'était pas considéré comme sélectionnable
                        {                                                  // Il le sera à présent !
                            Platform.runLater(() -> {   // Besoin d'un runLater car sinon la liste de la ComboBox est inaccessible alors qu'on change d'index sélectionné.
                                int indexOfOldValue = valeursOriginelles.indexOf(oldValue);   // Récupère l'index originel de l'ancien dieu afin de toujours garder le même ordre
                                if (indexOfOldValue < dieuxObservables.size())               //  dans la Liste de dieux sélectionnables
                                    dieuxObservables.add(indexOfOldValue, (String) oldValue);      // Rajoute le dieu à la liste vuq u'il est à présent sélectionnable à nouveau
                                else
                                    dieuxObservables.add(dieuxObservables.size(), (String) oldValue); // Si l'index est supérieur à la taille de la liste, on ajoute le dieu à la fin de celle-ci
                                setDieuxToComboBox();                     // Réinitialise toutes les ComboBoxs pour qu'elles aient la bonne liste de dieux sélectionnables après changements
                            }) ;
                        }
                    }


                    if (newValue != null && newValue != oldValue)
                    {
                        if (dieuxObservables.contains((String) newValue))
                        {
                            setRightImage(cb, (String) newValue);   // Change l'image pour quelle corresponde au nouveau dieu sélectionné
                            Platform.runLater(() -> {   // Besoin d'un runLater car sinon la liste de la ComboBox est inaccessible alors qu'on change d'index sélectionné.
                                dieuxObservables.remove((String) newValue);   // Enlève le dieu sélectionné des dieux sélectionnables
                                setDieuxToComboBox();                     // Réinitialise toutes les ComboBoxs pour qu'elles aient la bonne liste de dieux sélectionnables après changements
                            }) ;
                        }
                    }
                }
            }
        });
        return cb;
    }
    
    /**
     * Change l'image pour quelle corresponde au nouveau dieu sélectionné.
     * @param cb ComboBox pour laquelle le dieu sélectionné a changé
     * @param dieu dieu sélectionné sous forme de String
     */
    private void setRightImage(ComboBox cb, String dieu)
    {
        ivDieux.get(cbDieux.indexOf(cb))   // On récupère l'ImageViex correspondant à la ComboBox,
                .setImage(new Image(getClass().getClassLoader().getResource( // on la change en chargant l'URL de la nouvelle image
                        imagesDieux.get(valeursOriginelles.indexOf(dieu))) // que l'on trouve dans imagesDieux (initialisé en même temps que la fenêtre)
                        .toExternalForm()));                               // puis on transforme cette URL en format String
    }
    
    /**
     * Appelée lors de l'appui du bouton Réinitialiser, cette méthode réinitialise
     * la liste de Dieux encore choisissables par l'utilisateur ainsi que les listes des ComboBoxs
     * puis on met à leur valeur par défaut les ComboBoxs, comme au lancement de la fenêtre.
     */
    @FXML
    protected void handleButtonReinitialiser(ActionEvent event)
    {
        initializeList();
    }
    
    /**
     * Appelée lors de l'appui du bouton Aléatoire, cette méthode choisi entre
     * 2 et 8 dieux de façon aléatoire.
     * Si le dieu choisi aléatoirement est déjà sélectionné, on recommence jusqu'à
     * avoir un dieu non sélectionné auparavant.
     */
    @FXML
    protected void handleButtonAleatoire(ActionEvent event)
    {
        initializeList();
        
        List<String> dieuxDejaChoisis = new ArrayList<>();
        Random generateurDeNombresAleatoires = new Random();
        int indexAleatoire = -1;
        String dieu;
        for (int i=0; i<(2+generateurDeNombresAleatoires.nextInt(cbDieux.size()-1)); i++)
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
    
    /**
     * Appelée lors de l'appui du bouton Valider, cette méthode lance la Fenêtre de choix de terrains
     * en lui passant toutes les informations données par l'utilisateur (dans infosMonde).
     */
    @FXML
    protected void handleButtonValider(ActionEvent event) throws Exception
    {
        infosMonde.getDieux().clear();
        
        for (int i=0; i<cbDieux.size(); i++) // On récupère dans infosMonde les dieux sélectionnés dans les ComboBoxs
        {
            if (cbDieux.get(i).getSelectionModel().getSelectedIndex() > -1)
            {    
                infosMonde.getDieux().add(
                    dieux.get(valeursOriginelles.indexOf(cbDieux.get(i).getSelectionModel().getSelectedItem())));
            }
        }
        
        if (infosMonde.getDieux().size() < 2) // On ne peux avoir moins de 2 dieux.
            return;
        
        if (infosMonde.getTerrains().isEmpty()) // On crée les valeurs par défaut des Terrains dans infosMonde
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