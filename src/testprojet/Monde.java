/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testprojet;

import java.util.ArrayList;

/**
 *
 * @author Ribière Laurent
 */
public class Monde {
    //Region Attribut/Propriete
    private final Case damier[][];//////[y][x]----------> Construit en [hauteur][largeur] au lieu de [x][y]
        public Case[][] getDamier(){return damier;}
        
    private final int longueurMax;
    //Fin de Region
    
    private int hauteurLogique;
    private int largeurLogique;
    
    
    //Region Constructeur

    public Monde(int nbCase) {
        int incMonde=0;
        int idCase=1;
        this.longueurMax=(int)Math.sqrt(nbCase)+1;
        damier = new Case[longueurMax][longueurMax];
        for(int i=0;i<nbCase;i+=longueurMax)
        {
            for(int j=0;j<longueurMax;j++)
            {
                damier[incMonde][j]=new Case(this,idCase);
                System.out.println("création de la case numero "+idCase);
                if(idCase==nbCase)
                    break;
                idCase++;
            }
            incMonde++;
        }
        largeurLogique = calculLargeurLogique();
        hauteurLogique = calculHauteurLogique();
    }
    //Fin de Region
    
    
    //Region Methodes
    
    public void showDamier()
    {
        for(int i=longueurMax-1; i>=0; i--)
        {
            System.out.println("\n---------------------------------------");
            for(int j=0; j<longueurMax;j++)
            {
                if(damier[i][j]!=null)
                    System.out.print("|  " + damier[i][j].getId()+"  ");
                else
                    System.out.print("| null ");
            }
            
        }
        System.out.println("\n---------------------------------------\n");
    }
    
    
    public ArrayList<Case> findVoisinAtLoc(int idCase)
    {
        ArrayList<Case> voisins = new ArrayList<>();
        for(int i=0; i<hauteurLogique; i++)
        {
            for(int j=0; j<largeurLogique; j++)
            {
                if (damier[i][j]!=null && damier[i][j].getId()==idCase)
                {
                    ajouterVoisins(voisins, i, j);
                    return voisins;
                }
            }
        }
        return voisins;
    }
    
    private void ajoutVoisinSiExist(ArrayList<Case> voisins, int posx, int posy)
    {
        if(posy >= hauteurLogique || posx >= largeurLogique || posx < 0 || posy < 0)
            return;
        if (damier[posy][posx]!=null)
            voisins.add(damier[posy][posx]);        
    }
    
    private void ajouterVoisins(ArrayList<Case> voisins, int i, int j)
    {
            ajoutVoisinSiExist(voisins, j-1, i);
            ajoutVoisinSiExist(voisins, j-1, i+1);
            ajoutVoisinSiExist(voisins, j, i+1);
            ajoutVoisinSiExist(voisins, j, i-1);
            ajoutVoisinSiExist(voisins, j+1, i);
            ajoutVoisinSiExist(voisins, j+1, i-1);
    }
    
    public int getHauteurLogique()
    {
        return hauteurLogique;
    }
    
    public int getLargeurLogique()
    {
        return largeurLogique;
    }
    
    private int calculLargeurLogique()
    {
        int compteur = 0;
        for(int j=0;j<longueurMax; j++)
        {
            for(int i = 0; i<longueurMax ; i++)
            {
                if(damier[i][j]!=null)
                {
                    compteur++;
                    break;
                }
            }
        }
        return compteur;
    }
    
    private int calculHauteurLogique()
    {
        int compteur = 0;
        for(int i=0;i<longueurMax; i++)
        {
            for(int j = 0; j<longueurMax ; j++)
            {
                if(damier[i][j]!=null)
                {
                    compteur++;
                    break;
                }
            }
        }
        return compteur;
    }
}
