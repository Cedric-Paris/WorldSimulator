package metier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javafx.scene.paint.Color;

/**
 *
 * @author Nawhal
 * Cette classe a pour unique but de stocker les valeurs par defaut des dieux, terrains et populations.
 */

public class ValeursParDefaut {
    
    /**
     * @return la liste des dieux par défaut
     */
    public static List<Dieu> listeDieux()
    {
        List<Dieu> dieux = new ArrayList<>();
        dieux.add(new Dieu("Chauntéa, Déesse des Plaines", "Plaine", 0.9f, 1.5f, 0.9f, 1.5f, Color.ORANGE, "design/Chauntea.jpg"));
        dieux.add(new Dieu("Lissala, Mère Nourricière", "Plaine", 1.2f, 1.2f, 0.8f, 1.2f, Color.WHEAT, "design/Lissala.jpg"));
        dieux.add(new Dieu("Grumbar, Seigneur des Forgerons", "Plaine", 0.8f, 1.2f, 1.2f, 1.2f, Color.CHOCOLATE, "design/Grumbar.jpg"));
        dieux.add(new Dieu("Moradïn, Déesse des Montagnes", "Montagne", 0.9f, 1.5f, 0.9f, 1.5f, Color.BROWN, "design/Moradin.jpg"));
        dieux.add(new Dieu("Jean Philippe, Dieu des richesses et notaire de profession", "Montagne", 1f, 1.2f, 1f, 1.2f, Color.SILVER, "design/JeanPhilippe.jpg"));
        dieux.add(new Dieu("Ghorm Ghultyn, Père des Batailles", "Montagne", 0.8f, 1.2f, 1.2f, 1.2f, Color.DARKOLIVEGREEN, "design/GhormGhultyn.jpg"));
        dieux.add(new Dieu("Heruwa, Dieu des déserts", "Désert", 0.9f, 1.5f, 0.9f, 1.5f, Color.ANTIQUEWHITE, "design/Heruwa.jpg"));
        dieux.add(new Dieu("Sharess, Déesse de la Trahison", "Désert", 0.8f, 1.2f, 1.2f, 1.2f, Color.DARKMAGENTA, "design/Sharess.jpg"));
        dieux.add(new Dieu("Izdhar, Gardienne des Traditions", "Désert", 1.2f, 1.2f, 0.8f, 1.2f, Color.SALMON, "design/Izdhar.jpg"));
        dieux.add(new Dieu("Karl Mar, Dieu des Côtes", "Côte", 0.9f, 1.5f, 0.9f, 1.5f, Color.DODGERBLUE, "design/KarlMar.jpg"));
        dieux.add(new Dieu("Gond, Porteur de Merveilles", "Côte", 1.2f, 1.2f, 0.8f, 1.2f, Color.GOLDENROD, "design/Gond.jpg"));
        dieux.add(new Dieu("Istishia, Déesse des Flots Marins", "Côte", 1f, 1.2f, 1f, 1.2f, Color.DARKTURQUOISE, "design/Istishia.jpg"));
        dieux.add(new Dieu("Aerdrië, Déesse des Forêts", "Forêt", 0.9f, 1.5f, 0.9f, 1.5f, Color.DARKGREEN, "design/Aerdrie.jpg"));
        dieux.add(new Dieu("Labelas, Donneuse de Vie", "Forêt", 1.2f, 1.2f, 0.8f, 1.2f, Color.PLUM, "design/Labelas.jpg"));
        dieux.add(new Dieu("Rilifän, le Seigneur Feuille", "Forêt", 1f, 1.2f, 1f, 1.2f, Color.LIGHTGREEN, "design/Rilifan.jpg"));
        dieux.add(new Dieu("Ulutio, Dieu de la Tundra", "Tundra", 0.9f, 1.5f, 0.9f, 1.5f, Color.LIGHTCYAN, "design/Ulutio.jpg"));
        dieux.add(new Dieu("Veldharoon, Prince des Mensonges", "Tundra", 1.2f, 1.2f, 0.8f, 1.2f, Color.MEDIUMPURPLE, "design/Veldharoon.jpg"));
        dieux.add(new Dieu("Aurile, Vierge de Glace", "Tundra", 0.8f, 1.2f, 1.2f, 1.2f, Color.SNOW, "design/Aurile.jpg"));
        return dieux;
    }
    
    /**
     * @return une HashMap liant nom de dieu et population correspondante
     */
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
    
    /**
     * Initialise les Terrains par defaut dans FabriqueTerrain.
     */
    public static void initialiserTerrains()
    {
        FabriqueTerrain.ajouterTerrain("Plaine", 1.2f, 1f);
        FabriqueTerrain.ajouterTerrain("Montagne", 0.9f, 1.3f);
        FabriqueTerrain.ajouterTerrain("Désert", 0.9f, 0.9f);
        FabriqueTerrain.ajouterTerrain("Côte", 1.3f, 1f);
        FabriqueTerrain.ajouterTerrain("Forêt", 1.1f, 1.3f);
        FabriqueTerrain.ajouterTerrain("Tundra", 0.9f, 1f);
    }
    
    /**
     * @return une HashMap liant Terrain et Couleur, afin de pouvoir différencier les différents Terrains dans le jeu.
     */
    public static HashMap<Terrain, Color> couleurParTerrain()
    {
        HashMap<Terrain, Color> couleurParTerrain = new HashMap<>();
        couleurParTerrain.put(FabriqueTerrain.fabriquerTerrain("Plaine"), Color.rgb(178, 255, 102, 0.3));
        couleurParTerrain.put(FabriqueTerrain.fabriquerTerrain("Montagne"), Color.rgb(193, 127, 83, 0.3));
        couleurParTerrain.put(FabriqueTerrain.fabriquerTerrain("Désert"), Color.rgb(228, 194, 128, 0.3));
        couleurParTerrain.put(FabriqueTerrain.fabriquerTerrain("Côte"), Color.rgb(123, 223, 176, 0.3));
        couleurParTerrain.put(FabriqueTerrain.fabriquerTerrain("Forêt"), Color.rgb(103, 142, 109, 0.3));
        couleurParTerrain.put(FabriqueTerrain.fabriquerTerrain("Tundra"), Color.rgb(179, 201, 200, 0.3));
        return couleurParTerrain;
    }
}
