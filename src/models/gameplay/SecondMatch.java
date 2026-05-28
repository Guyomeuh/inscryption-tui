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
        deck.add(AnimalCard.Vipere());
        PlayerBoard board = new PlayerBoard();
        PlayerBoard waitingBoard = new PlayerBoard();
        return new Bot(board, waitingBoard, deck);
    }

    @Override
    public void botAction(int turnNumber, Bot bot) {
        switch (turnNumber)
        {
            case 1 -> {
                bot.transferCards();
                bot.place(2, 0);
            }
            case 2 -> {
                bot.place(3,0);
            }
            case 3 -> {
                bot.place(0, 0);
            }
            default -> {}
        }
    }
}
