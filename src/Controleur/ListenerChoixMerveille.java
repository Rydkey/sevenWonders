package Controleur;

import Vue.ConteneurChoixMerveille;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by ANTOINE on 09/12/2016.
 */
public class ListenerChoixMerveille implements MouseListener {
    private ConteneurChoixMerveille conteneurChoixMerveille;

    public ListenerChoixMerveille(ConteneurChoixMerveille conteneurChoixMerveille) {
        this.conteneurChoixMerveille = conteneurChoixMerveille;
        this.conteneurChoixMerveille.setControleur(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

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
