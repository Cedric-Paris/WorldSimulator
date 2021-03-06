package metier;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cedric
 */
public abstract class Observable {
    
    private List<Observer> obs = new ArrayList<Observer>();
    
    /**
     * Enregistre un Observer a notifier
     * @param observer Observer a notifier
     */
    public void enregistrer(Observer observer)
    {
        obs.add(observer);
    }
    
    /**
     * Notifie tout les "Observer" enregistrés
     */
    protected void notifier()
    {
        notifier(null);
    }
    
    /**
     * Notifie tout les "Observer" enregistrés avec des paramètres
     */
    protected void notifier(Object obj)
    {
        for(Observer o : obs)
        {
            o.mettreAJour(this, obj);
        }
    }
}
