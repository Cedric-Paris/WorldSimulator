package metier;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

/**
 *
 * @author Cedric
 */
public abstract class AfficheurMonde {
    
    /**
     * Affiche un monde dans un canvas en calculant la taille idéale pour les cases du monde
     * @param world Monde à afficher
     * @param canvas Canvas sur lequel afficher le monde
     * @param hauteurTableau Hauteur du monde en nombre de case
     * @param largeurTableau Largeur du monde en nombre de case
     */
    public static void drawMonde(Case[][] world, Canvas canvas, int hauteurTableau, int largeurTableau)
    {
        int widthCase = (int)( canvas.getWidth()/(1 + (0.75*(largeurTableau-1))) );
        int heightCase = (int)( canvas.getHeight()/(hauteurTableau +(largeurTableau/2.0)) );
        canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for(int i = 0; i<hauteurTableau; i++)
        {
            for(int j = 0; j<largeurTableau; j++)
            {
                traiterAffichageCase(canvas, world[i][j], j, i, widthCase, heightCase);
            }
        }
    }
    
    /**
     * Affiche un case dans un canvas
     * @param canvas Canvas sur lequel afficher la case
     * @param c Case a afficher
     * @param xEnGrille Position en x de la case dans le damier du monde
     * @param yEnGrille Position en y de la case dans le damier du monde
     * @param largeurCase Largeur idéale en px pour la case
     * @param hauteurCase Hauteur idéale en px pour la case
     */
    private static void traiterAffichageCase(Canvas canvas, Case c, int xEnGrille, int yEnGrille, int largeurCase, int hauteurCase )
    {
        if(c == null)
            return;
        int posX = (int)( (largeurCase/2.0) + (largeurCase*0.75*xEnGrille) );
        int posY = (int)( canvas.getHeight() - ((hauteurCase/2.0)*(xEnGrille + 1)) - (yEnGrille * hauteurCase) );
        Hexagon.draw(canvas, largeurCase, hauteurCase, posX, posY, Color.TRANSPARENT);
        if (ValeursParDefaut.couleurParTerrain().get(c.getTerrain()) != null)
            Hexagon.draw(canvas, largeurCase-2, hauteurCase-2, posX, posY, ValeursParDefaut.couleurParTerrain().get(c.getTerrain()));
        else
            Hexagon.draw(canvas, largeurCase-2, hauteurCase-2, posX, posY, Color.rgb(255, 255, 255, 0.3));
        if(c.getPopulation() == null)
            return;
        double ratio = (c.getPopulation().getNombreHabitants())/100.0;
        Hexagon.draw(canvas, (int)((largeurCase-2)*ratio), (int)((hauteurCase-2)*ratio), posX, posY, c.getPopulation().getDieuPop().getCouleur());       
    }
    
}
