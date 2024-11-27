/* 
 */
package lightoff_gaubil_fabre_version_console;

/**
 *
 * @author vtino
 */
import java.util.Random;

public class GrilleDeJeu {
    private CelluleLumineuse[][] matriceCellules; // on a créer une matrice en guise de grille de jeu
    private int nbLignes; // on a utiliser private pour que la grille soit accsessible que depuis l'intérieur de la classe GrilleDeJeu
    private int nbColonnes;

    public GrilleDeJeu(int p_nbLignes, int p_nbColonnes) {
        this.nbLignes = p_nbLignes;
        this.nbColonnes = p_nbColonnes;
        this.matriceCellules = new CelluleLumineuse[nbLignes][nbColonnes]; // cette étape permet de toujours initialisée à la taille désirée

        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                matriceCellules[i][j] = new CelluleLumineuse(); // cette étape sert a pouvoir initialiser chaque cellule pour qu'elles puissent être manipulées
            }
        }
    } // la grille de jeu a été initialisée completement

    public void eteindreToutesLesCellules() {
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                matriceCellules[i][j].eteindreCellule();
            } // éteindre la cellule pour i ligne et j colonne
        }
    }

    public void activerLigneDeCellules(int idLigne) {
        for (int j = 0; j < nbColonnes; j++) {
            matriceCellules[idLigne][j].activerCellule();
        }// permet d'actier toutte la colonne qu'on aura selectionner
    }

    public void activerColonneDeCellules(int idColonne) {
        for (int i = 0; i < nbLignes; i++) {
            matriceCellules[i][idColonne].activerCellule();
        }// permet d'actier toutte la ligne qu'on aura selectionner
    }
    
        public void activerDiagonaleDescendante() {
        for (int i = 0; i < Math.min(nbLignes, nbColonnes); i++) {
            matriceCellules[i][i].activerCellule();
        }
    }

    public void activerDiagonaleMontante() {
        for (int i = 0; i < Math.min(nbLignes, nbColonnes); i++) {
            matriceCellules[i][nbColonnes - 1 - i].activerCellule();
        }
    }

    public void melangerMatriceAleatoirement(int nbTours) {
        Random rand = new Random();
        for (int t = 0; t < nbTours; t++) {
            int choix = rand.nextInt(4);
            switch (choix) {
                case 0 -> activerLigneDeCellules(rand.nextInt(nbLignes));
                case 1 -> activerColonneDeCellules(rand.nextInt(nbColonnes));
                case 2 -> activerDiagonaleDescendante();
                case 3 -> activerDiagonaleMontante();
            }
        }
    }

    public boolean cellulesToutesEteintes() {
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                if (!matriceCellules[i][j].estEteint()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                sb.append(matriceCellules[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
