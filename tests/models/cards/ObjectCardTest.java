package models.cards;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ObjectCardTest {
    @Test
    public void getters(){
        Card oc = ObjectCardFactory.Sapin();

        assertTrue(oc.getName() == "Sapin");
        assertTrue(oc.getHp() == 3);
    }

    @Test
    public void getDamaged(){
        Card oc = ObjectCardFactory.Sapin();
        
        oc.getDamaged(2);
        assertTrue(oc.getHp() == 1);

        oc.getDamaged(2);
        assertTrue(oc.getHp() == 0);
    }

    @Test
    public void tostring(){
        Card oc = ObjectCardFactory.Rocher();

        assertEquals(oc.toString(), "Rocher: 5 hp");
    }
}
