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
public class Population {
    
    private String nom;
        public String getNom() { return nom;}
        public void setNom(String value) { nom = value; }
        
    private int nombreHabitants = 0;
        public int getNombreHabitants() { return nombreHabitants; }
        public void setNombreHabitants(int value)
                            {   if(value>100)
                                    value = 100;
                                nombreHabitants = value;
                            }
    
    private Race racePop;
        public Race getRacePop() { return racePop; }
        public void setRacePop(Race value) { racePop = value; }
    
    private Dieu dieuPop;
        public void setDieuPop(Dieu value) { dieuPop = value; }    
        public Dieu getDieuPop() { return dieuPop; }
        
    private Case casePop;
        public Case getCasePop() { return casePop; }
        public void setCasePop(Case value) { casePop = value; }
        
    private StrategieDeJeu strat;
        public void setStrat(StrategieDeJeu value) { strat  = value ;}
        
        
    public Population(String nom, int nombreHabitants, Dieu dieuPop, Race racePop) {
        this.nom = nom;
        this.nombreHabitants = nombreHabitants;
        this.racePop = racePop;
        this.dieuPop = dieuPop;
        strat = new StrategieDeJeuDefaut();
    }
    
    public Population(String nom, int nombreHabitants, Dieu dieuPop, Race racePop, Case casePop) {
        this(nom, nombreHabitants, dieuPop, racePop);
        this.casePop = casePop;
    }
    
    public Population(String nom, int nombreHabitants, Dieu dieuPop, Race racePop, Case casePop, StrategieDeJeu strat)
    {
        this(nom, nombreHabitants, dieuPop, racePop, casePop);
        this.strat = strat;
    }
    
    public void jouer()
    {
        strat.jouer(this);
    }
    
    /**
     * @param ennemi => à changer par une Case par la suite
     * @return true = gagné // false = perdu
     */
    public boolean attaquer(Population ennemi)
    {
        if (ennemi.defendre(this)) // On a gagné
            return true;
        
        setNombreHabitants(0); // On a perdu ou égalité donc notre population meurt
        return false;
    }
    
    /**
     * resultat : à quel point l'ennemi a gagné (négatif = perdu)
     * @param ennemi
     * @return true = perdu // false = gagné
     */
    public boolean defendre(Population ennemi)
    {
        float resultat = ennemi.getScorePuissanceAttaquePopulation(getCasePop().getTerrain()) - getScorePuissanceDefensePopulation();
        
        if (resultat < 0) // On a gagné
            return false;
        
        setNombreHabitants(0); // On a perdu ou égalité donc notre population meurt
        return resultat != 0; // false si égalité, true si on a perdu
    }
    
    public float getScorePuissanceDefensePopulation()
    {
        float result = 0.3f + getDieuPop().getBonusBasePuissance() * (float)getNombreHabitants() * getCasePop().getTerrain().getBonusPuissance();
        if (getCasePop().getTerrain().getNom().equals(getDieuPop().getTerrainPredilection()))
            result *= getDieuPop().getBonusTerrainPuissance();
        return result;
    }
    
    public float getScorePuissanceAttaquePopulation(Terrain terrainAttaque)
    {
        float result = getDieuPop().getBonusBasePuissance() * (float)getNombreHabitants();
        if (terrainAttaque.getNom().equals(getDieuPop().getTerrainPredilection()))
            result *= getDieuPop().getBonusTerrainPuissance();
        return result;
    }
    
    public void grandir()
    {
        int bebes = (int)(calculBonusAccroissement() * getNombreHabitants()/2);
        
        if (bebes == 0)
            bebes = 1;
        setNombreHabitants(getNombreHabitants() + bebes);
    }
   
    private float calculBonusAccroissement()
    {
        float result = getDieuPop().getBonusBaseAccroissement() * getRacePop().getBonusAccroissement();
                result *= getCasePop().getTerrain().getBonusAccroissment();
        if (getCasePop().getTerrain().getNom().equals(getDieuPop().getTerrainPredilection()))
            result *= getDieuPop().getBonusTerrainAccroissement();
        return result;
    }
}