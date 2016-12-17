package Vue;

import Controleur.ListenerChoixMerveille;
import Model.DeckMerveilleModel;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by ANTOINE on 09/12/2016.
 */
public class ConteneurChoixMerveille extends JPanel{

    private Fenetre fen;
    JPanel conteneurJLabelMerveille;
    JPanel global;
    JLabel merveille1;
    JLabel merveille2;
    JLabel merveille3;
    JLabel merveille4;
    private JButton boutonValidation;


    public ConteneurChoixMerveille(Fenetre fenetre) {
        this.fen = fenetre;
        setBackground(Color.orange);
        initAttribut();
        addWidgets();
    }

    private void initAttribut(){
        global = new JPanel();
        global.setOpaque(false);
        global.setLayout(new BoxLayout(global, BoxLayout.Y_AXIS));
        merveille1= new JLabel(initImageMerveilles(0));
        merveille1.setName("0");
        if (fen.getJeu().getDeckMerveilleModel().getChoixCarte().size()>=2) {
            merveille2 = new JLabel(initImageMerveilles(1));
            merveille2.setName("1");
        }else {
            merveille2 = new JLabel();
            merveille2.setName("-1");
        }
        if (fen.getJeu().getDeckMerveilleModel().getChoixCarte().size()>=3) {
            merveille3 = new JLabel(initImageMerveilles(2));
            merveille3.setName("2");
        }else {
            merveille3 = new JLabel();
            merveille3.setName("-1");
        }
        if (fen.getJeu().getDeckMerveilleModel().getChoixCarte().size()==4) {
            merveille4 = new JLabel(initImageMerveilles(3));
            merveille4.setName("3");
        }else {
            merveille4 = new JLabel();
            merveille4.setName("-1");
        }
        merveille1.setOpaque(false);
        merveille2.setOpaque(false);
        merveille3.setOpaque(false);
        merveille4.setOpaque(false);
        conteneurJLabelMerveille = new JPanel(new GridLayout(2,2));
        conteneurJLabelMerveille.setOpaque(false);
    }

    private Icon initImageMerveilles(int i) {
        ImageIcon icon=null;
        try {
            if (fen.getJeu().getDeckMerveilleModel().getChoixCarte().get(i).getIdMerveille() == 1) {
                icon = new ImageIcon(ImageIO.read(new File("src/ressources/wonders/7-Wonders-Duel-Merveille-Circus-Maximus.jpg")));
            }
            if (fen.getJeu().getDeckMerveilleModel().getChoixCarte().get(i).getIdMerveille() == 2) {
                icon = new ImageIcon(ImageIO.read(new File("src/ressources/wonders/7-Wonders-Duel-Merveille-Colosse.jpg")));
            }
            if (fen.getJeu().getDeckMerveilleModel().getChoixCarte().get(i).getIdMerveille() == 3) {
                icon = new ImageIcon(ImageIO.read(new File("src/ressources/wonders/7-Wonders-Duel-Merveille-Grand-Phare.jpg")));
            }
            if (fen.getJeu().getDeckMerveilleModel().getChoixCarte().get(i).getIdMerveille() == 4) {
                icon = new ImageIcon(ImageIO.read(new File("src/ressources/wonders/7-Wonders-Duel-Merveille-Jardins-Suspendus.jpg")));
            }
            if (fen.getJeu().getDeckMerveilleModel().getChoixCarte().get(i).getIdMerveille() == 5) {
                icon = new ImageIcon(ImageIO.read(new File("src/ressources/wonders/7-Wonders-Duel-Merveille-Grande-Bibliotheque.jpg")));
            }
            if (fen.getJeu().getDeckMerveilleModel().getChoixCarte().get(i).getIdMerveille() == 6) {
                icon = new ImageIcon(ImageIO.read(new File("src/ressources/wonders/7-Wonders-Duel-Merveille-Mausolee.jpg")));
            }
            if (fen.getJeu().getDeckMerveilleModel().getChoixCarte().get(i).getIdMerveille() == 7) {
                icon = new ImageIcon(ImageIO.read(new File("src/ressources/wonders/7-Wonders-Duel-Merveille-Piree.jpg")));
            }
            if (fen.getJeu().getDeckMerveilleModel().getChoixCarte().get(i).getIdMerveille() == 8) {
                icon = new ImageIcon(ImageIO.read(new File("src/ressources/wonders/7-Wonders-Duel-Merveille-Pyramide.jpg")));
            }
            if (fen.getJeu().getDeckMerveilleModel().getChoixCarte().get(i).getIdMerveille() == 9) {
                icon = new ImageIcon(ImageIO.read(new File("src/ressources/wonders/7-Wonders-Duel-Merveille-Sphinx.jpg")));
            }
            if (fen.getJeu().getDeckMerveilleModel().getChoixCarte().get(i).getIdMerveille() == 10) {
                icon = new ImageIcon(ImageIO.read(new File("src/ressources/wonders/7-wonders-duel-Statue-de-Zeux.jpg")));
            }
            if (fen.getJeu().getDeckMerveilleModel().getChoixCarte().get(i).getIdMerveille() == 11) {
                icon = new ImageIcon(ImageIO.read(new File("src/ressources/wonders/7-Wonders-Duel-Temple-Artemis.jpg")));
            }
            if (fen.getJeu().getDeckMerveilleModel().getChoixCarte().get(i).getIdMerveille() == 12) {
                icon = new ImageIcon(ImageIO.read(new File("src/ressources/wonders/7-Wonders-Duel-Merveille-Via-Appia.jpg")));
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return icon;
    }

    private void addWidgets(){
        conteneurJLabelMerveille.add(merveille1);
        conteneurJLabelMerveille.add(merveille2);
        conteneurJLabelMerveille.add(merveille3);
        conteneurJLabelMerveille.add(merveille4);
        JLabel test;
        if (fen.getJeu().getJ1joue()) {
            test=(new JLabel(fen.getJeu().getJoueur1().getNom()+" choisit une merveille"));
        }else {
            test=(new JLabel(fen.getJeu().getJoueur2().getNom()+" choisit une merveille"));
        }
        test.setFont(NewFont.getParchment());
        global.add(test);

        global.add(conteneurJLabelMerveille);
        this.add(global);
    }

    public void setControleur(ListenerChoixMerveille listenerChoixMerveille){
        merveille1.addMouseListener(listenerChoixMerveille);
        merveille2.addMouseListener(listenerChoixMerveille);
        merveille3.addMouseListener(listenerChoixMerveille);
        merveille4.addMouseListener(listenerChoixMerveille);
    }
}
