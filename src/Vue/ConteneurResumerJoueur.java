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
        if (fenetre.getJeu().getJ1joue()){
            global = new JPanel();
            jLabelNom = new JLabel(fenetre.getJeu().getJoueur1().getNom());
            String string="<html>Merveilles: <br>";
            for (int i=0;i<4;i++){
                string+=fenetre.getJeu().getDeckMerveilleModel().getDeckMerveille().get(fenetre.getJeu().getJoueur1().getIdMerveille()[i]-1).getNom()+"<br>";
            }
            System.out.println();
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
            jLabelNom = new JLabel(fenetre.getJeu().getJoueur2().getNom());
            String string="<html>Merveilles: ";
            for (int i=0;i<4;i++){
                string+=fenetre.getJeu().getDeckMerveilleModel().getDeckMerveille().get(fenetre.getJeu().getJoueur2().getIdMerveille()[i])+" ";
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
    }

    private void addWidgets() {
        global.add(jLabelNom);
        global.add(jLabelMerveille);
        global.add(jLabelscorePiece);
        global.add(jLabelScientifique);
        global.add(jLabelressource);
        this.add(global);
    }

}
