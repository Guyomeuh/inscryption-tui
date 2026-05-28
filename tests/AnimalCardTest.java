import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import models.cards.AnimalCard;
import models.cards.ObjectCard;
import org.junit.Test;

public class AnimalCardTest {
    @Test
    public void getters(){
        AnimalCard ac = AnimalCard.Corbeau();

        assertTrue(ac.getAttack() == 2);
        assertTrue(ac.getBloodCost() == 2);
        assertTrue(ac.getBoneCost() == 0);
    }

    @Test
    public void attack(){
        ObjectCard oc = new ObjectCard("rock", 5);
        AnimalCard ac = AnimalCard.Corbeau();
        AnimalCard ac1 = AnimalCard.Corbeau();

        ac.attack(oc);
        assertTrue(oc.getHp() == 3);

        ac.attack(ac1);
        assertTrue(ac1.getHp() == 1);

        ac.attack(ac1);
        assertTrue(ac1.getHp() == 0);
    }

    @Test
    public void tostring(){
        AnimalCard ac = AnimalCard.Corbeau();

        assertEquals(ac.toString(), "Corbeau: 3 hp, 2 atk, 2 blood, 0 bones");
    }
}
