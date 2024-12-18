package lightoff_gaubil_fabre_version_console;

/**
 * Classe principale du programme LightOff
 * La méthode main initialise et lance le jeu.
 * @author constancefabre
 */
public class LightOff_GAUBIL_FABRE_version_console {
    /**
     * Cette méthode affiche les instructions du jeu
     * @param args Arguments de la ligne de commande (non utilisés ici)
     */
    public static void main(String[] args) {
             System.out.println("Bienvenue dans le jeu LightOff !");
        System.out.println("Le but est d'éteindre toutes les lumières en un minimum de coups.");
        System.out.println("Choisissez une difficulté pour commencer.");

        // Choix de la difficulté et initialisation de la partie
        Partie partie = Partie.choisirDifficulte();
        
        // Lancer la partie
        partie.lancerPartie();

        System.out.println("Merci d'avoir joué à LightOff !");
    }
}