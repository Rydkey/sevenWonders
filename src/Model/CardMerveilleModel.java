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

    @Override
    public String toString() {
        String string = "<html>"+this.nom+":<br>";
        string+="Prix : ";
        if (getPrix_pieces()!=0 || !getPrix_resource().equals(new int[]{0,0,0,0,0})){
            if (getPrix_pieces()!=0){
                string+=" pieces : "+getPrix_pieces()+" ";
            }
            if (!getPrix_resource().equals(new int[]{0,0,0,0,0})){
                //Bois,pierre, argile,papyrus,verre
                string+=" ressources : ";
                if (getPrix_resource()[0]!=0){
                    string+="bois :"+getPrix_resource()[0]+" ";
                }
                if (getPrix_resource()[1]!=0){
                    string+="pierre :"+getPrix_resource()[1]+" ";
                }
                if (getPrix_resource()[2]!=0){
                    string+="argile :"+getPrix_resource()[2]+" ";
                }
                if (getPrix_resource()[3]!=0){
                    string+="papyrus :"+getPrix_resource()[3]+" ";
                }
                if (getPrix_resource()[4]!=0){
                    string+="verre :"+getPrix_resource()[4]+" ";
                }
            }
            string+="<br>";
        }
        if (getPointAttaque()!=0){
            string+="Attaque : "+getPointAttaque()+"<br>";
        }
        if (getPieces()!=0){
            string+="Pieces : "+getPieces()+"<br>";
        }
        //ajouter effet de l'id

        string+="</html>";
        return string;
    }

    public int getIdMerveille() {
        return idMerveille;
    }

}
