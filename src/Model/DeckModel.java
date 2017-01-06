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
    public CardGameModel[][] cardTab;

    public DeckModel(){
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
            add(new CardGameModel(0,0,0 ,new int[]{0,0,0,0,1},new int[]{0,0,0,0,0},1,"verrerie","grise"));
            add(new CardGameModel(0,0,0 ,new int[]{0,0,0,1,0},new int[]{0,0,0,0,0},1 ,"presse","grise"));
            //prix à 1=-1, ex: bois à -1, prix à 1
            add(new CardGameModel(0,0,0 ,new int[]{0,-1,0,0,0},new int[]{0,0,0,0,0},3 ,"depot_de_pierre","jaune"));//A voir
            add(new CardGameModel(0,0,0 ,new int[]{-1,0,0,0,0},new int[]{0,0,0,0,0},3 ,"depot_argile","jaune"));
            add(new CardGameModel(0,0,0 ,new int[]{0,0,-1,0,0},new int[]{0,0,0,0,0},3 ,"depot_de_bois","jaune"));
            add(new CardGameModel(3,0,0,6 ,new int[]{0,0,0,0,0},0 ,"théâtre","bleu"));
            add(new CardGameModel(3,0,0,7 ,new int[]{0,0,0,0,0},0 ,"autel","bleu"));
            add(new CardGameModel(3,0,0,8 ,new int[]{0,1,0,0,0},0 ,"bains","bleu"));
            add(new CardGameModel(0,0,4 ,new int[]{0,0,0,0,0},0 ,"taverne","jaune"));
            add(new CardScientifiqueModel(0,0,0,5 ,new int[]{0,0,0,0,0},2 ,"officine",4));
        }};
        deckAge2=new ArrayList<CardGameModel>(){{
            add(new CardGameModel(0,0,0,0,new int[]{0,0,0,0,0},0 ,"haras","rouge"));
            add(new CardGameModel(0,0,0,new int[]{0,0,0,0,0},0 ,"baraquement","rouge"));
            add(new CardGameModel(0,0,0,0 ,new int[]{0,0,0,0,0},0 ,"champTir","rouge"));
            add(new CardGameModel(0,0,0 ,new int[]{0,0,0,0,0},0 ,"muraille","rouge"));
            add(new CardGameModel(0,0,0 ,new int[]{0,0,0,0,0},0 ,"placeArmes","rouge"));
            add(new CardGameModel(0,0,0,new int[]{0,0,0,0,0} ,new int[]{0,0,0,0,0},0 ,"scierie","marron"));
            add(new CardGameModel(0,0,0,new int[]{0,0,0,0,0},new int[]{0,0,0,0,0},0  ,"briqueterie","marron"));
            add(new CardGameModel(0,0,0 ,new int[]{0,0,0,0,0},new int[]{0,0,0,0,0},0 ,"carriere","marron"));
            add(new CardScientifiqueModel(0,0,0 ,new int[]{0,0,0,0,0},0,"bibliotheque",0));
            add(new CardScientifiqueModel(0,0,0 ,new int[]{0,0,0,0,0},0 ,"dispensaire",0));
            add(new CardScientifiqueModel(0,0,0,0,new int[]{0,0,0,0,0},0 ,"ecole",0));
            add(new CardScientifiqueModel(0,0,0 ,new int[]{0,0,0,0,0},0,"laboratoire",0));
            add(new CardGameModel(0,0,0 ,new int[]{0,0,0,0,0},new int[]{0,0,0,0,0},0,"soufflerie","grise"));
            add(new CardGameModel(0,0,0 ,new int[]{0,0,0,0,0},new int[]{0,0,0,0,0},0 ,"sechoir","grise"));
            add(new CardGameModel(0,0,0 ,new int[]{0,0,0,0,0},new int[]{0,0,0,0,0},0 ,"forum","jaune"));
            add(new CardGameModel(0,0,0 ,new int[]{0,0,0,0,0},0 ,"caravanserail","jaune"));
            add(new CardGameModel(1,0,0 ,new int[]{0,0,0,0,0},0 ,"douanes","jaune"));
            add(new CardGameModel(1,0,0 ,new int[]{0,0,0,0,0},0 ,"brasserie","jaune"));
            add(new CardGameModel(0,0,0,0 ,new int[]{0,0,0,0,0},0 ,"tribunal","bleu"));
            add(new CardGameModel(0,0,0,0 ,new int[]{0,0,0,0,0},0 ,"statue","bleu"));
            add(new CardGameModel(0,0,0,0 ,new int[]{0,3,0,0,0},0 ,"temple","bleu"));
            add(new CardGameModel(0,0,0,0 ,new int[]{0,0,0,0,0},0 ,"aqueduc","bleu"));
            add(new CardGameModel(0,0,0,0 ,new int[]{0,0,0,0,0},0 ,"rostres ","bleu"));
        }};
        deckAge3=new ArrayList<CardGameModel>(){{
            add(new CardGameModel(0,0,0,0,new int[]{0,0,0,0,0},0 ,"arsenal","rouge"));
            add(new CardGameModel(0,0,0,new int[]{0,0,0,0,0},0 ,"pretoire","rouge"));
            add(new CardGameModel(0,0,0,0 ,new int[]{0,0,0,0,0},0 ,"fortifications","rouge"));
            add(new CardGameModel(0,0,0 ,new int[]{0,0,0,0,0},0 ,"atelierDeSiege","rouge"));
            add(new CardGameModel(0,0,0 ,new int[]{0,0,0,0,0},0 ,"cirque","rouge"));
            add(new CardScientifiqueModel(0,0,0 ,new int[]{0,0,0,0,0},0,"academie",0));
            add(new CardScientifiqueModel(0,0,0 ,new int[]{0,0,0,0,0},0 ,"etude",0));
            add(new CardScientifiqueModel(0,0,0,0,new int[]{0,0,0,0,0},0 ,"universite",0));
            add(new CardScientifiqueModel(0,0,0 ,new int[]{0,0,0,0,0},0,"observatoire",0));
            add(new CardGameModel(0,0,0 ,new int[]{0,0,0,0,0},new int[]{0,0,0,0,0},0 ,"chambredeCommerce","jaune"));
            add(new CardGameModel(0,0,0 ,new int[]{0,0,0,0,0},0 ,"port","jaune"));
            add(new CardGameModel(1,0,0 ,new int[]{0,0,0,0,0},0 ,"armurerie","jaune"));
            add(new CardGameModel(1,0,0 ,new int[]{0,0,0,0,0},0 ,"phare","jaune"));
            add(new CardGameModel(1,0,0 ,new int[]{0,0,0,0,0},0 ,"arene","jaune"));
            add(new CardGameModel(0,0,0,0 ,new int[]{0,0,0,0,0},0 ,"palace","bleu"));
            add(new CardGameModel(0,0,0,0 ,new int[]{0,0,0,0,0},0 ,"hotelDeVille","bleu"));
            add(new CardGameModel(0,0,0,0 ,new int[]{0,3,0,0,0},0 ,"obelisque","bleu"));
            add(new CardGameModel(0,0,0,0 ,new int[]{0,0,0,0,0},0 ,"jardins","bleu"));
            add(new CardGameModel(0,0,0,0 ,new int[]{0,0,0,0,0},0 ,"pantheon ","bleu"));
            add(new CardGameModel(0,0,0,0 ,new int[]{0,0,0,0,0},0 ,"senat ","bleu"));
        }};

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
        }
    }

//Tableau de carte plus éfficace
    public void faireCardTab(Random random){
        tirageAleatoire(random);
        CardGameModel[] cardTabLevel1=new CardGameModel[2];
        CardGameModel[] cardTabLevel2=new CardGameModel[3];
        CardGameModel[] cardTabLevel3=new CardGameModel[4];
        CardGameModel[] cardTabLevel4=new CardGameModel[5];
        CardGameModel[] cardTabLevel5=new CardGameModel[6];
        cardTab=new CardGameModel[][]{cardTabLevel1,cardTabLevel2,cardTabLevel3,cardTabLevel4,cardTabLevel5};

        for (int i=0;i<5;i++) {
            for (int j = 0; j < i + 2; j++) {
                cardTab[i][j]=deckAge1.remove(random.nextInt(deckAge1.size()));
            }
        }
    }

    public void printCardTab(){
        for (int i=0;i<5;i++) {
            for (int j=0;j<5-i;j++){
                System.out.print(" ");
            }
            for (int j = 0; j < i + 2; j++) {
                System.out.print(cardTab[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public ArrayList<CardGameModel> getDeckAge1() {
        return deckAge1;
    }
}
