package interfaceUtilisateur;

/**
 * Cette classe est un listener pour les événements claviers utilisé pour contrôler
 * les éléments du jeu.
 * 
 * Ces méthodes hérités ne sont pas utilisées:
 *	public void keyReleased(KeyEvent e) {}
 *  public void keyTyped(KeyEvent e) {}
 * 
 * @author Fred Simard | ETS
 * @version Hiver 2022 - TP2
 */


import java.awt.event.*;
import java.util.Observable;

import modele.PlanDeJeu;
import personnage.Joueur;
import physique.Direction;

public class ControleurClavier implements KeyListener{

	// référence au plan de jeu
	private PlanDeJeu planDeJeu;
	
	/**
	 * Méthode pour attacher le plan de jeu
	 * @param planDeJeu, référence au plan de jeu
	 */
	public void attacherPlanDeJeu(PlanDeJeu planDeJeu){
		this.planDeJeu = planDeJeu;
	}
	
	/**
	 * gestionnaire d'événement associé au clavier
	 * @param e(KeyEvent), evénement clavier
	 */
	@Override
	public void keyPressed(KeyEvent e) {

		// obtient une référence au joueur courant
		Joueur joueurControlle =  planDeJeu.getJoueur();
		
		// s'assure qu'un joueur a été initialisé
		if(joueurControlle != null){
			
			int keyCode = e.getKeyCode();
			
			// gestion de l'action en fonction de l'événement clavier
			switch(KeyEvent.getKeyText(keyCode)){

				case "Haut":
				case "Up":
					joueurControlle.seDeplacer(Direction.HAUT);
					break;
				case "Bas":
				case "Down":
					joueurControlle.seDeplacer(Direction.BAS);
					break;
				case "Gauche":
				case "Left":
					joueurControlle.seDeplacer(Direction.GAUCHE);
					break;
				case "Droite":
				case "Right":
					joueurControlle.seDeplacer(Direction.DROITE);
					break;
			
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {}

}
