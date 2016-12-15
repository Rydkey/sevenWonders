package Controleur;

import Model.Jeu;
import Vue.ConteneurChoixMerveille;
import Vue.Fenetre;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
        System.out.println(Integer.parseInt(e.getComponent().getName()));
        System.out.println(fen.getJeu().getDeckMerveilleModel().getChoixCarte().size());
        if (fen.getJeu().getJ1joue()){
            fen.getJeu().getJoueur1().addIdMerveille(fen.getJeu().getDeckMerveilleModel().getChoixCarte().get(Integer.parseInt(e.getComponent().getName())).getIdMerveille());
        }else {
            fen.getJeu().getJoueur2().addIdMerveille(fen.getJeu().getDeckMerveilleModel().getChoixCarte().get(Integer.parseInt(e.getComponent().getName())).getIdMerveille());
        }
        System.out.println(fen.getJeu().getDeckMerveilleModel().getChoixCarte().size());
        fen.getJeu().getDeckMerveilleModel().getChoixCarte().remove(Integer.parseInt(e.getComponent().getName()));
        if (fen.getJeu().getDeckMerveilleModel().getChoixCarte().size()==3 || fen.getJeu().getDeckMerveilleModel().getChoixCarte().size()==1){
            fen.getJeu().setJ1joue(!fen.getJeu().getJ1joue());
        }
        if (!(fen.getJeu().getDeckMerveilleModel().getChoixCarte().size()==0)) {
            fen.setVisible(false);
            conteneurChoixMerveille = new ConteneurChoixMerveille(fen);
            conteneurChoixMerveille.setControleur(this);
            fen.setContentPane(conteneurChoixMerveille);
            fen.pack();
            fen.setVisible(true);
        }else {
            fen.setVisible(false);
//            ConteneurAge conteneurCarte=new ConteneurAge(1)
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
