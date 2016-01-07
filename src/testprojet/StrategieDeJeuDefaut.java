/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testprojet;

import java.util.ArrayList;

/**
 *
 * @author Cedric
 */
public class StrategieDeJeuDefaut extends StrategieDeJeu {

    @Override
    public void jouer(Population pop) {
        if(pop.getNombreHabitants() == Population.MAX_POPULATION)
            gererDeplacement(pop);
        pop.grandir();
    }
    
    private void gererDeplacement(Population pop)
    {
        
        ArrayList<Case> voisins = pop.getCasePop().getVoisin();
        Case caseAAttquerEventuellement = null;
        for(Case c : voisins)
        {
            if(c.getPopulation() == null)
            {
                deplacer(pop, c);
                break;
            }
            if(!(c.getPopulation().getDieuPop() == pop.getDieuPop()))
                caseAAttquerEventuellement = c;                
        }
        System.out.println("-Attaqué-");
        if(caseAAttquerEventuellement == null)
            return;
        if(pop.attaquer(caseAAttquerEventuellement.getPopulation()))
            deplacer(pop, caseAAttquerEventuellement);
        
        
    }
    
    private void deplacer(Population p, Case c)
    {
        System.out.println("-Deplacer-");
        p.setNombreHabitants(p.getNombreHabitants()/2);
        c.setPopulation(new Population(p));
    }
}
