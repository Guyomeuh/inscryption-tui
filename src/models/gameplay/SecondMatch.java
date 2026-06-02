package models.gameplay;

import models.cards.AliveCard;
import models.cards.AliveCardFactory;

import java.util.ArrayList;

public class SecondMatch implements MatchStrategy{
    public SecondMatch()
    {

    }

    @Override
    public Bot initBot()
    {
        ArrayList<AliveCard> deck = new ArrayList<>();
        deck.add(AliveCardFactory.Loup());
        deck.add(AliveCardFactory.Grizzly());
        deck.add(AliveCardFactory.Vipere());
        Board board = new Board();
        Board waitingBoard = new Board();
        return new Bot(board, waitingBoard, deck);
    }

    @Override
    public void botAction(int turnNumber, Bot bot) {
        switch (turnNumber)
        {
            case 1 -> {
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

    @Override
    public PlayerBoard initPlayerBoard() {
        return new PlayerBoard();
    }
}
