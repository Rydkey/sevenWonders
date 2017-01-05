package Model;

import static org.junit.Assert.*;

/**
 * Created by ANTOINE on 05/01/2017.
 */
public class JeuUnitTest {
    private Jeu jeu;

    public void testJeu(){
        assertNotNull("L'instance n'est pas créée", jeu);

    }
    public void testgetJ1joue() {
        assertEquals("Ce n'est pas le bon tour", "J1joue", jeu.getJ1joue());
    }

    public void testgetAge() {

        assertEquals("L'age est incorrect", "age", jeu.getAge());
    }

    public void testgetDeckModel() {
        assertEquals("Le deck est incorrect", "deckModel", jeu.getDeckModel());

    }

/*    public void testsetDeckModel(DeckModel deckModel) {


    }*/

    public void testsetAge(int age) {
        jeu.setAge(5);
        assertEquals("age incorrect ", "age", jeu.getAge());

    }

    public void testsetJ1joue(Boolean j1joue) {
        jeu.setJ1joue(false);
        assertFalse(j1joue);


    }

    public void testgetJoueur1() {
        assertEquals("Pas le bon joueur", "joueur1", jeu.getJoueur1());

    }

    public void testgetJoueur2() {
        assertEquals("Pas le bon joueur", "joueur2", jeu.getJoueur2());

    }

    public void testgetDeckMerveilleModel() {
        assertEquals("Pas le bon deck merveille", "deckMerveillemodel", jeu.getDeckMerveilleModel());

    }
/*
    public void testsetDeckMerveilleModel() {

    }*/
}
