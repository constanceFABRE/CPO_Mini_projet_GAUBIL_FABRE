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
    private int nbCoups; // permet de svoir avec combien de coups on a gangé la partie 

    public Partie(int taille) {
        this.grille = new GrilleDeJeu(taille, taille);// permet de créer la grille de taille taille X taille 
        this.nbCoups = 0;
        grille.melangerMatriceAleatoirement(5);// permet de mélanger la grille
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
