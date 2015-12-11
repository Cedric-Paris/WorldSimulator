/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testprojet;

import java.util.List;
import testprojet.Monde;
import testprojet.Population;

/**
 *
 * @author Ribière Laurent
 */
public class Case {
    //Region Attribut/Propriete
    private Monde monde;
    public Monde getMonde() {return monde;}
    public void setMonde(Monde value) {monde = value;}
    
    private Population population;
    public Population getPopulation(){return population;}
    public void setPopulation(Population value) {population = value;}
        
    private Terrain terrain;
    public Terrain getTerrain() {return terrain;}
    public void setTerrain(Terrain value) {terrain = value;}
    //Fin de Region
    
    //Region Constructeur
    public Case(Monde monde) {
        this.monde = monde;
    }
    //Fin Region

    //Region Methodes
    public List<Case> getVoisin() 
    {
        monde.findVoisinAtLoc();
    }
    //Fin de Region
    
}
