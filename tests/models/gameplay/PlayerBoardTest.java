package models.gameplay;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import models.cards.AliveCardFactory;
import models.cards.ObjectCard;

public class PlayerBoardTest {
    @Test
    public void testAll(){
        PlayerBoard pb = new PlayerBoard();

        assertThrows(IllegalArgumentException.class, ()->{ pb.isOccupied(-1); });
        assertThrows(IllegalArgumentException.class, ()->{ pb.isOccupied(4); });

        assertTrue(!pb.isOccupied(0));
        
        pb.set(0, new ObjectCard("rock", 6));
        assertTrue(pb.isOccupied(0));
        assertTrue(!pb.isOccupied(1));

        assertThrows(IllegalArgumentException.class, ()-> { pb.set(-1, new ObjectCard("rock", 6)); });
        assertThrows(IllegalArgumentException.class, ()-> { pb.set(4, new ObjectCard("rock", 6)); });

        pb.remove(0);
        assertTrue(!pb.isOccupied(0));

        assertThrows(IllegalArgumentException.class, ()-> { pb.remove(-1); });
        assertThrows(IllegalArgumentException.class, ()-> { pb.remove(4); });

        pb.set(0, new ObjectCard("rock", 6));
        pb.set(1, AliveCardFactory.Moineau());
        assertThrows(IllegalArgumentException.class, ()-> { pb.isAirborne(-1); });
        assertThrows(IllegalArgumentException.class, ()-> { pb.isAirborne(4); });
        assertTrue(!pb.isAirborne(0));
        assertTrue(pb.isAirborne(1));
    }

    @Test
    public void sacrifice(){
        PlayerBoard pb = new PlayerBoard();
        pb.set(0, new ObjectCard("rock", 6));
        pb.set (1, AliveCardFactory.Chat());

        assertThrows(IllegalArgumentException.class, ()->{ pb.sacrifice(-1); });
        assertThrows(IllegalArgumentException.class, ()->{ pb.sacrifice(4); });

        assertEquals(0, pb.sacrifice(0));
        assertEquals(1, pb.sacrifice(1));
        assertEquals(0, pb.sacrifice(2));
    }
}
