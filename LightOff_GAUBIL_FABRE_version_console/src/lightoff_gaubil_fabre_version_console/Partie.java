/*
 */
package lightoff_gaubil_fabre_version_console;

/**
 *
 * @author vtino
 */

import java.util.Scanner;

public class Partie {
    private GrilleDeJeu grille;
    private int nbCoups;   // permet de svoir avec combien de coups on a gangé la partie 
    private int coupsRestants; // Limite de coups
    private boolean jokerUtilise; // Indique si le joker a été utilisé


    public Partie(int taille,int maxCoups) {
        this.grille = new GrilleDeJeu(taille, taille);// permet de créer la grille de taille taille X taille 
        this.nbCoups = 0;
        this.coupsRestants = maxCoups;
        this.jokerUtilise = false; // Le joueur commence sans avoir utilisé le joker

        grille.melangerMatriceAleatoirement(5);// permet de mélanger la grille
    }

    
        // Méthode pour choisir une difficulté
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

    public void lancerPartie() {
        Scanner scanner = new Scanner(System.in);// pour lire ce que l'utilisateur va entrer 
       
        while (!grille.cellulesToutesEteintes()) { // tant que les cellules ne sont pas éteintes, on continu de jouer 
            System.out.println("État actuel de la grille :");
            System.out.println(grille);

            System.out.println("Choisissez une action :");
            System.out.println("1. Activer une ligne");
            System.out.println("2. Activer une colonne");
            System.out.println("3. Activer diagonale descendante");
            System.out.println("4. Activer diagonale montante");

            int choix = scanner.nextInt();// permet de choisir et de lire ce que l'utilisateur à rentrer 

            switch (choix) { // pour avoir plusieurs choix possible 
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

            nbCoups++;//nombre de coups qui augmente de 1 à chaque fois qu'on a joué 
        }

        System.out.println("Bravo ! Vous avez éteint toutes les lumières en " + nbCoups + " coups.");
    }
}
