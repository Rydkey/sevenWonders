package Controleur; /**
 * Created by zliao on 08/12/16.
 */
import Model.CardMerveilleModel;
import Model.DeckMerveilleModel;
import Vue.*;


import javax.swing.*;
import java.awt.event.*;

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
        ConteneurChoixMerveille conteneurChoixMerveille =new ConteneurChoixMerveille(new DeckMerveilleModel());
        ListenerChoixMerveille listenerChoixMerveille = new ListenerChoixMerveille(conteneurChoixMerveille);
        fenetre.setContentPane(conteneurChoixMerveille);
        fenetre.pack();
        fenetre.setVisible(true);
    }

}
