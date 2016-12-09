package Model;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by ANTOINE on 25/11/2016.
 */
public class DeckModel {
    //Carte Age 1
    ArrayList<CardGameModel> deckAge1= new ArrayList<CardGameModel>(){{
    add(new CardGameModel(0,1,0,1,new int[]{1,0,0,0,0},0 ,"écurie","rouge"));
    add(new CardGameModel(0,1,0,new int[]{0,0,0,0,0},2 ,"palissade","rouge"));
    add(new CardGameModel(0,1,0,2 ,new int[]{0,0,1,0,0},0 ,"caserne","rouge"));
    add(new CardGameModel(0,1,0 ,new int[]{0,0,0,0,0},0 ,"tour","rouge"));
    add(new CardGameModel(0,0,0,new int[]{1,0,0,0,0} ,new int[]{0,0,0,0,0},0 ,"chantier","marron"));
    add(new CardGameModel(0,0,0,new int[]{1,0,0,0,0},new int[]{0,0,0,0,0},1 ,"exploitation" ,"marron"));
    add(new CardGameModel(1,0,0 ,new int[]{0,0,1,0,0},new int[]{0,0,0,0,0},0 ,"bassin","marron"));
    add(new CardGameModel(1,0,0 ,new int[]{0,0,1,0,0},new int[]{0,0,0,0,0},1 ,"cavite","marron"));
    add(new CardGameModel(1,0,0,new int[]{0,1,0,0,0} ,new int[]{0,0,0,0,0},1 ,"gisement","marron"));
    add(new CardGameModel(1,0,0,new int[]{0,1,0,0,0} ,new int[]{0,0,0,0,0},1 ,"mine","marron"));
    add(new CardScientifiqueModel(1,0,0 ,new int[]{0,0,0,0,0},0, "apothicaire",1));
    add(new CardScientifiqueModel(1,0,0 ,new int[]{0,0,0,0,0},0,"atelier",2));
    add(new CardScientifiqueModel(0,0,0,3,new int[]{0,0,0,0,0},2,"scriptorium",3));
    add(new CardGameModel(0,0,0 ,new int[]{0,0,0,0,1},new int[]{0,0,0,0,0},1,"verrerie","grise"));
    add(new CardGameModel(0,0,0 ,new int[]{0,0,0,1,0},new int[]{0,0,0,0,0},1 ,"presse","grise"));
    //prix à 1=-1, ex: bois à -1, prix à 1
    add(new CardGameModel(1,0,0 ,new int[]{0,-1,0,0,0},new int[]{0,0,0,0,0},0 ,"depotpierre","jaune"));//A voir
    add(new CardGameModel(1,0,0 ,new int[]{-1,0,0,0,0},0 ,"depotargile","jaune"));
    add(new CardGameModel(1,0,0 ,new int[]{0,0,-1,0,0},0 ,"depotbois","jaune"));
    add(new CardGameModel(3,0,0,4 ,new int[]{0,0,0,0,0},0 ,"theatre","bleu"));
    add(new CardGameModel(3,0,0,5 ,new int[]{0,0,0,0,0},0 ,"autel","bleu"));
    add(new CardGameModel(3,0,0,6 ,new int[]{0,3,0,0,0},0 ,"bain","bleu"));
    add(new CardGameModel(0,0,4 ,new int[]{0,0,0,0,0},0 ,"taverne","jaune"));
    add(new CardScientifiqueModel(0,0,0 ,new int[]{0,0,0,0,0},0 ,"officine",4));

    //Cartes Merveilles
    add(new CardMerveilleModel(1,3,0,new int[]{1,2,0,0,1},1,"circusMaximus"));
    add(new CardMerveilleModel(2,3,0,new int[]{0,0,3,0,1},2,"colosse"));
    add(new CardMerveilleModel(0,4,0,new int[]{1,1,0,2,0},3,"grandphare"));
    add(new CardMerveilleModel(0,3,6,new int[]{2,0,0,1,1},4,"jardinsSuspendus"));
    add(new CardMerveilleModel(0,4,0,new int[]{3,0,0,1,1},5,"grandeBibliotheque"));
    add(new CardMerveilleModel(0,2,0,new int[]{0,0,2,1,2},6,"mausolee"));
    add(new CardMerveilleModel(0,2,0,new int[]{2,1,2,0,0},7,"piree"));
    add(new CardMerveilleModel(0,9,0,new int[]{0,3,0,0,1},8,"pyramides"));
    add(new CardMerveilleModel(0,6,0,new int[]{0,1,1,0,2},9,"sphynx"));
    add(new CardMerveilleModel(1,3,0,new int[]{1,1,1,2,0},10,"statueZeus"));
    add(new CardMerveilleModel(0,0,12,new int[]{1,1,0,1,1},11,"templeArtemis"));
    add(new CardMerveilleModel(0,3,3,new int[]{0,2,2,1,0},12,"viaAppia"));
    }};

    //Ajouter les couts des cartes fait
    public void tirageAleatoire(Random random){

        for(int i=0; i<3;i++){
            deckAge1.remove(random.nextInt(deckAge1.size()));
        }
    }

    public ArrayList<CardGameModel> getDeckAge1() {
        return this.deckAge1;
    }
}
