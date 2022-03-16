package physique;

import java.util.Random;

public class Direction {

    // TODO pourquoi est-ce que les attributs doivent etre public ?
    public static final int HAUT = 0, BAS = 1, GAUCHE = 2, DROITE = 3;

    private static Random RAND = new Random();

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

    public static int positionADirection(Position pos){
        int dir = -1;

        if (pos.getI() == -1 && pos.getJ() == 0) dir = HAUT ;
        else if (pos.getI() == 1 && pos.getJ() == 0) dir = BAS ;
        else if (pos.getI() == 0 && pos.getJ() == -1) dir = GAUCHE ;
        else if (pos.getI() == 0 && pos.getJ() == 1) dir = DROITE ;

        return dir;
    }

    public static int obtenirDirAlea(){
        int dirAlea;
        int indexAlea = RAND.nextInt(4);

        return indexAlea;
    }
}
