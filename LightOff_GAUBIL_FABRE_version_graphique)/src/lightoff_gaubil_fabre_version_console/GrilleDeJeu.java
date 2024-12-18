package lightoff_gaubil_fabre_version_console;

/**
 * Classe GrilleDeJeu - Représente la grille de jeu pour le jeu LightOff.
 * 
 * @author vtino
 */
import java.util.Random;

public class GrilleDeJeu {
    public CelluleLumineuse[][] matriceCellules; // on a créer une matrice en guise de grille de jeu
    private int nbLignes; // Nombre de lignes de la grille
    private int nbColonnes; //Nombre de Colonnes de la grille
    
    /**
     * Constructeur de la classe GrilleDeJeu.
     * Initialise une grille de cellules lumineuses avec la taille spécifiée
     * @param p_nbLignes //Nombre de lignes de la grille.
     * @param p_nbColonnes //Nombre de colonnes de la grille.
     */
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
    
    /**
     * Éteint toutes les cellules de la grille
     */
    public void eteindreToutesLesCellules() {
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                matriceCellules[i][j].eteindreCellule();
            } // éteindre la cellule pour i ligne et j colonne
        }
    }
    
    /**
     * Active toutes les cellules d'une ligne spécifiée.
     * @param idLigne L'index de la ligne à activer (commençant à 0).
     */
    public void activerLigneDeCellules(int idLigne) {
        for (int j = 0; j < nbColonnes; j++) {
            matriceCellules[idLigne][j].activerCellule();
        }// permet d'activer toute la colonne qu'on aura selectionner
    }
    
    /**
     * Active toutes les cellules d'une colonne spécifiée.
     * @param idColonne L'index de la colonne à activer (commençant à 0).
     */
    public void activerColonneDeCellules(int idColonne) {
        for (int i = 0; i < nbLignes; i++) {
            matriceCellules[i][idColonne].activerCellule();
        }// permet d'activer toutte la ligne qu'on aura selectionner
    }
    
    /**
     * Active les cellules situées sur la diagonale descendante.
     * La diagonale descendante correspond à l'ensemble des cellules (i, i).
     */
    public void activerDiagonaleDescendante() {
        for (int i = 0; i < Math.min(nbLignes, nbColonnes); i++) {
            matriceCellules[i][i].activerCellule();
        }
    }// active les cellules qui se trouvent sur la diagonale escendante de la grille
    
    /**
     * Active les cellules situées sur la diagonale montante.
     * La diagonale montante correspond à l'ensemble des cellules (i, nbColonnes - 1 - i).
     */
    public void activerDiagonaleMontante() {
        for (int i = 0; i < Math.min(nbLignes, nbColonnes); i++) {
            matriceCellules[i][nbColonnes - 1 - i].activerCellule();
        }
    }// acitve les cellules qui se trouvent sur la diagonale montante de la grille
    
    /**
     * Mélange aléatoirement la grille en activant des lignes, colonnes, diagonales
     * @param nbTours Le nombre d'activations aléatoires à effectuer.
     */
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
    
    /**
     * Vérifie si toutes les cellules de la grille sont éteintes.
     * @return true si toutes les cellules sont éteintes, false sinon.
     */
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
    
    /**
     * Active une cellule spécifique de la grille.
     * @param ligne L'index de la ligne de la cellule (commençant à 0).
     * @param colonne L'index de la colonne de la cellule (commençant à 0).
     */
    public void activerCellule(int ligne, int colonne) {
        if (ligne >= 0 && ligne < nbLignes && colonne >= 0 && colonne < nbColonnes) {
            matriceCellules[ligne][colonne].activerCellule();
        }
    }
    
    
    /**
     * Retourne une représentation textuelle de la grille.
     * @return Une chaîne représentant la grille sous forme de texte.
     */
    public int getNbLignes() {
        return nbLignes;
    }

    /**
     * Accesseur pour le nombre de lignes de la grille.
     * @return Le nombre de lignes de la grille.
     */
    public int getNbColonnes() {
        return nbColonnes;
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
