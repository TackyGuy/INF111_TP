package donjon;
import physique.*;

/**
 * Cases du donjon
 *
 * La position est accessible en lecture par l'entremise de la méthode:
 *  - getPos()
 *
 * Les cases decouvertes sont accessibles en lecture/écriture par l'entremise de 2 méthodes:
 * - getConfig
 * - setDecouverte
 *
 * La case de fin de niveau es accessible en lecture/écriture par l'entremise de 2 méthodes:
 * - getFin
 * - setFin
 *
 * Les cases developpees sont accessible en lecture/écriture par l'entremise de 2 méthodes:
 * - estDeveloppee
 * - setDeveloppee
 *
 * Les cases découvertes sont accessible en lecture/écriture par l'entremise de 2 méthodes:
 * - getConfig
 * - setDecouverte
 *
 * Les cases voisines sont accessible en lecture/écriture par l'entremise de 2 méthodes:
 * - getVoisin
 * - setVoisin
 *
 * @author Fatma ALJANE, Guy BOUCHER, Jacinthe LAPOINTE
 * @version HIVER 2022
 */

public class Case {

    private Position position;

    private boolean estDecouverte;
    private boolean estFinNiveau;
    private boolean estDeveloppee;

    private Case[] caseVoisines = new Case[4];

    public Case(Position pos){
        this.position = pos;
    }

    //Accesseurs et mutateurs

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

    /**
     * Méthode qui surcharge la méthode toString
     *
     * @return String
     */
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
