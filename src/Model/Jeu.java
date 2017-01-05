package Model;

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

    public Jeu(Joueur joueur1, Joueur joueur2) {
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
    }

    public Jeu(String text, String text1) {
        this.joueur1=new Joueur(text);
        this.joueur2=new Joueur(text1);
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
