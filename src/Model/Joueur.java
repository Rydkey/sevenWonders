package Model;

import java.util.ArrayList;

/**
 * Created by ANTOINE on 08/12/2016.
 */
public class Joueur {
    private String nom;
    private int idJoueur;
    private int pieces;
    private int pointScore;
    private int pointAttaque;
    private int[] idMerveille;
    private int[] ressource;
    private boolean[] prixRessource;
    private ArrayList<Integer> idAvancement;
    private int tour;
    private ArrayList<CardGameModel> mainJoueur = new ArrayList<>();

    public Joueur(String text) {
        this.nom=text;
        idAvancement=new ArrayList<>();
        ressource=new int[]{0,0,0,0,0};
        prixRessource=new boolean[]{false,false,false,false,false};
        idMerveille=new int[]{-1,-1,-1,-1};
        pieces=7;
    }


    public boolean[] getPrixRessource() {
        return prixRessource;
    }

    public int[] getRessource() {
        return ressource;
    }

    public void setRessource(int[] ressource) {
        this.ressource = ressource;
    }

    public int[] getIdMerveille() {
        return idMerveille;
    }

    public void setIdMerveille(int[] idMerveille) {
        this.idMerveille = idMerveille;
    }

    public void addIdMerveille(int idMerveillePasTab) {
        boolean trouver=false;
        for (int i=0;i<idMerveille.length && !trouver;i++){
            if (idMerveille[i]==-1){
                idMerveille[i]=idMerveillePasTab;
                trouver=true;
            }
        }
    }

    public int getTour() {
        return tour;
    }

    public void setTour(int tour) {
        this.tour = tour;
    }

    public int getPointAttaque() {
        return pointAttaque;
    }

    public void setPointAttaque(int pointAttaque) {
        this.pointAttaque = pointAttaque;
    }

    public int getPointScore() {
        return pointScore;
    }

    public void setPointScore(int pointScore) {
        this.pointScore = pointScore;
    }

    public int getPieces() {
        return pieces;
    }

    public void setPieces(int pieces) {
        this.pieces = pieces;
    }

    public int getIdJoueur() {
        return idJoueur;
    }

    public void setIdJoueur(int idJoueur) {
        this.idJoueur = idJoueur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<Integer> getIdAvancement() {
        return idAvancement;
    }

    public ArrayList<CardGameModel> getMainJoueur() {
        return mainJoueur;
    }

    public void defausse(CardModel carte){
        setPieces(pieces+carte.getPieces());
    }

    public void piocher(CardGameModel carte,int prix) {
        mainJoueur.add(carte);
        setPieces(getPieces()+carte.getPieces());
        setPointScore(getPointScore()+carte.getPointScore());
        setPieces(getPieces()-prix);
        for (int i=0;i<5;i++){
            if (carte.getRessource()!=null) {
                if (carte.getRessource()[i]==-1){

                }
                ressource[i] += carte.getRessource()[i];
            }
        }
        if (carte.getIdAvancement()!=0){
            idAvancement.add(carte.getIdAvancement());
        }
    }
}
