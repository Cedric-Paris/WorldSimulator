/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testprojet;

import java.util.List;

/**
 *
 * @author Ribière Laurent
 */
public class Monde {
    
    private int damier[][];
    private int longueurMax;

    public Monde(int nbCase) {
        this.longueurMax=(int)nbCase/2;
        for(int i=0;i<nbCase-longueurMax;i+=longueurMax)
        {
            for(int j=0;j<longueurMax;j++)
            {
                //damier[j][]
            }
        }
    }
    
    
    //Region Methodes
    /*public List<Case> FindTerrainAtLoc() 
    {
        
    }*/
}
