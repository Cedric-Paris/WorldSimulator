package metier;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Nawhal
 */
public abstract class FabriqueTerrain {
    
    private static Map<String, Terrain> terrains = new HashMap();
    
    /**
     * Renvoie une instance de Terrain ayant le nom passé en argument
     * Renvoie null si aucun Terrain n'est associé a ce nom
     * @param nom Nom du Terrain
     * @return Terrain associé au nom passé en argument
     */
    public static Terrain fabriquerTerrain(String nom)
    {
        return terrains.get(nom);
    }
    
    /**
     * Ajoute un Terrain a la liste des terrains disponible
     * @param nom Nom du terrain a ajouter
     * @param bonusAccroissment Bonus d'accroissement octroyé par le terrain
     * @param bonusPuissance Bonus de puissance octroyé par le terrain
     */
    public static void ajouterTerrain(String nom, float bonusAccroissment, float bonusPuissance)
    {
        if (!terrains.containsKey(nom))
            terrains.put(nom, new Terrain(nom, bonusAccroissment, bonusPuissance));
    }
}
