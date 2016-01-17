package metier;

/**
 *
 * @author Cedric
 */
public abstract class StrategieDeJeu {
    
    /**
     * Fait jouer une population suivant la stratégie de jeu
     * @param pop Population à faire jouer
     */
    public abstract void jouer(Population pop);
}
