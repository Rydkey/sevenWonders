package Model;

/**
 * Created by Michael on 18/11/2016.
 */

public class CardMerveilleModel extends CardModel {
    private int idMerveille;

    public CardMerveilleModel(int idMerveille) {
        this.idMerveille = idMerveille;
    }

    public CardMerveilleModel(int pointAttaque, int pointScore, int idMerveille) {
        super(pointAttaque, pointScore);
        this.idMerveille = idMerveille;
    }
}
