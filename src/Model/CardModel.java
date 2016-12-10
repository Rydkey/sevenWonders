package Model;

/**
 * Created by Michael on 14/11/2016.
 */
public class CardModel {
    private int pointScore;
    private int pointAttaque;
    private int pieces;
    private int idAvancement;
    //Bois,pierre, argile,papyrus,verre
    private int[] ressource;
    private int[] prix_resource;
    private int prix_pieces;
    private String nom;
    public CardModel(){}
    public CardModel(int pointScore,int pointAttaque){
        this.pointAttaque=pointAttaque;
        this.pointScore=pointScore;
        this.prix_resource=new int[]{0,0,0,0,0};
    }


    public CardModel(int pointScore,int pointAttaque,int pieces){
        this.pointAttaque=pointAttaque;
        this.pointScore=pointScore;
        this.pieces=pieces;
        this.prix_resource=new int[]{0,0,0,0,0};
    }

    public CardModel(int pointScore, int pointAttaque, int pieces, int prix_pieces) {
        this.pointScore = pointScore;
        this.pointAttaque = pointAttaque;
        this.pieces = pieces;
        this.prix_pieces = prix_pieces;
        this.prix_resource=new int[]{0,0,0,0,0};
    }

    public CardModel(int pointScore, int pointAttaque, int pieces, int[] prix_resource) {
        this.pointScore = pointScore;
        this.pointAttaque = pointAttaque;
        this.pieces = pieces;
        this.prix_resource = prix_resource;
    }

    public CardModel(int pointScore, int pointAttaque, int pieces, int[] prix_resource, int prix_pieces) {
        this.pointScore = pointScore;
        this.pointAttaque = pointAttaque;
        this.pieces = pieces;
        this.prix_resource = prix_resource;
        this.prix_pieces = prix_pieces;
    }

    public CardModel(int pointScore, int pointAttaque, int pieces, int[] ressource, int[] prix_resource, int prix_pieces) {
        this.pointScore = pointScore;
        this.pointAttaque = pointAttaque;
        this.pieces = pieces;
        this.ressource = ressource;
        this.prix_resource = prix_resource;
        this.prix_pieces = prix_pieces;
    }

    public CardModel(int pointScore, int pointAttaque, int pieces, int idAvancement, int[] prix_resource, int prix_pieces) {
        this.pointScore = pointScore;
        this.pointAttaque = pointAttaque;
        this.pieces = pieces;
        this.idAvancement = idAvancement;
        this.prix_resource = prix_resource;
        this.prix_pieces = prix_pieces;
    }



    public CardModel(int pointScore, int pointAttaque, int pieces, int idAvancement, int[] prix_resource, int prix_pieces, String nom) {
        this.pointScore = pointScore;
        this.pointAttaque = pointAttaque;
        this.pieces = pieces;
        this.idAvancement = idAvancement;
        this.prix_pieces = prix_pieces;
        this.nom = nom;
        this.prix_resource = prix_resource;
    }

    public CardModel(int pointScore, int pointAttaque, int pieces, int[] prix_resource, int prix_pieces, String nom) {
        this.pointScore = pointScore;
        this.pointAttaque = pointAttaque;
        this.pieces = pieces;
        this.prix_resource = prix_resource;
        this.prix_pieces = prix_pieces;
        this.nom = nom;
    }

    public CardModel(int pointScore, int pointAttaque, int pieces, int[] ressource, int[] prix_resource, int prix_pieces, String nom) {
        this.pointScore = pointScore;
        this.pointAttaque = pointAttaque;
        this.pieces = pieces;
        this.ressource = ressource;
        this.prix_resource = prix_resource;
        this.prix_pieces = prix_pieces;
        this.nom = nom;
    }

    public int getPieces() {
        return pieces;
    }

    public void setPieces(int pieces) {
        this.pieces = pieces;
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


    public int[] getPrix_resource() {
        if (prix_resource==null){
            return new int[]{0,0,0,0,0};

        }
        return prix_resource;
    }

    public int getPrix_pieces() {
        return prix_pieces;
    }

    public String getNom() {
        return nom;
    }
}
