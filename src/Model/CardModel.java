package Model;

/**
 * Created by Michael on 14/11/2016.
 */
public class CardModel {
    private int pointScore;
    private int pointAttaque;
    //baptiste autiste

    public CardModel(){}
    public CardModel(int pointAttaque,int pointScore){
        this.pointAttaque=pointAttaque;
        this.pointScore=pointScore;
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
}
