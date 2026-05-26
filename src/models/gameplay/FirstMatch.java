package models.gameplay;

import models.cards.AliveCard;
import models.cards.AnimalCard;
import models.cards.ObjectCard;
import models.observer.BotObserver;

import java.util.ArrayList;

public class FirstMatch implements MatchStrategy {
    public FirstMatch()
    {

    }

    public Bot initBot(BotObserver observer)
    {
        ArrayList<AliveCard> deck = new ArrayList<>();
        PlayerBoard board = new PlayerBoard();
        board.set(1, new ObjectCard("Caillou", 10));
        PlayerBoard waitingBoard = new PlayerBoard();
        return new Bot(board, waitingBoard, deck, observer);
    }
}
