package donjon;

import pile.PileSChainee;
import physique.Direction;
import physique.Position;

import java.util.Random;
import java.util.concurrent.ExecutionException;

/**
 * Classe qui remplie un tableau de cases et produit le labyrinthe
 *
 * La case départ est accessibles en lecture par l'entremise de la methode:
 * - getDepart
 *
 * La case départ est accessibles en lecture par l'entremise de la methode:
 * - getFin
 *
 * @author Fatma ALJANE, Guy BOUCHER, Jacinthe LAPOINTE
 * @version HIVER 2022
 */

public class Donjon {
    private Case caseDepart;
    private Case caseFin;

    Case[][] tabCases;

    Random RANDOM = new Random();

    public Donjon(){
        Configuration config = Configuration.getInstance();
        this.tabCases = new Case[config.getConfig(0)][config.getConfig(1)];

        //remplie le tableau tabCases de cases
        for (int i = 0; i < tabCases.length; i++){
            for (int j = 0; j < tabCases[i].length; j++){
                this.tabCases[i][j] = new Case(new Position(i, j));
            }
        }

        //donne de façon aleatoire une case de départ
        this.caseDepart = tabCases[RANDOM.nextInt(tabCases.length)][RANDOM.nextInt(tabCases[0].length)];

        // produit le labyrinthe
        this.produireLabyrinthe();

        // assigne la fin
        this.caseFin.setFin(true);
    }

    // Accesseurs et mutateurs

    public Case getDepart() {
        return caseDepart;
    }
    public Case getFin() {
        return caseFin;
    }

    public Case[][] getCases(){
        return tabCases;
    }

    /**
     * Cette méthode donne une position aleatoire et retourne la position
     * @return Position Référence vers une position choisie aleatoirement
     */
    public Position getPositionAlea(){
        Position nouvPos = null;

        nouvPos = tabCases[RANDOM.nextInt(tabCases.length)][RANDOM.nextInt(tabCases[0].length)].getPos();
        return  nouvPos;
    }

    /**
     * Cette méthode reçoit en paramètre la position de la case
     * et retourne un int qui represente le nombre de voisins
     *
     * @param posCase Position de la case présentement évaluée
     * @return int Référence vers un voisin choisi aléatoirement.
     */
    public int getNbVoisinsNonDeveloppe(Position posCase){
        int nbVoisins = 0;

        for (int i = 0; i < 4; i++){
            try {
                // calcule la position de la case voisine
                Position posVoisin = Direction.directionAPosition(i);
                posVoisin.additionnerPos(posCase);

                if (positionEstValide(posVoisin)){
                    Case caseVoisine = tabCases[posVoisin.getI()][posVoisin.getJ()];
                    if (!caseVoisine.estDeveloppee()) nbVoisins++;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return nbVoisins;
    }

    /**
     * Cette méthode reçoit en paramètre la position de la case présentement
     * évaluée et retourne une référence vers un voisin choisi aléatoirement.
     * @param posCase Position de la case présentement évaluée
     * @return Case Référence vers un voisin choisi aléatoirement.
     */
    public Case getVoisinAlea(Position posCase){
        Case voisin = null;

        boolean posValide = false;
        do{
            try {
                Position posAlea = Direction.directionAPosition(Direction.obtenirDirAlea());
                posAlea.additionnerPos(posCase);

                if (positionEstValide(posAlea)) {
                    posValide = true;
                    voisin = tabCases[posAlea.getI()][posAlea.getJ()];
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        while(!posValide);

        return voisin;
    }

    /**
     * Cette méthode reçoit en paramètre la position de la case
     * et retourne une référence vers un voisin à cette case choisi aleatoirement
     *
     * @param posCase Position de la case
     * @return Case Référence vers un voisin choisi aléatoirement.
     */
    public Case getVoisinLibreAlea(Position posCase){
        Case voisinLibre;

        do{
            voisinLibre = getVoisinAlea(posCase);
        }
        while (voisinLibre.estDeveloppee());

        return voisinLibre;
    }

    /**
     * Methode qui développe le labyrinthe
     * @returns void
     */
    public void produireLabyrinthe() {
        PileSChainee pile = new PileSChainee();
        pile.empiler(caseDepart);

        while(!pile.estVide()){
            Case nouvCase = (Case)pile.regarder();

            nouvCase.getPos();
            if (!nouvCase.estDeveloppee()) nouvCase.setDeveloppee(true);
            // System.out.println("\nCase actuelle: " + nouvCase);

            // vérifie si cette case a un voisin non développé
            if (getNbVoisinsNonDeveloppe(nouvCase.getPos()) > 0){
                Case caseVoisine = developpeCaseVoisine(nouvCase);

                // ajoute le voisin à la pile
                pile.empiler(caseVoisine);

                // définit la fin comme étant la dernière case développée
                caseFin = (Case)pile.regarder();
            }
            else{
                // il s'agit d'un cul-de-sac, dépile une case
                pile.depiler();
            }
        }
    }

    /**
     * Méthode qui développe une case voisine de façon aléatoire
     * @param nouvCase Référence à une case
     * @return caseVoisine Reference de la case voisine
     */
    private Case developpeCaseVoisine(Case nouvCase){
        Case caseVoisine = getVoisinLibreAlea(nouvCase.getPos());

        // obtient la position du voisin
        Position posVoisin = caseVoisine.getPos();
        // calcul la direction du voisin
        posVoisin.soustrairePos(nouvCase.getPos());

        try{
            int dir = Direction.positionADirection(posVoisin);
            // ajoute à la case, comme voisin réciproque
            // appel à setVoisin pour les deux cases
            nouvCase.setVoisin(dir, caseVoisine);
            caseVoisine.setVoisin(Direction.directionOpposee(dir), nouvCase);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return caseVoisine;
    }

    /**
     * Méthode qui vérifie si la position est valide
     * @param pos Référence à une position
     * @return boolean
     */
    private boolean positionEstValide(Position pos){
        if (pos.getI() < tabCases.length && pos.getI() >= 0 && pos.getJ() < tabCases[0].length && pos.getJ() >= 0) {
            return true;
        }

        return false;
    }
}
