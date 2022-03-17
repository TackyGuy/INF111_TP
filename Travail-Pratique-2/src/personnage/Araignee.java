package personnage;

import physique.Position;

/**
 * classe de la créature araignée
 *
 * @author Fatma ALJANE, Guy BOUCHER, Jacinthe LAPOINTE
 * @version HIVER 2022
 */
public class Araignee extends AbstractCreature{
    public Araignee(Position pos) {
        super(pos);
    }

    @Override
    /**
     * Permet à l'araignée de se déplacer deux fois de sutie
     * @param direction, direction du mouvement
     */
    public void seDeplacer(int direction){
        super.seDeplacer(direction);
        super.seDeplacer(direction);
    }
}
