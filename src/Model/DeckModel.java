package Model;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by ANTOINE on 25/11/2016.
 */
public class DeckModel {
    //Carte Age 1
    ArrayList<CardGameModel> deckAge1;
    ArrayList<CardGameModel> deckAge2;
    ArrayList<CardGameModel> deckAge3;
    ArrayList<CardGuildModel> deckGuilde;
    public CardGameModel[][] cardTabAge1;
    public CardGameModel[][] cardTabAge2;
    public CardGameModel[][] cardTabAge3;

    public DeckModel(Random random){
        deckAge1= new ArrayList<CardGameModel>(){{
            add(new CardGameModel(0,1,0,1,new int[]{1,0,0,0,0},0 ,"écuries","rouge"));
            add(new CardGameModel(0,1,0,2,new int[]{0,0,0,0,0},2 ,"palissade","rouge"));
            add(new CardGameModel(0,1,0,3 ,new int[]{0,0,1,0,0},0 ,"caserne","rouge"));
            add(new CardGameModel(0,1,0 ,new int[]{0,0,0,0,0},0 ,"tour_de_garde","rouge"));
            add(new CardGameModel(0,0,0,new int[]{1,0,0,0,0} ,new int[]{0,0,0,0,0},0 ,"chantier","marron"));
            add(new CardGameModel(0,0,0,new int[]{1,0,0,0,0},new int[]{0,0,0,0,0},1 ,"exploitation" ,"marron"));
            add(new CardGameModel(0,0,0 ,new int[]{0,0,1,0,0},new int[]{0,0,0,0,0},0 ,"bassin_argileux","marron"));
            add(new CardGameModel(0,0,0 ,new int[]{0,0,1,0,0},new int[]{0,0,0,0,0},1 ,"cavité","marron"));
            add(new CardGameModel(0,0,0,new int[]{0,1,0,0,0} ,new int[]{0,0,0,0,0},0 ,"gisement","marron"));
            add(new CardGameModel(0,0,0,new int[]{0,1,0,0,0} ,new int[]{0,0,0,0,0},1 ,"mine","marron"));
            add(new CardScientifiqueModel(1,0,0 ,new int[]{0,0,0,0,1},0, "apothicaire",1));
            add(new CardScientifiqueModel(1,0,0 ,new int[]{0,0,0,1,0},0,"atelier",2));
            add(new CardScientifiqueModel(0,0,0,4,new int[]{0,0,0,0,0},2,"scriptorium",3));
            add(new CardScientifiqueModel(0,0,0,5 ,new int[]{0,0,0,0,0},2 ,"officine",4));
            add(new CardGameModel(0,0,0 ,new int[]{0,0,0,0,1},new int[]{0,0,0,0,0},1,"verrerie","grise"));
            add(new CardGameModel(0,0,0 ,new int[]{0,0,0,1,0},new int[]{0,0,0,0,0},1 ,"presse","grise"));
            //prix à 1=-1, ex: bois à -1, prix à 1
            add(new CardGameModel(0,0,0 ,new int[]{0,-1,0,0,0},new int[]{0,0,0,0,0},3 ,"depot_de_pierre","jaune"));//A voir
            add(new CardGameModel(0,0,0 ,new int[]{0,0,-1,0,0},new int[]{0,0,0,0,0},3 ,"depot_argile","jaune"));
            add(new CardGameModel(0,0,0 ,new int[]{-1,0,0,0,0},new int[]{0,0,0,0,0},3 ,"depot_de_bois","jaune"));
            add(new CardGameModel(3,0,0,6 ,new int[]{0,0,0,0,0},0 ,"théâtre","bleu"));
            add(new CardGameModel(3,0,0,7 ,new int[]{0,0,0,0,0},0 ,"autel","bleu"));
            add(new CardGameModel(3,0,0,8 ,new int[]{0,1,0,0,0},0 ,"bains","bleu"));
            add(new CardGameModel(0,0,4 ,9,new int[]{0,0,0,0,0},0 ,"taverne","jaune"));
        }};
        faireCardTabAge1(random);
        deckAge2= new ArrayList<CardGameModel>(){
            {
                add(new CardGameModel(0, 1, 0, 1, new int[]{1, 0, 1, 0, 0}, 0, "haras", "rouge"));
                add(new CardGameModel(0, 1, 0, 2, new int[]{0, 0, 0, 0, 0}, 3, "baraquements", "rouge"));
                add(new CardGameModel(0, 2, 0, 10, new int[]{1, 1, 0, 1, 0}, 0,"champ_de_tir", "rouge"));
                add(new CardGameModel(0, 2, 0, 11, new int[]{0, 0, 2, 0, 1}, 0,"place_d'armes", "rouge"));
                add(new CardGameModel(0, 2, 0,  new int[]{0, 2, 0, 0, 0}, 0,"muraille", "rouge"));
                add(new CardGameModel(0, 0, 0, new int[]{2, 0, 0, 0, 0},new int[]{0, 0, 0, 0, 0}, 2,"scierie", "marron"));
                add(new CardGameModel(0, 0, 0, new int[]{0, 0, 2, 0, 0}, new int[]{0, 0, 0, 0, 0}, 2,"briqueterie", "marron"));
                add(new CardGameModel(0, 0, 0, new int[]{0, 2, 0, 0, 0}, new int[]{0, 0, 0, 0, 0}, 2,"carrière", "marron"));
                add(new CardScientifiqueModel(2,0,0 ,new int[]{1,1,0,0,1},0, "bibliothèque",3));
                add(new CardScientifiqueModel(2,0,0 ,new int[]{1,0,2,0,0},0, "dispensaire",4));
                add(new CardScientifiqueModel(1,0,0,12 ,new int[]{1,0,0,2,0},0, "école",1));
                add(new CardScientifiqueModel(1,0,0,13 ,new int[]{1,0,0,0,2},0, "laboratoire",2));
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
        faireCardTabAge2(random);

        deckGuilde=new ArrayList<CardGuildModel>(){{
            add(new CardGuildModel(0,0,0,new int[]{1,0,1,1,1},0,"guilde_des_commerçants","violet",0));
            add(new CardGuildModel(0,0,0,new int[]{0,1,1,1,1},0,"guilde_des_armateurs","violet",1));
            add(new CardGuildModel(0,0,0,new int[]{1,2,1,0,1},0,"guilde_des_bâtisseurs","violet",2));
            add(new CardGuildModel(0,0,0,new int[]{2,0,1,1,0},0,"guilde_des_magistrats","violet",3));
            add(new CardGuildModel(0,0,0,new int[]{2,0,2,0,0},0,"guilde_des_scientifiques","violet",4));
            add(new CardGuildModel(0,0,0,new int[]{2,2,0,0,0},0,"guilde_des_usuriers","violet",5));
            add(new CardGuildModel(0,0,0,new int[]{0,2,1,1,0},0,"guilde_des_tacticiens","violet",6));
        }};

        deckAge3= new ArrayList<CardGameModel>(){
            {
                add(new CardGameModel(0, 3, 0,  new int[]{3, 0, 3, 0, 0}, 0, "arsenal", "rouge"));
                add(new CardGameModel(0, 3, 0, new int[]{0, 0, 0, 0, 0}, 8, "prétoire", "rouge"));
                add(new CardGameModel(0, 2, 0, 2, new int[]{0, 2, 1, 1, 0}, 0,"fortifications", "rouge"));
                add(new CardGameModel(0, 2, 0, 10, new int[]{3, 0, 0, 0, 1}, 0,"atelier_de_siège", "rouge"));
                add(new CardGameModel(0, 2, 0, 11, new int[]{0, 2, 2, 0, 0}, 0,"cirque", "rouge"));
                add(new CardGameModel(3, 0, 0,  new int[]{0, 0, 0, 2, 0}, 0,"chambre_de_commerce", "jaune"));
                add(new CardGameModel(3, 0, 0, new int[]{1, 0, 0, 1, 1}, 0,"port", "jaune"));
                add(new CardGameModel(3, 0, 0, new int[]{0, 2, 0, 1, 0}, 0,"armurerie", "jaune"));
                add(new CardGameModel(7, 0, 0, new int[]{0, 2, 0, 0, 0}, 2,"palace", "bleu"));
                add(new CardScientifiqueModel(3,0,0 ,new int[]{1,1,0,0,2},0, "académie",5));
                add(new CardScientifiqueModel(3,0,0 ,new int[]{2,0,0,1,1},0, "étude",5));
                add(new CardScientifiqueModel(2,0,0,12 ,new int[]{0,0,1,1,1},0, "université",6));
                add(new CardScientifiqueModel(2,0,0,13 ,new int[]{0,1,0,2,0},0, "observatoire",6));
                add(new CardGameModel(7,0,0,new int[]{2,3,0,0,0},0 ,"hôtel_de_ville","bleu"));
                add(new CardGameModel(5,0,0,new int[]{0,2,0,1,0},0 ,"obélisque","bleu"));
                add(new CardGameModel(6,0,0,14 ,new int[]{2,0,2,0,0},0 ,"jardins","bleu"));
                add(new CardGameModel(6,0,0,15 ,new int[]{1,0,1,0,2},0 ,"panthéon","bleu"));
                add(new CardGameModel(5,0,0,16 ,new int[]{0,1,2,0,1},0 ,"sénat","bleu"));
                add(new CardGameModel(3, 0, 0, 9, new int[]{0, 0, 2, 0,1}, 0,"phare", "jaune"));
                add(new CardGameModel(3, 0, 0, 17, new int[]{1, 1, 1, 2, 0}, 0,"arène", "jaune"));
            }};
        faireCardTabAge3(random);
    }

    //Ajouter les couts des cartes fait
    public void tirageAleatoire(Random random){
        for(int i=0; i<3;i++){
            deckAge1.remove(random.nextInt(deckAge1.size()));
        }
    }
    public void tirageAleatoireAge2(Random random){
        for(int i=0; i<3;i++){
            deckAge2.remove(random.nextInt(deckAge2.size()));
        }
    }
    public void tirageAleatoireAge3(Random random){
        for(int i=0; i<3;i++){
            deckAge3.remove(random.nextInt(deckAge3.size()));
            deckAge3.add(deckGuilde.remove(random.nextInt(deckGuilde.size())));
        }
    }

//Tableau de carte plus éfficace
    public void faireCardTabAge1(Random random){
        tirageAleatoire(random);
        CardGameModel[] cardTabLevel1=new CardGameModel[2];
        CardGameModel[] cardTabLevel2=new CardGameModel[3];
        CardGameModel[] cardTabLevel3=new CardGameModel[4];
        CardGameModel[] cardTabLevel4=new CardGameModel[5];
        CardGameModel[] cardTabLevel5=new CardGameModel[6];
        cardTabAge1 =new CardGameModel[][]{cardTabLevel1,cardTabLevel2,cardTabLevel3,cardTabLevel4,cardTabLevel5};

        for (int i=0;i<5;i++) {
            for (int j = 0; j < i + 2; j++) {
                cardTabAge1[i][j]=deckAge1.remove(random.nextInt(deckAge1.size()));
            }
        }
    }

    public void faireCardTabAge2(Random random){
        tirageAleatoireAge2(random);
        CardGameModel[] cardTabLevel1=new CardGameModel[6];
        CardGameModel[] cardTabLevel2=new CardGameModel[5];
        CardGameModel[] cardTabLevel3=new CardGameModel[4];
        CardGameModel[] cardTabLevel4=new CardGameModel[3];
        CardGameModel[] cardTabLevel5=new CardGameModel[2];
        cardTabAge2=new CardGameModel[][]{cardTabLevel1,cardTabLevel2,cardTabLevel3,cardTabLevel4,cardTabLevel5};

        for (int i=0;i<5;i++) {
            for (int j = 0; j < 6-i; j++) {
                cardTabAge2[i][j]=deckAge2.remove(random.nextInt(deckAge2.size()));
            }
        }
    }
    public void faireCardTabAge3(Random random){
        tirageAleatoireAge3(random);
        CardGameModel[] cardTabLevel1=new CardGameModel[2];
        CardGameModel[] cardTabLevel2=new CardGameModel[3];
        CardGameModel[] cardTabLevel3=new CardGameModel[4];
        CardGameModel[] cardTabLevel4=new CardGameModel[2];
        CardGameModel[] cardTabLevel5=new CardGameModel[4];
        CardGameModel[] cardTabLevel6=new CardGameModel[3];
        CardGameModel[] cardTabLevel7=new CardGameModel[2];
        cardTabAge3=new CardGameModel[][]{cardTabLevel1,cardTabLevel2,cardTabLevel3,cardTabLevel4,cardTabLevel5,cardTabLevel6,cardTabLevel7};
        for (int i=0;i<3;i++){
            for (int j=0;j<i+2;j++){
                cardTabAge3[i][j]=deckAge3.remove(random.nextInt(deckAge3.size()));
            }
        }
        cardTabAge3[3][0]=deckAge3.remove(random.nextInt(deckAge3.size()));
        cardTabAge3[3][1]=deckAge3.remove(random.nextInt(deckAge3.size()));
        for (int i=0;i<3;i++){
            for (int j=0;j<4-i;j++){
                cardTabAge3[i+4][j]=deckAge3.remove(random.nextInt(deckAge3.size()));
            }
        }
    }

    public void printCardTabAge1(){
        for (int i=0;i<5;i++) {
            for (int j=0;j<5-i;j++){
                System.out.print(" ");
            }
            for (int j = 0; j < i + 2; j++) {
                System.out.print(cardTabAge1[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public ArrayList<CardGameModel> getDeckAge1() {
        return deckAge1;
    }

    public ArrayList<CardGameModel> getDeckAge2() {
        return deckAge2;
    }
}
