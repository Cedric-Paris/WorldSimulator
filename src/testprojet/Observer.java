package testprojet;

/**
 *
 * @author Cedric
 */
public interface Observer{
    
    /**
     * Appelée en cas de changement sur l'Observable
     * @param sender Observable a l'origine de la notification
     * @param param Parametres
     */
    public void mettreAJour(Observable sender, Object param);
    
}
