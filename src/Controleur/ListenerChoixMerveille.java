package Controleur;

import Model.DeckModel;
import Model.Jeu;
import Vue.ConteneurChoixMerveille;
import Vue.ConteneurPlateauCarte;
import Vue.ConteneurResumerJoueur;
import Vue.Fenetre;

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
                fen.getJeu().getJoueur1().addIdMerveille(fen.getJeu().getDeckMerveilleModel().getChoixCarte().get(Integer.parseInt(e.getComponent().getName())).getIdMerveille());
            } else {
                fen.getJeu().getJoueur2().addIdMerveille(fen.getJeu().getDeckMerveilleModel().getChoixCarte().get(Integer.parseInt(e.getComponent().getName())).getIdMerveille());
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
            } else if (fen.getJeu().getJoueur1().getIdMerveille()[3] == -1) {
                fen.getJeu().setJ1joue(!fen.getJeu().getJ1joue());
                fen.getJeu().getDeckMerveilleModel().choixCarte(new Random());
                conteneurChoixMerveille = new ConteneurChoixMerveille(fen);
                conteneurChoixMerveille.setControleur(this);
                fen.setContentPane(conteneurChoixMerveille);
            } else {
                fen.getJeu().getJoueur1().setPointScore(3);
                fen.getJeu().getJoueur2().setPointScore(3);
                fen.getJeu().setAge(1);
                fen.getJeu().setDeckModel(new DeckModel());
                fen.getJeu().getDeckModel().faireCardTab(new Random());
                fen.setContentPane(new ConteneurPlateauCarte(fen));
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
