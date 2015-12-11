package testprojet;

import java.util.Map;

/**
 *
 * @author Nawhal
 */
public class FabriqueTerrain {
    
    public static Map<String, Terrain> terrains;
    
    public static Terrain fabriquerTerrain(String nom)
    {
        return terrains.get(nom);
    }
    
    public static void ajouterTerrain(String nom, float bonusAccroissment, float bonusPuissance)
    {
        if (!terrains.containsKey(nom))
            terrains.put(nom, new Terrain(nom, bonusAccroissment, bonusPuissance));
    }
}
