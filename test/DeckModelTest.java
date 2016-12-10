import Model.DeckModel;
import org.junit.Test;

import java.util.Random;

/**
 * Created by ANTOINE on 02/12/2016.
 */
public class DeckModelTest {
    @Test
    public void faireArbreTest(){
        DeckModel deck = new DeckModel();
        deck.faireArbre(new Random());
    }
}
