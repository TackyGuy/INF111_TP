package personnage;

import donjon.Case;
import donjon.Donjon;
import physique.Position;

public class Joueur extends AbstractPersonnage {

    public Joueur(Position pos) {
        super(pos);
    }

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
