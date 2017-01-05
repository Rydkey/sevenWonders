package Controleur;

import Model.DeckModel;
import Vue.ConteneurChoixMerveille;
import Vue.ConteneurPlateauCarte;
import Vue.ConteneurResumerJoueur;
import Vue.Fenetre;

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
                fen.getJeu().setDeckModel(new DeckModel());
                fen.getJeu().getDeckModel().faireCardTab(new Random());
                fen.setConteneurPlateauCarte(new ConteneurPlateauCarte(fen));
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
                global.add(fen.getConteneurPlateauCarte());
                fen.setContentPane(global);
//            ConteneurAge conteneurCarte=new ConteneurAge(1)
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
