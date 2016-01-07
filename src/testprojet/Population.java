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
    
    public static final int MAX_POPULATION = 100;
    
    private String nom;
        public String getNom() { return nom;}
        public void setNom(String value) { nom = value; }
        
    private int nombreHabitants = 0;
        public int getNombreHabitants() { return nombreHabitants; }
        public void setNombreHabitants(int value)
                            {   if(value>MAX_POPULATION)
                                    value = MAX_POPULATION;
                                if(value<0)
                                    value = 0;
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
        public StrategieDeJeu getStrat(){return strat;}
        
        
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
    
    public Population(Population pop)
    {
        this(pop.getNom(), pop.getNombreHabitants(),pop.getDieuPop(), pop.getRacePop(), pop.getCasePop(), pop.getStrat());
    }
    
    public void jouer()
    {
        strat.jouer(this);
    }
    
    public void tuer()//supprime la population du monde
    {
        setNombreHabitants(0);
        getCasePop().setPopulation(null);
        setCasePop(null);
    }
    
    /**
     * @param ennemi => à changer par une Case par la suite
     * @return true = gagné // false = perdu
     */
    public boolean attaquer(Population ennemi)
    {
        if (ennemi.defendre(this)) // On a gagné
            return true;
        
        tuer(); // On a perdu ou égalité donc notre population meurt
        return false;
    }
    
    /**
     * resultat : à quel point l'ennemi a gagné (négatif = perdu)
     * @param ennemi
     * @return true = perdu // false = gagné
     */
    private boolean defendre(Population ennemi)
    {        
        float ratioDefenseur = getRatioPuissanceAttaque(getCasePop().getTerrain());//le terrain de l'attaque est le terrain du defenseur
        ratioDefenseur += getCasePop().getTerrain().getBonusPuissance();//le defenseur a droit a un bonus de defence car il connait le terrain ou il se trouve
        float ratioEnnemi = ennemi.getRatioPuissanceAttaque(getCasePop().getTerrain());
        
        if( (ratioDefenseur*(float)getNombreHabitants()) >= (ratioEnnemi*(float)ennemi.getNombreHabitants()) )//defenseur gagne
        {
            setNombreHabitants(getNombreHabitants() - calculNbMortPourLeGagnant(this, ratioDefenseur, ennemi, ratioEnnemi));//Calcul des "morts"
            return false;
        }
        tuer();
        ennemi.setNombreHabitants(ennemi.getNombreHabitants() - calculNbMortPourLeGagnant(ennemi, ratioEnnemi, this, ratioDefenseur));//Calcul des "morts"
        return true;        
    }
    
    private int calculNbMortPourLeGagnant(Population gagnant, float ratioGagnant, Population perdant, float ratioPerdant)
    {
        return (int)( ( (float)gagnant.getNombreHabitants() * (ratioPerdant*(float)perdant.getNombreHabitants()) ) / (ratioGagnant * (float)gagnant.getNombreHabitants()) );
    }
    
    
    private float getRatioPuissanceAttaque(Terrain terrainAttaque)
    {
        //Renvoie le ratio bonus/malus a  appliquer sur le nombre d'habitant pour obtenir le score d'attaque
        float ratio = getRacePop().getBonusAttaque() + getDieuPop().getBonusBasePuissance();
        if(terrainAttaque.getNom().equals(getDieuPop().getTerrainPredilection()))
            ratio += getDieuPop().getBonusTerrainPuissance();
        return ratio;
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