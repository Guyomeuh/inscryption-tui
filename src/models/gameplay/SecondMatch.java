package models.gameplay;

import models.cards.AliveCard;
import models.observer.BotObserver;

import java.util.ArrayList;

public class SecondMatch implements MatchStrategy{
    public SecondMatch()
    {

    }

    public Bot initBot(BotObserver observer)
    {
        ArrayList<AliveCard> deck = new ArrayList<>();
        PlayerBoard board = new PlayerBoard();
        PlayerBoard waitingBoard = new PlayerBoard();
        return new Bot(board, waitingBoard, deck, observer);
    }
}
