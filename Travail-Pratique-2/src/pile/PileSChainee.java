package pile;

public class PileSChainee {

    private class Noeud{
        // TODO demande si ces champs membres devraient etre public ou non
        private Noeud suivant;
        private Object element;

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

    public void empiler(Object element){
        Noeud nouv = new Noeud(null, element);
        if (tete != null){
            nouv.suivant = tete;
        }
        tete = nouv;
    }

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
