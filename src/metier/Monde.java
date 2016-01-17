package metier;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Ribière Laurent
 */
public class Monde {

    private final Case damier[][];//////[y][x]----------> Construit en [hauteur][largeur] au lieu de [x][y]
        /** @return Damier représentant le monde */
        public Case[][] getDamier(){return damier;}
        
        
    private final int longueurMax;    
    private int hauteurLogique;
    private int largeurLogique;
    


    public Monde(MondeInfos mondeInfos)
    {
        int nbCase = calculerNbCase(mondeInfos);
        this.longueurMax=(int)Math.sqrt(nbCase)+1;
        damier = new Case[longueurMax][longueurMax];
        
        genererDamierCaseVide(nbCase);
        genererTerrainCase(mondeInfos, nbCase);
        mettrePopulationsDansCases(mondeInfos, nbCase);
    }
    
    /**
     * Calcul le nombre de case necessaire a partir des informations du monde a générer
     * @param mondeInfos Information sur le monde à générer
     * @return Nombre de case necessaire pour créer le monde
     */
    private int calculerNbCase(MondeInfos mondeInfos)
    {
        int nbCase = 0;
        for(Terrain t : mondeInfos.getTerrains().keySet())
        {
            nbCase += mondeInfos.getTerrains().get(t);
        }
        return nbCase;
    }
    
    /**
     * Place des Cases vide (Sans populations dans le damier)
     * @param nbCase Nombre de case a créer 
     */
    private void genererDamierCaseVide(int nbCase)
    {
        int incMonde=0;
        int idCase=1;
        
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
    
    /**
     * Obtient la liste des cases du damier
     * @return Liste des Cases du damier
     */
    private ArrayList<Case> getListeCase()
    {
        ArrayList<Case> listeCases = new ArrayList<>();
        for(Case tabC[]: damier)
        {
            for(Case c: tabC)
            {
                if(c!=null)
                    listeCases.add(c);
            }
        }  
        return listeCases;
    }
    
    /**
     * Renseigne le Terrain de chaque case de maniere aléatoire
     * @param mondeInfos Information sur le monde à créer
     * @param nbCase Nombre de case dans le damier
     */
    private void genererTerrainCase(MondeInfos mondeInfos, int nbCase)
    {
        int index;
        ArrayList<Case> listeCases = getListeCase();

        for(Terrain t : mondeInfos.getTerrains().keySet())
        {
            for(int i=0; i<mondeInfos.getTerrains().get(t); i++)
            {
                index = ThreadLocalRandom.current().nextInt(0, listeCases.size());
                listeCases.get(index).setTerrain(t);
                listeCases.remove(index);
            }
        }
    }
    
    private void mettrePopulationsDansCases(MondeInfos mondeInfos, int nbCase)
    {
        int index;
        ArrayList<Case> listeCases = getListeCase();
        
        for(Population p : mondeInfos.getPopulations().values())
        {
            index = ThreadLocalRandom.current().nextInt(0, listeCases.size());
            listeCases.get(index).setPopulation(p);
            listeCases.remove(index);
        }
    }
    
    /**
     * Trouve la liste des voisins de la case ayant l'ID passer en argument
     * @param idCase
     * @return Liste des voisins
     */
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
    
    /**
     * Ajoute un voisin a la liste des voisins si il existe     * 
     * @param voisins Liste des voisins
     * @param posx Position en x du voisin a vérifier
     * @param posy Position en y du voisin a vérifier
     */
    private void ajoutVoisinSiExist(ArrayList<Case> voisins, int posx, int posy)
    {
        if(posy >= hauteurLogique || posx >= largeurLogique || posx < 0 || posy < 0)
            return;
        if (damier[posy][posx]!=null)
            voisins.add(damier[posy][posx]);        
    }
    
    /**
     * Ajoute les voisin de la case a la position (i,j) a la liste de voisins 
     * @param voisins Liste des voisins
     * @param i Position en y de la case
     * @param j Position en x de la case
     */
    private void ajouterVoisins(ArrayList<Case> voisins, int i, int j)
    {
            ajoutVoisinSiExist(voisins, j-1, i);
            ajoutVoisinSiExist(voisins, j-1, i+1);
            ajoutVoisinSiExist(voisins, j, i+1);
            ajoutVoisinSiExist(voisins, j, i-1);
            ajoutVoisinSiExist(voisins, j+1, i);
            ajoutVoisinSiExist(voisins, j+1, i-1);
    }
    
    /**
     * @return Hauteur du monde en nombre de cases
     */
    public int getHauteurLogique()
    {
        return hauteurLogique;
    }
    
    /**
     * @return Largeur du monde en nombre de cases
     */
    public int getLargeurLogique()
    {
        return largeurLogique;
    }
    
    /**
     * Calcul la largeur du monde en nombre de cases
     * @return Largeur du monde en nombre de cases
     */
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
    
    /**
     * Calcul la hauteur du monde en nombre de cases
     * @return Hauteur du monde en nombre de cases
     */
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
