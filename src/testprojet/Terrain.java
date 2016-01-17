/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testprojet;

/**
 *
 * @author Cedric
 */
public class Terrain {
    
    private String nom;
        public String getNom(){return nom;}
        public void setNom(String nom){this.nom = nom;}
    
    private float bonusAccroissment;
        public float getBonusAccroissment() {return bonusAccroissment;}
        public void setBonusAccroissment(float bonusAccroissment){this.bonusAccroissment = bonusAccroissment;}
    
    private float bonusPuissance;
        public float getBonusPuissance() {return bonusPuissance;}
        public void setBonusPuissance(float bonusPuissance){this.bonusPuissance = bonusPuissance;}
        
    public Terrain(String nom, float bonusAccroissment, float bonusPuissance) {
        this.nom = nom;
        this.bonusAccroissment = bonusAccroissment;
        this.bonusPuissance = bonusPuissance;
    }
}
