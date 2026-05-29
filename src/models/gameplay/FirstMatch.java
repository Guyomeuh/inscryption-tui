package models.gameplay;

import models.cards.AliveCard;
import models.cards.AliveCardFactory;

import java.util.ArrayList;

public class FirstMatch implements MatchStrategy {
    public FirstMatch()
    {

    }

    @Override
    public Bot initBot()
    {
        ArrayList<AliveCard> deck = new ArrayList<>();
        deck.add(AliveCardFactory.Coyote());
        deck.add(AliveCardFactory.Loup());
        deck.add(AliveCardFactory.Loup());
        deck.add(AliveCardFactory.Ecureuil());
        PlayerBoard board = new PlayerBoard();
        PlayerBoard waitingBoard = new PlayerBoard();
        waitingBoard.set(3, AliveCardFactory.Coyote());
        return new Bot(board, waitingBoard, deck);
    }

    @Override
    public void botAction(int turnNumber, Bot bot) {
        switch (turnNumber)
        {
            case 1 -> {
                bot.transferCards();
                bot.place(0, 0);
            }
            case 2 -> {
                bot.place(1,0);
                bot.place(2, 0);
            }
            case 3 -> {
                bot.place(3, 0);
            }
            default -> {}
        }

    }
}
