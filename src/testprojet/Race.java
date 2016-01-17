package testprojet;

/**
 *
 * @author Cedric
 */
public class Race {
    
    private String nom;
        /** @return Nom de la race */
        public String getNom() { return nom; }
        public void setNom(String value) { nom = value; }
    
    private float bonusAttaque;
        /** @return Bonus d'attaque octroyé par la race */
        public float getBonusAttaque() { return bonusAttaque; }
        public void setBonusAttaque(float value) { bonusAttaque = value; }
    
    private float bonusAccroissement;
        /** @return Bonus d'accroissement octroyé par la race */
        public float getBonusAccroissement() { return bonusAccroissement; }
        public void setBonusAccroissement(float value) { bonusAccroissement = value; }

    public Race(String nom, float bonusAttaque, float bonusAccroissement) 
    {
        setNom(nom);
        setBonusAttaque(bonusAttaque);
        setBonusAccroissement(bonusAccroissement);
    }

}
