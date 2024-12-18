package lightoff_gaubil_fabre_version_console;
import java.util.Random;
import java.util.Scanner;

/**
 * Classe Partie  
 * Gère une partie du jeu LightOff
 * 
 * @author valentine GAUBIL constance FABRE
 */
public class Partie {
    private GrilleDeJeu grille;
    private int nbCoups;
    private int coupsRestants; // Limite de coups
    private boolean jokerUtilise; // Indique si le joker a été utilisé

    /**
     * Constructeur de la classe Partie
     * @param taille La taille de la grille
     * @param maxCoups Le nombre maximum de coups
     */
    public Partie(int taille, int maxCoups) {
        this.grille = new GrilleDeJeu(taille, taille);
        this.nbCoups = 0;
        this.coupsRestants = maxCoups;
        this.jokerUtilise = false; // Le joueur commence sans avoir utilisé le joker
        grille.melangerMatriceAleatoirement(25); // Mélange initial de la grille
    }

    /**
     * Méthode statique pour choisir un niveau de difficulté
     * @return Une instance de Partie correspondant à la difficulté choisie
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
     * Utilisation du joker
     * Il inverse aleatoirement 3 cases de la grille 
     * Il peut etre utilisé une seule fois
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
     * Lance la partie
     * Permet à l'utilisateur de jouer, dans le but de gagné ou perdre
     */
    public void lancerPartie() {
        Scanner scanner = new Scanner(System.in);

        while (!grille.cellulesToutesEteintes() && coupsRestants > 0) {
            System.out.println("État actuel de la grille :");
            System.out.println(grille);
            System.out.println("Coups restants : " + coupsRestants);

            if (!jokerUtilise) {
                System.out.println("Tapez -1 pour utiliser le joker.");
            }
            System.out.println("Choisissez une action :");
            System.out.println("1. Activer une ligne");
            System.out.println("2. Activer une colonne");
            System.out.println("3. Activer diagonale descendante");
            System.out.println("4. Activer diagonale montante");

            int choix = scanner.nextInt();

            if (choix == -1) {
                utiliserJoker();
                continue;
            }

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

            nbCoups++;
            coupsRestants--;

            if (coupsRestants == 0 && !grille.cellulesToutesEteintes()) {
                System.out.println("Vous avez perdu ! Vous avez atteint la limite de coups.");
                return;
            }
        }

        if (grille.cellulesToutesEteintes()) {
            System.out.println("Bravo ! Vous avez éteint toutes les lumières en " + nbCoups + " coups.");
        }
    }
}
