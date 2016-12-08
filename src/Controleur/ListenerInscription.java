package Controleur; /**
 * Created by zliao on 08/12/16.
 */
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
    }

}
