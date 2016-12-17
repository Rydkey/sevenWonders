package Vue;

import javax.swing.*;

/**
 * Created by ANTOINE on 16/12/2016.
 */
public class ConteneurPlateauCarte extends JPanel {
    private Fenetre fen;
    JPanel conteneurJLabelCarte;
    JPanel global;
    JLabel tabCarte[] = new JLabel[20];

    public ConteneurPlateauCarte(Fenetre fenetre){
        this.fen=fenetre;
        initAttribut();
        addWidgets();

    }
    private void initAttribut(){
        global = new JPanel();
        global.setLayout(new BoxLayout(global,));
    }
    private void addWidgets(){

    }
}
