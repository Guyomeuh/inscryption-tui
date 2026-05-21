package models.gameplay;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

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
    }
}
