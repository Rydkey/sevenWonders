package Controleur; /**
 * Created by zliao on 08/12/16.
 */
import Model.CardMerveilleModel;
import Model.DeckMerveilleModel;
import Model.Jeu;
import Vue.*;


import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class ListenerInscription implements ActionListener{
    private Fenetre fenetre;
    private ConteneurInscription conteneur;

    public ListenerInscription(Fenetre fen, ConteneurInscription ci){
        fenetre = fen;
        conteneur = ci;

    }


    public void actionPerformed(ActionEvent e){
        fenetre.finInscriptionJoueurs(conteneur);
        fenetre.setVisible(false);
        fenetre.remove(fenetre.getContentPane());
        fenetre.setJeu(new Jeu(conteneur.getJoueur1().getText(),conteneur.getJoueur2().getText(),new Random()));
        fenetre.getJeu().setDeckMerveilleModel(new DeckMerveilleModel());
        fenetre.getJeu().getDeckMerveilleModel().choixCarte(new Random());
        fenetre.getJeu().setJ1joue(new Random().nextBoolean());
        ConteneurChoixMerveille conteneurChoixMerveille =new ConteneurChoixMerveille(fenetre);
        ListenerChoixMerveille listenerChoixMerveille = new ListenerChoixMerveille(conteneurChoixMerveille,fenetre);
        fenetre.setContentPane(conteneurChoixMerveille);
        fenetre.pack();
        fenetre.setVisible(true);
    }

}
