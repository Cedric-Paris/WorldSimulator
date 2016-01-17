package metier;

import java.util.ArrayList;

/**
 *
 * @author Ribière Laurent
 */
public class Case {
    
    private Monde monde;
        /** @return Monde contenant la case */
        public Monde getMonde() {return monde;}
        public void setMonde(Monde value) {monde = value;}
    
    private Population population;
        /** @return Population contenue par la case */
        public Population getPopulation(){return population;}
        public void setPopulation(Population value)
        {
            if(value!=null) value.setCasePop(this);//la case s'inscrit dans la nouvelle population
            if(population!=null) population.setCasePop(null);//on supprime la case des attribut de l'ancienne poulation
            population = value;
        }
        
    private Terrain terrain;
        /** @return Terrain associé à la case */
        public Terrain getTerrain() {return terrain;}
        public void setTerrain(Terrain value) {terrain = value;}
    
    private int id;
        /** @return ID de la case */
        public int getId() {return id;}
        public void setId(int value) {id = value;}
    
    public Case(Monde monde, int id)
    {
        this.monde = monde;
        this.id=id;
    }

    /**
     * Obtient la liste des voisins de la case
     * @return Liste des voisins
     */
    public ArrayList<Case> getVoisin() 
    {
        return monde.findVoisinAtLoc(id);
        
    }    
    
    @Override
    public String toString()
    {
        return "Id : "+getId();
    }
    
}
