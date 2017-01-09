package Model;

/**
 * Created by Michael on 09/01/2017.
 */
public class CardGuildModel extends CardGameModel {
    int idGuild;

    public CardGuildModel(int pointScore, int pointAttaque, int pieces, int[] prix_resource, int prix_pieces, String nom, String color, int idGuild) {
        super(pointScore, pointAttaque, pieces, prix_resource, prix_pieces, nom, color);
        this.idGuild = idGuild;
    }
}
