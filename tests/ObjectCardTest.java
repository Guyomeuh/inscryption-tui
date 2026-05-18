import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ObjectCardTest {
    @Test
    public void getters(){
        ObjectCard oc = new ObjectCard("rock", 3);

        assertTrue(oc.getName() == "rock");
        assertTrue(oc.getHp() == 3);
    }

    @Test
    public void getDamaged(){
        ObjectCard oc = new ObjectCard("rock", 3);
        
        oc.getDamaged(2);
        assertTrue(oc.getHp() == 1);

        oc.getDamaged(2);
        assertTrue(oc.getHp() == 0);
    }
}
