/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testprojet;

import java.util.Objects;
import javafx.scene.paint.Color;

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
        
    private Color couleur;
        public Color getCouleur() { return couleur; }
        private void setCouleur(Color value) { couleur = value; }
   
        
    public Dieu(String nom, String terrainPredilection, float bonusBaseAccroissement, float bonusTerrainAccroissement, float bonusBasePuissance, float bonusTerrainPuissance)
    {
        setNom(nom);
        setTerrainPredilection(terrainPredilection);
        setBonusBaseAccroissement(bonusBaseAccroissement);
        setBonusTerrainAccroissement(bonusTerrainAccroissement);
        setBonusBasePuissance(bonusBasePuissance);
        setBonusTerrainPuissance(bonusTerrainPuissance);
        setCouleur(Color.BLACK);
    }
    
    public Dieu(String nom, String terrainPredilection, float bonusBaseAccroissement, float bonusTerrainAccroissement, float bonusBasePuissance, float bonusTerrainPuissance, Color couleurPopDieu)
    {
        this( nom, terrainPredilection, bonusBaseAccroissement, bonusTerrainAccroissement, bonusBasePuissance, bonusTerrainPuissance);
        setCouleur(couleurPopDieu);
        
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dieu other = (Dieu) obj;
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.couleur, other.couleur)) {
            return false;
        }
        return true;
    }
    
    
      
}
