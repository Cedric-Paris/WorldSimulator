package testprojet;

/**
 *
 * @author Cedric
 */
public class Terrain {
    
    private String nom;
        /** @return Nom du terrain */
        public String getNom(){return nom;}
        public void setNom(String nom){this.nom = nom;}
    
    private float bonusAccroissment;
        /** @return Bonus d'accroissement octroyé par le terrain */
        public float getBonusAccroissment() {return bonusAccroissment;}
        public void setBonusAccroissment(float bonusAccroissment){this.bonusAccroissment = bonusAccroissment;}
    
    private float bonusPuissance;
        /** @return Bonus de puissance octroyé par le terrain */
        public float getBonusPuissance() {return bonusPuissance;}
        public void setBonusPuissance(float bonusPuissance){this.bonusPuissance = bonusPuissance;}
        
    public Terrain(String nom, float bonusAccroissment, float bonusPuissance) {
        this.nom = nom;
        this.bonusAccroissment = bonusAccroissment;
        this.bonusPuissance = bonusPuissance;
    }
}
