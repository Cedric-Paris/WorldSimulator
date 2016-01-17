/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testprojet;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cedric
 */
public abstract class GestionnaireDeMonde extends Observable {
    
    private Monde monde;
        /** @return Monde géré par le gestionnaire */
        public Monde getMonde(){return monde;};

    public GestionnaireDeMonde(Monde monde) {
        this.monde = monde;
    }
    
    /**
     * Demarre le jeu
     */
    public void LancerPartie()
    {
        long delaisAvantDepart = 0;
        long tempsEntreDeuxTaches = 50;//1000 => 1s
        TimerTask task = new TimerTask(){
            
            @Override
            public void run() {
                Case cAJouer;
                if(!isOver())
                {
                    do
                        cAJouer = choixCaseAJouer();
                    while(cAJouer == null || cAJouer.getPopulation() == null);
                    traiterTourDeLaCase(cAJouer);
                }
                else
                {
                    System.out.println("CANCEL!");
                    cancel();
                }
            }
        };
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(task, delaisAvantDepart, tempsEntreDeuxTaches);
    }
    
    /**
     * Indique si la partie se termine
     * @return true -> Partie terminée / false -> Partie non terminée
     */
    abstract boolean isOver();
    
    /**
     * Choisit un case pour faire jouer la population qu'elle contient
     * @return Case à faire jouer
     */
    abstract Case choixCaseAJouer();
    
    /**
     * Fait jouer la case passée en argument
     * @param cAJouer Case à faire jouer
     */
    private void traiterTourDeLaCase(Case cAJouer)
    {
        cAJouer.getPopulation().jouer();
        notifier(null);
    }
    
}
