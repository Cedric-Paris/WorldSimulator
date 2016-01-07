/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testprojet;

import java.util.ArrayList;
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
        public void setPopulation(Population value)
        {
            if(value!=null) value.setCasePop(this);//la case s'inscrit dans la nouvelle population
            if(population!=null) population.setCasePop(null);//on supprime la case des attribut de l'ancienne poulation
            population = value;
        }
        
    private Terrain terrain;
        public Terrain getTerrain() {return terrain;}
        public void setTerrain(Terrain value) {terrain = value;}
    
    private int id;
        public int getId() {return id;}
        public void setId(int value) {id = value;}
    //Fin de Region
    
    //Region Constructeur
    public Case(Monde monde, int id) {//devra prendre une pop et un terrain par la suite
        this.monde = monde;
        this.id=id;
        
        //POUR LES TESTS A SUPPRIMER:
        FabriqueTerrain.ajouterTerrain("Montagne", 0.9f, 1.2f);
        terrain = FabriqueTerrain.fabriquerTerrain("Montagne");
    }
    //Fin Region

    //Region Methodes
    public ArrayList<Case> getVoisin() 
    {
        return monde.findVoisinAtLoc(id);
        
    }
    public void showVoisin()
    {
        ArrayList<Case> voisin = getVoisin();

        for (Case a : voisin) {
            System.out.println(a);
        }
    }
    //Fin de Region
    
    
    //Region Override
    @Override
    public String toString()
    {
        return "Id : "+getId();
    }
    //Fin de région
    
}
