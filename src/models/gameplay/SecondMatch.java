package models.gameplay;

import models.cards.AliveCard;
import models.cards.AliveCardFactory;
import models.cards.ObjectCard;

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
        deck.add(AliveCardFactory.Ecureuil());
        Board board = new Board();
        Board waitingBoard = new Board();
        waitingBoard.set(1, AliveCardFactory.Coyote());
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
        PlayerBoard board = new PlayerBoard();
        board.set(2, new ObjectCard("Rocher", 2));
        return board;
    }
}
