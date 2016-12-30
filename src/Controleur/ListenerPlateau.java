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
        }else {
            int[] pos;
            pos = (int[]) ((JLabel) e.getSource()).getClientProperty("pos");
            if (pos[0] == 4 || (fen.getJeu().getDeckModel().cardTab[pos[0] + 1][pos[1]]) == null && fen.getJeu().getDeckModel().cardTab[pos[0] + 1][pos[1] + 1] == null) {
                if (fen.getJeu().getJ1joue()) {
                    int prix = fen.getJeu().getDeckModel().cardTab[pos[0]][pos[1]].getPrix_pieces();
                    for (int i = 0; i < 5; i++) {
                        if (fen.getJeu().getDeckModel().cardTab[pos[0]][pos[1]].getPrix_resource()[i] - fen.getJeu().getJoueur1().getRessource()[i] > 0) {
                            if (fen.getJeu().getJoueur1().getPrixRessource()[i]) {
                                prix += fen.getJeu().getDeckModel().cardTab[pos[0]][pos[1]].getPrix_resource()[i] - fen.getJeu().getJoueur1().getRessource()[i];
                            } else {
                                prix += (fen.getJeu().getDeckModel().cardTab[pos[0]][pos[1]].getPrix_resource()[i] - fen.getJeu().getJoueur1().getRessource()[i]) * (fen.getJeu().getJoueur2().getRessource()[i] + 2);
                            }
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
                            System.out.println(fen.getJeu().getJoueur2().getPrixRessource()[i]);
                            if (fen.getJeu().getJoueur2().getPrixRessource()[i]) {
                                prix += fen.getJeu().getDeckModel().cardTab[pos[0]][pos[1]].getPrix_resource()[i] - fen.getJeu().getJoueur2().getRessource()[i];
                            } else {
                                prix += (fen.getJeu().getDeckModel().cardTab[pos[0]][pos[1]].getPrix_resource()[i] - fen.getJeu().getJoueur2().getRessource()[i]) * (fen.getJeu().getJoueur1().getRessource()[i] + 2);
                            }
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
                        if (fen.getJeu().getJoueur1().getPrixRessource()[i]){
                            prix+=fen.getJeu().getDeckModel().cardTab[pos[0]][pos[1]].getPrix_resource()[i] - fen.getJeu().getJoueur1().getRessource()[i];
                        }else {
                            prix += (fen.getJeu().getDeckModel().cardTab[pos[0]][pos[1]].getPrix_resource()[i] - fen.getJeu().getJoueur1().getRessource()[i]) * (fen.getJeu().getJoueur2().getRessource()[i] + 2);
                        }
                    }
                }
                if (prix<fen.getJeu().getJoueur1().getPieces()){
                    fen.getJeu().getJoueur1().piocher(fen.getJeu().getDeckModel().cardTab[pos[0]][pos[1]],prix);
                    fen.getJeu().getDeckModel().cardTab[pos[0]][pos[1]]=null;
                }else {
                    error="Not enough money";
                }
            }else {

                int prix=fen.getJeu().getDeckModel().cardTab[pos[0]][pos[1]].getPrix_pieces();
                for (int i=0;i<5;i++){
                    System.out.println(fen.getJeu().getJoueur2().getPrixRessource()[i]);
                    if (fen.getJeu().getJoueur2().getPrixRessource()[i]){
                        prix+=fen.getJeu().getDeckModel().cardTab[pos[0]][pos[1]].getPrix_resource()[i] - fen.getJeu().getJoueur2().getRessource()[i];
                    }else {
                        prix += (fen.getJeu().getDeckModel().cardTab[pos[0]][pos[1]].getPrix_resource()[i] - fen.getJeu().getJoueur2().getRessource()[i]) * (fen.getJeu().getJoueur1().getRessource()[i] + 2);
                    }
                }
                System.out.println("prix"+prix);
                System.out.println(fen.getJeu().getJoueur1().getPieces());
                if (prix<fen.getJeu().getJoueur2().getPieces()) {
                    fen.getJeu().getJoueur2().piocher(fen.getJeu().getDeckModel().cardTab[pos[0]][pos[1]], prix);
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
                        if (fen.getJeu().getJoueur1().getPrixRessource()[i]){
                            prix[k]+=fen.getJeu().getDeckMerveilleModel().getDeckMerveille().get(fen.getJeu().getJoueur1().getIdMerveille()[k]-1).getPrix_resource()[i] - fen.getJeu().getJoueur1().getRessource()[i];
                        }else {
                            prix[k] += (fen.getJeu().getDeckMerveilleModel().getDeckMerveille().get(fen.getJeu().getJoueur1().getIdMerveille()[k]-1).getPrix_resource()[i] - fen.getJeu().getJoueur1().getRessource()[i]) * (fen.getJeu().getJoueur2().getRessource()[i] + 2);
                        }
                    }
                }
            }else {
                for (int k=0;k<4;k++){
                    for (int i=0;i<5;i++){
                        if (fen.getJeu().getJoueur1().getPrixRessource()[i]){
                            prix[k]+=fen.getJeu().getDeckMerveilleModel().getDeckMerveille().get(fen.getJeu().getJoueur2().getIdMerveille()[k]-1).getPrix_resource()[i] - fen.getJeu().getJoueur1().getRessource()[i];
                        }else {
                            prix[k] += (fen.getJeu().getDeckMerveilleModel().getDeckMerveille().get(fen.getJeu().getJoueur2().getIdMerveille()[k]-1).getPrix_resource()[i] - fen.getJeu().getJoueur1().getRessource()[i]) * (fen.getJeu().getJoueur2().getRessource()[i] + 2);
                        }
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
            if (fen.getJeu().getDeckModel().cardTab[0][i]!=null) age1Ended=false;
        }
        if (age1Ended){
            fen.getJeu().setAge(2);
            fen.setConteneurPlateauCarte(new ConteneurPlateauCarte(fen));
        }
    }

}
