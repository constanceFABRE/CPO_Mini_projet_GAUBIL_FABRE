package lightoff_gaubil_fabre_version_console;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JButton;

/**
 * La classe CelluleGraphique représente un bouton graphique (JButton) associé à une cellule lumineuse.
 * 
 * @author Valentine GAUBIL
 * @version 1.0
 */
public class CelluleGraphique extends JButton {

    /**
     * Largeur en pixels de la cellule graphique.
     */
    int largeur;

    /**
     * Hauteur en pixels de la cellule graphique.
     */
    int hauteur;

    /**
     * Cellule lumineuse associée à cette cellule graphique.
     */
    CelluleLumineuse celluleLumineuseAssociee;

    /**
     * Constructeur de la classe CelluleGraphique.
     * Initialise une cellule graphique avec une cellule lumineuse associée, 
     * ainsi que ses dimensions.
     * 
     * @param celluleLumineuseAssociee La cellule lumineuse associée à cette cellule graphique.
     * @param l La largeur de la cellule graphique en pixels.
     * @param h La hauteur de la cellule graphique en pixels.
     */
    public CelluleGraphique(CelluleLumineuse celluleLumineuseAssociee, int l, int h) {
        this.largeur = l;
        this.hauteur = h;
        this.celluleLumineuseAssociee = celluleLumineuseAssociee;
    }

    /**
     * Méthode de dessin de la cellule graphique.
     * Cette méthode personnalise l'apparence du bouton en fonction de 
     * l'état de la cellule lumineuse associée. 
     * 
     * - Si la cellule lumineuse est éteinte, le bouton est coloré en rose.
     * - Si la cellule lumineuse est allumée, le bouton est coloré en jaune.
     * 
     * @param g L'objet Graphics utilisé pour dessiner la cellule.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Définir le texte affiché à partir de la représentation de la cellule lumineuse
        this.setText(celluleLumineuseAssociee.toString());

        // Obtenir la largeur et la hauteur du bouton
        int w = this.getWidth();
        int h = this.getHeight();

        // Définir la couleur selon l'état de la cellule lumineuse
        if (celluleLumineuseAssociee.estEteint()) {
            g.setColor(Color.pink);
        } else {
            g.setColor(Color.yellow);
        }

        // Dessiner un cercle coloré représentant l'état de la cellule
        g.fillOval(2, 2, w - 4, h - 4);
    }
}
