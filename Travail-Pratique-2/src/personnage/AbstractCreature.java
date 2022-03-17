package personnage;

import physique.Position;

/**
 * Classe abstraite dont les créatures héritent
 *
 * @author Fatma ALJANE, Guy BOUCHER, Jacinthe LAPOINTE
 * @version HIVER 2022
 */
public abstract class AbstractCreature extends AbstractPersonnage {
    public AbstractCreature(Position pos) {
        super(pos);
    }
}
