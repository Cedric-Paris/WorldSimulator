/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testprojet;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/**
 *
 * @author Cedric
 */
public class Hexagon {
    
    private Hexagon(){}
    
    private static double[] coordX = new double[] { 0, 0.25, 0.75, 1, 0.75, 0.25 };
    private static double[] coordY = new double[] { 0.5, 1, 1, 0.5, 0, 0 };
    
    public static void draw(Canvas canvas, int width, int height, int posX, int posY, Color couleur)
    {
        double[] tabX = new double[6];
        double[] tabY = new double[6];
        for(int i=0; i<6; i++)
        {
            tabX[i] = (coordX[i]*width) + posX;
            tabY[i] = (coordY[i]*height) + posY;
        }
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(couleur);
        gc.fillPolygon(tabX, tabY, 6);
    }
    
    public static void draw(Canvas canvas, int width, int height, int posX, int posY, Color couleur, double pourcentage)
    {
        double[] tabX = new double[6];
        double[] tabY = new double[6];
        for(int i=0; i<6; i++)
        {
            tabX[i] = (coordX[i]*width);
            tabY[i] = (coordY[i]*height);
        }
        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        Canvas canvasTemp = new Canvas(); 
        canvasTemp.setWidth(width*pourcentage); 
        canvasTemp.setHeight(height);
        GraphicsContext gcTemp = canvasTemp.getGraphicsContext2D();
        gcTemp.setFill(couleur);
        gcTemp.fillPolygon(tabX, tabY, 6);
        
        WritableImage i = new WritableImage((int)(width*pourcentage), height);
        SnapshotParameters sp = new SnapshotParameters();
        sp.setFill(Color.TRANSPARENT);//Parametre parmettant de prendre en compte la transparence dans le canevas
        canvasTemp.snapshot(sp, i);
        
        gc.drawImage(i, posX, posY);
    }
}
