package models.gameplay;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.ArrayList;

import org.junit.Test;

import models.cards.AliveCard;
import models.cards.AnimalCard;
import view.PlayerTextObserver;

public class PlayableTest {
    public Player createPlayer(){
        AnimalCard ac = AnimalCard.Chat();
        AnimalCard ac1 = AnimalCard.Grizzly();

        ArrayList<AliveCard> d = new ArrayList<AliveCard>();

        for (int i = 0; i < 5; i++){
            d.add(ac);
            d.add(ac1);
        }
        PlayerTextObserver pt = new PlayerTextObserver();
        return new Player(d, new PlayerBoard(), pt);
    }

    @Test 
    public void endTurn(){
        Player p1 = createPlayer();

        // place card at every board location
        for (int i = 0; i < 4; i++){
            p1.place(i, 0);
        }

        //En debuguant ce test marche plus, vu qu'on init notre main avec 4 cartes aléatoires de notre deck, on a pas toujours 1 chat, 1 grizzly, 1 chat et 1 grizzly
        assertArrayEquals(new int[]{1, 4, 1, 4}, p1.endTurn());
        p1.getDamaged(0, 100); // to kill the card 

        assertArrayEquals(new int[]{0, 4, 1, 4}, p1.endTurn());
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
