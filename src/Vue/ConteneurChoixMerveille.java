package Vue;

import Controleur.ListenerChoixMerveille;
import Model.CardMerveilleModel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ANTOINE on 09/12/2016.
 */
public class ConteneurChoixMerveille extends JPanel{

    private CardMerveilleModel merveille_model;
    JPanel conteneurJLabelMerveille;
    JPanel global;
    JLabel merveille1;
    JLabel merveille2;
    JLabel merveille3;
    JLabel merveille4;
    private JButton boutonValidation;


    public ConteneurChoixMerveille(CardMerveilleModel merveille_model) {
        this.merveille_model = merveille_model;
        initAttribut();
        addWidgets();
    }

    private void initAttribut(){
        global = new JPanel();
        merveille1= new JLabel();
        merveille2= new JLabel();
        merveille3= new JLabel();
        merveille4= new JLabel();
        conteneurJLabelMerveille = new JPanel(new GridLayout(2,2));
    }

    private void addWidgets(){
        merveille1.setText("Merveille 1");
        merveille2.setText("Merveille 2");
        merveille3.setText("Merveille 3");
        merveille4.setText("Merveille 4");
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
