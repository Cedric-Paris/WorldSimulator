/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testprojet;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Cedric
 */
public class Dieu {
    
    private final StringProperty nom = new SimpleStringProperty();
        public String getNom() { return nom.get(); }
        public void setNom(String value) { nom.set(value); }
        public StringProperty NomProperty() { return nom; }
    
    private final StringProperty terrainPredilection = new SimpleStringProperty();
        public String getTerrainPredilection() { return terrainPredilection.get(); }
        public void setTerrainPredilection(String value) { terrainPredilection.set(value); }
        public StringProperty TerrainPredilectionProperty() { return terrainPredilection; }
    
    private final FloatProperty bonusBaseAccroissement = new SimpleFloatProperty();
        public float getBonusBaseAccroissement() { return bonusBaseAccroissement.get(); }
        public void setBonusBaseAccroissement(float value) { bonusBaseAccroissement.set(value); }
        public FloatProperty BonusBaseAccroissementProperty() { return bonusBaseAccroissement; }
    
    private final FloatProperty bonusTerrainAccroissement = new SimpleFloatProperty();
        public float getBonusTerrainAccroissement() { return bonusTerrainAccroissement.get(); }
        public void setBonusTerrainAccroissement(float value) { bonusTerrainAccroissement.set(value); }
        public FloatProperty BonusTerrainAccroissementProperty() { return bonusTerrainAccroissement; }
    
    private final FloatProperty bonusBasePuissance = new SimpleFloatProperty();
        public float getBonusBasePuissance() { return bonusBasePuissance.get(); }
        public void setBonusBasePuissance(float value) { bonusBasePuissance.set(value); }
        public FloatProperty BonusBasePuissanceProperty() { return bonusBasePuissance; }
    
    private final FloatProperty bonusTerrainPuissance = new SimpleFloatProperty();
        public float getBonusTerrainPuissance() { return bonusTerrainPuissance.get(); }
        public void setBonusTerrainPuissance(float value) { bonusTerrainPuissance.set(value); }
        public FloatProperty BonusTerrainPuissanceProperty() { return bonusTerrainPuissance; }

    public Dieu(String nom, String terrainPredilection, float bonusBaseAccroissement, float bonusTerrainAccroissement, float bonusBasePuissance, float bonusTerrainPuissance)
    {
        setNom(nom);
        setTerrainPredilection(terrainPredilection);
        setBonusBaseAccroissement(bonusBaseAccroissement);
        setBonusTerrainAccroissement(bonusTerrainAccroissement);
        setBonusBasePuissance(bonusBasePuissance);
        setBonusTerrainPuissance(bonusTerrainPuissance);
    }
    
}
