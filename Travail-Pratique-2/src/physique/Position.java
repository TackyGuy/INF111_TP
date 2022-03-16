package physique;

/**
 * Classe qui définit la position en i et en j
 *
 * La position en i est accessibles en lecture/écriture par l'entremise de 2 méthodes:
 *  - getI
 *  - setI
 *
 * La position en i est accessibles en lecture/écriture par l'entremise de 2 méthodes:
 *  - getJ
 *  - setJ
 *
 * @author Fatma ALJANE, Guy BOUCHER, Jacinthe LAPOINTE
 * @version HIVER 2022
 */
public class Position {

    private int i;
    private int j;


    //Constructeurs par paramètre
    public Position(int i, int j){
        this.i = i;
        this.j = j;
    }

    //Constructeur par paramètre (surchage de méthode)
    public Position(Position pos){
        //
        this.i = pos.i;
        this.j = pos.j;
    }

    public void additionnerPos(Position pos){
        this.i += pos.i;
        this.j += pos.j;
    }

    public void soustrairePos(Position pos){
        this.i -= pos.i;
        this.j -= pos.j;
    }

    public void multiplierPos(double i, double j){
        this.i *= i;
        this.j *= j;
    }



    //Accesseurs et mutateurs
    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    /**
     * Méthode qui surcharge la méthode clone
     *
     * @return Position
     */
    @Override
    protected Position clone() {
        return new Position(this);
    }

    /**
     * Méthode qui surcharge la méthode equals
     *
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        Position pos = (Position) obj;

        if (pos != null){
            if (pos.i == this.i && pos.j == this.j){
                return true;
            }
        }

        return false;
    }

    /**
     * Méthode qui surcharge la méthode toString
     *
     * @return String
     */
    @Override
    public String toString() {
        return "physique.Position{" +
                "i=" + i +
                ", j=" + j +
                '}';
    }
}
