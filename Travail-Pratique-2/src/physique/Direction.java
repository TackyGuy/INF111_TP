package physique;

import java.util.Random;

/**
 * Classe qui contient les differentes directions possible avec des méthodes associées
 *
 * @author Fatma ALJANE, Guy BOUCHER, Jacinthe LAPOINTE
 * @version HIVER 2022
 */

public class Direction {

    public static final int HAUT = 0, BAS = 1, GAUCHE = 2, DROITE = 3;

    private static Random RAND = new Random();

    /**
     * Méthode qui prend en paramètre une direction et qui retourne la direction oppsoée associée
     * @param dir Integer qui représente une direction
     * @return nouvDir Integer qui représente une direction opposée à celle dans les paramètrs
     * @throws Exception
     */
    public static int directionOpposee(int dir) throws Exception{
        int nouvDir = 0;
        switch (dir){
            case HAUT:
                nouvDir = BAS;
                break;
            case BAS:
                nouvDir = HAUT;
                break;
            case GAUCHE:
                nouvDir = DROITE;
                break;
            case DROITE:
                nouvDir = GAUCHE;
                break;
            default:
                throw new Exception("Parametre invalide");
        }

        return nouvDir;
    }

    /**
     * Methode qui prend en paramètre une direction et la transforme en position
     *
     * @param dir Integer qui définie une direction
     * @return pos Reference à une position
     */
    public static Position directionAPosition(int dir) throws Exception{
        Position pos = null;

        switch (dir){
            case HAUT:
                pos = new Position(-1, 0);
                break;
            case BAS:
                pos = new Position(1, 0);
                break;
            case GAUCHE:
                pos = new Position(0, -1);
                break;
            case DROITE:
                pos = new Position(0, 1);
                break;
            default:
                throw new Exception("Parametre invalide");
        }
        return pos;
    }

    /**
     * Methode qui prend en paramètre une position et la transforme en direction
     *
     * @param pos Reference à une position
     * @return dir Integer qui représente une direction
     */
    public static int positionADirection(Position pos){
        int dir = -1;

        if (pos.getI() == -1 && pos.getJ() == 0) dir = HAUT ;
        else if (pos.getI() == 1 && pos.getJ() == 0) dir = BAS ;
        else if (pos.getI() == 0 && pos.getJ() == -1) dir = GAUCHE ;
        else if (pos.getI() == 0 && pos.getJ() == 1) dir = DROITE ;

        return dir;
    }

    /**
     * Methode qui donne une direction de facon aleatoire
     * @return indexAlea Integer aléatoire qui représente une direction
     */
    public static int obtenirDirAlea(){
        int indexAlea = RAND.nextInt(4);

        return indexAlea;
    }
}
