/* 
 */
package lightoff_gaubil_fabre_version_console;

/**
 *
 * @author vtino
 */

import java.util.Random;

/**
 * Représente une grille de jeu composée de cellules lumineuses organisées en une matrice. 
 * Chaque cellule peut être allumée ou éteinte, et la grille offre plusieurs opérations pour manipuler ces cellules.
 */
public class GrilleDeJeu {
    private CelluleLumineuse[][] matriceCellules; 
    private int nbLignes; 
    private int nbColonnes;

    /**
     * Constructeur qui initialise une grille de jeu avec un nombre donné de lignes et de colonnes.
     * Chaque cellule de la grille est initialisée à l'état éteint.
     *
     * @param p_nbLignes  Le nombre de lignes de la grille
     * @param p_nbColonnes Le nombre de colonnes de la grille
     */
    public GrilleDeJeu(int p_nbLignes, int p_nbColonnes) {
        this.nbLignes = p_nbLignes;
        this.nbColonnes = p_nbColonnes;
        this.matriceCellules = new CelluleLumineuse[nbLignes][nbColonnes]; 

        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                matriceCellules[i][j] = new CelluleLumineuse(); 
            }
        }
    } 

     /**
     * Éteint toutes les cellules de la grille.
     */
    public void eteindreToutesLesCellules() {
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                matriceCellules[i][j].eteindreCellule();
            } 
        }
    }

     /**
     * Active toutes les cellules d'une ligne donnée.
     *
     * @param idLigne L'indice de la ligne à activer (0-indexé)
     */
    public void activerLigneDeCellules(int idLigne) {
        for (int j = 0; j < nbColonnes; j++) {
            matriceCellules[idLigne][j].activerCellule();
        }
    }

     /**
     * Active toutes les cellules d'une colonne donnée.
     *
     * @param idColonne L'indice de la colonne à activer (0-indexé)
     */
    public void activerColonneDeCellules(int idColonne) {
        for (int i = 0; i < nbLignes; i++) {
            matriceCellules[i][idColonne].activerCellule();
        }
    }
    
      /**
     * Active les cellules sur la diagonale descendante de la grille
     * (celle allant du coin supérieur gauche au coin inférieur droit).
     */
        public void activerDiagonaleDescendante() {
        for (int i = 0; i < Math.min(nbLignes, nbColonnes); i++) {
            matriceCellules[i][i].activerCellule();
        }
    }

        /**
     * Active les cellules sur la diagonale montante de la grille
     * (celle allant du coin inférieur gauche au coin supérieur droit).
     */
    public void activerDiagonaleMontante() {
        for (int i = 0; i < Math.min(nbLignes, nbColonnes); i++) {
            matriceCellules[i][nbColonnes - 1 - i].activerCellule();
        }
    }

     /**
     * Mélange aléatoirement les cellules de la grille en activant des lignes,
     * colonnes ou diagonales un certain nombre de fois.
     *
     * @param nbTours Le nombre d'itérations de mélange
     */
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

     /**
     * Vérifie si toutes les cellules de la grille sont éteintes.
     *
     * @return `true` si toutes les cellules sont éteintes, `false` sinon.
     */
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

    
     /**
     * Active une cellule spécifique de la grille (en basculant son état).
     *
     * @param ligne   L'indice de la ligne de la cellule (0-indexé)
     * @param colonne L'indice de la colonne de la cellule (0-indexé)
     */
    public void activerCellule(int ligne, int colonne) {
        if (ligne >= 0 && ligne < nbLignes && colonne >= 0 && colonne < nbColonnes) {
            matriceCellules[ligne][colonne].activerCellule();
        }
    }
    
    
     /**
     * Retourne le nombre de lignes de la grille.
     *
     * @return Le nombre de lignes
     */
    public int getNbLignes() {
        return nbLignes;
    }

    /**
     * Retourne le nombre de colonnes de la grille.
     *
     * @return Le nombre de colonnes
     */
    public int getNbColonnes() {
        return nbColonnes;
    }
    
     /**
     * Représente la grille sous forme de chaîne de caractères.
     * Chaque cellule est représentée par "X" si elle est allumée, et "O" si elle est éteinte.
     *
     * @return Une représentation textuelle de la grille
     */
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
