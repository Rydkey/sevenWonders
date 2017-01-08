package Model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by ANTOINE on 04/01/2017.
 */
public class JoueurUnitTest {
    private Joueur joueur;

    public void testJoueur() {
        assertNotNull("L'instance n'est pas créée", joueur);
    }

    public void testGetNom() {
        assertEquals("Le nom est incorrect", "nom1", joueur.getNom());

    }

    public void testGetPrixRessource() {
        assertEquals("Le prix n'est pas égal", "prix", joueur.getPrixRessource());

    }

    public void testGetRessource() {
        assertEquals("La ressource est incorrect", "ressource", joueur.getRessource());

    }

    public void testGetIdMerveille() {
        assertEquals("L'id de la merveille est incorrect", "id merveille", joueur.getMerveilleJoueur());

    }

    public void testGetTour() {
        assertEquals("Le tour n'est pas le bon", "tour", joueur.getTour());

    }

    public void testGetPointAttaque() {
        assertEquals("Les points attaques ne sont pas bons", "pointAttaque", joueur.getPointAttaque());

    }

    public void testGetPointScore() {
        assertEquals("Point score incorrect", "pointScore", joueur.getPointScore());
    }

    public void testGetPieces() {
        assertEquals("Les pieces incorrect ", "pieces", joueur.getPieces());

    }

    public void testGetIdJoueur() {
        assertEquals("Id incorrect ", "idJoueur", joueur.getIdJoueur());

    }

    public void testGetIdAvancement() {
        assertEquals("Id incorrect ", "idAvancement", joueur.getIdAvancement());
    }

    public void testGetMainJoueur() {
        assertEquals("Main incorrect ", "mainJoueur", joueur.getMainJoueur());
    }

    /*
        public void testSetRessource(){
            joueur.setRessource(4,5,6);
            assertEquals("Ressource incorrect ", "mainJoueur", joueur.getMainJoueur());
        }
    */
/*    public void testIdMerveille(){
        joueur.setIdMerveille(int[4,5,6]);
        assertEquals("Main incorrect ", "mainJoueur", joueur.getMainJoueur());
}*/
    public void testSetTour() {
        joueur.setTour(4);
        assertEquals("tour incorrect ", "tour", joueur.getTour());
    }

    public void testSetPointAttaque() {
        joueur.setPointAttaque(4);
        assertEquals("point attaque incorrect ", "tour", joueur.getPointAttaque());
    }

    public void testSetIdJoueur() {
        joueur.setIdJoueur(9);
        assertEquals("Id Joueur incorrect ", "idJoueur", joueur.getIdJoueur());
    }

    public void testSetNom() {
        joueur.setNom("kiki");
        assertEquals("nom incorrect ", "nom", joueur.getNom());
    }

    public void testaddIdMerveille(int idMerveillePasTab) {
        assertNotNull(idMerveillePasTab);
        boolean trouver = false;
        int idMerveille[] = new int[]{-1, -1, -1, -1};
        for (int i = 0; i < idMerveille.length && !trouver; i++) {
            if (idMerveille[i] == -1) {
                idMerveille[i] = idMerveillePasTab;
                trouver = true;
                assertTrue(trouver);
            }
        }
    }

    public void testPiocher(CardGameModel carte, int prix) {

        joueur.getMainJoueur().add(carte);
        assertEquals(joueur.getMainJoueur(), carte);
        joueur.setPieces(joueur.getPieces() + carte.getPieces());
        joueur.setPointScore(joueur.getPointScore() + carte.getPointScore());
        joueur.setPieces(joueur.getPieces() - prix);
        for (int i = 0; i < 5; i++) {
            if (carte.getRessource() != null) {
                if (carte.getRessource()[i] == -1) {
                    assertEquals(carte.getRessource()[i], -1);
                }
            }
        }
    }
}