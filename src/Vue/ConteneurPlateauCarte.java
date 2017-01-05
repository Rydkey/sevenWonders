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
                for (int j=0;j<6;j++){
                    if (j<5-i){
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
                icon = new ImageIcon(ImageIO.read(new File("src/ressources/age1/"+fen.getJeu().getDeckModel().cardTab[i][j].getNom()+".png")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            try {
                icon = new ImageIcon(ImageIO.read(new File("src/ressources/age2/"+fen.getJeu().getDeckModel().cardTab[i][j].getNom()+".png")));
            } catch (IOException e) {
                e.printStackTrace();
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
        if (fen.getJeu().getAge()==1){
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
            if (fen.getJeu().getJ1joue()){
                System.out.println(fen.getJeu().getJoueur1().getMerveilleJoueur().get(i).getIdMerveille());
                labelMerveillesImages[i]=new JLabel(initCardMerveille(fen.getJeu().getJoueur1().getMerveilleJoueur().get(i).getIdMerveille()));
            }else {
                labelMerveillesImages[i]=new JLabel(initCardMerveille(fen.getJeu().getJoueur2().getMerveilleJoueur().get(i).getIdMerveille()));
            }

            labelMerveillesImages[i].setMinimumSize(new Dimension(500,300));
            labelMerveillesImages[i].setMaximumSize(new Dimension(500,300));
            labelMerveillesImages[i].setPreferredSize(new Dimension(500,300));
            labelMerveillesPrix[i]=new JLabel("prix :"+prix[i]);
            labelMerveillesPrix[i].setFont(NewFont.getParchment());
            labelMerveillesPrix[i].setOpaque(false);
            panelMerveilles[i].setOpaque(false);
            panelMerveilles[i].addMouseListener(listenerPlateau);
            panelMerveilles[i].putClientProperty("nb",i);
            System.out.println("i:"+i);
            panelMerveilles[i].add(labelMerveillesImages[i]);
            panelMerveilles[i].add(labelMerveillesPrix[i]);
            global.add(panelMerveilles[i]);
        }
        jDialog.add(global);
        jDialog.pack();
        jDialog.setVisible(true);

    }

    public void showDestroyCardPopup(String couleur) {
        JDialog jDialog=new JDialog();
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
                }
            }
        }else {

            int compteCarte=0;
            for (int i=0;i<fen.getJeu().getJoueur2().getMainJoueur().size();i++){
                if (fen.getJeu().getJoueur1().getMainJoueur().get(i).getColor().equals(couleur)){
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
