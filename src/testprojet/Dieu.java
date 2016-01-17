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
        /** @return Nom du dieu */
        public String getNom() { return nom;}
        public void setNom(String value) { nom = value; }
        
    private String terrainPredilection;
        /** @return Terrain de prédilection du dieu */
        public String getTerrainPredilection() { return terrainPredilection;}
        public void setTerrainPredilection(String value) { terrainPredilection = value; }
    
    private float bonusBaseAccroissement;
        /** @return Bonus d'accroissement pour les populations associées à ce dieu */
        public float getBonusBaseAccroissement() { return bonusBaseAccroissement;}
        public void setBonusBaseAccroissement(float value) { bonusBaseAccroissement = value; }
    
    private float bonusTerrainAccroissement;
        /** @return Bonus d'accroissement pour les populations associées à ce dieu si elles sont sur son terrain de prédilection */
        public float getBonusTerrainAccroissement() { return bonusTerrainAccroissement;}
        public void setBonusTerrainAccroissement(float value) { bonusTerrainAccroissement = value; }
    
    private float bonusBasePuissance;
        /** @return Bonus de puissance pour les populations associées à ce dieu */
        public float getBonusBasePuissance() { return bonusBasePuissance;}
        public void setBonusBasePuissance(float value) { bonusBasePuissance = value; }
    
    private float bonusTerrainPuissance;
        /** @return Bonus de puissance pour les populations associées à ce dieu si elles sont sur son terrain de prédilection */
        public float getBonusTerrainPuissance() { return bonusTerrainPuissance;}
        public void setBonusTerrainPuissance(float value) { bonusTerrainPuissance = value; }
        
    private Color couleur;
        /** @return Couleur du dieu */
        public Color getCouleur() { return couleur; }
        private void setCouleur(Color value) { couleur = value; }
        
    private String image;
        /** @return Chemin de l'image illustrant le dieu */
        public String getImage() { return image; }
        private void setImage(String value) { image = value; }
   
        
    public Dieu(String nom, String terrainPredilection, float bonusBaseAccroissement, float bonusTerrainAccroissement, float bonusBasePuissance, float bonusTerrainPuissance)
    {
        setNom(nom);
        setTerrainPredilection(terrainPredilection);
        setBonusBaseAccroissement(bonusBaseAccroissement);
        setBonusTerrainAccroissement(bonusTerrainAccroissement);
        setBonusBasePuissance(bonusBasePuissance);
        setBonusTerrainPuissance(bonusTerrainPuissance);
        setCouleur(Color.BLACK);
        setImage("Images/Defaut.jpg");
    }
    
    public Dieu(String nom, String terrainPredilection, float bonusBaseAccroissement, float bonusTerrainAccroissement, float bonusBasePuissance, float bonusTerrainPuissance, Color couleurPopDieu)
    {
        this( nom, terrainPredilection, bonusBaseAccroissement, bonusTerrainAccroissement, bonusBasePuissance, bonusTerrainPuissance);
        setCouleur(couleurPopDieu);
        setImage("Images/Defaut.jpg");
    }
    
    public Dieu(String nom, String terrainPredilection, float bonusBaseAccroissement, float bonusTerrainAccroissement, float bonusBasePuissance, float bonusTerrainPuissance, Color couleurPopDieu, String urlImage)
    {
        this( nom, terrainPredilection, bonusBaseAccroissement, bonusTerrainAccroissement, bonusBasePuissance, bonusTerrainPuissance, couleurPopDieu);
        setImage(urlImage);
    }
    
    public Dieu(String nom, String terrainPredilection, float bonusBaseAccroissement, float bonusTerrainAccroissement, float bonusBasePuissance, float bonusTerrainPuissance, String urlImage)
    {
        this( nom, terrainPredilection, bonusBaseAccroissement, bonusTerrainAccroissement, bonusBasePuissance, bonusTerrainPuissance);
        setImage(urlImage);
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
