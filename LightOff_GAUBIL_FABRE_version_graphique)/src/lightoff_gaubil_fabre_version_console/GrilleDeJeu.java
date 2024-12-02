/* 
 */
package lightoff_gaubil_fabre_version_console;

/**
 *
 * @author vtino
 */
import java.util.Random;

public class GrilleDeJeu {
    public CelluleLumineuse[][] matriceCellules; // on a créer une matrice en guise de grille de jeu
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
        }// permet d'activer toute la colonne qu'on aura selectionner
    }

    public void activerColonneDeCellules(int idColonne) {
        for (int i = 0; i < nbLignes; i++) {
            matriceCellules[i][idColonne].activerCellule();
        }// permet d'activer toutte la ligne qu'on aura selectionner
    }
    
        public void activerDiagonaleDescendante() {
        for (int i = 0; i < Math.min(nbLignes, nbColonnes); i++) {
            matriceCellules[i][i].activerCellule();
        }
    }// active les cellules qui se trouvent sur la diagonale escendante de la grille

    public void activerDiagonaleMontante() {
        for (int i = 0; i < Math.min(nbLignes, nbColonnes); i++) {
            matriceCellules[i][nbColonnes - 1 - i].activerCellule();
        }
    }// acitve les cellules qui se trouvent sur la diagonale montante de la grille

    public void melangerMatriceAleatoirement(int nbTours) {
        Random rand = new Random();
        for (int t = 0; t < nbTours; t++) {
            int choix = rand.nextInt(4);// rentrer un nombre entre 1 et 4 pour faire un choix de l'endroit ou on veux selectionner les cellules
            switch (choix) {
                case 0 -> activerLigneDeCellules(rand.nextInt(nbLignes));//acitve une ligne
                case 1 -> activerColonneDeCellules(rand.nextInt(nbColonnes));//active une colonne
                case 2 -> activerDiagonaleDescendante();//acitve la diago descendante
                case 3 -> activerDiagonaleMontante();//acitive la diago montante
            }
        }
    }

    public boolean cellulesToutesEteintes() {
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                if (!matriceCellules[i][j].estEteint()) {
                    return false;
                }
            }// sert à vérifier si les cellules sont éteintes 
        }// si on enleve cette étape, cela ne changera rien pour les cellules éteintes mais si elles sont allumées, le méthode ne renverra pas falseet donc continura à vérifier toutes les autres cellules 
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                sb.append(matriceCellules[i][j]).append(" ");// mettre un espace entre les cellules 
            }
            sb.append("\n");
        }
        return sb.toString();// cette méthode ser à écrire la grille sous forme de texte
    }
}
