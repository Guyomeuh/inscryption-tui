package models.gameplay;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.ArrayList;

import models.observer.PlayerObserver;
import org.junit.Test;

import models.cards.AliveCard;
import models.cards.AnimalCard;
import view.PlayerTextObserver;

public class PlayableTest {
    public Player createPlayer(){
        AnimalCard ac = new AnimalCard("cat", 1, 0, 1, 0);
        AnimalCard ac1 = new AnimalCard("grizzly", 6, 4, 3, 0);
        PlayerObserver obs = new PlayerTextObserver();
        ArrayList<AliveCard> d = new ArrayList<AliveCard>();

        for (int i = 0; i < 5; i++){
            d.add(ac);
            d.add(ac1);
        }

        return new Player(d, new PlayerBoard(),obs);
    }

    @Test 
    public void endTurn(){
        Player p1 = createPlayer();

        // place card at every board location
        for (int i = 0; i < 4; i++){
            p1.place(i, 0);
        }

        assertArrayEquals(new int[]{0, 4, 0, 4}, p1.endTurn());
        p1.getDamaged(0, 100); // to kill the card 

        assertArrayEquals(new int[]{0, 4, 0, 4}, p1.endTurn());
    }

    @Test
    public void getDamaged(){
        Player p1 = createPlayer();
        p1.place(0, 0);

        assertEquals(true, p1.getDamaged(0, 1));
        assertEquals(false, p1.getDamaged(0, 1));
        assertEquals(false, p1.getDamaged(0, 5));
        assertEquals(false, p1.getDamaged(0, 5));

        assertThrows(IllegalArgumentException.class, ()->{ p1.getDamaged(-1, 1); });
        assertThrows(IllegalArgumentException.class, ()->{ p1.getDamaged(4, 1); });
        assertThrows(IllegalArgumentException.class, ()->{ p1.getDamaged(0, -1); });
    }
}
