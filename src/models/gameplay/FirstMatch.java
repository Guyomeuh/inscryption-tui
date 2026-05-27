package models.gameplay;

import models.cards.AliveCard;
import models.cards.AnimalCard;
import models.cards.ObjectCard;
import models.observer.BotObserver;

import java.util.ArrayList;
import java.util.Optional;

public class FirstMatch implements MatchStrategy {
    public FirstMatch()
    {

    }

    @Override
    public Bot initBot()
    {
        ArrayList<AliveCard> deck = new ArrayList<>();
        PlayerBoard board = new PlayerBoard();
        PlayerBoard waitingBoard = new PlayerBoard();
        waitingBoard.set(0, new AnimalCard("ZZZZZZZ", 5, 5, 0, 0));
        return new Bot(board, waitingBoard, deck);
    }

    @Override
    public void botAction(int turnNumber, Bot bot) {

    }
}
