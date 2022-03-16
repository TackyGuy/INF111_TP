package modele;

/**
 * Le plan de jeu est la classe qui supporte le modèle du programme.
 * Il contient:
 * 	- le donjon
 *  - le joueur
 *  - les créatures
 *  
 * et actionne les mécaniques du jeu.
 * 
 * Le plan de jeu est implémenté en Lazy Singleton
 * 
 * @author Fred Simard  modifié par Fatma ALJANE, Guy BOUCHER et Jacinthe LAPOINTE
 * @version Hiver 2022 - TP2
 */


import java.lang.reflect.Type;
import java.util.*;
import java.util.concurrent.TimeUnit;

import donjon.Case;
import donjon.Configuration;
import donjon.Donjon;
import observer.MonObservable;
import observer.MonObserver;
import personnage.*;
import physique.Direction;
import physique.Position;

public class PlanDeJeu extends MonObservable implements MonObserver, Runnable {

	private Donjon donjon;
	private boolean partieEnCours = false;
	private int niveauCourant = 0;
	private Random rand = new Random(System.currentTimeMillis());
	
	private static final PlanDeJeu instance = new PlanDeJeu();
	private static Thread t;

	private Vector<AbstractCreature> creatures = new Vector<>();
	private Joueur joueur;
	
	/**
	 * constructeur du plan de jeu
	 */
	public PlanDeJeu(){
		partieEnCours = true;
		nouveauNiveau();
	}

	/**
	 * Méthode qui créer des créatures et les positions dans le labyrinthe de manière aléatoire
	 */
	private void initCreatures(){
		Case[][] cases = donjon.getCases();
		Configuration config = Configuration.getInstance();

		creatures.clear();

		//créer des créature de façon aléatoire
		for (int i = 0; i < config.getConfig(Configuration.NB_CREATURES); i++){
			Position posAleatoire = donjon.getPositionAlea();
			AbstractCreature typeCreature=creatureAlea(posAleatoire);

			typeCreature.attacherObserver(this);
			typeCreature.setCase(cases[posAleatoire.getI()][posAleatoire.getJ()]);
			creatures.add(typeCreature);
		}

	}

	/**
	 * Méthode qui crée des créatures de façon aléatoire
	 * @param posAleatoire Reference à une position aléatoire
	 * @return typeCrature Reference à une créature
	 */
	public AbstractCreature creatureAlea(Position posAleatoire){

		int indexCreature = rand.nextInt(3);
		AbstractCreature typeCreature;

		switch (indexCreature){
			case 0:
				typeCreature = new Minotaure(posAleatoire);
				break;
			case 1:
				typeCreature = new Dragon(posAleatoire);
				break;
			default:
				typeCreature = new Araignee(posAleatoire);
				break;
		}
		return typeCreature;
	}

	/**
	 * Méthode qui position le joueur sur la case de départ
	 */
	public void initJoueur(){
		Case[][] cases = donjon.getCases();

		Position posInitiale = donjon.getDepart().getPos();
		joueur = new Joueur(posInitiale);
		joueur.setCase(cases[posInitiale.getI()][posInitiale.getJ()]);
		joueur.attacherObserver(this);
	}

	/**
	 * méthode pour obtenir une référence au plan de jeu
	 * @return l'instance
	 */
	public static PlanDeJeu getInstance(){
		return instance;
	}
	
	/**
	 * méthode pour obtenir une référence au donjon
	 * @return référence au donjon
	 */
	public Donjon getDonjon(){
		return this.donjon;
	}

	/**
	 * méthode pour obtenir une référence au vecteur de creatures
	 * 	@return référence au vecteur de creatures
	 */
	public Vector<AbstractCreature> getCreatures() {return this.creatures;}

	public Joueur getJoueur() {return this.joueur;}

	@Override
	/**
	 * callback implémenté par l'observer
	 */
	public void avertir() {
		
		// vérifie les règles du jeu
		validerEtatJeu();
		
		// avertie les observers du plan de jeu
		this.avertirLesObservers();
	}

	@Override
	/**
	 * implémente la méthode run de Runnable
	 */
	public void run() {

		// tant qu'une partie est en cours
		while(partieEnCours){
			
			// déplace toutes les créatures à compléter

			for (AbstractCreature creature:creatures){
				creature.seDeplacer(Direction.obtenirDirAlea());
			}
			// attend X nombre de secondes
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * méthode qui valide les règles du jeu
	 */
	private void  validerEtatJeu(){
		

		// verifie si le joueur vient de trouver de l'équipement
			// oui, ajoute à l'inventaire
		
		// verifie s'il y a un combat
			// oui, fais la résolution du combat

		// verifie si le joueur est mort...
			// oui, partie perdu

	
	}
	
	/**
	 * méthode qui lance un nouveau niveau
	 */
	private void  nouveauNiveau(){
		
		// la partie est toujours en cours
		partieEnCours = true;
		// crée un nouveau donjon
		this.donjon = new Donjon();
		
		
		
		// si la tâche qui gère les créature
		// n'a pas encore été lancé, la lance.
		if(t ==null){
			t = new Thread(this);
			t.start();
		}

		// Initialise les creatures
		initCreatures();
		// Initialise le joueur
		initJoueur();
		
	}

	/**
	 * méthode qui gère une partie gagné
	 */
	private void partieGagne(){
		
		// incrémente le compteur de niveau
		niveauCourant++;
		
		// obtient les configs
		Configuration config = Configuration.getInstance();
		int nbCols = (int)config.getConfig(Configuration.NB_COLONNES);
		int nbLignes = (int)config.getConfig(Configuration.NB_LIGNES);
		int nbCreatures = (int)config.getConfig(Configuration.NB_CREATURES);
		// mets à jours les configs
		config.setConfig(Configuration.NB_COLONNES,nbCols+1);
		config.setConfig(Configuration.NB_LIGNES,nbLignes+1);
		config.setConfig(Configuration.NB_CREATURES,nbCreatures+2);
		
		// lance un nouveau niveau
		nouveauNiveau();
	}

	/**
	 * gestion d'une partie perdu
	 */
	private void partiePerdu(){
		
		// plus de partie en cours
		partieEnCours = false;
		
		// attend la fin de la tâche
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// remise à zéro du jeu
		Configuration.remiseAZero();
	}
		
}
