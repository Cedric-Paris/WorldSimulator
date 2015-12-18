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
public class Race {
    
    private String nom;
        public String getNom() { return nom; }
        public void setNom(String value) { nom = value; }
    
    private float bonusAttaque;
        public float getBonusAttaque() { return bonusAttaque; }
        public void setBonusAttaque(float value) { bonusAttaque = value; }
    
    private float bonusAccroissement;
        public float getBonusAccroissement() { return bonusAccroissement; }
        public void setBonusAccroissement(float value) { bonusAccroissement = value; }

    public Race(String nom, float bonusAttaque, float bonusAccroissement) 
    {
        setNom(nom);
        setBonusAttaque(bonusAttaque);
        setBonusAccroissement(bonusAccroissement);
    }

}
