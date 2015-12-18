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
    private final Case damier[][];
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
         for(int i=0;i<longueurMax;i++)
       {
           System.out.print("\n-------------------------------------------------------------------------------------\n");
           for(int j=0;j<longueurMax;j++)
           {
               try{
                   System.out.print(" | "+damier[i][j]);
               }catch(NullPointerException e){
                   System.out.println("Limite de la carte!");
               }
           }
       }
         System.out.println();
    }
    
    
    public ArrayList<Case> findVoisinAtLoc(int idCase) 
    {
       ArrayList<Case> voisin = new ArrayList<>();

       for(int i=0;i<longueurMax;i++)
       {
           for(int j=0;j<longueurMax;j++)
           {
               try{
               if(damier[i][j].getId()==idCase)
               {
                   try{
                       ajouterVoisin(voisin, i, j);
                   }catch(ArrayIndexOutOfBoundsException e)
                   {
                       System.out.println("Voisin en dehors de la carte.");
                   }
               }
               }catch(NullPointerException e){
               }
           }
       }
       return voisin;
    }
    
    private boolean existVoisin(int i, int j)
    {
        return damier[i][j]!=null;
    }
    
    
    private void ajouterVoisin(ArrayList voisin, int i, int j)
    {
        if(existVoisin(i+1,j))
            voisin.add(damier[i+1][j]);
        if(existVoisin(i,j+1))
            voisin.add(damier[i][j+1]);
        if(existVoisin(i+1,j+1))
            voisin.add(damier[i+1][j+1]);
        if(existVoisin(i-1,j))
            voisin.add(damier[i-1][j]);
        if(existVoisin(i,j-1))
            voisin.add(damier[i][j-1]);
        if(existVoisin(i-1,j-1))
            voisin.add(damier[i-1][j-1]);
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
