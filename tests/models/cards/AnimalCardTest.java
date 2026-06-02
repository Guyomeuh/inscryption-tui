package models.cards;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AnimalCardTest {
    @Test
    public void getters(){
        AliveCard ac = AliveCardFactory.Corbeau();

        assertTrue(ac.getAttack() == 2);
        assertTrue(ac.getBloodCost() == 2);
        assertTrue(ac.getBoneCost() == 0);
    }

    @Test
    public void attack(){
        Card oc = ObjectCardFactory.Rocher();
        AliveCard ac = AliveCardFactory.Corbeau();
        AliveCard ac1 = AliveCardFactory.Corbeau();

        ac.attack(oc);
        assertTrue(oc.getHp() == 3);

        ac.attack(ac1);
        assertTrue(ac1.getHp() == 1);

        ac.attack(ac1);
        assertTrue(ac1.getHp() == 0);
    }

    @Test
    public void tostring(){
        AliveCard ac = AliveCardFactory.Corbeau();

        assertEquals(ac.toString(), "Corbeau: 3 hp, 2 atk, 2 blood, 0 bones Volant");
    }
}
