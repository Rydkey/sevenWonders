package Controleur;

import Vue.ConteneurPlateauCarte;
import Vue.ConteneurResumerJoueur;
import Vue.Fenetre;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by ANTOINE on 16/12/2016.
 */
public class ListenerPlateau implements MouseListener,ActionListener {
    Fenetre fen;
    ConteneurPlateauCarte conteneurPlateauCarte;
    ConteneurResumerJoueur conteneurResumerJoueur1;
    ConteneurResumerJoueur conteneurResumerJoueur2;


    public ListenerPlateau(ConteneurPlateauCarte conteneurPlateauCarte,ConteneurResumerJoueur conteneurResumerJoueur1,ConteneurResumerJoueur conteneurResumerJoueur2, Fenetre fen){
        this.fen=fen;
        this.conteneurPlateauCarte=conteneurPlateauCarte;
        this.conteneurResumerJoueur1=conteneurResumerJoueur1;
        this.conteneurResumerJoueur2=conteneurResumerJoueur2;
        conteneurPlateauCarte.setControleur(this);
        conteneurResumerJoueur1.setControler(this);
        conteneurResumerJoueur2.setControler(this);
    }



    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(conteneurResumerJoueur1.getGlobal())){
            conteneurResumerJoueur1.showPopup();
        }else if (e.getSource().equals(conteneurResumerJoueur2.getGlobal())){
            conteneurResumerJoueur2.showPopup();
        }else if (e.getSource().getClass().equals(JPanel.class)){
            int nb =(int)((JPanel)e.getSource()).getClientProperty("nb");
            int prix=0;
            String erreur="no error";
            if (fen.getJeu().getJ1joue()){
                for (int i=0;i<5;i++){
                    prix += (fen.getJeu().getJoueur1().getMerveilleJoueur().get(nb).getPrix_resource()[i] - fen.getJeu().getJoueur1().getRessource()[i]) * (fen.getJeu().getJoueur1().getPrixRessource()[i]);
                }
                if (prix>fen.getJeu().getJoueur1().getPieces()){
                    erreur="erreur";
                }else {
                    fen.getJeu().getJoueur1().setPieces(fen.getJeu().getJoueur1().getPieces() - prix);
                    fen.getJeu().getJoueur1().constructMerveilles(nb, prix);
                    switch (fen.getJeu().getJoueur1().getMerveilleJoueur().get(nb).getIdMerveille()) {
                        case 1:
                            fen.getConteneurPlateauCarte().showDestroyCardPopup("grise");
                            break;
                        case 5:
                            break;
                        case 6:
                            break;
                        case 10:
                            fen.getConteneurPlateauCarte().showDestroyCardPopup("marron");
                            break;
                        case 12:
                            break;
                        case 11:
                        case 9:
                        case 7:
                        case 4:
                            break;
                        default:
                    }
                }
            }else {
                for (int i=0;i<5;i++){
                    prix+= (fen.getJeu().getJoueur2().getMerveilleJoueur().get(nb).getPrix_resource()[i] - fen.getJeu().getJoueur1().getRessource()[i]) * (fen.getJeu().getJoueur2().getPrixRessource()[i]);
                }
                if (prix>fen.getJeu().getJoueur2().getPieces()){
                    erreur="erreur";
                }else {
                    fen.getJeu().getJoueur2().setPieces(fen.getJeu().getJoueur1().getPieces() - prix);
                    fen.getJeu().getJoueur2().constructMerveilles(nb, prix);
                    switch (fen.getJeu().getJoueur2().getMerveilleJoueur().get(nb).getIdMerveille()) {
                        case 1:
                            fen.getConteneurPlateauCarte().showDestroyCardPopup("grise");
                            break;
                        case 5:
                            break;
                        case 6:
                            break;
                        case 10:
                            fen.getConteneurPlateauCarte().showDestroyCardPopup("marron");
                            break;
                        case 12:
                            break;
                        case 11:
                        case 9:
                        case 7:
                        case 4:
                            break;
                        default:
                    }
                }

            }
            if (erreur.equals("no error")) {
                fen.getConteneurPlateauCarte().getjDialog().setVisible(false);
                conteneurPlateauCarte.getjDialog().dispose();
            }
        }else {
            int[] pos;
            pos = (int[]) ((JLabel) e.getSource()).getClientProperty("pos");
            if (pos[0] == 4 || (fen.getJeu().getDeckModel().cardTab[pos[0] + 1][pos[1]]) == null && fen.getJeu().getDeckModel().cardTab[pos[0] + 1][pos[1] + 1] == null) {
                if (fen.getJeu().getJ1joue()) {
                    int prix = fen.getJeu().getDeckModel().cardTab[pos[0]][pos[1]].getPrix_pieces();
                    for (int i = 0; i < 5; i++) {
                        if (fen.getJeu().getDeckModel().cardTab[pos[0]][pos[1]].getPrix_resource()[i] - fen.getJeu().getJoueur1().getRessource()[i] > 0) {
                            prix += (fen.getJeu().getDeckModel().cardTab[pos[0]][pos[1]].getPrix_resource()[i] - fen.getJeu().getJoueur1().getRessource()[i]) * (fen.getJeu().getJoueur1().getPrixRessource()[i]);
                        }
                    }

                    int vente = 2;
                    for (int i = 0; i < fen.getJeu().getJoueur1().getMainJoueur().size(); i++) {
                        if (fen.getJeu().getJoueur1().getMainJoueur().get(i).getColor().equals("jaune")) {
                            vente++;
                        }
                    }
                    conteneurPlateauCarte.showBuyCardPopup(this, pos, prix, vente);
                } else {
                    int prix = fen.getJeu().getDeckModel().cardTab[pos[0]][pos[1]].getPrix_pieces();
                    for (int i = 0; i < 5; i++) {
                        if (fen.getJeu().getDeckModel().cardTab[pos[0]][pos[1]].getPrix_resource()[i] - fen.getJeu().getJoueur2().getRessource()[i] > 0) {
                            prix += (fen.getJeu().getDeckModel().cardTab[pos[0]][pos[1]].getPrix_resource()[i] - fen.getJeu().getJoueur2().getRessource()[i]) * (fen.getJeu().getJoueur2().getPrixRessource()[i]);
                        }
                    }

                    int vente = 2;
                    for (int i = 0; i < fen.getJeu().getJoueur2().getMainJoueur().size(); i++) {
                        if (fen.getJeu().getJoueur2().getMainJoueur().get(i).getColor().equals("jaune")) {
                            vente++;
                        }
                    }
                    conteneurPlateauCarte.showBuyCardPopup(this, pos, prix, vente);
                }
            }
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

    @Override
    public void actionPerformed(ActionEvent e) {
        String error="no error";
        int[] pos;
        pos =(int[])((JButton)e.getSource()).getClientProperty("pos");
        if (e.getActionCommand().startsWith("Acheter pour")){
            if (fen.getJeu().getJ1joue()){

                int prix=fen.getJeu().getDeckModel().cardTab[pos[0]][pos[1]].getPrix_pieces();
                for (int i=0;i<5;i++){
                    if (fen.getJeu().getDeckModel().cardTab[pos[0]][pos[1]].getPrix_resource()[i]-fen.getJeu().getJoueur1().getRessource()[i]>0) {
                        prix += (fen.getJeu().getDeckModel().cardTab[pos[0]][pos[1]].getPrix_resource()[i] - fen.getJeu().getJoueur1().getRessource()[i]) * (fen.getJeu().getJoueur1().getPrixRessource()[i]);
                    }
                }
                System.out.println("achat\n\n");
                if (prix<=fen.getJeu().getJoueur1().getPieces()){
                    fen.getJeu().getJoueur1().piocher(fen.getJeu().getDeckModel().cardTab[pos[0]][pos[1]],prix);
                    fen.getJeu().getJoueur2().augmentePrixRessource(fen.getJeu().getDeckModel().cardTab[pos[0]][pos[1]]);
                    fen.getJeu().getDeckModel().cardTab[pos[0]][pos[1]]=null;
                }else {
                    error="Not enough money";
                }
            }else {
                int prix=fen.getJeu().getDeckModel().cardTab[pos[0]][pos[1]].getPrix_pieces();
                for (int i=0;i<5;i++){
                    prix += (fen.getJeu().getDeckModel().cardTab[pos[0]][pos[1]].getPrix_resource()[i] - fen.getJeu().getJoueur2().getRessource()[i]) * (fen.getJeu().getJoueur2().getPrixRessource()[i]);
                }
                System.out.println("achat\n\n");
                if (prix<=fen.getJeu().getJoueur2().getPieces()) {
                    fen.getJeu().getJoueur2().piocher(fen.getJeu().getDeckModel().cardTab[pos[0]][pos[1]], prix);
                    fen.getJeu().getJoueur1().augmentePrixRessource(fen.getJeu().getDeckModel().cardTab[pos[0]][pos[1]]);
                    fen.getJeu().getDeckModel().cardTab[pos[0]][pos[1]] = null;
                }else {
                    error="Not enough money";
                }
            }
            conteneurPlateauCarte.setInvisible(pos[2]);
            conteneurPlateauCarte.getjDialog().dispose();
        }else if (e.getActionCommand().startsWith("Vendre pour")){
            if (fen.getJeu().getJ1joue()){
                int vente=0;
                for (int i=0;i<fen.getJeu().getJoueur1().getMainJoueur().size();i++){
                    if (fen.getJeu().getJoueur1().getMainJoueur().get(i).getColor().equals("jaune")){
                        vente++;
                    }
                }
                fen.getJeu().getJoueur1().setPieces(fen.getJeu().getJoueur1().getPieces()+2+vente);
            }else {
                int vente=0;
                for (int i=0;i<fen.getJeu().getJoueur2().getMainJoueur().size();i++){
                    if (fen.getJeu().getJoueur2().getMainJoueur().get(i).getColor().equals("jaune")){
                        vente++;
                    }
                }
                fen.getJeu().getJoueur2().setPieces(fen.getJeu().getJoueur2().getPieces()+2+vente);

            }
            if (error.equals("no error")) {
                fen.getJeu().getDeckModel().cardTab[pos[0]][pos[1]] = null;

                conteneurPlateauCarte.setInvisible(pos[2]);
                conteneurPlateauCarte.getjDialog().dispose();
            }
        }else {
            conteneurPlateauCarte.getjDialog().dispose();
            int prix[]=new int[]{0,0,0,0};
            if (fen.getJeu().getJ1joue()){
                for (int k=0;k<4;k++){
                    for (int i=0;i<5;i++){
                        prix[k] += (fen.getJeu().getJoueur1().getMerveilleJoueur().get(k).getPrix_resource()[i] - fen.getJeu().getJoueur1().getRessource()[i]) * (fen.getJeu().getJoueur1().getPrixRessource()[i]);
                    }
                }
            }else {
                for (int k=0;k<4;k++){
                    for (int i=0;i<5;i++){
                        prix[k] += (fen.getJeu().getJoueur2().getMerveilleJoueur().get(k).getPrix_resource()[i] - fen.getJeu().getJoueur1().getRessource()[i]) * (fen.getJeu().getJoueur2().getPrixRessource()[i]);
                    }
                }
            }
            error="nope";
            conteneurPlateauCarte.showBuyMerveillePopup(this,pos,prix);
        }
        if (error.equals("no error")) {
            conteneurPlateauCarte.updateAllCarte();
            conteneurPlateauCarte.getTabCarte()[pos[2]].removeMouseListener(this);
            fen.getJeu().setJ1joue(!fen.getJeu().getJ1joue());
            fen.getResumerJoueur1().updateResumer();
            fen.getResumerJoueur2().updateResumer();
        }
        boolean age1Ended=true;
        for (int i=0;i<2;i++){
            System.out.println(fen.getJeu().getDeckModel().cardTab[0][i]!=null);
            if (fen.getJeu().getDeckModel().cardTab[0][i]!=null) age1Ended=false;
        }

        if (age1Ended){
            fen.getJeu().setAge(2);
            fen.setVisible(false);
            fen.setConteneurPlateauCarte(new ConteneurPlateauCarte(fen));
            fen.setVisible(true);
        }
    }
}
