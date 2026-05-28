package models.gameplay;

import models.cards.AliveCard;
import models.cards.AnimalCard;
import models.observer.BotObserver;

import java.util.ArrayList;

public class SecondMatch implements MatchStrategy{
    public SecondMatch()
    {

    }

    @Override
    public Bot initBot()
    {
        ArrayList<AliveCard> deck = new ArrayList<>();
        deck.add(AnimalCard.Loup());
        deck.add(AnimalCard.Grizzly());
        deck.add(AnimalCard.Loup());
        deck.add(AnimalCard.Ecureuil());
        PlayerBoard board = new PlayerBoard();
        PlayerBoard waitingBoard = new PlayerBoard();
        return new Bot(board, waitingBoard, deck);
    }

    @Override
    public void botAction(int turnNumber, Bot bot) {

    }
}
