package metier;

/**
 *
 * @author Cedric
 */
public class GestionnaireDeMondeCaseParCase extends GestionnaireDeMonde {

    private int nbTourRestant = 0;
    private int posXCourant = -1;
    private int posYCourant = 0;

    public GestionnaireDeMondeCaseParCase(Monde monde, int nbTour) {
        super(monde);
        nbTourRestant = nbTour;
    }

    @Override
    boolean isOver() {
        return nbTourRestant == 0;
    }

    @Override
    Case choixCaseAJouer() {
        if(posXCourant==getMonde().getLargeurLogique()-1)
        {
            posXCourant=0;
            posYCourant++;
            if(posYCourant==getMonde().getLargeurLogique())
            {
                posYCourant = 0;
                nbTourRestant--;
            }
        }
        else
            posXCourant++;
        return getMonde().getDamier()[posXCourant][posYCourant];
    }    
}
