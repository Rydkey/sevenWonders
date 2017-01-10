package Vue; /**
 * Created by zliao on 08/12/16.
 */

import Model.Jeu;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Fenetre extends JFrame {
    Jeu jeu;
    ConteneurResumerJoueur resumerJoueur1;
    ConteneurResumerJoueur resumerJoueur2;
    ConteneurPlateauCarte conteneurPlateauCarte;
    ConteneurPionGuerre conteneurPionGuerre;

    public Fenetre(String nomFenetre){
        NewFont.chargeParchment();
        setTitle(nomFenetre);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Image backgroundImage=null;
        try {
            backgroundImage=(ImageIO.read(new File("src/ressources/Background/7WondersDuel_Fond.png")));
        }catch (Exception e){
            e.printStackTrace();
        }
        ConteneurInscription conteneur =new ConteneurInscription(this);

//        setContentPane(conteneur);
        setContentPane(new JLabel(new ImageIcon(backgroundImage)));
        setLayout(new BorderLayout());
        add(conteneur,BorderLayout.PAGE_END);
        setResizable(false);

        pack();
        setVisible(true);

    }

    public ConteneurPionGuerre getConteneurPionGuerre() {
        return conteneurPionGuerre;
    }

    public void setConteneurPionGuerre(ConteneurPionGuerre conteneurPionGuerre) {
        this.conteneurPionGuerre = conteneurPionGuerre;
    }

    public ConteneurPlateauCarte getConteneurPlateauCarte() {
        return conteneurPlateauCarte;
    }

    public void setConteneurPlateauCarte(ConteneurPlateauCarte conteneurPlateauCarte) {
        this.conteneurPlateauCarte = conteneurPlateauCarte;
    }

    public ConteneurResumerJoueur getResumerJoueur1() {
        return resumerJoueur1;
    }

    public void setResumerJoueur1(ConteneurResumerJoueur resumerJoueur1) {
        this.resumerJoueur1 = resumerJoueur1;
    }

    public ConteneurResumerJoueur getResumerJoueur2() {
        return resumerJoueur2;
    }

    public void setResumerJoueur2(ConteneurResumerJoueur resumerJoueur2) {
        this.resumerJoueur2 = resumerJoueur2;
    }

    public void finInscriptionJoueurs(ConteneurInscription conteneur){
        String pseudoJoueur1 = conteneur.getJoueur1().getText();
        String pseudoJoueur2 = conteneur.getJoueur2().getText();
        //Inserer ici instructions pour creer des objets Joueur à partir de ça

        JPanel grille = new JPanel();
        JLabel boucheTrou = new JLabel("");
        grille.add(boucheTrou);

        setContentPane(grille);
        setSize(800,800);
        validate();     //Mise à jour de la fenetre
    }

    public Jeu getJeu() {
        return jeu;
    }

    public void setJeu(Jeu jeu) {
        this.jeu = jeu;
    }

    public void afficheVictoire(int joueur, int typeVictoire) {
        this.getContentPane().removeAll();
        Image backgroundImage=null;
        try {
            backgroundImage=(ImageIO.read(new File("src/ressources/Background/7WondersDuel_Fond.png")));
        }catch (Exception e){
            e.printStackTrace();
        }
JPanel jPanel=new JPanel();
        JLabel conteneur=new JLabel(joueur==3?"égalité":"Bravo "+(joueur==1?jeu.getJoueur1().getNom():jeu.getJoueur2().getNom())+", tu as gagné une victoire "+(typeVictoire==1?"militaire":typeVictoire==2?"scientifique":"civile"));
        conteneur.setFont(NewFont.getParchment().deriveFont(50f));
        setContentPane(new JLabel(new ImageIcon(backgroundImage)));
        setLayout(new BorderLayout());
        jPanel.add(conteneur);
        jPanel.setOpaque(false);
        add(jPanel,BorderLayout.PAGE_END);
        pack();
        setVisible(true);
    }

    public static void main(String[] args){
        Fenetre fen = new Fenetre("7 wonders duel");
    }

}
