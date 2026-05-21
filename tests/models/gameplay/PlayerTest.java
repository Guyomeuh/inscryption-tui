package models.gameplay;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import models.cards.AliveCard;
import models.cards.AnimalCard;

public class PlayerTest {
    public Player createPlayer(){
        AnimalCard ac = new AnimalCard("cat", 1, 0, 1, 0);
        AnimalCard ac1 = new AnimalCard("grizzly", 6, 4, 3, 0);

        ArrayList<AliveCard> d = new ArrayList<AliveCard>();

        for (int i = 0; i < 5; i++){
            d.add(ac);
            d.add(ac1);
        }

        return new Player(d, new PlayerBoard());
    }

    @Test
    public void getters(){
        Player p1 = createPlayer();
       
        assertEquals(6, p1.getDeckSize());
        assertEquals(4, p1.getHandSize());
    }

    @Test 
    public void draw(){
        Player p1 = createPlayer();

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
        Player p1 = createPlayer();

        assertTrue(p1.place(0, 0));
        assertTrue(!p1.place(0, 0));

        assertThrows(IllegalArgumentException.class, ()->{ p1.place(0, -1); });
        assertThrows(IllegalArgumentException.class, ()->{ p1.place(0, p1.getHandSize()); });
    }

    @Test 
    public void endTurn(){
        Player p1 = createPlayer();

        // place card at every board location
        for (int i = 0; i < 4; i++){
            p1.place(i, i);
        }

        assertEquals(new int[]{0, 4, 0, 4}, p1.endTurn());
        p1.getDamaged(0, 100); // to kill the card 

        assertEquals(new int[]{-1, 4, 0, 4}, p1.endTurn());
    }

    @Test
    public void getDamaged(){
        Player p1 = createPlayer();
        p1.place(0, 0);

        assertEquals(true, p1.getDamaged(0, 1));
        assertEquals(true, p1.getDamaged(0, 1));
        assertEquals(true, p1.getDamaged(0, 5));
        assertEquals(false, p1.getDamaged(0, 5));

        assertThrows(IllegalArgumentException.class, ()->{ p1.getDamaged(-1, 1); });
        assertThrows(IllegalArgumentException.class, ()->{ p1.getDamaged(4, 1); });
        assertThrows(IllegalArgumentException.class, ()->{ p1.getDamaged(0, -1); });
    }
}
