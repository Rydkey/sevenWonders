package Vue;

import Controleur.ListenerPlateau;
import Model.CardGameModel;

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
        JPanel jPanelLevel6 = null;
        JPanel jPanelLevel7 = null;
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
        }else if (fen.getJeu().getAge()==2){
            int rank=0;
            for (int i=0;i<5;i++){
                for (int j=0;j<6-i;j++){
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
        }else{
            jPanelLevel6 = new JPanel();
            jPanelLevel7 = new JPanel();
            jPanelLevel6.setOpaque(false);
            jPanelLevel7.setOpaque(false);
            int rank=0;
            for (int i=0;i<3;i++){
                for (int j=0;j<i+2;j++){
                    if (i==1) {
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
                    }
                    rank++;
                }
            }
            tabCarte[9].setText("Caché");
            tabCarte[9].setOpaque(true);
            tabCarte[9].putClientProperty("pos",new int[]{3,0,9});
            tabCarte[9].setMinimumSize(new Dimension(220,50));
            tabCarte[9].setMaximumSize(new Dimension(220,50));
            tabCarte[9].setPreferredSize(new Dimension(220,50));
            tabCarte[10].setText("Caché");
            tabCarte[10].setOpaque(true);
            tabCarte[10].putClientProperty("pos",new int[]{3,0,10});
            tabCarte[10].setMinimumSize(new Dimension(220,50));
            tabCarte[10].setMaximumSize(new Dimension(220,50));
            tabCarte[10].setPreferredSize(new Dimension(220,50));
            JPanel useless=new JPanel();
            useless.setMinimumSize(new Dimension(220,50));
            useless.setMaximumSize(new Dimension(220,50));
            useless.setPreferredSize(new Dimension(220,50));
            useless.setOpaque(false);

            jPanelLevel4.add(tabCarte[9]);
            jPanelLevel4.add(useless);
            jPanelLevel4.add(tabCarte[10]);
            rank=11;
            for (int i=0;i<3;i++){
                for (int j=0;j<4-i;j++){
                    if (i==1) {
                        tabCarte[rank].setText("Caché");
                        tabCarte[rank].setOpaque(true);
                    }else {
                        tabCarte[rank].setIcon(initCardImage(i+4,j));
                    }
                    tabCarte[rank].putClientProperty("pos",new int[]{i+4,j,rank});
                    tabCarte[rank].setMinimumSize(new Dimension(220,50));
                    tabCarte[rank].setMaximumSize(new Dimension(220,50));
                    tabCarte[rank].setPreferredSize(new Dimension(220,50));
                    if (i==0){
                        jPanelLevel5.add(tabCarte[rank]);
                    }else if (i==1){
                        jPanelLevel6.add(tabCarte[rank]);
                    }else if (i==2){
                        jPanelLevel7.add(tabCarte[rank]);
                    }
                    rank++;
                }
            }
        }

        global.add(jPanelLevel1);
        global.add(jPanelLevel2);
        global.add(jPanelLevel3);
        global.add(jPanelLevel4);
        global.add(jPanelLevel5);
        if (fen.getJeu().getAge()==3) {
            global.add(jPanelLevel6);
            global.add(jPanelLevel7);
        }
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

    public void showBuyCardPopup(ListenerPlateau listenerPlateau, int pos[], int prix, int vente){
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
        buttonBuild.putClientProperty("pos",pos);
        buttonBuild.setFont(NewFont.getParchment());
        buttonBuy.setFont(NewFont.getParchment());
        buttonSell.setFont(NewFont.getParchment());
        buttonBuild.setBackground(Color.orange);
        buttonBuy.setBackground(Color.orange);
        buttonSell.setBackground(Color.orange);
        buttonBuild.addActionListener(listenerPlateau);
        buttonBuy.addActionListener(listenerPlateau);
        buttonSell.addActionListener(listenerPlateau);
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
            try {
                icon = new ImageIcon(ImageIO.read(new File("src/ressources/age1/"+fen.getJeu().getDeckModel().cardTabAge1[i][j].getNom()+".png")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if (fen.getJeu().getAge()==2) {
            try {
                icon = new ImageIcon(ImageIO.read(new File("src/ressources/age2/"+fen.getJeu().getDeckModel().cardTabAge2[i][j].getNom()+".png")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            if (fen.getJeu().getDeckModel().cardTabAge3[i][j].getColor().equals("violet")) {
                try {
                    icon = new ImageIcon(ImageIO.read(new File("src/ressources/guilde/" + fen.getJeu().getDeckModel().cardTabAge3[i][j].getNom() + ".png")));
                } catch (IOException e) {
                    System.out.println("i:" + i);
                    System.out.println("j:" + j);
                    System.out.println(fen.getJeu().getDeckModel().cardTabAge3[i][j].getNom());
                    e.printStackTrace();
                }
            } else {
                try {
                    icon = new ImageIcon(ImageIO.read(new File("src/ressources/age3/" + fen.getJeu().getDeckModel().cardTabAge3[i][j].getNom() + ".png")));
                } catch (IOException e) {
                    System.out.println("i:" + i);
                    System.out.println("j:" + j);
                    System.out.println(fen.getJeu().getDeckModel().cardTabAge3[i][j].getNom());
                    e.printStackTrace();
                }
            }
        }

        return icon;
    }

    private Icon initCardMerveille(int i){
        ImageIcon icon=null;
        System.out.println("idmerveille:"+i);
        try {
            if (i == 1) {
                System.out.println("circus");
                icon = new ImageIcon(ImageIO.read(new File("src/ressources/wonders/7-Wonders-Duel-Merveille-Circus-Maximus.jpg")));
            }
            if (i == 2) {
                icon = new ImageIcon(ImageIO.read(new File("src/ressources/wonders/7-Wonders-Duel-Merveille-Colosse.jpg")));
            }
            if (i == 3) {
                icon = new ImageIcon(ImageIO.read(new File("src/ressources/wonders/7-Wonders-Duel-Merveille-Grand-Phare.jpg")));
            }
            if (i == 4) {
                icon = new ImageIcon(ImageIO.read(new File("src/ressources/wonders/7-Wonders-Duel-Merveille-Jardins-Suspendus.jpg")));
            }
            if (i == 5) {
                icon = new ImageIcon(ImageIO.read(new File("src/ressources/wonders/7-Wonders-Duel-Merveille-Grande-Bibliotheque.jpg")));
            }
            if (i == 6) {
                icon = new ImageIcon(ImageIO.read(new File("src/ressources/wonders/7-Wonders-Duel-Merveille-Mausolee.jpg")));
            }
            if (i == 7) {
                icon = new ImageIcon(ImageIO.read(new File("src/ressources/wonders/7-Wonders-Duel-Merveille-Piree.jpg")));
            }
            if (i == 8) {
                icon = new ImageIcon(ImageIO.read(new File("src/ressources/wonders/7-Wonders-Duel-Merveille-Pyramide.jpg")));
            }
            if (i == 9) {
                icon = new ImageIcon(ImageIO.read(new File("src/ressources/wonders/7-Wonders-Duel-Merveille-Sphinx.jpg")));
            }
            if (i == 10) {
                icon = new ImageIcon(ImageIO.read(new File("src/ressources/wonders/7-wonders-duel-Statue-de-Zeux.jpg")));
            }
            if (i == 11) {
                icon = new ImageIcon(ImageIO.read(new File("src/ressources/wonders/7-Wonders-Duel-Temple-Artemis.jpg")));
            }
            if (i == 12) {
                icon = new ImageIcon(ImageIO.read(new File("src/ressources/wonders/7-Wonders-Duel-Merveille-Via-Appia.jpg")));
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return icon;
    }

    public void setControleur(ListenerPlateau listenerPlateau){
        for (int i=0;i<20;i++){
            tabCarte[i].addMouseListener(listenerPlateau);
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
            if (fen.getJeu().getAge() == 1) {
                for (int j = 0; j < 6; j++) {
                    if (j<i+2) {
                        if (i > 0) {
                            if (j != i + 1) {
                                if (fen.getJeu().getDeckModel().cardTabAge1[i-1][j]!=null && (fen.getJeu().getDeckModel().cardTabAge1[i][j]) == null && fen.getJeu().getDeckModel().cardTabAge1[i][j + 1] == null) {
                                    updateCard(rank - fen.getJeu().getDeckModel().cardTabAge1[i - 1].length, i - 1, j);
                                }
                            }
                        }
                        rank++;
                    }
                }
            }else if (fen.getJeu().getAge()==2){
                for (int j = 0; j < 6-i; j++) {
                        if (i > 0) {
                            if (fen.getJeu().getDeckModel().cardTabAge2[i-1][j]!=null && (fen.getJeu().getDeckModel().cardTabAge2[i][j]) == null && (j==0 || fen.getJeu().getDeckModel().cardTabAge2[i][j - 1] == null)) {
                                updateCard(rank - fen.getJeu().getDeckModel().cardTabAge2[i - 1].length, i - 1, j);
                            }
                            if (fen.getJeu().getDeckModel().cardTabAge2[i-1][j+1]!=null && (fen.getJeu().getDeckModel().cardTabAge2[i][j]) == null && (j==fen.getJeu().getDeckModel().cardTabAge2[i].length-1 || fen.getJeu().getDeckModel().cardTabAge2[i][j + 1] == null)) {
                                updateCard(rank - fen.getJeu().getDeckModel().cardTabAge2[i - 1].length+1, i - 1, j+1);
                            }
                        }
                    rank++;
                }
            }

        }
    }

    public void showBuyMerveillePopup(ListenerPlateau listenerPlateau, int pos[], int prix[]) {
        jDialog=new JDialog();
        jDialog.setBackground(Color.orange);
        //init JDIalog contentPane
        JPanel global=new JPanel();
        global.setBackground(Color.orange);
        global.setLayout(new GridLayout(2,2));
        global.setOpaque(false);
        JPanel[] panelMerveilles=new JPanel[4];
        JLabel[] labelMerveillesImages=new JLabel[4];
        JLabel[] labelMerveillesPrix=new JLabel[4];
        for (int i=0;i<4;i++){
            panelMerveilles[i]=new JPanel();
            panelMerveilles[i].setLayout(new BoxLayout(panelMerveilles[i],BoxLayout.Y_AXIS));
            labelMerveillesImages[i]=new JLabel(initCardMerveille(fen.getJeu().getJ1joue()?fen.getJeu().getJoueur1().getMerveilleJoueur().get(i).getIdMerveille():fen.getJeu().getJoueur2().getMerveilleJoueur().get(i).getIdMerveille()));
            labelMerveillesImages[i].setMinimumSize(new Dimension(500,300));
            labelMerveillesImages[i].setMaximumSize(new Dimension(500,300));
            labelMerveillesImages[i].setPreferredSize(new Dimension(500,300));
            int count=0;
           for (int j=0;j<4;j++){
               if (fen.getJeu().getJoueur1().getMerveilleConstructed()[i] || fen.getJeu().getJoueur2().getMerveilleConstructed()[i]){
                   count++;
               }
           }
            if (fen.getJeu().getJ1joue()?fen.getJeu().getJoueur1().getMerveilleConstructed()[i]:fen.getJeu().getJoueur2().getMerveilleConstructed()[i]) {
                labelMerveillesPrix[i] = new JLabel("Déja construit");
            }else if (count==7){

            }else{
                labelMerveillesPrix[i] = new JLabel("prix :" + prix[i]);
                panelMerveilles[i].addMouseListener(listenerPlateau);
            }
            labelMerveillesPrix[i].setFont(NewFont.getParchment());
            labelMerveillesPrix[i].setOpaque(false);
            panelMerveilles[i].setOpaque(false);
            panelMerveilles[i].putClientProperty("nb",i);
            System.out.println(pos);
            panelMerveilles[i].putClientProperty("pos",pos);
            panelMerveilles[i].add(labelMerveillesImages[i]);
            panelMerveilles[i].add(labelMerveillesPrix[i]);
            global.add(panelMerveilles[i]);
        }
        jDialog.add(global);
        jDialog.pack();
        jDialog.setVisible(true);

    }

    public void showThrownCard(ListenerPlateau listenerPlateau){
        jDialog=new JDialog();
        boolean page2=false;
        boolean page3=false;
        UIManager.put("TabbedPane.contentOpaque", false);
        JTabbedPane jTabbedPane;
        JPanel conteneursCardsPage1=new JPanel(new GridLayout(3,3));
        JPanel conteneursCardsPage2=new JPanel(new GridLayout(3,3));
        JPanel conteneursCardsPage3=new JPanel(new GridLayout(3,3));
        conteneursCardsPage1.setBackground(Color.orange);
        conteneursCardsPage2.setBackground(Color.orange);
        conteneursCardsPage3.setBackground(Color.orange);
        jDialog.setBackground(Color.orange);
        conteneursCardsPage1.setOpaque(false);
        conteneursCardsPage2.setOpaque(false);
        conteneursCardsPage3.setOpaque(false);
        JLabel[] cards;
        cards=new JLabel[fen.getJeu().getDeckModel().getDeckAge1().size()+fen.getJeu().getDeckModel().getDeckAge2().size()];
        for (int i=0;i<cards.length;i++){
            if (i<fen.getJeu().getDeckModel().getDeckAge1().size()){
                cards[i] = new JLabel(initImage(fen.getJeu().getDeckModel().getDeckAge1().get(i)));
            }else {
                cards[i] = new JLabel(initImage(fen.getJeu().getDeckModel().getDeckAge2().get(i)));
            }
            cards[i].putClientProperty("position",i);
            cards[i].putClientProperty("test",2);
            cards[i].addMouseListener(listenerPlateau);
            cards[i].setMinimumSize(new Dimension(220,50));
            cards[i].setMaximumSize(new Dimension(220,50));
            cards[i].setPreferredSize(new Dimension(220,50));
            if (i>17){
                conteneursCardsPage3.add(cards[i]);
                page3=true;
            }else if (i>8){
                conteneursCardsPage2.add(cards[i]);
                page2=true;
            }else {
                conteneursCardsPage1.add(cards[i]);
            }
        }
        if (page2){
            jTabbedPane=new JTabbedPane();
            jTabbedPane.addTab("Page 1",conteneursCardsPage1);
            jTabbedPane.addTab("Page 2",conteneursCardsPage2);
            if (page3){
                jTabbedPane.addTab("Page 3",conteneursCardsPage3);
            }
            jDialog.setContentPane(jTabbedPane);
        }else {
            jDialog.setContentPane(conteneursCardsPage1);
        }
        jDialog.pack();
        jDialog.setVisible(true);
    }

    public void showDestroyCardPopup(ListenerPlateau listenerPlateau,String couleur) {
        jDialog=new JDialog();
        boolean page2=false;
        boolean page3=false;
        UIManager.put("TabbedPane.contentOpaque", false);
        JTabbedPane jTabbedPane;
        JPanel conteneursCardsPage1=new JPanel(new GridLayout(3,3));
        JPanel conteneursCardsPage2=new JPanel(new GridLayout(3,3));
        JPanel conteneursCardsPage3=new JPanel(new GridLayout(3,3));
        conteneursCardsPage1.setBackground(Color.orange);
        conteneursCardsPage2.setBackground(Color.orange);
        conteneursCardsPage3.setBackground(Color.orange);
        jDialog.setBackground(Color.orange);
        conteneursCardsPage1.setOpaque(false);
        conteneursCardsPage2.setOpaque(false);
        conteneursCardsPage3.setOpaque(false);
        JLabel[] cards;
        if (!fen.getJeu().getJ1joue()){
            int compteCarte=0;
            for (int i=0;i<fen.getJeu().getJoueur1().getMainJoueur().size();i++){
                if (fen.getJeu().getJoueur1().getMainJoueur().get(i).getColor().equals(couleur)){
                    compteCarte++;
                }
            }
            cards=new JLabel[compteCarte];
            for (int i=0;i<cards.length;i++){
                if (fen.getJeu().getJoueur1().getMainJoueur().get(i).getColor().equals(couleur)) {
                    cards[i] = new JLabel(initImage(fen.getJeu().getJoueur1().getMainJoueur().get(i)));
                    cards[i].putClientProperty("position",i);
                    cards[i].putClientProperty("test",1);
                }
            }
        }else {

            int compteCarte=0;
            for (int i=0;i<fen.getJeu().getJoueur2().getMainJoueur().size();i++){
                if (fen.getJeu().getJoueur2().getMainJoueur().get(i).getColor().equals(couleur)){
                    compteCarte++;
                }
            }
            cards=new JLabel[compteCarte];
            for (int i=0;i<cards.length;i++){
                if (fen.getJeu().getJoueur2().getMainJoueur().get(i).getColor().equals(couleur)) {
                    cards[i] = new JLabel(initImage(fen.getJeu().getJoueur2().getMainJoueur().get(i)));
                }
            }
        }
        for (int i=0;i<cards.length;i++){
            cards[i].addMouseListener(listenerPlateau);
            cards[i].setMinimumSize(new Dimension(220,50));
            cards[i].setMaximumSize(new Dimension(220,50));
            cards[i].setPreferredSize(new Dimension(220,50));
            if (i>17){
                conteneursCardsPage3.add(cards[i]);
                page3=true;
            }else if (i>8){
                conteneursCardsPage2.add(cards[i]);
                page2=true;
            }else {
                conteneursCardsPage1.add(cards[i]);
            }
        }
        if (page2){
            jTabbedPane=new JTabbedPane();
            jTabbedPane.addTab("Page 1",conteneursCardsPage1);
            jTabbedPane.addTab("Page 2",conteneursCardsPage2);
            if (page3){
                jTabbedPane.addTab("Page 3",conteneursCardsPage3);
            }
            jDialog.setContentPane(jTabbedPane);
        }else {
            jDialog.setContentPane(conteneursCardsPage1);
        }
        jDialog.pack();
        jDialog.setVisible(true);
    }

    private Icon initImage(CardGameModel cardGameModel) {
        Icon icon= null;
        try {
            icon = new ImageIcon(ImageIO.read(new File("src/ressources/age1/"+cardGameModel.getNom()+".png")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return icon;
    }
}
