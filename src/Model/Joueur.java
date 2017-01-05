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
    private int pointScorePiece;
    private int pointAttaque;
    private int[] ressource;
    private boolean[] prixRessourceReduit;
    private int[] prixRessource;
    private ArrayList<Integer> idAvancement;
    private int tour;
    private ArrayList<Integer[]> ressourcePossible;
    private ArrayList<CardMerveilleModel> merveilleJoueur;
    private ArrayList<CardGameModel> mainJoueur;

    public Joueur(String text) {
        this.nom=text;
        mainJoueur = new ArrayList<>();
        merveilleJoueur = new ArrayList<>();
        idAvancement=new ArrayList<>();
        ressource=new int[]{0,0,0,0,0};
        prixRessource=new int[]{2,2,2,2,2};
        prixRessourceReduit =new boolean[]{false,false,false,false,false};
        ressourcePossible=new ArrayList<>();
        pointScorePiece=0;
        pointScore=0;
        setPieces(7);
    }


    public boolean[] getPrixRessourceReduit() {
        return prixRessourceReduit;
    }

    public int[] getRessource() {
        return ressource;
    }

    public void setRessource(int[] ressource) {
        this.ressource = ressource;
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

    public int getPointScorePiece() {
        return pointScorePiece;
    }

    public int getPieces() {
        return pieces;
    }

    public void setPieces(int pieces) {
        this.pieces = pieces;
        System.out.println(this.pieces/3);
        pointScorePiece=(this.pieces/3);
        System.out.println(pointScorePiece);
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

    public ArrayList<CardMerveilleModel> getMerveilleJoueur() {
        return merveilleJoueur;
    }

    public ArrayList<Integer[]> getRessourcePossible() {
        return ressourcePossible;
    }

    public int getRessourcePossible(int i) {
        int somme=0;
        for (int j=0;j<ressourcePossible.size();j++){
            somme+=ressourcePossible.get(j)[i];
        }
        return somme;
    }

    public void setRessourcePossible(ArrayList<Integer[]> ressourcePossible) {
        this.ressourcePossible = ressourcePossible;
    }

    public int[] getPrixRessource() {
        return prixRessource;
    }

    public void setPrixRessource(int[] prixRessource) {
        this.prixRessource = prixRessource;
    }

    public void piocher(CardGameModel carte, int prix) {
        mainJoueur.add(carte);
        if (carte.getPieces()!=0){
            setPieces(getPieces()+carte.getPieces());
        }
        if (carte.getPointScore()!=0) {
            setPointScore(getPointScore() + carte.getPointScore());
        }
        if (prix!=0) {
            setPieces(getPieces() - prix);
        }
        for (int i=0;i<5;i++){
            if (carte.getRessource()!=null) {
                boolean ressourcePoss=false;
                Integer[] resPoss = new Integer[5];
                if (carte.getRessource()[i]==-1){
                    prixRessourceReduit[i]=true;
                }else if (carte.getRessource()[i]==-2){
                    resPoss[i]=1;
                    ressourcePoss=true;
                }else {
                    resPoss[i]=carte.getRessource()[i];
                    ressource[i] += carte.getRessource()[i];
                }
                if (ressourcePoss){
                    ressourcePossible.add(resPoss);
                }
            }
        }
        if (carte.getIdAvancement()!=0){
            idAvancement.add(carte.getIdAvancement());
        }
    }

    public void constructMerveilles(int nb,int prix) {
        CardMerveilleModel carte=merveilleJoueur.remove(nb);
        if (carte.getPieces()!=0){
            setPieces(getPieces()+carte.getPieces());
        }
        if (carte.getPointScore()!=0) {
            setPointScore(getPointScore() + carte.getPointScore());
        }
        if (prix!=0) {
            setPieces(getPieces() - prix);
        }
        for (int i=0;i<5;i++){
            if (carte.getRessource()!=null) {
                if (carte.getRessource()[i]==-1){
                    prixRessourceReduit[i]=true;
                }else {
                    ressource[i] += carte.getRessource()[i];
                }
            }
        }
        if (carte.getIdAvancement()!=0){
            idAvancement.add(carte.getIdAvancement());
        }
    }

    public void augmentePrixRessource(CardGameModel carte){
        if (carte.getRessource()!=null) {
            for (int i=0;i<5;i++){
                System.out.println(carte.getRessource()[i]);
                if (carte.getRessource()[i]==-1){
                    prixRessourceReduit[i]=true;
                    prixRessource[i] = 1;
                }
                if (carte.getRessource()[i]>0){
                    if (prixRessourceReduit[i]) {
                        prixRessource[i] = 1;
                    }else {
                        prixRessource[i] += carte.getRessource()[i];
                    }
                }
            }
        }
    }
}
