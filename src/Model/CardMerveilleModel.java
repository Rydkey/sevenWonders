package Model;

/**
 * Created by Michael on 18/11/2016.
 */

public class CardMerveilleModel extends CardModel {
    private int idMerveille;

    public CardMerveilleModel(int idMerveille) {
        this.idMerveille = idMerveille;
    }

    public CardMerveilleModel(int pointAttaque, int pointScore, int pieces, int[] prix_ressource, int idMerveille) {
        super(pointAttaque, pointScore, pieces, prix_ressource);
        this.idMerveille = idMerveille;
    }
}
