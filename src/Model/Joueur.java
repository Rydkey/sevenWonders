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
    private int tour;
    private DeckModel deckAge1 = new DeckModel();
    private ArrayList<CardGameModel> mainJoueur = new ArrayList<>();

    public Joueur(String text) {
        this.nom=text;
        idMerveille=new int[]{-1,-1,-1,-1};
        pieces=7;
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

    public void defausse(CardModel carte){
        setPieces(pieces+carte.getPieces());
        deckAge1.getDeckAge1().remove(carte);
    }

    public void piocher(CardGameModel carte) {
        mainJoueur.add(carte);
        deckAge1.getDeckAge1().remove(carte);
    }
}
