package Model;

/**
 * Created by Michael on 18/11/2016.
 */

public class CardMerveilleModel extends CardGameModel {
    private int idMerveille;
    private String nom;

    public CardMerveilleModel(int idMerveille, String nom) {
        super();
        this.idMerveille = idMerveille;
        this.nom = nom;
    }

    public CardMerveilleModel(int pointAttaque, int pointScore, int pieces, int[] prix_ressource, int idMerveille, String nom) {
        super(pointAttaque, pointScore, pieces, prix_ressource);
        this.idMerveille = idMerveille;
        this.nom = nom;
    }
}
