package models.gameplay;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import models.cards.AliveCard;
import models.cards.AnimalCard;

public class BotTest {
    public Bot createBot(){
        AnimalCard ac = new AnimalCard("cat", 1, 0, 1, 0);
        AnimalCard ac1 = new AnimalCard("grizzly", 6, 4, 3, 0);

        ArrayList<AliveCard> d = new ArrayList<AliveCard>();

        for (int i = 0; i < 5; i++){
            d.add(ac);
            d.add(ac1);
        }

        PlayerBoard board = new PlayerBoard();
        PlayerBoard waitingBoard = new PlayerBoard();

        return new Bot(board, waitingBoard, d);
    }

    @Test 
    public void place(){
        Bot b = createBot();

        assertTrue(b.place(0, 0));
        assertTrue(!b.place(0, 0));

        assertThrows(IllegalArgumentException.class, ()->{ b.place(0, -1); });
        assertThrows(IllegalArgumentException.class, ()->{ b.place(0, b.getCardsSize()); });
    }

    @Test 
    public void transferCards(){
        Bot b = createBot();

        for (int i = 0; i < PlayerBoard.SIZE; i++){
            b.place(i, 0);
        }
        b.transferCards();

        assertArrayEquals(new int[]{0, 4, 0, 4}, b.endTurn());
    }
}
