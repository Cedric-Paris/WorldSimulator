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
    
    private String nom;
        public String getNom() { return nom;}
        public void setNom(String value) { nom = value; }
        
    private String terrainPredilection;
        public String getTerrainPredilection() { return terrainPredilection;}
        public void setTerrainPredilection(String value) { terrainPredilection = value; }
    
    private float bonusBaseAccroissement;
        public float getBonusBaseAccroissement() { return bonusBaseAccroissement;}
        public void setBonusBaseAccroissement(float value) { bonusBaseAccroissement = value; }
    
    private float bonusTerrainAccroissement;
        public float getBonusTerrainAccroissement() { return bonusTerrainAccroissement;}
        public void setBonusTerrainAccroissement(float value) { bonusTerrainAccroissement = value; }
    
    private float bonusBasePuissance;
        public float getBonusBasePuissance() { return bonusBasePuissance;}
        public void setBonusBasePuissance(float value) { bonusBasePuissance = value; }
    
    private float bonusTerrainPuissance;
        public float getBonusTerrainPuissance() { return bonusTerrainPuissance;}
        public void setBonusTerrainPuissance(float value) { bonusTerrainPuissance = value; }

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
