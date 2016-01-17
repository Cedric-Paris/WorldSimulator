package testprojet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javafx.scene.paint.Color;

/**
 *
 * @author Nawhal
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
    
    public static List<Dieu> listeDieux()
    {
        List<Dieu> dieux = new ArrayList<>();
        dieux.add(new Dieu("Chauntéa, Déesse des Plaines", "Plaine", 0.9f, 1.5f, 0.9f, 1.5f, Color.ORANGE, "Design/Chauntea.jpg"));
        dieux.add(new Dieu("Lissala, Mère Nourricière", "Plaine", 1.2f, 1.2f, 0.8f, 1.2f, Color.WHEAT, "Design/Lissala.jpg"));
        dieux.add(new Dieu("Grumbar, Seigneur des Forgerons", "Plaine", 0.8f, 1.2f, 1.2f, 1.2f, Color.MAROON, "Design/Grumbar.jpg"));
        dieux.add(new Dieu("Moradïn, Déesse des Montagnes", "Montagne", 0.9f, 1.5f, 0.9f, 1.5f, Color.BROWN, "Design/Moradin.jpg"));
        dieux.add(new Dieu("Jean Philippe, Dieu des richesses et notaire de profession", "Montagne", 1f, 1.2f, 1f, 1.2f, Color.SILVER, "Design/JeanPhilippe.jpg"));
        dieux.add(new Dieu("Ghorm Ghultyn, Père des Batailles", "Montagne", 0.8f, 1.2f, 1.2f, 1.2f, Color.WHEAT, "Design/GhormGhultyn.jpg"));
        dieux.add(new Dieu("Heruwa, Dieu des déserts", "Désert", 0.9f, 1.5f, 0.9f, 1.5f, Color.ANTIQUEWHITE, "Design/Heruwa.jpg"));
        dieux.add(new Dieu("Sharess, Déesse de la Trahison", "Désert", 0.8f, 1.2f, 1.2f, 1.2f, Color.DARKMAGENTA, "Design/Sharess.jpg"));
        dieux.add(new Dieu("Izdhar, Gardienne des Traditions", "Désert", 1.2f, 1.2f, 0.8f, 1.2f, Color.SALMON, "Design/Izdhar.jpg"));
        dieux.add(new Dieu("Karl Mar, Dieu des Côtes", "Côte", 0.9f, 1.5f, 0.9f, 1.5f, Color.DODGERBLUE, "Design/KarlMar.jpg"));
        dieux.add(new Dieu("Gond, Porteur de Merveilles", "Côte", 1.2f, 1.2f, 0.8f, 1.2f, Color.GOLDENROD, "Design/Gond.jpg"));
        dieux.add(new Dieu("Istishia, Déesse des Flots Marins", "Côte", 1f, 1.2f, 1f, 1.2f, Color.DARKTURQUOISE, "Design/Istishia.jpg"));
        dieux.add(new Dieu("Aerdrië, Déesse des Forêts", "Forêt", 0.9f, 1.5f, 0.9f, 1.5f, Color.DARKGREEN, "Design/Aerdrie.jpg"));
        dieux.add(new Dieu("Labelas, Donneuse de Vie", "Forêt", 1.2f, 1.2f, 0.8f, 1.2f, Color.PLUM, "Design/Labelas.jpg"));
        dieux.add(new Dieu("Rilifän, le Seigneur Feuille", "Forêt", 1f, 1.2f, 1f, 1.2f, Color.LIGHTGREEN, "Design/Rilifan.jpg"));
        dieux.add(new Dieu("Ulutio, Dieu de la Tundra", "Tundra", 0.9f, 1.5f, 0.9f, 1.5f, Color.LIGHTCYAN, "Design/Ulutio.jpg"));
        dieux.add(new Dieu("Veldharoon, Prince des Mensonges", "Tundra", 1.2f, 1.2f, 0.8f, 1.2f, Color.MEDIUMPURPLE, "Design/Veldharoon.jpg"));
        dieux.add(new Dieu("Aurile, Vierge de Glace", "Tundra", 0.8f, 1.2f, 1.2f, 1.2f, Color.SNOW, "Design/Aurile.jpg"));
        return dieux;
    }
    
    public static HashMap<String, Population> populationParDieu()
    {
        HashMap<String, Population> populationParDieu = new HashMap<>();
        List<Dieu> dieux = listeDieux();
        
        Race nymphe = new Race("Nymphe", 0.9f, 1.1f);
        Race elfe = new Race("Elfe", 0.95f, 1.05f);
        Race sirene = new Race("Sirène", 0.95f, 1.05f);
        Race humain = new Race("Humain", 1f, 1f);
        Race nain = new Race("Nain", 1.05f, 0.95f);
        Race geant = new Race("Géant", 1.1f, 0.9f);
        
        populationParDieu.put("Chauntéa, Déesse des Plaines", new Population("Humains des cités", 2, dieux.get(0), humain));
        populationParDieu.put("Lissala, Mère Nourricière", new Population("Humains paysans", 2, dieux.get(1), humain));
        populationParDieu.put("Grumbar, Seigneur des Forgerons", new Population("Nains artisans", 2, dieux.get(2), nain));
        populationParDieu.put("Moradïn, Déesse des Montagnes", new Population("Nains montagnards", 2, dieux.get(3), nain));
        populationParDieu.put("Jean Philippe, Dieu des richesses et notaire de profession", new Population("Humains notaires", 2, dieux.get(4), humain));
        populationParDieu.put("Ghorm Ghultyn, Père des Batailles", new Population("Nains des profondeurs", 2, dieux.get(5), nain));
        populationParDieu.put("Heruwa, Dieu des déserts", new Population("Humains nomades", 2, dieux.get(6), humain));
        populationParDieu.put("Sharess, Déesse de la Trahison", new Population("Nymphes des oasis", 2, dieux.get(7), nymphe));
        populationParDieu.put("Izdhar, Gardienne des Traditions", new Population("Elfes noirs", 2, dieux.get(8), elfe));
        populationParDieu.put("Karl Mar, Dieu des Côtes", new Population("Humains touristes", 2, dieux.get(9), humain));
        populationParDieu.put("Gond, Porteur de Merveilles", new Population("Géants féluriens", 2, dieux.get(10), geant));
        populationParDieu.put("Istishia, Déesse des Flots Marins", new Population("Sirènes", 2, dieux.get(11), sirene));
        populationParDieu.put("Aerdrië, Déesse des Forêts", new Population("Elfes sylvestres", 2, dieux.get(12), elfe));
        populationParDieu.put("Labelas, Donneuse de Vie", new Population("Nymphes des forêts", 2, dieux.get(13), nymphe));
        populationParDieu.put("Rilifän, le Seigneur Feuille", new Population("Elfes sylvestres", 2, dieux.get(14), elfe));
        populationParDieu.put("Ulutio, Dieu de la Tundra", new Population("Géant de glace", 2, dieux.get(15), geant));
        populationParDieu.put("Veldharoon, Prince des Mensonges", new Population("Nymphes des neiges", 2, dieux.get(16), nymphe));
        populationParDieu.put("Aurile, Vierge de Glace", new Population("Géants de glace", 2, dieux.get(17), geant));
        
        return populationParDieu;
    }
}
