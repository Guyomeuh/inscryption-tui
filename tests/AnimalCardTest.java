import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AnimalCardTest {
    @Test
    public void getters(){
        AnimalCard ac = new AnimalCard("crow", 3, 2, 2, 0);

        assertTrue(ac.getAttack() == 2);
        assertTrue(ac.getBlood() == 2);
        assertTrue(ac.getBone() == 0);
    }

    @Test
    public void attack(){
        ObjectCard oc = new ObjectCard("rock", 5);
        AnimalCard ac = new AnimalCard("crow", 3, 2, 2, 0);
        AnimalCard ac1 = new AnimalCard("crow", 3, 2, 2, 0);

        ac.attack(oc);
        assertTrue(oc.getHp() == 3);

        ac.attack(ac1);
        assertTrue(ac1.getHp() == 1);

        ac.attack(ac1);
        assertTrue(ac1.getHp() == 0);
    }

    @Test
    public void tostring(){
        AnimalCard ac = new AnimalCard("crow", 3, 2, 2, 0);

        assertEquals(ac.toString(), "crow: 3hp, 2atk, 2blood, 0bones");
    }
}
