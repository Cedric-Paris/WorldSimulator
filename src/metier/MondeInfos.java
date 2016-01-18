package metier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Nawhal
 * Cette classe sert à stocker les informations données par l'utilisateur, ou déduies par ses choix (cas des populations) par rapport à la simulation qu'il veut voir.
 */
public class MondeInfos {
    private HashMap<Terrain, Integer> terrains;
        public HashMap<Terrain, Integer> getTerrains() { return terrains; }
    
    private HashMap<Dieu, Population> populations;
        public HashMap<Dieu, Population> getPopulations() { return populations; }
    
    private List<Dieu> dieux;
        public List<Dieu> getDieux() { return dieux; }
    
    public MondeInfos()
    {
        dieux = new ArrayList<>();
        terrains = new HashMap<>();
        populations = new HashMap<>();
    }
}
