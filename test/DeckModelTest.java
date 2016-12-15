import Model.DeckModel;
import org.junit.Test;

import java.util.Random;

/**
 * Created by ANTOINE on 02/12/2016.
 */
public class DeckModelTest {
    @Test
    public void faireCardTabTest(){
        DeckModel deck = new DeckModel();
        deck.faireCardTab(new Random());
        deck.printCardTab();
    }
}
