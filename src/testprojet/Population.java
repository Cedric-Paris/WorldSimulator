package testprojet;

/**
 *
 * @author Cedric
 */
public class Population {
    
    public static final int MAX_POPULATION = 100;
    
    private String nom;
        /** @return Nom de la population */
        public String getNom() { return nom;}
        public void setNom(String value) { nom = value; }
        
    private int nombreHabitants = 0;
        /** @return Nombre d'habitant */
        public int getNombreHabitants() { return nombreHabitants; }
        public void setNombreHabitants(int value)
                            {   if(value>MAX_POPULATION)
                                    value = MAX_POPULATION;
                                if(value<0)
                                    value = 0;
                                nombreHabitants = value;
                            }
    
    private Race racePop;
        /** @return Race de la population */
        public Race getRacePop() { return racePop; }
        public void setRacePop(Race value) { racePop = value; }
    
    private Dieu dieuPop;
        /** @return Dieu de la population */
        public Dieu getDieuPop() { return dieuPop; }
        public void setDieuPop(Dieu value) { dieuPop = value; }    
        
        
    private Case casePop;
        /** @return Case contenant la population */
        public Case getCasePop() { return casePop; }
        public void setCasePop(Case value) { casePop = value; }
        
    private StrategieDeJeu strat;
        /** @return Stratégie de jeu adoptée par la population */
        public StrategieDeJeu getStrat(){return strat;}
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
    
    
    public Population(Population pop)
    {
        this(pop.getNom(), pop.getNombreHabitants(),pop.getDieuPop(), pop.getRacePop(), pop.getCasePop(), pop.getStrat());
    }
    
    /**
     * Fait joueur la population suivant sa stratégie de jeu
     */
    public void jouer()
    {
        strat.jouer(this);
    }
    
    /**
     * Supprime la population de sa case
     */
    public void tuer()
    {
        setNombreHabitants(0);
        getCasePop().setPopulation(null);
        setCasePop(null);
    }
    
    /**
     * Lance l'attaque d'une population ennemie
     * Si la population attaquante perd elle disparait (tuer())
     * @param ennemi Population à attaquer
     * @return true -> L'attaquant gagne // false -> L'attaquant perd
     */
    public boolean attaquer(Population ennemi)
    {
        if (ennemi.defendre(this))
            return true;
        
        tuer(); // On a perdu ou égalité donc notre population meurt
        return false;
    }
    
    /**
     * Gere le combat quand la population se fait attaquer
     * @param ennemi Population attaquante
     * @return true -> L'attaquant gagne // false -> L'attaquant perd
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
    
    /**
     * Calcul le nombre de mort pour la population qui à gagnée le combat
     * @param gagnant Population gagnante
     * @param ratioGagnant Ratio bonus/malus d'attaque du gagnant
     * @param perdant Population perdante
     * @param ratioPerdant Ratio bonus/malus d'attaque du perdant
     * @return Nombre de morts dans la population du gagnant
     */
    private int calculNbMortPourLeGagnant(Population gagnant, float ratioGagnant, Population perdant, float ratioPerdant)
    {
        return (int)( ( (float)gagnant.getNombreHabitants() * (ratioPerdant*(float)perdant.getNombreHabitants()) ) / (ratioGagnant * (float)gagnant.getNombreHabitants()) );
    }
    
    /**
     * Renvoie le ratio bonus/malus a appliquer sur le nombre d'habitants pour obtenir le score d'attaque
     * @param terrainAttaque Terrain de l'attaque
     * @return Ratio
     */
    private float getRatioPuissanceAttaque(Terrain terrainAttaque)
    {
        float ratio = getRacePop().getBonusAttaque() + getDieuPop().getBonusBasePuissance();
        if(terrainAttaque.getNom().equals(getDieuPop().getTerrainPredilection()))
            ratio += getDieuPop().getBonusTerrainPuissance();
        return ratio;
    }
    
    /**
     * Fait croitre la population en augmentant plus ou moins son nombre d'habitant suivant son bonus d'accroissement
     */
    public void grandir()
    {
        int bebes = (int)(calculBonusAccroissement() * getNombreHabitants()/2);
        if (bebes == 0)
            bebes = 1;
        setNombreHabitants(getNombreHabitants() + bebes);
    }
   
    /**
     * Calcul le bonus d'accroissement de la population
     * @return Bonus d'accroissement de la population
     */
    private float calculBonusAccroissement()
    {
        float result = getDieuPop().getBonusBaseAccroissement() * getRacePop().getBonusAccroissement();
                result *= getCasePop().getTerrain().getBonusAccroissment();
        if (getCasePop().getTerrain().getNom().equals(getDieuPop().getTerrainPredilection()))
            result *= getDieuPop().getBonusTerrainAccroissement();
        return result;
    }    
    
}