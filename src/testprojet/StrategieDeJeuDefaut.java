package testprojet;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Cedric
 */
public class StrategieDeJeuDefaut extends StrategieDeJeu {

    @Override
    public void jouer(Population pop) {
        if(pop.getNombreHabitants() == Population.MAX_POPULATION)
        {
            gererDeplacement(pop);
            return;
        }
        pop.grandir();
    }
    
    /**
     * Gere les actions d'une population si elle a atteint le nombre maximal
     * @param pop Population à traiter
     */
    private void gererDeplacement(Population pop)
    {
        List<Case> voisins = pop.getCasePop().getVoisin();
        List<Case> libre = new ArrayList<>();
        List<Case> ennemis = new ArrayList<>();
        
        for(Case c : voisins)
        {
            if(c.getPopulation() == null)
            {
                libre.add(c);
                continue;
            }
            if(!(c.getPopulation().getDieuPop() == pop.getDieuPop()))
                ennemis.add(c);                
        }
        
        if(libre.size() > 0)
        {
            deplacer(pop, libre.get( ThreadLocalRandom.current().nextInt(0, libre.size()) ));
            return;
        }
        if(ennemis.size() > 0)
        {
            int indexAAttaquer = ThreadLocalRandom.current().nextInt(0, ennemis.size());
            if(pop.attaquer(ennemis.get(indexAAttaquer).getPopulation() ))
                deplacer(pop,ennemis.get(indexAAttaquer));
        }
    }
    
    /**
     * Déplace une population sur une case voisine
     * @param p Population à déplacer
     * @param c Case où la population doit être déplacée
     */
    private void deplacer(Population p, Case c)
    {
        p.setNombreHabitants(p.getNombreHabitants()/2);
        c.setPopulation(new Population(p));
        c.getPopulation().setNombreHabitants(p.getNombreHabitants());
    }
}
