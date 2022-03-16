package donjon;
import physique.*;

public class Case {

    private Position position;

    private boolean estDecouverte;
    private boolean estFinNiveau;
    private boolean estDeveloppee;

    private Case[] caseVoisines = new Case[4];

    public Case(Position pos){
        this.position = pos;
    }

    public Position getPos(){
        return new Position(position);
    }

    public boolean getDecouverte() {
        return estDecouverte;
    }

    public void setDecouverte(boolean estDecouverte) {
        this.estDecouverte = estDecouverte;
    }

    public boolean getFin() {
        return estFinNiveau;
    }

    public void setFin(boolean estFinNiveau) {
        this.estFinNiveau = estFinNiveau;
    }

    public boolean estDeveloppee() {
        return estDeveloppee;
    }

    public void setDeveloppee(boolean estDeveloppee) {
        this.estDeveloppee = estDeveloppee;
    }

    public Case getVoisin(int indexDirection) {
        return caseVoisines[indexDirection];
    }

    public void setVoisin(int dir, Case voisin) {
        caseVoisines[dir] = voisin;
    }

    @Override
    public String toString() {
        return "Case{" +
                "position=" + position +
                ", estDecouverte=" + estDecouverte +
                ", estFinNiveau=" + estFinNiveau +
                ", estDeveloppee=" + estDeveloppee +
                '}';
    }
}
