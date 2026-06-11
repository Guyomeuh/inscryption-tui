package models.gameplay;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import models.cards.AliveCard;
import models.cards.AliveCardFactory;
import models.cards.ObjectCardFactory;
import view.PlayerTextObserver;

public class PlayerTest {
    public Player createPlayer(){
        AliveCard ac = AliveCardFactory.Chat();
        AliveCard ac1 = AliveCardFactory.Grizzly();

        ArrayList<AliveCard> d = new ArrayList<AliveCard>();


        for (int i = 0; i < 5; i++){
            d.add(ac);
            d.add(ac1);
        }

        Board pb = new Board();
        pb.set(3, ObjectCardFactory.Rocher());
        pb.set(0, AliveCardFactory.Corbeau());
        PlayerTextObserver pt = new PlayerTextObserver();
        Player p = new Player(d, pb,pt);
        p.sacrifice(0);

        return p;
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
    public void sacrifice(){
        Player p1 = createPlayer();

        assertThrows(IllegalArgumentException.class, ()->{ p1.sacrifice(-1); });
        assertThrows(IllegalArgumentException.class, ()->{ p1.sacrifice(4); });
        assertEquals(p1.sacrifice(0),0);

        p1.place(0, 0);
        assertEquals(p1.sacrifice(0),1);
        assertEquals(p1.sacrifice(3),0);
    }

    @Test
    public void sacrificeGivesBloodAndBone(){
        Player p1 = createPlayer();

        p1.place(0, 0);
        int beforeBone = p1.getBone();

        assertEquals(1, p1.sacrifice(0));
        assertEquals(beforeBone + 1, p1.getBone());
        assertEquals(1, p1.getBlood());
    }
}
