package Vue;

import Controleur.ListenerChoixMerveille;
import Model.CardMerveilleModel;
import Model.DeckMerveilleModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * Created by ANTOINE on 09/12/2016.
 */
public class ConteneurChoixMerveille extends JPanel{

    Random random=new Random();

    private DeckMerveilleModel deckMerveilleModel;
    JPanel conteneurJLabelMerveille;
    JPanel global;
    JLabel merveille1;
    JLabel merveille2;
    JLabel merveille3;
    JLabel merveille4;
    private JButton boutonValidation;


    public ConteneurChoixMerveille(DeckMerveilleModel deckMerveilleModel) {
        this.deckMerveilleModel = deckMerveilleModel;
        this.deckMerveilleModel.choixCarte(random);
        initAttribut();
        addWidgets();
    }

    private void initAttribut(){
        global = new JPanel();
        merveille1= new JLabel(initImageMerveilles(0));
        merveille2= new JLabel(initImageMerveilles(1));
        merveille3= new JLabel(initImageMerveilles(2));
        merveille4= new JLabel(initImageMerveilles(3));
        merveille1.setVisible(true);
        conteneurJLabelMerveille = new JPanel(new GridLayout(2,2));
    }

    private Icon initImageMerveilles(int i) {
        ImageIcon icon=null;
        try {
            if (deckMerveilleModel.getChoixCarte().get(i).getIdMerveille() == 1) {
                icon = new ImageIcon(ImageIO.read(new File("ressources/wonders/7-Wonders-Duel-Merveille-Circus-Maximus.jpg")));
            }
            if (deckMerveilleModel.getChoixCarte().get(i).getIdMerveille() == 2) {
                icon = new ImageIcon(ImageIO.read(new File("ressources/wonders/7-Wonders-Duel-Merveille-Colosse.jpg")));
            }
            if (deckMerveilleModel.getChoixCarte().get(i).getIdMerveille() == 3) {
                icon = new ImageIcon(ImageIO.read(new File("ressources/wonders/7-Wonders-Duel-Merveille-Grand-Phare.jpg")));
            }
            if (deckMerveilleModel.getChoixCarte().get(i).getIdMerveille() == 4) {
                icon = new ImageIcon(ImageIO.read(new File("ressources/wonders/7-Wonders-Duel-Merveille-Jardins-Suspendus.jpg")));
            }
            if (deckMerveilleModel.getChoixCarte().get(i).getIdMerveille() == 5) {
                icon = new ImageIcon(ImageIO.read(new File("ressources/wonders/7-Wonders-Duel-Merveille-Grande-Bibliotheque.jpg")));
            }
            if (deckMerveilleModel.getChoixCarte().get(i).getIdMerveille() == 6) {
                icon = new ImageIcon(ImageIO.read(new File("ressources/wonders/7-Wonders-Duel-Merveille-Mausolee.jpg")));
            }
            if (deckMerveilleModel.getChoixCarte().get(i).getIdMerveille() == 7) {
                icon = new ImageIcon(ImageIO.read(new File("ressources/wonders/7-Wonders-Duel-Merveille-Piree.jpg")));
            }
            if (deckMerveilleModel.getChoixCarte().get(i).getIdMerveille() == 8) {
                icon = new ImageIcon(ImageIO.read(new File("ressources/wonders/7-Wonders-Duel-Merveille-Pyramide.jpg")));
            }
            if (deckMerveilleModel.getChoixCarte().get(i).getIdMerveille() == 9) {
                icon = new ImageIcon(ImageIO.read(new File("ressources/wonders/77-Wonders-Duel-Merveille-Sphinx.jpg")));
            }
            if (deckMerveilleModel.getChoixCarte().get(i).getIdMerveille() == 10) {
                icon = new ImageIcon(ImageIO.read(new File("ressources/wonders/7-wonders-duel-Statue-de-Zeux.jpg")));
            }
            if (deckMerveilleModel.getChoixCarte().get(i).getIdMerveille() == 11) {
                icon = new ImageIcon(ImageIO.read(new File("ressources/wonders/7-Wonders-Duel-Temple-Artemis.jpg")));
            }
            if (deckMerveilleModel.getChoixCarte().get(i).getIdMerveille() == 12) {
                icon = new ImageIcon(ImageIO.read(new File("ressources/wonders/7-Wonders-Duel-Merveille-Via-Appia.jpg")));
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
