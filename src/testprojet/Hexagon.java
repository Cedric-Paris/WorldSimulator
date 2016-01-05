/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testprojet;

import javafx.application.Platform;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

/**
 *
 * @author Cedric
 */
public abstract class Hexagon {
    
    //private static double[] coordX = new double[] { 0, 0.25, 0.75, 1, 0.75, 0.25 };
    //private static double[] coordY = new double[] { 0.5, 1, 1, 0.5, 0, 0 };
    private static double[] coordX = new double[] { -0.5, -0.25, 0.25, 0.5, 0.25, -0.25 };
    private static double[] coordY = new double[] { 0, 0.5, 0.5, 0, -0.5, -0.5 };
    
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
        if(pourcentage == 0)
            return;
        for(int i=0; i<6; i++)
        {
            tabX[i] = ((coordX[i]+0.5)*width);
            tabY[i] = ((coordY[i]+0.5)*height);
        }
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Canvas canvasTemp = new Canvas(); 
        canvasTemp.setWidth(width*pourcentage); 
        canvasTemp.setHeight(height);
        GraphicsContext gcTemp = canvasTemp.getGraphicsContext2D();
        gcTemp.setFill(couleur);
        gcTemp.fillPolygon(tabX, tabY, 6);
        
        Platform.runLater(new Runnable() {//Necessaire car snapshot ne peut être appelé que si on est dans le javafx thread
            public void run() { 
                WritableImage i = new WritableImage((int)(width*pourcentage), height);
                SnapshotParameters sp = new SnapshotParameters();
                sp.setFill(Color.TRANSPARENT);//Parametre parmettant de prendre en compte la transparence dans le canevas
                canvasTemp.snapshot(sp, i);
                gc.drawImage(i, posX-(width/2), posY-(height/2));
            }
        });        
    }
}
