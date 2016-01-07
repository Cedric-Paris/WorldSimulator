/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testprojet;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author Nawhal
 */
public class FenetreChoixDieuController implements Initializable {

    ObservableList<String> dieuxObservables = FXCollections.observableArrayList();
    
    /*private final ListProperty<String> dieux = new SimpleListProperty<>(dieuxObservables);
        public ObservableList<String> getLesEtudiants() {return dieux.get();}
        public void setLesEtudiants(ObservableList<String> value) {dieux.set(value);}
        public ListProperty<String> lesEtudiantsProperty() {return dieux;}*/
    
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
    private ComboBox cbDieu8;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setListToDefault();
        cbDieu1 = setChangeListener(cbDieu1);
        cbDieu2 = setChangeListener(cbDieu2);
        cbDieu3 = setChangeListener(cbDieu3);
        cbDieu4 = setChangeListener(cbDieu4);
        cbDieu5 = setChangeListener(cbDieu5);
        cbDieu6 = setChangeListener(cbDieu6);
        cbDieu7 = setChangeListener(cbDieu7);
        cbDieu8 = setChangeListener(cbDieu8);
    }
    
    private void setListToDefault()
    {
        dieuxObservables.clear();
        dieuxObservables.add("A");
        dieuxObservables.add("B");
        dieuxObservables.add("C");
        dieuxObservables.add("D");
        dieuxObservables.add("E");
        dieuxObservables.add("F");
        dieuxObservables.add("G");
        dieuxObservables.add("H");
        setDieuxToComboBox();
    }
    
    private void setDieuxToComboBox()
    {
        cbDieu1.setItems(dieuxObservables);
        cbDieu2.setItems(dieuxObservables);
        cbDieu3.setItems(dieuxObservables);
        cbDieu4.setItems(dieuxObservables);
        cbDieu5.setItems(dieuxObservables);
        cbDieu6.setItems(dieuxObservables);
        cbDieu7.setItems(dieuxObservables);
        cbDieu8.setItems(dieuxObservables);
    }
    
    private ComboBox setChangeListener(ComboBox cb)
    {
        cb.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if (oldValue != null)
                    if (!dieuxObservables.contains((String) oldValue))
                        dieuxObservables.add((String) oldValue);
                
                if (newValue != null)
                    if (dieuxObservables.contains((String) newValue))
                        dieuxObservables.remove((String) newValue);
                
                setDieuxToComboBox();
            }
        });
        return cb;
    }
}