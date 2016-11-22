package Model;

/**
 * Created by ANTOINE on 21/11/2016.
 */
public class PointScientifiqueModel {
    private int nbPointScientifique;
    private String typePointScientifique[]={"a","b","c","d","e","f","g"};//7 type de point scientifique
    public int getNbPointScientifique() {
        return nbPointScientifique;
    }

    public void setNbPointScientifique(int nbPointScientifique) {
        this.nbPointScientifique = nbPointScientifique;
    }
    public void VictoirePointScientifique(){
        if(nbPointScientifique==6){
            //Il faut prendre en compte aussi que les 6 types de symboles soient différents
            //Victoire du joueur
        }
    }

}
