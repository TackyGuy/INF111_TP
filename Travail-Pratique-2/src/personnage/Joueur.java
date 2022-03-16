package personnage;

import donjon.Case;
import donjon.Donjon;
import physique.Position;

/**
 * classe du personnage qu joueur
 *
 * @author Fatma ALJANE, Guy BOUCHER, Jacinthe LAPOINTE
 * @version HIVER 2022
 */
public class Joueur extends AbstractPersonnage {

    public Joueur(Position pos) {
        super(pos);
    }

    /**
     * méthode qui permet au joueur de se déplacer dans une direction et de découvrir les cases proches
     * @param direction, direction du mouvement
     */
    @Override
    public void seDeplacer(int direction) {
        super.seDeplacer(direction);

        caseCourante.setDecouverte(true);
        for (int i = 0; i < 4; i++){
            Case caseVoisine = caseCourante.getVoisin(i);
            if (caseVoisine != null) caseVoisine.setDecouverte(true);
        }

    }
}
