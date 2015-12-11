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
    
    private Case damier[][];
    private int longueurMax;
    int incMonde=0;

    public Monde(int nbCase) {
        this.longueurMax=(int)nbCase/2;
        for(int i=0;i<nbCase-longueurMax;i+=longueurMax)
        {
            for(int j=0;j<longueurMax;j++)
            {
                damier[j][incMonde]=new Case(this);
            }
            incMonde++;
        }
    }
    
    
    //Region Methodes
    public List<Case> FindTerrainAtLoc() 
    {
        
    }
}
