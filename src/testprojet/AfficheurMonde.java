/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testprojet;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author Cedric
 */
public abstract class AfficheurMonde {
    
    public static void drawMonde(Case[][] world, Canvas canvas, int hauteurTableau, int largeurTableau)
    {
        //int widthCase = (int)( (3.5*canvas.getWidth())/(2.0*largeurTableau) );
        int widthCase = (int)( canvas.getWidth()/(1 + (0.75*(largeurTableau-1))) );
        int heightCase = (int)( canvas.getHeight()/(hauteurTableau +(largeurTableau/2.0)) );
        for(int i = 0; i<hauteurTableau; i++)
        {
            for(int j = 0; j<largeurTableau; j++)
            {
                traiterAffichageCase(canvas, world[i][j], j, i, widthCase, heightCase);
            }
        }
    }
    
    private static void traiterAffichageCase(Canvas canvas, Case c, int xEnGrille, int yEnGrille, int largeurCase, int hauteurCase )
    {
        if(c == null)
            return;        
        int posX = (int)( (largeurCase/2.0) + (largeurCase*0.75*xEnGrille) );
        int posY = (int)( canvas.getHeight() - ((hauteurCase/2.0)*(xEnGrille + 1)) - (yEnGrille * hauteurCase) );
        Hexagon.draw(canvas, largeurCase, hauteurCase, posX, posY, Color.BLACK);
        Hexagon.draw(canvas, largeurCase-2, hauteurCase-2, posX, posY, Color.RED);
                
    }
    
}
