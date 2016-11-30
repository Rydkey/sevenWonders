package Model;

/**
 * Created by ANTOINE on 21/11/2016.
 */
public class CardScientifiqueModel extends CardGameModel{
    private int idScientifique;


    public CardScientifiqueModel(int pointScore, int pointAttaque, int pieces, int[] prix_resource, int prix_pieces, int idScientifique) {
        super(pointScore, pointAttaque, pieces, prix_resource, prix_pieces,"vert");
        this.idScientifique = idScientifique;
    }

    public CardScientifiqueModel(int pointScore, int pointAttaque, int pieces, int idAvancement, int[] prix_resource, int prix_pieces, int idScientifique) {
        super(pointScore, pointAttaque, pieces, idAvancement, prix_resource, prix_pieces,"vert");
        this.idScientifique = idScientifique;
    }

    public int getIdScientifique() {
        return idScientifique;
    }

    public void setIdScientifique(int idScientifique) {
        this.idScientifique = idScientifique;
    }


}
