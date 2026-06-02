package models.gameplay;

import models.cards.AliveCard;
import models.cards.AliveCardFactory;

import java.util.ArrayList;

public class ThirdMatch implements MatchStrategy{
    public ThirdMatch()
    {

    }
    @Override
    public Bot initBot()
    {
        ArrayList<AliveCard> deck = new ArrayList<>();
        Board board = new Board();
        deck.add(AliveCardFactory.Corbeau());
        deck.add(AliveCardFactory.Elan());
        deck.add(AliveCardFactory.Louveteau());
        deck.add(AliveCardFactory.PorcEpic());
        Board waitingBoard = new Board();
        waitingBoard.set(1,AliveCardFactory.Moineau());
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
                bot.place(0, 0);
            }
            case 3 -> {
                bot.place(1, 0);
            }
            default -> {}
        }
    }

    @Override
    public PlayerBoard initPlayerBoard() {
        return new PlayerBoard();
    }
}
