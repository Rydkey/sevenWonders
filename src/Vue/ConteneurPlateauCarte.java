package Vue;

import Controleur.ListenerPlateauCarte;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by ANTOINE on 16/12/2016.
 */
public class ConteneurPlateauCarte extends JPanel {
    private Fenetre fen;
    JDialog jDialog;
    JPanel global;
    JLabel[] tabCarte;

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
            int rank=0;
            for (int i=0;i<5;i++){
                for (int j=0;j<6;j++){
                    if (j<i+2){
                        if (i==1 || i==3) {
                            tabCarte[rank].setText("Caché");
                            tabCarte[rank].setOpaque(true);
                        }else {
                            tabCarte[rank].setIcon(initCardImage(i,j));
                        }
                        tabCarte[rank].putClientProperty("pos",new int[]{i,j,rank});
                        tabCarte[rank].setMinimumSize(new Dimension(220,50));
                        tabCarte[rank].setMaximumSize(new Dimension(220,50));
                        tabCarte[rank].setPreferredSize(new Dimension(220,50));
                        if (i==0){
                            jPanelLevel1.add(tabCarte[rank]);
                        }else if (i==1){
                            jPanelLevel2.add(tabCarte[rank]);
                        }else if (i==2){
                            jPanelLevel3.add(tabCarte[rank]);
                        }else if (i==3){
                            jPanelLevel4.add(tabCarte[rank]);
                        }else if (i==4){
                            jPanelLevel5.add(tabCarte[rank]);
                        }
                        rank++;
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

    public void updateCard(int rank, int i,int j){
        tabCarte[rank].setText("");
        tabCarte[rank].setOpaque(false);
        tabCarte[rank].setIcon(initCardImage(i,j));
    }

    public void setInvisible(int rank){
        tabCarte[rank].setOpaque(false);
        tabCarte[rank].setIcon(null);
    }

    public void showBuyCardPopup(ListenerPlateauCarte listenerPlateauCarte,int pos[],int prix, int vente){
        jDialog=new JDialog();
        jDialog.setBackground(Color.orange);
        //init JDIalog contentPane
        JPanel global=new JPanel();
        global.setLayout(new BoxLayout(global,BoxLayout.Y_AXIS));
        global.setOpaque(false);
        JPanel panelButton=new JPanel();
        panelButton.setOpaque(false);
        JLabel imageCard = new JLabel(initCardImage(pos[0],pos[1]));
        JButton buttonBuy=new JButton("Acheter pour "+prix);
        JButton buttonSell=new JButton("Vendre pour "+vente);
        JButton buttonBuild=new JButton("Construire une merveille");
        buttonBuy.putClientProperty("pos",pos);
        buttonSell.putClientProperty("pos",pos);
        buttonBuild.setFont(NewFont.getParchment());
        buttonBuy.setFont(NewFont.getParchment());
        buttonSell.setFont(NewFont.getParchment());
        buttonBuild.setBackground(Color.orange);
        buttonBuy.setBackground(Color.orange);
        buttonSell.setBackground(Color.orange);
        buttonBuild.addActionListener(listenerPlateauCarte);
        buttonBuy.addActionListener(listenerPlateauCarte);
        buttonSell.addActionListener(listenerPlateauCarte);
        panelButton.add(buttonBuy);
        panelButton.add(buttonSell);
        panelButton.add(buttonBuild);
        global.add(imageCard);
        global.add(panelButton);
        jDialog.setContentPane(global);
        jDialog.pack();
        jDialog.setVisible(true);

    }

    private Icon initCardImage(int i,int j) {
        Icon icon= null;
        if (fen.getJeu().getAge()==1) {
            System.out.println("src/ressources/age1/"+fen.getJeu().getDeckModel().cardTab[i][j].getNom()+".png");
            try {
                icon = new ImageIcon(ImageIO.read(new File("src/ressources/age1/"+fen.getJeu().getDeckModel().cardTab[i][j].getNom()+".png")));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return icon;
    }

    public void setControleur(ListenerPlateauCarte listenerPlateauCarte){
        for (int i=0;i<20;i++){
            tabCarte[i].addMouseListener(listenerPlateauCarte);
        }
    }

    public JDialog getjDialog() {
        return jDialog;
    }

    public JLabel[] getTabCarte() {
        return tabCarte;
    }

    public void updateAllCarte() {
        int rank=0;
        for (int i=0;i<5;i++) {
            for (int j = 0; j < 6; j++) {
                if (j<i+2) {
                    if (i > 0) {
                        if (j != i + 1) {
                            if (fen.getJeu().getDeckModel().cardTab[i-1][j]!=null && (fen.getJeu().getDeckModel().cardTab[i][j]) == null && fen.getJeu().getDeckModel().cardTab[i][j + 1] == null) {
                                updateCard(rank - fen.getJeu().getDeckModel().cardTab[i - 1].length, i - 1, j);
                            }
                        }
                    }
                    rank++;
                }
            }
        }
    }
}
