/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package lightoff_gaubil_fabre_version_console;


import java.awt.GridLayout;
import javax.swing.JButton;
import lightoff_gaubil_fabre_version_console.CelluleLumineuse;
import lightoff_gaubil_fabre_version_console.GrilleDeJeu;

/**
 *
 * @author constancefabre
 */
public class FenetrePrincipale extends javax.swing.JFrame {
    GrilleDeJeu grille;
    int nbCoups;
    /**
     * Creates new form FenetrePrincipale
     */
      /**
     * Constructeur de la fenêtre principale
     */
    public FenetrePrincipale(int taille) {
        initComponents();

        // Initialisation du nombre de coups en fonction de la taille
        switch (taille) {
            case 5 -> nbCoups = 25;
            case 7 -> nbCoups = 18;
            case 10 -> nbCoups = 10;
        }

        // Adapter le panneau des colonnes
        jPanel1.removeAll();
        jPanel1.setLayout(new GridLayout(1, taille));
        for (int i = 0; i < taille; i++) {
            JButton btnColonne = new JButton("C" + (i + 1));
            int colIndex = i;
            btnColonne.addActionListener(evt -> {
                grille.activerColonneDeCellules(colIndex);
                repaint();
                verifierVictoire();
            });
            jPanel1.add(btnColonne);
        }

        // Adapter le panneau des lignes
        jPanel2.removeAll();
        jPanel2.setLayout(new GridLayout(taille, 1));
        for (int i = 0; i < taille; i++) {
            JButton btnLigne = new JButton("L" + (i + 1));
            int rowIndex = i;
            btnLigne.addActionListener(evt -> {
                grille.activerLigneDeCellules(rowIndex);
                repaint();
                verifierVictoire();
            });
            jPanel2.add(btnLigne);
        }

        // Adapter le panneau de la grille principale
        PanneauGrille.removeAll();
        PanneauGrille.setLayout(new GridLayout(taille, taille));

        // Créer une nouvelle grille et mélanger
        this.grille = new GrilleDeJeu(taille, taille);
        grille.melangerMatriceAleatoirement(10);

        // Ajouter les cellules au panneau
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                CelluleGraphique boutonCellule = new CelluleGraphique(grille.matriceCellules[i][j], 36, 36);
                PanneauGrille.add(boutonCellule);
            }
        }

        // Rafraîchir les composants
        jPanel1.revalidate();
        jPanel1.repaint();
        jPanel2.revalidate();
        jPanel2.repaint();
        PanneauGrille.revalidate();
        PanneauGrille.repaint();
    }

    private boolean estVictoire() {
        for (int i = 0; i < grille.getNbLignes(); i++) {
            for (int j = 0; j < grille.getNbColonnes(); j++) {
                if (!grille.matriceCellules[i][j].estEteint()) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Arrête le jeu et affiche un message si toutes les lumières sont éteintes
     */
    private void verifierVictoire() {
        if (estVictoire()) {
            Victoire fenetreVictoire = new Victoire();
            fenetreVictoire.setVisible(true);
            dispose();
        }
    }
 
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanneauGrille = new javax.swing.JPanel();
        btnDiagonaleMontante = new javax.swing.JButton();
        btnDiagonaleDescendante = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnColonne0 = new javax.swing.JButton();
        btnColonne1 = new javax.swing.JButton();
        btnColonne2 = new javax.swing.JButton();
        btnColonne3 = new javax.swing.JButton();
        btnColonne4 = new javax.swing.JButton();
        btnColonne5 = new javax.swing.JButton();
        btnColonne6 = new javax.swing.JButton();
        btnColonne7 = new javax.swing.JButton();
        btnColonne8 = new javax.swing.JButton();
        btnColonne9 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnLigne0 = new javax.swing.JButton();
        btnLigne1 = new javax.swing.JButton();
        btnLigne2 = new javax.swing.JButton();
        btnLigne3 = new javax.swing.JButton();
        btnLigne4 = new javax.swing.JButton();
        btnLigne5 = new javax.swing.JButton();
        btnLigne6 = new javax.swing.JButton();
        btnLigne7 = new javax.swing.JButton();
        btnLigne8 = new javax.swing.JButton();
        btnLigne9 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanneauGrille.setBackground(new java.awt.Color(0, 102, 255));

        javax.swing.GroupLayout PanneauGrilleLayout = new javax.swing.GroupLayout(PanneauGrille);
        PanneauGrille.setLayout(PanneauGrilleLayout);
        PanneauGrilleLayout.setHorizontalGroup(
            PanneauGrilleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        PanneauGrilleLayout.setVerticalGroup(
            PanneauGrilleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        getContentPane().add(PanneauGrille, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 400, 400));

        btnDiagonaleMontante.setText("DiagoMontante");
        btnDiagonaleMontante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDiagonaleMontanteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDiagonaleMontante, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 120, -1, -1));

        btnDiagonaleDescendante.setText("DiagoDescendante");
        btnDiagonaleDescendante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDiagonaleDescendanteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDiagonaleDescendante, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 150, -1, -1));

        jPanel1.setPreferredSize(new java.awt.Dimension(20, 400));
        jPanel1.setLayout(new java.awt.GridLayout());

        btnColonne0.setText("0");
        btnColonne0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColonne0ActionPerformed(evt);
            }
        });
        jPanel1.add(btnColonne0);

        btnColonne1.setText("1");
        btnColonne1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColonne1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnColonne1);

        btnColonne2.setText("2");
        btnColonne2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColonne2ActionPerformed(evt);
            }
        });
        jPanel1.add(btnColonne2);

        btnColonne3.setText("3");
        btnColonne3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColonne3ActionPerformed(evt);
            }
        });
        jPanel1.add(btnColonne3);

        btnColonne4.setText("4");
        btnColonne4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColonne4ActionPerformed(evt);
            }
        });
        jPanel1.add(btnColonne4);

        btnColonne5.setText("5");
        btnColonne5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColonne5ActionPerformed(evt);
            }
        });
        jPanel1.add(btnColonne5);

        btnColonne6.setText("6");
        btnColonne6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColonne6ActionPerformed(evt);
            }
        });
        jPanel1.add(btnColonne6);

        btnColonne7.setText("7");
        btnColonne7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColonne7ActionPerformed(evt);
            }
        });
        jPanel1.add(btnColonne7);

        btnColonne8.setText("8");
        btnColonne8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColonne8ActionPerformed(evt);
            }
        });
        jPanel1.add(btnColonne8);

        btnColonne9.setText("9");
        btnColonne9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColonne9ActionPerformed(evt);
            }
        });
        jPanel1.add(btnColonne9);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 400, 40));

        jPanel2.setLayout(new java.awt.GridLayout(0, 1));

        btnLigne0.setText("L0");
        btnLigne0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLigne0ActionPerformed(evt);
            }
        });
        jPanel2.add(btnLigne0);

        btnLigne1.setText("L1");
        btnLigne1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLigne1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnLigne1);

        btnLigne2.setText("L2");
        btnLigne2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLigne2ActionPerformed(evt);
            }
        });
        jPanel2.add(btnLigne2);

        btnLigne3.setText("L3");
        btnLigne3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLigne3ActionPerformed(evt);
            }
        });
        jPanel2.add(btnLigne3);

        btnLigne4.setText("L4");
        btnLigne4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLigne4ActionPerformed(evt);
            }
        });
        jPanel2.add(btnLigne4);

        btnLigne5.setText("L5");
        btnLigne5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLigne5ActionPerformed(evt);
            }
        });
        jPanel2.add(btnLigne5);

        btnLigne6.setText("L6");
        btnLigne6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLigne6ActionPerformed(evt);
            }
        });
        jPanel2.add(btnLigne6);

        btnLigne7.setText("L7");
        btnLigne7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLigne7ActionPerformed(evt);
            }
        });
        jPanel2.add(btnLigne7);

        btnLigne8.setText("L8");
        btnLigne8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLigne8ActionPerformed(evt);
            }
        });
        jPanel2.add(btnLigne8);

        btnLigne9.setText("L9");
        btnLigne9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLigne9ActionPerformed(evt);
            }
        });
        jPanel2.add(btnLigne9);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 50, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLigne0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLigne0ActionPerformed
        this.grille.activerLigneDeCellules(0);
        repaint();
       
    }//GEN-LAST:event_btnLigne0ActionPerformed

    private void btnLigne1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLigne1ActionPerformed
        this.grille.activerLigneDeCellules(1);
repaint();

    }//GEN-LAST:event_btnLigne1ActionPerformed

    private void btnLigne2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLigne2ActionPerformed
       this.grille.activerLigneDeCellules(2);
repaint();

    }//GEN-LAST:event_btnLigne2ActionPerformed

    private void btnLigne3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLigne3ActionPerformed
        this.grille.activerLigneDeCellules(3);
repaint();

    }//GEN-LAST:event_btnLigne3ActionPerformed

    private void btnLigne4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLigne4ActionPerformed
       this.grille.activerLigneDeCellules(4);
repaint();

    }//GEN-LAST:event_btnLigne4ActionPerformed

    private void btnLigne5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLigne5ActionPerformed
        this.grille.activerLigneDeCellules(5);
repaint();

    }//GEN-LAST:event_btnLigne5ActionPerformed

    private void btnLigne6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLigne6ActionPerformed
        this.grille.activerLigneDeCellules(6);
repaint();

    }//GEN-LAST:event_btnLigne6ActionPerformed

    private void btnLigne7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLigne7ActionPerformed
        this.grille.activerLigneDeCellules(7);
repaint();
    }//GEN-LAST:event_btnLigne7ActionPerformed

    private void btnLigne8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLigne8ActionPerformed
       this.grille.activerLigneDeCellules(8);
repaint();

    }//GEN-LAST:event_btnLigne8ActionPerformed

    private void btnLigne9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLigne9ActionPerformed
       this.grille.activerLigneDeCellules(9);
repaint();

    }//GEN-LAST:event_btnLigne9ActionPerformed

    private void btnColonne1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColonne1ActionPerformed
        this.grille.activerColonneDeCellules(1);
repaint();

    }//GEN-LAST:event_btnColonne1ActionPerformed

    private void btnColonne0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColonne0ActionPerformed
        this.grille.activerColonneDeCellules(0);
repaint();

    }//GEN-LAST:event_btnColonne0ActionPerformed

    private void btnColonne2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColonne2ActionPerformed
        this.grille.activerColonneDeCellules(2);
repaint();

    }//GEN-LAST:event_btnColonne2ActionPerformed

    private void btnColonne3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColonne3ActionPerformed
        this.grille.activerColonneDeCellules(3);
repaint();

    }//GEN-LAST:event_btnColonne3ActionPerformed

    private void btnColonne4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColonne4ActionPerformed
        this.grille.activerColonneDeCellules(4);
repaint();

    }//GEN-LAST:event_btnColonne4ActionPerformed

    private void btnColonne5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColonne5ActionPerformed
        this.grille.activerColonneDeCellules(5);
repaint();

    }//GEN-LAST:event_btnColonne5ActionPerformed

    private void btnColonne6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColonne6ActionPerformed
        this.grille.activerColonneDeCellules(6);
repaint();

    }//GEN-LAST:event_btnColonne6ActionPerformed

    private void btnColonne7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColonne7ActionPerformed
        this.grille.activerColonneDeCellules(7);
repaint();

    }//GEN-LAST:event_btnColonne7ActionPerformed

    private void btnColonne8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColonne8ActionPerformed
        this.grille.activerColonneDeCellules(8);
repaint();

    }//GEN-LAST:event_btnColonne8ActionPerformed

    private void btnColonne9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColonne9ActionPerformed
        this.grille.activerColonneDeCellules(9);
repaint();

    }//GEN-LAST:event_btnColonne9ActionPerformed

    private void btnDiagonaleMontanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDiagonaleMontanteActionPerformed
        this.grille.activerDiagonaleMontante();
repaint();

    }//GEN-LAST:event_btnDiagonaleMontanteActionPerformed

    private void btnDiagonaleDescendanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDiagonaleDescendanteActionPerformed
        this.grille.activerDiagonaleDescendante();
repaint();

    }//GEN-LAST:event_btnDiagonaleDescendanteActionPerformed

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FenetrePrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FenetrePrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FenetrePrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FenetrePrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanneauGrille;
    private javax.swing.JButton btnColonne0;
    private javax.swing.JButton btnColonne1;
    private javax.swing.JButton btnColonne2;
    private javax.swing.JButton btnColonne3;
    private javax.swing.JButton btnColonne4;
    private javax.swing.JButton btnColonne5;
    private javax.swing.JButton btnColonne6;
    private javax.swing.JButton btnColonne7;
    private javax.swing.JButton btnColonne8;
    private javax.swing.JButton btnColonne9;
    private javax.swing.JButton btnDiagonaleDescendante;
    private javax.swing.JButton btnDiagonaleMontante;
    private javax.swing.JButton btnLigne0;
    private javax.swing.JButton btnLigne1;
    private javax.swing.JButton btnLigne2;
    private javax.swing.JButton btnLigne3;
    private javax.swing.JButton btnLigne4;
    private javax.swing.JButton btnLigne5;
    private javax.swing.JButton btnLigne6;
    private javax.swing.JButton btnLigne7;
    private javax.swing.JButton btnLigne8;
    private javax.swing.JButton btnLigne9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
