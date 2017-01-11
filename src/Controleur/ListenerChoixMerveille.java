
package Controleur;
import Model.DeckModel;
import Vue.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

/**
 * Created by ANTOINE on 09/12/2016.
 */
public class ListenerChoixMerveille implements MouseListener {
    private ConteneurChoixMerveille conteneurChoixMerveille;
    private Fenetre fen;

    public ListenerChoixMerveille(ConteneurChoixMerveille conteneurChoixMerveille, Fenetre fen) {
        this.fen =fen;
        this.conteneurChoixMerveille = conteneurChoixMerveille;
        this.conteneurChoixMerveille.setControleur(this);
    }



    @Override
    public void mouseClicked(MouseEvent e) {
        if (!e.getComponent().getName().equals("-1")) {
            if (fen.getJeu().getJ1joue()) {
                fen.getJeu().getJoueur1().getMerveilleJoueur().add(fen.getJeu().getDeckMerveilleModel().getChoixCarte().get(Integer.parseInt(e.getComponent().getName())));
            } else {
                fen.getJeu().getJoueur2().getMerveilleJoueur().add(fen.getJeu().getDeckMerveilleModel().getChoixCarte().get(Integer.parseInt(e.getComponent().getName())));
            }
            fen.getJeu().getDeckMerveilleModel().getChoixCarte().remove(Integer.parseInt(e.getComponent().getName()));
            if (fen.getJeu().getDeckMerveilleModel().getChoixCarte().size() == 3 || fen.getJeu().getDeckMerveilleModel().getChoixCarte().size() == 1) {
                fen.getJeu().setJ1joue(!fen.getJeu().getJ1joue());
            }
            fen.setVisible(false);
            if (!(fen.getJeu().getDeckMerveilleModel().getChoixCarte().size() == 0)) {
                conteneurChoixMerveille = new ConteneurChoixMerveille(fen);
                conteneurChoixMerveille.setControleur(this);
                fen.setContentPane(conteneurChoixMerveille);
            } else if (fen.getJeu().getJoueur1().getMerveilleJoueur().size() == 2) {
                fen.getJeu().setJ1joue(!fen.getJeu().getJ1joue());
                fen.getJeu().getDeckMerveilleModel().choixCarte(new Random());
                conteneurChoixMerveille = new ConteneurChoixMerveille(fen);
                conteneurChoixMerveille.setControleur(this);
                fen.setContentPane(conteneurChoixMerveille);
            } else {
                fen.getJeu().setAge(1);
//                fen.getJeu().setAge(2);
//                fen.getJeu().setAge(3);
                //test victoire militaire
//                fen.getJeu().getJoueur1().setPointAttaque(8);
                //test victoire Scientifique
//                fen.getJeu().getJoueur1().getIdScience().add(2);
//                fen.getJeu().getJoueur1().getIdScience().add(3);
//                fen.getJeu().getJoueur1().getIdScience().add(4);
//                fen.getJeu().getJoueur1().getIdScience().add(5);
//                fen.getJeu().getJoueur1().getIdScience().add(6);
                //testVictoire civile
                //fen.getJeu().setAge(3);
                //fen.getJeu().getJoueur1().setPointScore(10);
                //test Victoire civile egalité
                //fen.getJeu().getJoueur2().setPointScore(20);
                //egalité pur désactivé guerre
                //fen.getJeu.getJoueur1().setPointScore(20);
                fen.getJeu().setDeckModel(new DeckModel(new Random()));
//                for (int i=0;i<fen.getJeu().getDeckModel().cardTabAge3.length;i++) {
//                    for (int j = 0; j < fen.getJeu().getDeckModel().cardTabAge3[i].length; j++) {
//                        if (!(i==0 && j==0)){
//                            fen.getJeu().getDeckModel().cardTabAge3[i][j] = null;
//                        }
//                    }
//                }
                fen.setConteneurPlateauCarte(new ConteneurPlateauCarte(fen));
                fen.setConteneurPionGuerre(new ConteneurPionGuerre(fen.getJeu()));
                JPanel global = new JPanel();
                JPanel joueurs = new JPanel();
                global.setLayout(new BoxLayout(global,BoxLayout.Y_AXIS));
                global.setBackground(Color.orange);
                joueurs.setLayout(new BorderLayout());
                joueurs.setOpaque(false);
                fen.setResumerJoueur1(new ConteneurResumerJoueur(fen,1));
                fen.setResumerJoueur2(new ConteneurResumerJoueur(fen,2));
                new ListenerPlateau(fen.getConteneurPlateauCarte(),fen.getResumerJoueur1(),fen.getResumerJoueur2(),fen);
                joueurs.add(fen.getResumerJoueur1(),BorderLayout.LINE_START);
                joueurs.add(fen.getResumerJoueur2(),BorderLayout.LINE_END);
                global.add(joueurs);
                global.add(fen.getConteneurPionGuerre());
                global.add(fen.getConteneurPlateauCarte());
                fen.setContentPane(global);
            }
            fen.pack();
            fen.setVisible(true);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
