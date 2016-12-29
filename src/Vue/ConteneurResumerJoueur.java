package Vue;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Michael on 15/12/2016.
 */
public class ConteneurResumerJoueur extends JPanel {
    private int joueurs;
    Fenetre fenetre;
    JPanel global;
    JPanel jPanelRight;
    JLabel jLabelNom;
    JLabel jLabelMerveille;
    JLabel jLabelscorePiece;
    JLabel jLabelressource;
    JLabel jLabelScientifique;
    JPanel jPanelAvancement;
    JLabel[] jLabelsAvancement;

    public ConteneurResumerJoueur(Fenetre fenetre,int joueurs){
        this.joueurs=joueurs;
        this.fenetre=fenetre;
        initAttribut();
        addWidgets();
    }



    private void initAttribut() {

        global = new JPanel();
        jPanelRight = new JPanel();
        jPanelRight.setLayout(new BoxLayout(jPanelRight, BoxLayout.Y_AXIS));
        jLabelScientifique = new JLabel();
        jPanelAvancement = new JPanel(new GridLayout(4,5));
        jLabelsAvancement = new JLabel[17];
        for (int i=0;i<17;i++){
            jLabelsAvancement[i] = new JLabel();
            jLabelsAvancement[i].setOpaque(false);
            jLabelsAvancement[i].setMinimumSize(new Dimension(50,50));
            jLabelsAvancement[i].setMaximumSize(new Dimension(50,50));
            jLabelsAvancement[i].setPreferredSize(new Dimension(50,50));
        }
        if (joueurs==1){
            if (fenetre.getJeu().getJ1joue()) {
                jLabelNom = new JLabel(fenetre.getJeu().getJoueur1().getNom()+" à toi");
            }else {
                jLabelNom = new JLabel(fenetre.getJeu().getJoueur1().getNom());
            }
            String string="<html>Merveilles: <br>";
            for (int i=0;i<4;i++){
                string+=fenetre.getJeu().getDeckMerveilleModel().getDeckMerveille().get(fenetre.getJeu().getJoueur1().getIdMerveille()[i]-1).getNom()+"<br>";
            }
            string+="</html>";
            jLabelMerveille = new JLabel(string);
            jLabelscorePiece = new JLabel("<html>Score:"+fenetre.getJeu().getJoueur1().getPointScore()+"<br> Pieces :"+fenetre.getJeu().getJoueur1().getPieces()+"</html>");
            //Bois,pierre, argile,papyrus,verre
            string="<html>Bois :"+fenetre.getJeu().getJoueur1().getRessource()[0]+"<br> Pierrre :"+fenetre.getJeu().getJoueur1().getRessource()[1]+"<br> Argile :"+fenetre.getJeu().getJoueur1().getRessource()[2]+"<br> Papyrus :"+fenetre.getJeu().getJoueur1().getRessource()[3]+"<br> Verre :"+fenetre.getJeu().getJoueur1().getRessource()[4]+"</html>";
            jLabelressource = new JLabel(string);

        }else {

            if (fenetre.getJeu().getJ1joue()) {
                jLabelNom = new JLabel(fenetre.getJeu().getJoueur2().getNom());
            }else {
                jLabelNom = new JLabel(fenetre.getJeu().getJoueur2().getNom()+" à toi");
            }
            String string="<html>Merveilles: <br>";
            for (int i=0;i<4;i++){
                string+=fenetre.getJeu().getDeckMerveilleModel().getDeckMerveille().get(fenetre.getJeu().getJoueur1().getIdMerveille()[i]-1).getNom()+"<br>";
            }
            string+="</html>";
            jLabelMerveille = new JLabel(string);
            jLabelscorePiece = new JLabel("<html>Score:"+fenetre.getJeu().getJoueur2().getPointScore()+"<br> Pieces :"+fenetre.getJeu().getJoueur2().getPieces()+"</html>");
            //Bois,pierre, argile,papyrus,verre
            string="<html>Bois :"+fenetre.getJeu().getJoueur2().getRessource()[0]+"<br> Pierrre :"+fenetre.getJeu().getJoueur2().getRessource()[1]+"<br> Argile :"+fenetre.getJeu().getJoueur2().getRessource()[2]+"<br> Papyrus :"+fenetre.getJeu().getJoueur2().getRessource()[3]+"<br> Verre :"+fenetre.getJeu().getJoueur2().getRessource()[4]+"</html>";
            jLabelressource = new JLabel(string);
        }
        this.setBackground(Color.orange);
        global.setOpaque(false);
        jPanelRight.setOpaque(false);
        jLabelNom.setOpaque(false);
        jLabelMerveille.setOpaque(false);
        jLabelscorePiece.setOpaque(false);
        jLabelressource.setOpaque(false);
        jLabelScientifique.setOpaque(false);
        jPanelAvancement.setOpaque(false);

        jLabelNom.setFont(NewFont.getParchment().deriveFont(20f));
        jLabelMerveille.setFont(NewFont.getParchment().deriveFont(20f));
        jLabelscorePiece.setFont(NewFont.getParchment().deriveFont(20f));
        jLabelressource.setFont(NewFont.getParchment().deriveFont(20f));
        jLabelScientifique.setFont(NewFont.getParchment().deriveFont(20f));
    }

    private Icon initImageAvance(Integer integer) {
        ImageIcon icon=null;
        try {
            icon = new ImageIcon(ImageIO.read(new File("src/ressources/Avancement/"+integer+".png")));
        }catch(IOException e){
            e.printStackTrace();
        }
        return icon;
    }

    private void addWidgets() {
        for (int i=0;i<jLabelsAvancement.length;i++){
            jPanelAvancement.add(jLabelsAvancement[i]);
        }
        jPanelRight.add(jLabelNom);
        jPanelRight.add(jLabelscorePiece);
        jPanelRight.add(jLabelScientifique);
        jPanelRight.add(jLabelressource);
        global.add(jLabelMerveille);
        global.add(jPanelRight);
        global.add(jPanelAvancement);
        this.add(global);
    }

    public void updateResumer(){

        if (joueurs==1){
            if (fenetre.getJeu().getJ1joue()) {
                jLabelNom.setText(fenetre.getJeu().getJoueur1().getNom()+" à toi");
            }else {
                jLabelNom.setText(fenetre.getJeu().getJoueur1().getNom());
            }
            String string="<html>Merveilles: <br>";
            for (int i=0;i<4;i++){
                string+=fenetre.getJeu().getDeckMerveilleModel().getDeckMerveille().get(fenetre.getJeu().getJoueur1().getIdMerveille()[i]-1).getNom()+"<br>";
            }
            string+="</html>";
            jLabelMerveille.setText(string);
            jLabelscorePiece.setText("<html>Score:"+fenetre.getJeu().getJoueur1().getPointScore()+"<br> Pieces :"+fenetre.getJeu().getJoueur1().getPieces()+"</html>");
            //Bois,pierre, argile,papyrus,verre
            string="<html>Bois :"+fenetre.getJeu().getJoueur1().getRessource()[0]+"<br> Pierrre :"+fenetre.getJeu().getJoueur1().getRessource()[1]+"<br> Argile :"+fenetre.getJeu().getJoueur1().getRessource()[2]+"<br> Papyrus :"+fenetre.getJeu().getJoueur1().getRessource()[3]+"<br> Verre :"+fenetre.getJeu().getJoueur1().getRessource()[4]+"</html>";
            jLabelressource.setText(string);
            for (int i=0;i<17;i++){
                if (i<fenetre.getJeu().getJoueur1().getIdAvancement().size()) {
                    jLabelsAvancement[i].setIcon(initImageAvance(fenetre.getJeu().getJoueur1().getIdAvancement().get(i)));
                    jLabelsAvancement[i].setOpaque(false);
                }
            }
//            jLabelScientifique = new JLabel();
//            jLabelAvancement = new JLabel();
        }else {

            if (fenetre.getJeu().getJ1joue()) {
                jLabelNom.setText(fenetre.getJeu().getJoueur2().getNom());
            }else {
                jLabelNom.setText(fenetre.getJeu().getJoueur2().getNom()+" à toi");
            }
            String string="<html>Merveilles: <br>";
            for (int i=0;i<4;i++){
                string+=fenetre.getJeu().getDeckMerveilleModel().getDeckMerveille().get(fenetre.getJeu().getJoueur1().getIdMerveille()[i]-1).getNom()+"<br>";
            }
            string+="</html>";
            jLabelMerveille.setText(string);
            jLabelscorePiece.setText("<html>Score:"+fenetre.getJeu().getJoueur2().getPointScore()+"<br> Pieces :"+fenetre.getJeu().getJoueur2().getPieces()+"</html>");
            //Bois,pierre, argile,papyrus,verre
            string="<html>Bois :"+fenetre.getJeu().getJoueur2().getRessource()[0]+"<br> Pierrre :"+fenetre.getJeu().getJoueur2().getRessource()[1]+"<br> Argile :"+fenetre.getJeu().getJoueur2().getRessource()[2]+"<br> Papyrus :"+fenetre.getJeu().getJoueur2().getRessource()[3]+"<br> Verre :"+fenetre.getJeu().getJoueur2().getRessource()[4]+"</html>";
            jLabelressource.setText(string);
            for (int i=0;i<17;i++){
                if (i<fenetre.getJeu().getJoueur2().getIdAvancement().size()) {
                    jLabelsAvancement[i].setIcon(initImageAvance(fenetre.getJeu().getJoueur2().getIdAvancement().get(i)));
                    jLabelsAvancement[i].setOpaque(false);
                }
            }
//            jLabelScientifique = new JLabel();
//            jLabelAvancement = new JLabel();
        }
    }
}
