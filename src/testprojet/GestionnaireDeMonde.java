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
        public Monde getMonde(){return monde;};

    public GestionnaireDeMonde(Monde monde) {
        this.monde = monde;
    }
    
    public void LancerPartie()
    {
        long delaisAvantDepart = 0;
        long tempsEntreDeuxTaches = 100;//1000 => 1s
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
    
    abstract boolean isOver();
    
    abstract Case choixCaseAJouer();
    
    private void traiterTourDeLaCase(Case cAJouer)
    {
        cAJouer.getPopulation().jouer();
        notifier(null);
    }
    
}
