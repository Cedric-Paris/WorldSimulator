/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testprojet;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author Cedric
 */
public class AfficheurMonde {
    
    private AfficheurMonde(){}
    
    public static void drawMonde(Case[][] world, Canvas canvas, int largeurTableau, int hauteurTableau)
    {
        int widthCase = (int)((canvas.getWidth())/largeurTableau);
        int heightCase = (int)((canvas.getWidth())/hauteurTableau);
        for(int i = 0; i<hauteurTableau; i++)
        {
            for(int j = 0; j<largeurTableau; j++)
            {
                traiterAffichageCase(canvas, world[i][j]);
            }
        }
    }
    
    private static void traiterAffichageCase(Canvas canvas, Case c)
    {
        if(c == null)
            return;
        
                
    }
}
