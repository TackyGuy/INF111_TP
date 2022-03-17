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
     * méthode qui permet au joueur de se déplacer dans une direction
     * @param direction Integer qui représente une direction
     */
    @Override
    public void seDeplacer(int direction) {
        super.seDeplacer(direction);

        decouvrirCase();
    }

    /**
     * méthode découvre les cases voisines et courantes du joueurs
     */
    public void decouvrirCase(){
        caseCourante.setDecouverte(true);
        for (int i = 0; i < 4; i++){
            Case caseVoisine = caseCourante.getVoisin(i);
            if (caseVoisine != null) caseVoisine.setDecouverte(true);
        }
    }
}
