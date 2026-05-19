package models.gameplay;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import models.cards.AliveCard;
import models.cards.AnimalCard;

public class PlayerTest {
    @Test
    public void getters(){
        AnimalCard ac = new AnimalCard("cat", 1, 0, 1, 0);
        AnimalCard ac1 = new AnimalCard("grizzly", 6, 4, 3, 0);

        ArrayList<AliveCard> d = new ArrayList<AliveCard>();

        for (int i = 0; i < 5; i++){
            d.add(ac);
            d.add(ac1);
        }

        Player p1 = new Player(d, new PlayerBoard());
        
        assertEquals(6, p1.getDeckSize());
        assertEquals(4, p1.getHandSize());
        
    }

    @Test 
    public void draw(){
        AnimalCard ac = new AnimalCard("cat", 1, 0, 1, 0);
        AnimalCard ac1 = new AnimalCard("grizzly", 6, 4, 3, 0);

        ArrayList<AliveCard> d = new ArrayList<AliveCard>();

        for (int i = 0; i < 5; i++){
            d.add(ac);
            d.add(ac1);
        }

        Player p1 = new Player(d, new PlayerBoard());

        p1.draw();
        assertEquals(5, p1.getDeckSize());
        assertEquals(5, p1.getHandSize());

        while (p1.getDeckSize() > 0){
            p1.draw();
        }

        assertTrue(!p1.draw());
        assertEquals(0, p1.getDeckSize());
        assertEquals(10, p1.getHandSize());
    }

    @Test 
    public void place(){
        AnimalCard ac = new AnimalCard("cat", 1, 0, 1, 0);
        AnimalCard ac1 = new AnimalCard("grizzly", 6, 4, 3, 0);

        ArrayList<AliveCard> d = new ArrayList<AliveCard>();

        for (int i = 0; i < 5; i++){
            d.add(ac);
            d.add(ac1);
        }

        Player p1 = new Player(d, new PlayerBoard());
        assertTrue(p1.place(0, 0));
        assertTrue(!p1.place(0, 0));

        assertThrows(IllegalArgumentException.class, ()->{ p1.place(0, -1); });
        assertThrows(IllegalArgumentException.class, ()->{ p1.place(0, p1.getHandSize()); });
    }
}
