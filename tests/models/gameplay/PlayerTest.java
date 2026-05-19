package models.gameplay;

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

        for (int i = 0; i < 10; i++){
            d.add(ac);
            d.add(ac1);
        }

        Player p1 = new Player(d);
        
        assertTrue(p1.getDeckSize() == 6);
        assertTrue(p1.getHandSize() == 4);
        
    }

    @Test 
    public void draw(){
        AnimalCard ac = new AnimalCard("cat", 1, 0, 1, 0);
        AnimalCard ac1 = new AnimalCard("grizzly", 6, 4, 3, 0);

        ArrayList<AliveCard> d = new ArrayList<AliveCard>();

        for (int i = 0; i < 10; i++){
            d.add(ac);
            d.add(ac1);
        }

        Player p1 = new Player(d);

        p1.draw();
        assertTrue(p1.getDeckSize() == 5);
        assertTrue(p1.getHandSize() == 5);

        // try when deck is empty and cannot draw anymore
    }
}
