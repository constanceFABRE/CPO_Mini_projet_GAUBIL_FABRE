package lightoff_gaubil_fabre_version_console;

/**
 * Classe CelluleLumineuse - Représente une cellule lumineuse dans le jeu LightOff.
 * Cette classe fournit des méthodes pour manipuler l'état de la cellule
 * @author constancefabre
 */
public class CelluleLumineuse {
    private boolean etat;
    
    /**
     * Constructeur par défaut de la classe CelluleLumineuse.
     * Initialise la cellule à l'état éteint (false).
     */
    public CelluleLumineuse() {
        this.etat = false; // Cellule éteinte par défaut
    }
    
    /**
     * Change l'état actuel de la cellule.
     */
    public void activerCellule() {
        this.etat = !this.etat; // sert à basculer d'un état allumé à celui d'éteint 
    }
    
    /**
     * Éteint la cellule en forçant son état à false.
     */
    public void eteindreCellule() {
        this.etat = false; // éteind la cellule 
    }
    
    /**
     * Vérifie si la cellule est éteinte.
     * @return true si la cellule est éteinte, false sinon.
     */
    public boolean estEteint() {
        return !this.etat; //si la cellule est allumé cela renvoie true, pour obtenir l'état exact de la cellule
    }

    /**
     * Retourne l'état actuel de la cellule.
     * @return true si la cellule est allumée, false si elle est éteinte.
     */    
    public boolean getEtat() {
        return this.etat; // si le résultat est true, alors la cellule est allumée, vérifie si la cellule est éteinte
    }

    /**
     * Retourne une représentation textuelle de la cellule.
     * @return "X" si la cellule est allumée, "O" si elle est éteinte.
     */
    @Override
    public String toString() {
        return this.etat ? "X" : "O"; // "X" pour allumée, "O" pour éteinte
    }
}


 

