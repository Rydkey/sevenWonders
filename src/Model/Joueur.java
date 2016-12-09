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
    private DeckModel deckAge1 = new DeckModel();

    public int[] getIdMerveille() {
        return idMerveille;
    }

    public void setIdMerveille(int[] idMerveille) {
        this.idMerveille = idMerveille;
    }

    public int getTour() {
        return tour;
    }

    public void setTour(int tour) {
        this.tour = tour;
    }

    private int[] idMerveille;
    private int tour;

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

    public void defausse(CardModel carte) {
        setPieces(pieces+carte.getPieces());
        deckAge1.getDeckAge1().remove(carte);
    }


}
