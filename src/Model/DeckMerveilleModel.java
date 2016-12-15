package Model;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by ANTOINE on 09/12/2016.
 */
public class DeckMerveilleModel {

   private ArrayList<CardMerveilleModel> deckMerveille;

    ArrayList<CardMerveilleModel> choixCarte;
    private ArrayList<CardMerveilleModel> chosenCard;
    public DeckMerveilleModel(){
        chosenCard=new ArrayList<>();
        deckMerveille = new ArrayList<>();
        choixCarte=new ArrayList<>();
        deckMerveille.add(new CardMerveilleModel(1,3,0,new int[]{1,2,0,0,1},1,"circus Maximus"));
        deckMerveille.add(new CardMerveilleModel(2,3,0,new int[]{0,0,3,0,1},2,"colosse"));
        deckMerveille.add(new CardMerveilleModel(0,4,0,new int[]{1,1,0,2,0},3,"grand phare"));
        deckMerveille.add(new CardMerveilleModel(0,3,6,new int[]{2,0,0,1,1},4,"jardins Suspendus"));
        deckMerveille.add(new CardMerveilleModel(0,4,0,new int[]{3,0,0,1,1},5,"grande Bibliotheque"));
        deckMerveille.add(new CardMerveilleModel(0,2,0,new int[]{0,0,2,1,2},6,"mausolee"));
        deckMerveille.add(new CardMerveilleModel(0,2,0,new int[]{2,1,2,0,0},7,"piree"));
        deckMerveille.add(new CardMerveilleModel(0,9,0,new int[]{0,3,0,0,1},8,"pyramides"));
        deckMerveille.add(new CardMerveilleModel(0,6,0,new int[]{0,1,1,0,2},9,"sphynx"));
        deckMerveille.add(new CardMerveilleModel(1,3,0,new int[]{1,1,1,2,0},10,"statue Zeus"));
        deckMerveille.add(new CardMerveilleModel(0,0,12,new int[]{1,1,0,1,1},11,"temple d'Artemis"));
        deckMerveille.add(new CardMerveilleModel(0,3,3,new int[]{0,2,2,1,0},12,"via Appia"));
    }
    public void choixCarte(Random random){
        for (int i=0;i<4;i++){
            int randomInt = random.nextInt(deckMerveille.size());
            while (chosenCard.contains(deckMerveille.get(randomInt))){
                randomInt = random.nextInt(deckMerveille.size());
            }
            choixCarte.add(deckMerveille.get(randomInt));
            chosenCard.add(deckMerveille.get(randomInt));
        }
    }

    public ArrayList<CardMerveilleModel> getDeckMerveille() {
        return deckMerveille;
    }

    public ArrayList<CardMerveilleModel> getChoixCarte() {
        return choixCarte;
    }
}