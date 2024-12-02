/*
 * 
 *
 */

package lightoff_gaubil_fabre_version_console;

/**
 *
 * @author constancefabre
 */
public class CelluleLumineuse {
    private boolean etat;
    
    public CelluleLumineuse() {
        this.etat = false; // Cellule éteinte par défaut
    }
     
    public void activerCellule() {
        this.etat = !this.etat; // sert à basculer d'un état allumé à celui d'éteint 
    }
     
    public void eteindreCellule() {
        this.etat = false; // éteind la cellule 
    }

    public boolean estEteint() {
        return !this.etat; //si la cellule est allumé cela renvoie true, pour obtenir l'état exact de la cellule
    }

    public boolean getEtat() {
        return this.etat; // si le résultat est true, alors la cellule est allumée, vérifie si la cellule est éteinte
    }

    @Override
    public String toString() {
        return this.etat ? "X" : "O"; // "X" pour allumée, "O" pour éteinte
    }
}




