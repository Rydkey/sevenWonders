package Vue;

import Model.Jeu;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by zliao on 16/12/2016.
 */
public class ConteneurPionGuerre extends JPanel{
    private Jeu jeu;
    JPanel global;
    JPanel jPanelTabScore;
    JLabel[] tabScore_piece;
    JPanel jPanelTab;
    JLabel tabLabel[];

    public ConteneurPionGuerre(Jeu jeu){
        this.jeu=jeu;
        initAttribut();
        addWidget();
    }

    private void addWidget() {
        for (int i=0;i<19;i++){
            jPanelTab.add(tabLabel[i]);
        }

        for (int i=0;i<7;i++){
            jPanelTabScore.add(tabScore_piece[i]);
        }
        global.add(jPanelTabScore);
        global.add(jPanelTab);
        add(global);
    }

    private void initAttribut() {
        global=new JPanel();
        jPanelTab=new JPanel();
        jPanelTabScore=new JPanel();
        tabScore_piece=new JLabel[7];
        for (int i=0;i<7;i++){
            tabScore_piece[i]=new JLabel();
            tabScore_piece[i].setFont(NewFont.getParchment().deriveFont(20f));
            tabScore_piece[i].setBorder(BorderFactory.createLineBorder(Color.black));
            if (i==2 || i==4){
                tabScore_piece[i].setText("2 Point");
                tabScore_piece[i].setMinimumSize(new Dimension(105,25));
                tabScore_piece[i].setMaximumSize(new Dimension(105,25));
                tabScore_piece[i].setPreferredSize(new Dimension(105,25));
            }else if (i==3){
                tabScore_piece[i].setMinimumSize(new Dimension(50,25));
                tabScore_piece[i].setMaximumSize(new Dimension(50,25));
                tabScore_piece[i].setPreferredSize(new Dimension(50,25));
            }else {
                tabScore_piece[i].setMinimumSize(new Dimension(160,25));
                tabScore_piece[i].setMaximumSize(new Dimension(160,25));
                tabScore_piece[i].setPreferredSize(new Dimension(160,25));
            }
        }
        if (jeu.getJoueur1().isPremiereAttaque()) {
            tabScore_piece[1].setText("5 Point");
        }else {
            tabScore_piece[1].setText("5 Point  -2 pieces");
        }
        if (jeu.getJoueur2().isPremiereAttaque()) {
            tabScore_piece[5].setText("5 Point");
        }else {
            tabScore_piece[5].setText("5 Point  -2 pieces");
        }
        if (jeu.getJoueur1().isDeuxiemeAttaque()){
            tabScore_piece[0].setText("10 Point");
        }else {
            tabScore_piece[0].setText("10 Point -5 pieces");
        }
        if (jeu.getJoueur2().isDeuxiemeAttaque()){
            tabScore_piece[6].setText("10 Point");
        }else {
            tabScore_piece[6].setText("10 Point  -5 pieces");
        }
        jPanelTab.setBackground(Color.RED);
        global.setOpaque(false);
        global.setLayout(new BoxLayout(global,BoxLayout.Y_AXIS));
        jPanelTabScore.setOpaque(false);
        setOpaque(false);
        tabLabel = new JLabel[19];
        for (int i=0;i<19;i++){
            tabLabel[i]=new JLabel();
            tabLabel[i].setBorder(BorderFactory.createLineBorder(Color.black));
            tabLabel[i].setBackground(Color.RED);
            tabLabel[i].setMinimumSize(new Dimension(50,50));
            tabLabel[i].setMaximumSize(new Dimension(50,50));
            tabLabel[i].setPreferredSize(new Dimension(50,50));
        }
        updatePion();
    }

    public void updatePion(){
        for (int i=0;i<19;i++){
            tabLabel[i].setIcon(null);
        }
        if (jeu.getJoueur2().isPremiereAttaque()) {
            tabScore_piece[5].setText("5 Point");
        }else {
            tabScore_piece[5].setText("5 Point  -2 pieces");
        }
        if (jeu.getJoueur1().isDeuxiemeAttaque()){
            tabScore_piece[0].setText("10 Point");
        }else {
            tabScore_piece[0].setText("10 Point -5 pieces");
        }
        if (jeu.getJoueur2().isDeuxiemeAttaque()){
            tabScore_piece[6].setText("10 Point");
        }else {
            tabScore_piece[6].setText("10 Point  -5 pieces");
        }
        if (jeu.getJoueur1().getPointAttaque()-jeu.getJoueur2().getPointAttaque()+9>18) {
            tabLabel[18].setIcon(initImagePion());
        }else if (jeu.getJoueur1().getPointAttaque()-jeu.getJoueur2().getPointAttaque()+9<0){
            tabLabel[0].setIcon(initImagePion());
        }else {
            tabLabel[jeu.getJoueur1().getPointAttaque() - jeu.getJoueur2().getPointAttaque() + 9].setIcon(initImagePion());
        }
    }

    private Icon initImagePion(){
        Icon icon=null;
        try {
            icon = new ImageIcon(ImageIO.read(new File("src/ressources/pion_guerre.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return icon;
    }

}
