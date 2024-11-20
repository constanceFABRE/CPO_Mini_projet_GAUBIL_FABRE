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
    private int nbCoups;

    public Partie(int taille) {
        this.grille = new GrilleDeJeu(taille, taille);
        this.nbCoups = 0;
        grille.melangerMatriceAleatoirement(5);
    }

    public void lancerPartie() {
        Scanner scanner = new Scanner(System.in);

        while (!grille.cellulesToutesEteintes()) {
            System.out.println("État actuel de la grille :");
            System.out.println(grille);

            System.out.println("Choisissez une action :");
            System.out.println("1. Activer une ligne");
            System.out.println("2. Activer une colonne");
            System.out.println("3. Activer diagonale descendante");
            System.out.println("4. Activer diagonale montante");

            int choix = scanner.nextInt();

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
        }

        System.out.println("Bravo ! Vous avez éteint toutes les lumières en " + nbCoups + " coups.");
    }
}
