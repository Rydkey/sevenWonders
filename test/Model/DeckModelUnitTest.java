package Model;

import org.junit.Test;
import org.mockito.Mockito;
//import org.mockito.Mockito;

import java.util.Random;

//*
// * Created by ANTOINE on 02/12/2016.
 
public class DeckModelUnitTest {
    @Test
    public void faireCardTabTest(){
        Random rand = Mockito.mock(Random.class);
        DeckModel deck = new DeckModel(rand);
        deck.printCardTabAge1();
    }
}
