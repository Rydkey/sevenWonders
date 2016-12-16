package Model;

import Model.DeckModel;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Random;

/**
 * Created by ANTOINE on 02/12/2016.
 */
public class DeckModelUnitTest {
    @Test
    public void faireCardTabTest(){
        DeckModel deck = new DeckModel();
        Random rand = Mockito.mock(Random.class);
        deck.faireCardTab(rand);
        deck.printCardTab();
    }
}
