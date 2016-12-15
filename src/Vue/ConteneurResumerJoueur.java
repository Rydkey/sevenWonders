package Vue;

import javax.swing.*;

/**
 * Created by Michael on 15/12/2016.
 */
public class ConteneurResumerJoueur extends JPanel {
    Fenetre fenetre;
    JPanel global;
    JLabel jLabelNom;
    JLabel jLabelMerveille;
    JLabel jLabelscorePiece;
    JLabel jLabelressource;
    JLabel jLabelScientifique;
    JLabel jLabelAvancement;

    public ConteneurResumerJoueur(Fenetre fenetre){
        this.fenetre=fenetre;
        initAttribut();
        addWidgets();
    }

    private void initAttribut() {
        global=new JPanel();
        jLabelNom=new JLabel();
        jLabelMerveille=new JLabel();
        jLabelscorePiece=new JLabel();
        jLabelressource=new JLabel();
        jLabelScientifique=new JLabel();
        jLabelAvancement=new JLabel();
    }

    private void addWidgets() {

    }

}
