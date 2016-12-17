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
    Image backgroundImage;
    public Fenetre(String nomFenetre){
        NewFont.chargeParchment();
        setTitle(nomFenetre);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

    public static void main(String[] args){
        Fenetre fen = new Fenetre("7 wonders duel");
    }
}
