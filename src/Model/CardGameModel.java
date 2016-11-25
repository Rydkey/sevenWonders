package Model;

/**
 * Created by Michael on 18/11/2016.
 */
public class CardGameModel extends CardModel {

    private String color;

    public CardGameModel(){}

    public CardGameModel(String color) {
        this.color = color;
    }

    public CardGameModel(int pointAttaque, int pointScore, String color) {
        super(pointAttaque, pointScore);
        this.color = color;
    }
    public CardGameModel(int pointAttaque, int pointScore,int pieces, String color) {
        super(pointAttaque, pointScore);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


}
