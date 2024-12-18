/*
 */
package lightoff_gaubil_fabre_version_console;

/**
 *
 * @author vtino
 */

import java.util.Random;
import java.util.Scanner;

/**
 * Représente une partie du jeu "LightOff".
 * 
 * Une partie comporte une grille de jeu, un nombre maximum de coups, un compteur
 * de coups effectués, et un joker que le joueur peut utiliser une fois pour inverser
 * aléatoirement l'état de certaines cases.
 */

public class Partie {
    private GrilleDeJeu grille;
    private int nbCoups;
    private int coupsRestants; 
    private boolean jokerUtilise; 

  /**
     * Constructeur de la classe Partie.
     * 
     * @param taille   La taille de la grille de jeu (carrée).
     * @param maxCoups Le nombre maximum de coups autorisés pour cette partie.
     */
    public Partie(int taille, int maxCoups) {
        this.grille = new GrilleDeJeu(taille, taille);
        this.nbCoups = 0;
        this.coupsRestants = maxCoups;
        this.jokerUtilise = false; 
        grille.melangerMatriceAleatoirement(25); 
    }

     /**
     * Permet au joueur de choisir la difficulté de la partie.
     * 
     * @return Une instance de Partie correspondant à la difficulté choisie.
     */
    public static Partie choisirDifficulte() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choisissez un niveau de difficulté :");
        System.out.println("1. Débutant (5x5, 25 coups max)");
        System.out.println("2. Confirmé (7x7, 18 coups max)");
        System.out.println("3. Expert (10x10, 10 coups max)");

        int choix = scanner.nextInt();
        switch (choix) {
            case 1:
                return new Partie(5, 25); // Débutant
            case 2:
                return new Partie(7, 18); // Confirmé
            case 3:
                return new Partie(10, 10); // Expert
            default:
                System.out.println("Choix invalide, niveau Débutant par défaut.");
                return new Partie(5, 25);
        }
    }

      /**
     * Permet au joueur d'utiliser un joker.
     * 
     * Le joker inverse l'état de trois cases aléatoires sur la grille.
     * Si le joker a déjà été utilisé, un message d'erreur est affiché.
     */
    private void utiliserJoker() {
        if (jokerUtilise) {
            System.out.println("Vous avez déjà utilisé votre joker !");
            return;
        }

        Random rand = new Random();
        for (int i = 0; i < 3; i++) {
            int ligne = rand.nextInt(grille.getNbLignes());
            int colonne = rand.nextInt(grille.getNbColonnes());
            grille.activerCellule(ligne, colonne);
        }
        jokerUtilise = true;
        System.out.println("Joker utilisé ! Trois cases ont été inversées.");
    }

      /**
     * Lance une partie du jeu.
     * 
     * Le joueur effectue des actions jusqu'à ce que toutes les lumières soient
     * éteintes ou que le nombre de coups restants atteigne 0. Pendant la partie,
     * le joueur peut :
     * - Activer une ligne
     * - Activer une colonne
     * - Activer une diagonale descendante
     * - Activer une diagonale montante
     * - Utiliser un joker (une seule fois)
     */
    
    public void lancerPartie() {
        Scanner scanner = new Scanner(System.in);

        // Boucle principale de la partie
        while (!grille.cellulesToutesEteintes() && coupsRestants > 0) {
            // Affichage de l'état actuel de la grille
            System.out.println("État actuel de la grille :");
            System.out.println(grille);
            System.out.println("Coups restants : " + coupsRestants);

            // Vérifie si le joker est disponible
            if (!jokerUtilise) {
                System.out.println("Tapez -1 pour utiliser le joker.");
            }

            // Menu des actions possibles
            System.out.println("Choisissez une action :");
            System.out.println("1. Activer une ligne");
            System.out.println("2. Activer une colonne");
            System.out.println("3. Activer diagonale descendante");
            System.out.println("4. Activer diagonale montante");

            // Lecture du choix du joueur
            int choix = scanner.nextInt();

            // Si le joueur choisit le joker
            if (choix == -1) {
                utiliserJoker();
                continue;
            }

            // Exécution de l'action choisie
            switch (choix) {
                case 1 -> {
                    System.out.print("Numéro de la ligne : ");
                    int ligne = scanner.nextInt();
                    grille.activerLigneDeCellules(ligne);
                }
                case 2 -> {
                    System.out.print("Numéro de la colonne : ");
                    int colonne = scanner.nextInt();
                    grille.activerColonneDeCellules(colonne);
                }
                case 3 -> grille.activerDiagonaleDescendante();
                case 4 -> grille.activerDiagonaleMontante();
                default -> System.out.println("Choix invalide.");
            }

            // Mise à jour des compteurs
            nbCoups++;
            coupsRestants--;

            // Si le joueur n'a plus de coups et que la grille n'est pas éteinte
            if (coupsRestants == 0 && !grille.cellulesToutesEteintes()) {
                System.out.println("Vous avez perdu ! Vous avez atteint la limite de coups.");
                return;
            }
        }

        // Si toutes les lumières sont éteintes
        if (grille.cellulesToutesEteintes()) {
            System.out.println("Bravo ! Vous avez éteint toutes les lumières en " + nbCoups + " coups.");
        }
    }
}
