/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testprojet;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cedric
 */
public abstract class Observable {
    
    private List<Observer> obs = new ArrayList<Observer>();
    
    public void enregistrer(Observer observer)
    {
        obs.add(observer);
    }
    
    protected void notifier()
    {
        for(Observer o : obs)
        {
            o.mettreAJour();
        }
    }
}
