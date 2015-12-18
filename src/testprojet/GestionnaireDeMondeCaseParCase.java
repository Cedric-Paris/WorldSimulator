/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testprojet;

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
        posXCourant++;
        if(posXCourant>=getMonde().getLargeurLogique())
        {
            posXCourant=0;
            posYCourant++;
            if(posYCourant>=getMonde().getHauteurLogique())
            {
                posYCourant = 0;
                nbTourRestant--;
            }
        }
        return getMonde().getDamier()[posXCourant][posYCourant];
    }    
}
