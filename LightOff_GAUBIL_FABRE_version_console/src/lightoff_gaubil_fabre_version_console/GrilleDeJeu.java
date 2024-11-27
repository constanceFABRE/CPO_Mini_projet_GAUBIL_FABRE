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

}
// fin de la création de la grille jeu    