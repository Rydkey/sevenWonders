package Vue;

import Model.Jeu;

import javax.swing.*;

/**
 * Created by Michael on 09/01/2017.
 */
public class ConteneurJetonScientifique extends JPanel{
    JLabel[] jetonScientifique;
    JPanel jPanelJetons;
    Jeu jeu;

    public ConteneurJetonScientifique(Jeu jeu){
        this.jeu=jeu;
        initAttribut();
    }

    private void initAttribut() {
        jetonScientifique=new JLabel[5];
        jPanelJetons=new JPanel();
    }
}
