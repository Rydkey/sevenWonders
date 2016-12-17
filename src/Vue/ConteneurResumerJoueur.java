package Vue;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Michael on 15/12/2016.
 */
public class ConteneurResumerJoueur extends JPanel {
    Fenetre fenetre;
    JPanel global;
    JPanel jPanelRight;
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
        if (fenetre.getJeu().getJ1joue()){
            global = new JPanel();
            jPanelRight = new JPanel();
            jPanelRight.setLayout(new BoxLayout(jPanelRight, BoxLayout.Y_AXIS));
            jLabelNom = new JLabel(fenetre.getJeu().getJoueur1().getNom());
            String string="<html>Merveilles: <br>";
            for (int i=0;i<4;i++){
                string+=fenetre.getJeu().getDeckMerveilleModel().getDeckMerveille().get(fenetre.getJeu().getJoueur1().getIdMerveille()[i]-1).getNom()+"<br>";
            }
            System.out.println("suce");
            string+="</html>";
            jLabelMerveille = new JLabel(string);
            jLabelscorePiece = new JLabel("<html>Score:"+fenetre.getJeu().getJoueur1().getPointScore()+"<br> Pieces :"+fenetre.getJeu().getJoueur1().getPieces()+"</html>");
            //Bois,pierre, argile,papyrus,verre
            string="<html>Bois :"+fenetre.getJeu().getJoueur1().getRessource()[0]+"<br> Pierrre :"+fenetre.getJeu().getJoueur1().getRessource()[1]+"<br> Argile :"+fenetre.getJeu().getJoueur1().getRessource()[2]+"<br> Papyrus :"+fenetre.getJeu().getJoueur1().getRessource()[3]+"<br> Verre :"+fenetre.getJeu().getJoueur1().getRessource()[4]+"</html>";
            jLabelressource = new JLabel(string);
            jLabelScientifique = new JLabel();
            jLabelAvancement = new JLabel();
        }else {

            global = new JPanel();
            jPanelRight = new JPanel();
            jPanelRight.setLayout(new BoxLayout(jPanelRight, BoxLayout.Y_AXIS));
            jLabelNom = new JLabel(fenetre.getJeu().getJoueur2().getNom());
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
            jLabelScientifique = new JLabel();
            jLabelAvancement = new JLabel();
        }
        this.setBackground(Color.orange);
        global.setOpaque(false);
        jPanelRight.setOpaque(false);
        jLabelNom.setOpaque(false);
        jLabelMerveille.setOpaque(false);
        jLabelscorePiece.setOpaque(false);
        jLabelressource.setOpaque(false);
        jLabelScientifique.setOpaque(false);
        jLabelAvancement.setOpaque(false);

        jLabelNom.setFont(NewFont.getParchment());
        jLabelMerveille.setFont(NewFont.getParchment());
        jLabelscorePiece.setFont(NewFont.getParchment());
        jLabelressource.setFont(NewFont.getParchment());
        jLabelScientifique.setFont(NewFont.getParchment());
        jLabelAvancement.setFont(NewFont.getParchment());
    }

    private void addWidgets() {
        jPanelRight.add(jLabelNom);
        jPanelRight.add(jLabelscorePiece);
        jPanelRight.add(jLabelScientifique);
        jPanelRight.add(jLabelressource);
        global.add(jLabelMerveille);
        global.add(jPanelRight);
        this.add(global);
    }

}
