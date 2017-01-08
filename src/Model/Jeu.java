package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Michael on 15/12/2016.
 */
public class Jeu {
    private Joueur joueur1;
    private Joueur joueur2;
    private DeckMerveilleModel deckMerveilleModel;
    private Boolean J1joue;
    private int age;
    private DeckModel deckModel;
    private Age2Carte age2Carte;
    private Age3Carte age3Carte;
    private ArrayList<Integer> jetonScience;
    private ArrayList<Integer> jetonScienceChoisi;

    public Jeu(Joueur joueur1, Joueur joueur2, Random random) {
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        jetonScience=new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6,7,8,9));
        jetonScienceChoisi=new ArrayList<>();
        for (int i=0;i<5;i++){
            jetonScienceChoisi.add(jetonScience.remove(random.nextInt(jetonScience.size())));
        }
    }

    public Jeu(String text, String text1,Random random) {
        this.joueur1=new Joueur(text);
        this.joueur2=new Joueur(text1);
        jetonScience=new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6,7,8,9));
        jetonScienceChoisi=new ArrayList<>();
        for (int i=0;i<5;i++){
            jetonScienceChoisi.add(jetonScience.remove(random.nextInt(jetonScience.size())));
        }
    }

    public Age2Carte getAge2Carte() {
        return age2Carte;
    }

    public void setAge2Carte(Age2Carte age2Carte) {
        this.age2Carte = age2Carte;
    }

    public Age3Carte getAge3Carte() {
        return age3Carte;
    }

    public void setAge3Carte(Age3Carte age3Carte) {
        this.age3Carte = age3Carte;
    }

    public Boolean getJ1joue() {
        return J1joue;
    }

    public int getAge() {
        return age;
    }

    public DeckModel getDeckModel() {
        return deckModel;
    }

    public void setDeckModel(DeckModel deckModel) {
        this.deckModel = deckModel;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setJ1joue(Boolean j1joue) {
        J1joue = j1joue;
    }

    public Joueur getJoueur1() {
        return joueur1;
    }

    public Joueur getJoueur2() {
        return joueur2;
    }

    public DeckMerveilleModel getDeckMerveilleModel() {
        return deckMerveilleModel;
    }

    public void setDeckMerveilleModel(DeckMerveilleModel deckMerveilleModel) {
        this.deckMerveilleModel = deckMerveilleModel;
    }

}
