package lightoff_gaubil_fabre_version_console;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JButton;

/* 
 *
 *
 */

/**
 *
 * @author constancefabre
 */
public class CelluleGraphique extends JButton {
        int largeur; // largeur en pixel de la cellule
        int hauteur; // hauteur en pixel de la cellule
        CelluleLumineuse celluleLumineuseAssociee;
   
        // constructeur (appelé depuis FenetrePrincipale)
    public CelluleGraphique(CelluleLumineuse celluleLumineuseAssociee, int l,int h) {
        this.largeur = l;
        this.hauteur = h;
        this.celluleLumineuseAssociee = celluleLumineuseAssociee;
    }
        // Methode gérant le dessin de la cellule
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setText(celluleLumineuseAssociee.toString());
        int w = this.getWidth();
        int h = this.getHeight();
        if (celluleLumineuseAssociee.estEteint()== true){
            g.setColor(Color.pink);
        }else{
            g.setColor(Color.yellow);
        }
        g.fillOval(2, 2,w - 4, h - 4);
    }
}