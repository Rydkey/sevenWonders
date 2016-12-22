package Vue;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ANTOINE on 16/12/2016.
 */
public class ConteneurPlateauCarte extends JPanel {
    private Fenetre fen;
    JPanel conteneurJLabelCarte;
    JPanel global;
    JLabel tabCarte[] = new JLabel[30];

    public ConteneurPlateauCarte(Fenetre fenetre){
        this.fen=fenetre;
        initAttribut();
        addWidgets();

    }
    private void initAttribut(){
        global = new JPanel();
        global.setOpaque(false);
        global.setLayout(new BoxLayout(global, BoxLayout.Y_AXIS));
        tabCarte=new JLabel[20];
        for (int i=0;i<20;i++){
            tabCarte[i]=new JLabel();
            tabCarte[i].setMinimumSize(new Dimension(20,50));
            tabCarte[i].setMaximumSize(new Dimension(20,50));
            tabCarte[i].setFont(NewFont.getParchment());
            tabCarte[i].setOpaque(false);
        }
        setBackground(Color.orange);
    }
    private void addWidgets(){
        JPanel jPanelLevel1 = new JPanel();
        JPanel jPanelLevel2 = new JPanel();
        JPanel jPanelLevel3 = new JPanel();
        JPanel jPanelLevel4 = new JPanel();
        JPanel jPanelLevel5 = new JPanel();
        jPanelLevel1.setOpaque(false);
        jPanelLevel2.setOpaque(false);
        jPanelLevel3.setOpaque(false);
        jPanelLevel4.setOpaque(false);
        jPanelLevel5.setOpaque(false);
        if (fen.getJeu().getAge()==1){
            for (int i=0;i<5;i++){
                for (int j=0;j<6;j++){
                    if (j<i+2){
                        tabCarte[i+j].setText(fen.getJeu().getDeckModel().cardTab[i][j].toString()+"  ");
                        System.out.println("i"+i+" j"+j+" message:"+fen.getJeu().getDeckModel().cardTab[i][j].toString());

                        if (i==0){
                            jPanelLevel1.add(tabCarte[i+j]);
                        }else if (i==1){
                            jPanelLevel2.add(tabCarte[i+j]);
                        }else if (i==2){
                            jPanelLevel3.add(tabCarte[i+j]);
                        }else if (i==3){
                            jPanelLevel4.add(tabCarte[i+j]);
                        }else if (i==4){
                            jPanelLevel5.add(tabCarte[i+j]);
                        }
                    }
                }
            }
        }

        global.add(jPanelLevel1);
        global.add(jPanelLevel2);
        global.add(jPanelLevel3);
        global.add(jPanelLevel4);
        global.add(jPanelLevel5);

        add(global);
    }
}
