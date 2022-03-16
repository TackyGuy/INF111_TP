package personnage;

import physique.Position;

public class Araignee extends AbstractCreature{
    public Araignee(Position pos) {
        super(pos);
    }

    @Override
    public void seDeplacer(int direction){
        super.seDeplacer(direction);
        super.seDeplacer(direction);
    }
}
