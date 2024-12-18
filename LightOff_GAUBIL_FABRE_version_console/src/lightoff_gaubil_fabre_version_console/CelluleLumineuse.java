
package lightoff_gaubil_fabre_version_console;

/**
 *
 * @author constancefabre
 */

/**
 * Représente une cellule lumineuse avec deux états : allumée ou éteinte.
 * La cellule peut être activée, désactivée ou éteinte explicitement.
 * 
 * L'état de la cellule est représenté par un booléen "etat" :
 * - "true" indique que la cellule est allumée.
 * - "false" indique que la cellule est éteinte.
 * 
 * La classe offre également une méthode pour basculer entre les deux états
 * et une méthode pour obtenir une représentation textuelle de l'état.
 */

public class CelluleLumineuse {
    private boolean etat;
    
    /**
     * Constructeur par défaut de la cellule lumineuse.
     * Initialise la cellule à l'état éteint.
     */
    public CelluleLumineuse() {
        this.etat = false; 
    }
     
     /**
     * Active ou désactive la cellule en basculant son état.
     * Si la cellule est allumée, elle sera éteinte.
     * Si la cellule est éteinte, elle sera allumée.
     */
    public void activerCellule() {
        this.etat = !this.etat; 
    }
     
     /**
     * Éteint explicitement la cellule (passe son état à "false").
     */
    public void eteindreCellule() {
        this.etat = false; 
    }

    /**
     * Vérifie si la cellule est éteinte.
     * 
     * @return "true" si la cellule est éteinte, "false" si elle est allumée.
     */
    public boolean estEteint() {
        return !this.etat; 
    }

    /**
     * Renvoie l'état actuel de la cellule.
     * 
     * @return "true" si la cellule est allumée, "false" si elle est éteinte.
     */
    public boolean getEtat() {
        return this.etat; 
    }

    /**
     * Renvoie une représentation textuelle de l'état de la cellule.
     * 
     * @return "X" si la cellule est allumée, "O" si elle est éteinte.
     */
    @Override
    public String toString() {
        return this.etat ? "X" : "O"; 
    }
}


 

