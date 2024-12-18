/*
 * 
 *
 */
package lightoff_gaubil_fabre_version_console;

/**
 *
 * @author constancefabre
 */

/**
 * Classe principale pour le jeu "LightOff", version console.
 * 
 * Le jeu "LightOff" consiste à éteindre toutes les lumières d'une grille en un minimum de coups.
 * Cette classe sert de point d'entrée pour lancer le jeu, choisir la difficulté,
 * et démarrer une partie.
 */

public class LightOff_GAUBIL_FABRE_version_console {
    /**
     * Méthode principale qui lance le jeu "LightOff" dans la console.
     * 
     * Le programme :
     * 1. Affiche une introduction au jeu.
     * 2. Demande à l'utilisateur de choisir une difficulté.
     * 3. Lance la partie avec la difficulté choisie.
     * 4. Affiche un message de fin de jeu une fois la partie terminée.
     * 
     * @param args Les arguments de la ligne de commande (non utilisés ici).
     */
    public static void main(String[] args) {
             System.out.println("Bienvenue dans le jeu LightOff !");
        System.out.println("Le but est d'éteindre toutes les lumières en un minimum de coups.");
        System.out.println("Choisissez une difficulté pour commencer.");

        Partie partie = Partie.choisirDifficulte();
     
        partie.lancerPartie();

        System.out.println("Merci d'avoir joué à LightOff !");
    }
}
