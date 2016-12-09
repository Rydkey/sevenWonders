package Model;

/**
 * Created by Michael on 18/11/2016.
 */
public class CardGameModel extends CardModel {
    private String color;

    public CardGameModel(int pointAttaque, int pointScore, int pieces, int[] prix_ressource){
        super(pointAttaque,pointScore,pieces,prix_ressource);
    }

    public CardGameModel() {
        this.color = color;
    }

    public CardGameModel(int pointScore,int pointAttaque, String color) {
        super(pointScore,pointAttaque);
        this.color = color;
    }
    public CardGameModel( int pointScore,int pointAttaque,int pieces, String color) {
        super(pointScore,pointAttaque);
        this.color = color;
    }

    public CardGameModel(int pointScore, int pointAttaque, int pieces, int[] prix_resource, int prix_pieces, String color) {
        super(pointScore, pointAttaque, pieces, prix_resource, prix_pieces);
        this.color = color;
    }
    public CardGameModel(int pointScore, int pointAttaque, int pieces,int[] ressources, int[] prix_resource, int prix_pieces, String color) {
        super(pointScore, pointAttaque, pieces,ressources, prix_resource, prix_pieces);
        this.color = color;
    }

    public CardGameModel(int pointScore, int pointAttaque, int pieces, int idAvancement, int[] prix_resource, int prix_pieces, String color) {
        super(pointScore, pointAttaque, pieces, idAvancement, prix_resource, prix_pieces);
        this.color = color;
    }

    public CardGameModel(int pointScore, int pointAttaque, int pieces, int[] ressource, int[] prix_resource, int prix_pieces, String nom, String color) {
        super(pointScore, pointAttaque, pieces, ressource, prix_resource, prix_pieces, nom);
        this.color = color;
    }

    public CardGameModel(int pointScore, int pointAttaque, int pieces, int[] prix_resource, int prix_pieces, String nom, String color) {
        super(pointScore, pointAttaque, pieces, prix_resource, prix_pieces, nom);
        this.color = color;
    }

    public CardGameModel(int pointScore, int pointAttaque, int pieces, int idAvancement, int[] prix_resource, int prix_pieces, String nom, String color) {
        super(pointScore, pointAttaque, pieces, idAvancement, prix_resource, prix_pieces, nom);
        this.color = color;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


}
