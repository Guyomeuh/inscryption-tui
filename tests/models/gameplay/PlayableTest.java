package models.gameplay;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.ArrayList;

import org.junit.Test;

import models.cards.AliveCard;
import models.cards.AliveCardFactory;
import view.PlayerTextObserver;

public class PlayableTest {
    public Player createPlayer(){
        AliveCard ac = AliveCardFactory.Chat();
        AliveCard ac1 = AliveCardFactory.Grizzly();

        ArrayList<AliveCard> d = new ArrayList<AliveCard>();

        for (int i = 0; i < 5; i++){
            d.add(ac);
            d.add(ac1);
        }
        PlayerTextObserver pt = new PlayerTextObserver();
        return new Player(d, new PlayerBoard(), pt);
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
