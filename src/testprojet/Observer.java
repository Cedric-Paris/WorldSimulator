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
public interface Observer{
    
    /**
     * Appelée en cas de changement sur l'Observable
     * @param sender Observable a l'origine de la notification
     * @param param Parametres
     */
    public void mettreAJour(Observable sender, Object param);
    
}
