package Model;

/**
 * Created by ANTOINE on 25/11/2016.
 */
public class DeckModel {
    //Carte Age 1
    CardGameModel ecurie = new CardGameModel(0,1,0,1,new int[]{1,0,0,0,0},0 ,"rouge");
    CardGameModel palissade = new CardGameModel(0,1,0,new int[]{0,0,0,0,0},2 ,"rouge");
    CardGameModel caserne = new CardGameModel(0,1,0,2 ,new int[]{0,0,1,0,0},0 ,"rouge");
    CardGameModel tour = new CardGameModel(0,1,0 ,new int[]{0,0,0,0,0},0 ,"rouge");
    CardGameModel chantier = new CardGameModel(0,0,0,new int[]{1,0,0,0,0} ,new int[]{0,0,0,0,0},0 ,"marron");
    CardGameModel exploitation = new CardGameModel(0,0,0,new int[]{1,0,0,0,0},new int[]{0,0,0,0,0},1  ,"marron");
    CardGameModel bassin = new CardGameModel(1,0,0 ,new int[]{0,0,1,0,0},new int[]{0,0,0,0,0},0 ,"marron");
    CardGameModel cavite = new CardGameModel(1,0,0 ,new int[]{0,0,1,0,0},new int[]{0,0,0,0,0},1 ,"marron");
    CardGameModel gisement = new CardGameModel(1,0,0,new int[]{0,1,0,0,0} ,new int[]{0,0,0,0,0},01 ,"marron");
    CardGameModel mine = new CardGameModel(1,0,0,new int[]{0,1,0,0,0} ,new int[]{0,0,0,0,0},1 ,"marron");
    CardScientifiqueModel apothicaire = new CardScientifiqueModel(1,0,0 ,new int[]{0,0,0,0,0},0 ,1);
    CardScientifiqueModel atelier = new CardScientifiqueModel(1,0,0 ,new int[]{0,0,0,0,0},0 ,2);
    CardScientifiqueModel scriptorium = new CardScientifiqueModel(0,0,0,3,new int[]{0,0,0,0,0},2 ,3); //A voir
    CardGameModel verrerie = new CardGameModel(0,0,0 ,new int[]{0,0,0,0,1},new int[]{0,0,0,0,0},1,"grise");
    CardGameModel presse = new CardGameModel(0,0,0 ,new int[]{0,0,0,1,0},new int[]{0,0,0,0,0},1 ,"grise");
    //prix à 1=-1, ex: bois à -1, prix à 1
    CardGameModel depotpierre = new CardGameModel(1,0,0 ,new int[]{0,-1,0,0,0},new int[]{0,0,0,0,0},0 ,"jaune");//A voir
    CardGameModel depotargile = new CardGameModel(1,0,0 ,new int[]{-1,0,0,0,0},0 ,"jaune");//A voir
    CardGameModel depotbois = new CardGameModel(1,0,0 ,new int[]{0,0,-1,0,0},0 ,"jaune");//A voir
    CardGameModel theatre = new CardGameModel(3,0,0,4 ,new int[]{0,0,0,0,0},0 ,"bleu");
    CardGameModel autel = new CardGameModel(3,0,0,5 ,new int[]{0,0,0,0,0},0 ,"bleu");
    CardGameModel bain = new CardGameModel(3,0,0,6 ,new int[]{0,3,0,0,0},0 ,"bleu");
    CardGameModel taverne = new CardGameModel(0,0,4 ,new int[]{0,0,0,0,0},0 ,"jaune");
    CardScientifiqueModel officine = new CardScientifiqueModel(0,0,0 ,new int[]{0,0,0,0,0},0 ,4);// A voir

    //Ajouter les couts des cartes fait

}
