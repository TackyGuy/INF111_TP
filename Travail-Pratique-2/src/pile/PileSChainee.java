package pile;

/**
 * Pile simplement chainée
 *
 * @author Fatma Aljane , Guy Boucher, Jacinthe Lapointe | ETS
 * @version Hiver 2022 - TP2
 */
public class PileSChainee {

    private class Noeud{
        private Noeud suivant;
        private Object element;

        /**
         * constructeur
         * @param {Noeud} suivant , {Object} element
         */
        public Noeud(Noeud suivant, Object element){
            this.suivant = suivant;
            this.element = element;
        }

        @Override
        public String toString() {
            return element.toString();
        }
    }

    public Noeud tete;

    /**
     * empiler, méthode qui ajoute un élément à la pile
     *
     * @param {Object} element
     */
    public void empiler(Object element){
        Noeud nouv = new Noeud(null, element);
        if (tete != null){
            nouv.suivant = tete;
        }
        tete = nouv;
    }

    /**
     * depiler, méthode enlève un élément de la pile
     *
     * @return noeud sinon null si la tête est null
     */
    public Noeud depiler() {
        if (tete != null) {
            Noeud noeud = tete;
            tete = noeud.suivant;

            return noeud;
        }

        return null;
    }

    public Object regarder(){
        return tete.element;
    }

    public boolean estVide(){
        return tete == null;
    }




}
