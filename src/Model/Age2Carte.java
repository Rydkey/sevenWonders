package Model;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by zliao on 01/12/16.
 */
public class Age2Carte {
    private ArrayList<CardGameModel> deckAge2;
    public CardGameModel[][] cardTab;

    public Age2Carte(Random random){
        deckAge2= new ArrayList<CardGameModel>(){
            {
                add(new CardGameModel(0, 1, 0, 1, new int[]{1, 0, 1, 0, 0}, 0, "haras", "rouge"));
                add(new CardGameModel(0, 1, 0, 2, new int[]{0, 0, 0, 0, 0}, 3, "baraquements", "rouge"));
                add(new CardGameModel(0, 2, 0, 10, new int[]{1, 1, 0, 1, 0}, 0,"champ_de_tir", "rouge"));
                add(new CardGameModel(0, 2, 0, 11, new int[]{0, 0, 2, 0, 1}, 0,"place_d'armes", "rouge"));
                add(new CardGameModel(0, 2, 0,  new int[]{0, 2, 0, 0, 0}, 0,"muraille", "rouge"));
                add(new CardGameModel(0, 0, 0,  new int[]{0, 0, 0, 0, 0}, 8,"prétoire", "rouge"));
                add(new CardGameModel(0, 0, 0, new int[]{2, 0, 0, 0, 0},new int[]{0, 0, 0, 0, 0}, 2,"scierie", "marron"));
                add(new CardGameModel(0, 0, 0, new int[]{0, 0, 2, 0, 0}, new int[]{0, 0, 0, 0, 0}, 2,"briqueterie", "marron"));
                add(new CardGameModel(0, 0, 0, new int[]{0, 2, 0, 0, 0}, new int[]{0, 0, 0, 0, 0}, 2,"carrière", "marron"));
                add(new CardScientifiqueModel(2,0,0 ,new int[]{1,1,0,0,1},0, "bibliothèque",3));
                add(new CardScientifiqueModel(2,0,0 ,new int[]{1,0,2,0,0},0, "dispensaire",4));
                add(new CardScientifiqueModel(1,0,0,12 ,new int[]{1,0,2,0,0},0, "école",5));
                add(new CardScientifiqueModel(1,0,0,13 ,new int[]{1,0,2,0,0},0, "laboratoire",6));
                add(new CardGameModel(0,0,0 ,new int[]{0,0,0,0,1},new int[]{0,0,0,0,0},0,"soufflerie","grise"));
                add(new CardGameModel(0,0,0 ,new int[]{0,0,0,1,0},new int[]{0,0,0,0,0},0,"séchoir","grise"));
                add(new CardGameModel(0, 1, 0, new int[]{0, 0, 0, -2, -2}, new int[]{0, 0, 1, 0, 0}, 3, "forum", "jaune"));
                add(new CardGameModel(0, 1, 0,  new int[]{-2, -2, -2, 0, 0}, new int[]{0, 0, 0, 1, 1}, 2, "caravansérail", "jaune"));
                add(new CardGameModel(0, 1, 0, new int[]{0, 0, 0, -1, -1}, new int[]{0, 0, 0, 0, 0}, 4, "douane", "jaune"));
                add(new CardGameModel(0, 0, 6, 17, new int[]{0, 0, 0, 0, 0}, 0, "brasserie", "jaune"));
                add(new CardGameModel(5,0,0,new int[]{2,0,0,0,1},0 ,"tribunal","bleu"));
                add(new CardGameModel(4,0,0,6 ,14,new int[]{0,0,0,0,0},0 ,"statue","bleu"));
                add(new CardGameModel(4,0,0,7 ,15,new int[]{0,0,0,0,0},0 ,"temple","bleu"));
                add(new CardGameModel(5,0,0,8 ,new int[]{0,0,0,0,0},0 ,"aqueduc","bleu"));
                add(new CardGameModel(4,0,0,16 ,new int[]{0,0,0,0,0},0 ,"rostres","bleu"));
            }};
        faireCardTab(random);
    }
    //Ajouter les couts des cartes fait
    public void tirageAleatoire(Random random){
        for(int i=0; i<3;i++){
            deckAge2.remove(random.nextInt(deckAge2.size()));
        }
    }

    //Tableau de carte plus éfficace
    public void faireCardTab(Random random){
        tirageAleatoire(random);
        CardGameModel[] cardTabLevel1=new CardGameModel[6];
        CardGameModel[] cardTabLevel2=new CardGameModel[5];
        CardGameModel[] cardTabLevel3=new CardGameModel[4];
        CardGameModel[] cardTabLevel4=new CardGameModel[3];
        CardGameModel[] cardTabLevel5=new CardGameModel[2];
        cardTab=new CardGameModel[][]{cardTabLevel1,cardTabLevel2,cardTabLevel3,cardTabLevel4,cardTabLevel5};

        for (int i=0;i<5;i++) {
            for (int j = 0; j < 6-i; j++) {
                cardTab[i][j]=deckAge2.remove(random.nextInt(deckAge2.size()));
            }
        }
    }

}
