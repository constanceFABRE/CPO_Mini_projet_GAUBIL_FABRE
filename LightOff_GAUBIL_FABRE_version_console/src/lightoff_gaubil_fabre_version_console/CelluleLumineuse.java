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
        this.etat = !this.etat; // changement d'état, bascule entre éteind et allumé
    }
     
    public void eteindreCellule() {
        this.etat = false; // éteind la cellule 
    }

    public boolean estEteint() {
        return !this.etat; // Savoir si c'est éteins, vérifier
    }

    public boolean getEtat() {
        return this.etat; // Savoir si c'est allumée, vérifier
    }

    @Override
    public String toString() {
        return this.etat ? "X" : "O"; // "X" pour allumée, "O" pour éteinte
    }
}
