package Model;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by gabiv on 16/12/2016.
 */
public class CardGameModelUnitTest {
    @Test
    public void toStringTest(){
        CardGameModel cgmTest = new CardGameModel(0,0,0,0,new int[]{0,0,0,0,0},0 ,"rouge", "Nom");
        Assert.assertEquals("Nom", cgmTest.toString());
    }
}
