package Vue;

import java.awt.*;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by Michael on 16/12/2016.
 */
public class NewFont {
    private static Font parchment;
    static void chargeParchment(){
        try {
            InputStream is = new FileInputStream("src/ressources/Font/Parchment MF.ttf");
            parchment=Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(40f);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    static Font getParchment(){
        if (!parchment.equals(null)){
            return parchment;
        }
        return Font.getFont("Arial");
    }
}
