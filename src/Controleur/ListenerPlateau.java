package Controleur;

import Model.CardGameModel;
import Vue.ConteneurPlateauCarte;
import Vue.ConteneurResumerJoueur;
import Vue.Fenetre;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;

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

    //trop dur osef
    public int[] getBestPosRess(CardGameModel carte){
        int []totalPosRess=new int[]{0,0,0,0,0};
        int[] bestRessourceUse=new int[]{0,0,0,0,0};
        boolean[] cardUsed=new boolean[fen.getJeu().getJoueur1().getRessourcePossible().size()];
        Integer[] bestCardToUse;
        if (fen.getJeu().getJ1joue()){
            int temp=0;
            for (int j=0;j<fen.getJeu().getJoueur1().getRessourcePossible().size();j++) {
                bestCardToUse = fen.getJeu().getJoueur1().getRessourcePossible().get(j);
                for (int i = 0; i < 5; i++) {
                    if (carte.getPrix_resource()[i]!=0) {

                    }
                }
            }
        }
        return new int[]{0};
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
            System.out.println("marche");
            String erreur="no error";
            if (fen.getJeu().getJ1joue()){
                for (int i=0;i<5;i++){
                    prix += (fen.getJeu().getJoueur1().getMerveilleJoueur().get(nb).getPrix_resource()[i] - fen.getJeu().getJoueur1().getRessource()[i]) * (fen.getJeu().getJoueur1().getPrixRessource()[i]);
                }
                if (prix>fen.getJeu().getJoueur1().getPieces()){
                    erreur="erreur";
                }else {
                    fen.getConteneurPlateauCarte().getjDialog().dispose();
                    fen.getConteneurPlateauCarte().getjDialog().setVisible(false);
                    fen.getJeu().getJoueur1().setPieces(fen.getJeu().getJoueur1().getPieces() - prix);
                    fen.getJeu().getJoueur1().constructMerveilles(nb, prix);
                    switch (fen.getJeu().getJoueur1().getMerveilleJoueur().get(nb).getIdMerveille()) {
                        case 1:
                            fen.getConteneurPlateauCarte().showDestroyCardPopup(this,"grise");
                            break;
                        case 5:
                            break;
                        case 6:
                            fen.getConteneurPlateauCarte().showThrownCard(this);
                            break;
                        case 10:
                            fen.getConteneurPlateauCarte().showDestroyCardPopup(this,"marron");
                            break;
                        case 12:
                            break;
                        case 11:
                        case 9:
                        case 7:
                        case 4:
                            fen.getJeu().setJ1joue(!fen.getJeu().getJ1joue());
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
                    fen.getConteneurPlateauCarte().getjDialog().dispose();
                    fen.getConteneurPlateauCarte().getjDialog().setVisible(false);
                    fen.getJeu().getJoueur2().setPieces(fen.getJeu().getJoueur1().getPieces() - prix);
                    fen.getJeu().getJoueur2().constructMerveilles(nb, prix);
                    switch (fen.getJeu().getJoueur2().getMerveilleJoueur().get(nb).getIdMerveille()) {
                        case 1:
                            fen.getConteneurPlateauCarte().showDestroyCardPopup(this,"grise");
                            break;
                        case 5:
                            break;
                        case 6:
                            fen.getConteneurPlateauCarte().showThrownCard(this);
                            break;
                        case 10:
                            fen.getConteneurPlateauCarte().showDestroyCardPopup(this,"marron");
                            break;
                        case 12:
                            break;
                        case 11:
                        case 9:
                        case 7:
                        case 4:
                            fen.getJeu().setJ1joue(!fen.getJeu().getJ1joue());
                            break;
                        default:
                    }
                }
            }
            System.out.println(erreur);
            if (erreur.equals("no error")){
                int[] pos =(int[])((JPanel)e.getSource()).getClientProperty("pos");
                conteneurPlateauCarte.setInvisible(pos[2]);
                conteneurPlateauCarte.updateAllCarte();
                conteneurPlateauCarte.getTabCarte()[pos[2]].removeMouseListener(this);
                fen.getResumerJoueur1().updateResumer();
                fen.getResumerJoueur2().updateResumer();
                testVictoireScientifique();
                testPionGuerre();
                fen.getJeu().setJ1joue(!fen.getJeu().getJ1joue());
                if (fen.getJeu().getAge()==1){
                    fen.getJeu().getDeckModel().cardTabAge1[pos[0]][pos[1]] = null;
                }else if (fen.getJeu().getAge()==2){
                    fen.getJeu().getDeckModel().cardTabAge2[pos[0]][pos[1]] = null;
                }
            }
        }else {
            int test=0;
            if (((JLabel) e.getSource()).getClientProperty("test")!=null) {
                test = (int) ((JLabel) e.getSource()).getClientProperty("test");
            }
            if (test==1){
                int pos = (int) ((JLabel) e.getSource()).getClientProperty("position");
                if (!fen.getJeu().getJ1joue()){
                    fen.getJeu().getDeckModel().getDeckAge1().add(fen.getJeu().getJoueur1().getMainJoueur().get(pos));
                    fen.getJeu().getJoueur1().defausse(pos);
                    fen.getConteneurPlateauCarte().getjDialog().dispose();
                }else {
                    fen.getJeu().getDeckModel().getDeckAge1().add(fen.getJeu().getJoueur1().getMainJoueur().get(pos));
                    fen.getJeu().getJoueur2().defausse(pos);
                    fen.getConteneurPlateauCarte().getjDialog().dispose();
                }
            }else if (test==2){
                int pos = (int) ((JLabel) e.getSource()).getClientProperty("position");
                if (fen.getJeu().getJ1joue()){
                    fen.getJeu().getJoueur1().piocherGratuit(fen.getJeu().getDeckModel().getDeckAge1().remove(pos));
                }else {
                    fen.getJeu().getJoueur2().piocherGratuit(fen.getJeu().getDeckModel().getDeckAge1().remove(pos));
                }
            }else {
                int[] pos;
                pos = (int[]) ((JLabel) e.getSource()).getClientProperty("pos");
                if (fen.getJeu().getAge()==1){
                    if (pos[0] == 4 || (fen.getJeu().getDeckModel().cardTabAge1[pos[0] + 1][pos[1]]) == null && fen.getJeu().getDeckModel().cardTabAge1[pos[0] + 1][pos[1] + 1] == null) {
                        if (fen.getJeu().getJ1joue()) {
                            int prix = fen.getJeu().getDeckModel().cardTabAge1[pos[0]][pos[1]].getPrix_pieces();
                            for (int i = 0; i < 5; i++) {
                                if (fen.getJeu().getDeckModel().cardTabAge1[pos[0]][pos[1]].getPrix_resource()[i] - fen.getJeu().getJoueur1().getRessource()[i] > 0) {
                                    prix += (fen.getJeu().getDeckModel().cardTabAge1[pos[0]][pos[1]].getPrix_resource()[i] - fen.getJeu().getJoueur1().getRessource()[i]) * (fen.getJeu().getJoueur1().getPrixRessource()[i]);
                                }
                            }
                            if (fen.getJeu().getDeckModel().cardTabAge1[pos[0]][pos[1]].getIdAvancement()!=0) {
                                if (fen.getJeu().getJoueur1().getIdAvancement().contains(fen.getJeu().getDeckModel().cardTabAge1[pos[0]][pos[1]].getIdAvancement())) {
                                    prix = 0;
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
                            int prix = fen.getJeu().getDeckModel().cardTabAge1[pos[0]][pos[1]].getPrix_pieces();
                            for (int i = 0; i < 5; i++) {
                                if (fen.getJeu().getDeckModel().cardTabAge1[pos[0]][pos[1]].getPrix_resource()[i] - fen.getJeu().getJoueur2().getRessource()[i] > 0) {
                                    prix += (fen.getJeu().getDeckModel().cardTabAge1[pos[0]][pos[1]].getPrix_resource()[i] - fen.getJeu().getJoueur2().getRessource()[i]) * (fen.getJeu().getJoueur2().getPrixRessource()[i]);
                                }
                            }
                            if (fen.getJeu().getDeckModel().cardTabAge1[pos[0]][pos[1]].getIdAvancement()!=0) {
                                if (fen.getJeu().getJoueur2().getIdAvancement().contains(fen.getJeu().getDeckModel().cardTabAge1[pos[0]][pos[1]].getIdAvancement())) {
                                    prix = 0;
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
                }else if (fen.getJeu().getAge()==2){
                    if (pos[0] == 4 || ((pos[1]>=fen.getJeu().getDeckModel().cardTabAge2[pos[0]+1].length || fen.getJeu().getDeckModel().cardTabAge2[pos[0] + 1][pos[1]] == null) && (pos[1] == 0 || fen.getJeu().getDeckModel().cardTabAge2[pos[0] + 1][pos[1] - 1] == null))) {
                        if (fen.getJeu().getJ1joue()) {
                            int prix = fen.getJeu().getDeckModel().cardTabAge2[pos[0]][pos[1]].getPrix_pieces();
                            for (int i = 0; i < 5; i++) {
                                if (fen.getJeu().getDeckModel().cardTabAge2[pos[0]][pos[1]].getPrix_resource()[i] - fen.getJeu().getJoueur2().getRessource()[i] > 0) {
                                    prix += (fen.getJeu().getDeckModel().cardTabAge2[pos[0]][pos[1]].getPrix_resource()[i] - fen.getJeu().getJoueur1().getRessource()[i]) * (fen.getJeu().getJoueur1().getPrixRessource()[i]);
                                }
                            }
                            if (fen.getJeu().getDeckModel().cardTabAge2[pos[0]][pos[1]].getIdAvancement()!=0) {
                                if (fen.getJeu().getJoueur1().getIdAvancement().contains(fen.getJeu().getDeckModel().cardTabAge2[pos[0]][pos[1]].getIdAvancement())) {
                                    prix=0;
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
                            int prix = fen.getJeu().getDeckModel().cardTabAge2[pos[0]][pos[1]].getPrix_pieces();
                            for (int i = 0; i < 5; i++) {
                                if (fen.getJeu().getDeckModel().cardTabAge2[pos[0]][pos[1]].getPrix_resource()[i] - fen.getJeu().getJoueur2().getRessource()[i] > 0) {
                                    prix += (fen.getJeu().getDeckModel().cardTabAge2[pos[0]][pos[1]].getPrix_resource()[i] - fen.getJeu().getJoueur2().getRessource()[i]) * (fen.getJeu().getJoueur2().getPrixRessource()[i]);
                                }
                            }

                            if (fen.getJeu().getDeckModel().cardTabAge2[pos[0]][pos[1]].getIdAvancement()!=0) {
                                if (fen.getJeu().getJoueur1().getIdAvancement().contains(fen.getJeu().getDeckModel().cardTabAge2[pos[0]][pos[1]].getIdAvancement())) {
                                    prix=0;
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
        }
    }

    private void testPionGuerre() {
        if (fen.getJeu().getJoueur1().getPointAttaque()-fen.getJeu().getJoueur2().getPointAttaque()>=1) {
            if (fen.getJeu().getJoueur1().getPointAttaque()-fen.getJeu().getJoueur2().getPointAttaque()>3){
                if (fen.getJeu().getJoueur1().getPointAttaque()-fen.getJeu().getJoueur2().getPointAttaque()>6){
                    if (!fen.getJeu().getJoueur2().isDeuxiemeAttaque()){
                        fen.getJeu().getJoueur2().setDeuxiemeAttaque(true);
                        fen.getJeu().getJoueur1().setScoreBataille(10);
                        fen.getJeu().getJoueur2().setPieces(fen.getJeu().getJoueur2().getPieces()-5);
                    }
                }else {
                    fen.getJeu().getJoueur1().setScoreBataille(5);
                    if (!fen.getJeu().getJoueur2().isPremiereAttaque()){
                        fen.getJeu().getJoueur2().setPremiereAttaque(true);
                        fen.getJeu().getJoueur2().setPieces(fen.getJeu().getJoueur2().getPieces()-2);
                    }
                }

            }else{
                fen.getJeu().getJoueur1().setScoreBataille(2);
            }

        }
        if (fen.getJeu().getJoueur2().getPointAttaque()-fen.getJeu().getJoueur1().getPointAttaque()>=1) {
            if (fen.getJeu().getJoueur2().getPointAttaque() - fen.getJeu().getJoueur1().getPointAttaque() > 3) {
                if (fen.getJeu().getJoueur2().getPointAttaque() - fen.getJeu().getJoueur1().getPointAttaque() > 6) {
                    if (!fen.getJeu().getJoueur1().isDeuxiemeAttaque()) {
                        fen.getJeu().getJoueur1().setDeuxiemeAttaque(true);
                        fen.getJeu().getJoueur2().setScoreBataille(10);
                        fen.getJeu().getJoueur1().setPieces(fen.getJeu().getJoueur2().getPieces() - 5);
                    }
                    fen.getJeu().getJoueur2().setScoreBataille(10);
                } else {
                    fen.getJeu().getJoueur2().setScoreBataille(5);
                }
                if (!fen.getJeu().getJoueur1().isPremiereAttaque()) {
                    fen.getJeu().getJoueur1().setPremiereAttaque(true);
                    fen.getJeu().getJoueur1().setPieces(fen.getJeu().getJoueur2().getPieces() - 2);
                }
            } else {
                fen.getJeu().getJoueur2().setScoreBataille(2);
            }
        }
        if (fen.getJeu().getJoueur2().getPointAttaque()-fen.getJeu().getJoueur1().getPointAttaque()==0){
            fen.getJeu().getJoueur1().setScoreBataille(0);
            fen.getJeu().getJoueur2().setScoreBataille(0);
        }
        if (fen.getJeu().getJoueur1().getPointAttaque()-fen.getJeu().getJoueur2().getPointAttaque()==9) {
            fen.afficheVictoire(1,1);
        }
        if (fen.getJeu().getJoueur2().getPointAttaque()-fen.getJeu().getJoueur1().getPointAttaque()==9) {
            fen.afficheVictoire(2,1);
        }
    }

    public void testVictoireScientifique(){
        HashSet<Integer> setJ1=new HashSet<>(fen.getJeu().getJoueur1().getIdScience());
        HashSet<Integer> setJ2=new HashSet<>(fen.getJeu().getJoueur2().getIdScience());
        if (setJ1.containsAll(Arrays.asList(1,2,3,4,5,6))){
            fen.afficheVictoire(1,2);
        }
        if (setJ1.containsAll(Arrays.asList(1,2,3,4,5,6))){
            fen.afficheVictoire(2,2);
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
            if (fen.getJeu().getAge()==1){
                if (fen.getJeu().getJ1joue()){

                    int prix=fen.getJeu().getDeckModel().cardTabAge1[pos[0]][pos[1]].getPrix_pieces();
                    for (int i=0;i<5;i++){
                            if (fen.getJeu().getDeckModel().cardTabAge1[pos[0]][pos[1]].getPrix_resource()[i] - fen.getJeu().getJoueur1().getRessource()[i] > 0) {
                                prix += (fen.getJeu().getDeckModel().cardTabAge1[pos[0]][pos[1]].getPrix_resource()[i] - fen.getJeu().getJoueur1().getRessource()[i]) * (fen.getJeu().getJoueur1().getPrixRessource()[i]);
                            }
                    }
                    if (fen.getJeu().getDeckModel().cardTabAge1[pos[0]][pos[1]].getIdAvancement()!=0) {
                        if (fen.getJeu().getJoueur1().getIdAvancement().contains(fen.getJeu().getDeckModel().cardTabAge1[pos[0]][pos[1]].getIdAvancement())) {
                        prix=0;
                        }
                    }
                        System.out.println("achat\n\n");
                    if (prix<=fen.getJeu().getJoueur1().getPieces()){
                        fen.getJeu().getJoueur1().piocher(fen.getJeu().getDeckModel().cardTabAge1[pos[0]][pos[1]],prix);
                        fen.getJeu().getJoueur2().augmentePrixRessource(fen.getJeu().getDeckModel().cardTabAge1[pos[0]][pos[1]]);
                        fen.getJeu().getDeckModel().cardTabAge1[pos[0]][pos[1]]=null;
                    }else {
                        error="Not enough money";
                    }
                }else {
                    int prix = fen.getJeu().getDeckModel().cardTabAge1[pos[0]][pos[1]].getPrix_pieces();
                    for (int i = 0; i < 5; i++) {
                        if (fen.getJeu().getDeckModel().cardTabAge1[pos[0]][pos[1]].getPrix_resource()[i] - fen.getJeu().getJoueur2().getRessource()[i] > 0) {
                            prix += (fen.getJeu().getDeckModel().cardTabAge1[pos[0]][pos[1]].getPrix_resource()[i] - fen.getJeu().getJoueur2().getRessource()[i]) * (fen.getJeu().getJoueur2().getPrixRessource()[i]);
                        }
                    }
                    if (fen.getJeu().getDeckModel().cardTabAge1[pos[0]][pos[1]].getIdAvancement()!=0) {
                        if (fen.getJeu().getJoueur2().getIdAvancement().contains(fen.getJeu().getDeckModel().cardTabAge1[pos[0]][pos[1]].getIdAvancement())) {
                            prix = 0;
                        }
                    }
                    if (prix<=fen.getJeu().getJoueur2().getPieces()) {
                        fen.getJeu().getJoueur2().piocher(fen.getJeu().getDeckModel().cardTabAge1[pos[0]][pos[1]], prix);
                        fen.getJeu().getJoueur1().augmentePrixRessource(fen.getJeu().getDeckModel().cardTabAge1[pos[0]][pos[1]]);
                        fen.getJeu().getDeckModel().cardTabAge1[pos[0]][pos[1]] = null;
                    }else {
                        error="Not enough money";
                    }
                }
            }else if (fen.getJeu().getAge()==2){
                if (fen.getJeu().getJ1joue()){
                    int prix=fen.getJeu().getDeckModel().cardTabAge2[pos[0]][pos[1]].getPrix_pieces();
                    for (int i=0;i<5;i++){
                            if (fen.getJeu().getDeckModel().cardTabAge2[pos[0]][pos[1]].getPrix_resource()[i] - fen.getJeu().getJoueur1().getRessource()[i] > 0) {
                                prix += (fen.getJeu().getDeckModel().cardTabAge2[pos[0]][pos[1]].getPrix_resource()[i] - fen.getJeu().getJoueur1().getRessource()[i]) * (fen.getJeu().getJoueur1().getPrixRessource()[i]);
                            }
                    }
                    if (fen.getJeu().getDeckModel().cardTabAge2[pos[0]][pos[1]].getIdAvancement()!=0) {
                        if (fen.getJeu().getJoueur1().getIdAvancement().contains(fen.getJeu().getDeckModel().cardTabAge2[pos[0]][pos[1]].getIdAvancement())) {
                            prix = 0;
                        }
                    }
                    if (prix<=fen.getJeu().getJoueur1().getPieces()){
                        fen.getJeu().getJoueur1().piocher(fen.getJeu().getDeckModel().cardTabAge2[pos[0]][pos[1]],prix);
                        fen.getJeu().getJoueur2().augmentePrixRessource(fen.getJeu().getDeckModel().cardTabAge2[pos[0]][pos[1]]);
                        fen.getJeu().getDeckModel().cardTabAge2[pos[0]][pos[1]]=null;
                    }else {
                        error="Not enough money";
                    }
                }else {
                    int prix=fen.getJeu().getDeckModel().cardTabAge2[pos[0]][pos[1]].getPrix_pieces();
                    for (int i=0;i<5;i++){
                        if (fen.getJeu().getDeckModel().cardTabAge2[pos[0]][pos[1]].getPrix_resource()[i] - fen.getJeu().getJoueur2().getRessource()[i] > 0) {
                            prix += (fen.getJeu().getDeckModel().cardTabAge2[pos[0]][pos[1]].getPrix_resource()[i] - fen.getJeu().getJoueur2().getRessource()[i]) * (fen.getJeu().getJoueur2().getPrixRessource()[i]);
                        }
                    }
                    if (fen.getJeu().getDeckModel().cardTabAge2[pos[0]][pos[1]].getIdAvancement()!=0) {
                        if (fen.getJeu().getJoueur2().getIdAvancement().contains(fen.getJeu().getDeckModel().cardTabAge2[pos[0]][pos[1]].getIdAvancement())) {
                            prix = 0;
                        }
                    }

                    if (prix<=fen.getJeu().getJoueur2().getPieces()) {
                        fen.getJeu().getJoueur2().piocher(fen.getJeu().getDeckModel().cardTabAge2[pos[0]][pos[1]], prix);
                        fen.getJeu().getJoueur1().augmentePrixRessource(fen.getJeu().getDeckModel().cardTabAge2[pos[0]][pos[1]]);
                        fen.getJeu().getDeckModel().cardTabAge2[pos[0]][pos[1]] = null;
                    }else {
                        error="Not enough money";
                    }
                }
            }
            if (error.equals("no error")) {
                conteneurPlateauCarte.setInvisible(pos[2]);
                conteneurPlateauCarte.getjDialog().dispose();
            }
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
                if (fen.getJeu().getAge()==1){

                    fen.getJeu().getDeckModel().getDeckAge1().add(fen.getJeu().getDeckModel().cardTabAge1[pos[0]][pos[1]]);
                    fen.getJeu().getDeckModel().cardTabAge1[pos[0]][pos[1]] = null;

                    conteneurPlateauCarte.setInvisible(pos[2]);
                    conteneurPlateauCarte.getjDialog().dispose();
                }else if (fen.getJeu().getAge()==2){
                    fen.getJeu().getDeckModel().getDeckAge1().add(fen.getJeu().getDeckModel().cardTabAge2[pos[0]][pos[1]]);

                    fen.getJeu().getDeckModel().cardTabAge2[pos[0]][pos[1]] = null;

                    conteneurPlateauCarte.setInvisible(pos[2]);
                    conteneurPlateauCarte.getjDialog().dispose();
                }
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
            error="not yet";
            pos =(int[])((JButton)e.getSource()).getClientProperty("pos");
            conteneurPlateauCarte.showBuyMerveillePopup(this,pos,prix);
        }
        if (error.equals("no error")) {
            conteneurPlateauCarte.updateAllCarte();
            conteneurPlateauCarte.getTabCarte()[pos[2]].removeMouseListener(this);
            testPionGuerre();
            testVictoireScientifique();
            fen.getConteneurPionGuerre().updatePion();
            fen.getJeu().setJ1joue(!fen.getJeu().getJ1joue());
            fen.getResumerJoueur1().updateResumer();
            fen.getResumerJoueur2().updateResumer();
        }
        boolean age1Ended=true;
        if (fen.getJeu().getAge()==1) {
            for (int i = 0; i < 2; i++) {
                if (fen.getJeu().getDeckModel().cardTabAge1[0][i] != null) age1Ended = false;
            }
        }else{
            age1Ended=false;
        }
        boolean age2Ended=true;
        if (fen.getJeu().getAge()==2) {
            for (int i = 0; i < 6; i++) {
                if (fen.getJeu().getDeckModel().cardTabAge2[0][i] != null) age2Ended = false;
            }
        }else {
            age2Ended=false;
        }

        boolean age3Ended=true;
        if (fen.getJeu().getAge()==3) {
            for (int i = 0; i < 2; i++) {
                if (fen.getJeu().getDeckModel().cardTabAge3[0][i] != null) age3Ended = false;
            }
        }else {
            age3Ended=false;
        }
        if (age1Ended && fen.getJeu().getAge()==1){
            fen.getJeu().setAge(2);
            fen.setVisible(false);
            fen.setConteneurPlateauCarte(new ConteneurPlateauCarte(fen));
            fen.getConteneurPlateauCarte().setControleur(this);
            this.conteneurPlateauCarte=fen.getConteneurPlateauCarte();
            fen.getContentPane().removeAll();
            JPanel global = new JPanel();
            JPanel joueurs = new JPanel();
            global.setLayout(new BoxLayout(global,BoxLayout.Y_AXIS));
            global.setBackground(Color.orange);
            joueurs.setLayout(new BorderLayout());
            joueurs.setOpaque(false);
            joueurs.add(fen.getResumerJoueur1(),BorderLayout.LINE_START);
            joueurs.add(fen.getResumerJoueur2(),BorderLayout.LINE_END);
            global.add(joueurs);
            global.add(fen.getConteneurPionGuerre());
            global.add(fen.getConteneurPlateauCarte());
            fen.setContentPane(global);
            fen.pack();
            fen.setVisible(true);
        }
        if (age2Ended && fen.getJeu().getAge()==2){
            fen.getJeu().setAge(3);
            fen.setVisible(false);
            fen.setConteneurPlateauCarte(new ConteneurPlateauCarte(fen));
            fen.getContentPane().removeAll();
            fen.getConteneurPlateauCarte().setControleur(this);
            this.conteneurPlateauCarte=fen.getConteneurPlateauCarte();
            JPanel global = new JPanel();
            JPanel joueurs = new JPanel();
            global.setLayout(new BoxLayout(global,BoxLayout.Y_AXIS));
            global.setBackground(Color.orange);
            joueurs.setLayout(new BorderLayout());
            joueurs.setOpaque(false);
            joueurs.add(fen.getResumerJoueur1(),BorderLayout.LINE_START);
            joueurs.add(fen.getResumerJoueur2(),BorderLayout.LINE_END);
            global.add(joueurs);
            global.add(fen.getConteneurPionGuerre());
            global.add(fen.getConteneurPlateauCarte());
            fen.setContentPane(global);
            fen.pack();
            fen.setVisible(true);
        }
        if (age3Ended && fen.getJeu().getAge()==3) {
            if (fen.getJeu().getJoueur1().getScore() > fen.getJeu().getJoueur2().getScore()) {
                fen.afficheVictoire(1, 3);
            } else if (fen.getJeu().getJoueur2().getScore() > fen.getJeu().getJoueur1().getScore()) {
                fen.afficheVictoire(2, 3);

            } else {
                int pointJ1 = 0, pointJ2 = 0;
                for (CardGameModel card :
                        fen.getJeu().getJoueur1().getMainJoueur()) {
                    if (card.getColor().equals("bleu")) {
                        pointJ1 += card.getPointScore();
                    }
                }
                for (CardGameModel card :
                        fen.getJeu().getJoueur2().getMainJoueur()) {
                    if (card.getColor().equals("bleu")) {
                        pointJ2 += card.getPointScore();
                    }
                }
                if (pointJ1 > pointJ2) {
                    fen.afficheVictoire(1, 3);
                } else if (pointJ2 > pointJ1) {
                    fen.afficheVictoire(2, 3);

                } else {
                    fen.afficheVictoire(3, 1);
                }
            }
        }
    }
}
