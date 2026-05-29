package models.gameplay;

import models.cards.AliveCard;
import models.cards.AnimalCard;

import java.util.ArrayList;

public class FirstMatch implements MatchStrategy {
    public FirstMatch()
    {

    }

    @Override
    public Bot initBot()
    {
        ArrayList<AliveCard> deck = new ArrayList<>();
        deck.add(AnimalCard.Coyote());
        deck.add(AnimalCard.Loup());
        deck.add(AnimalCard.Loup());
        deck.add(AnimalCard.Ecureuil());
        Board board = new Board();
        Board waitingBoard = new Board();
        waitingBoard.set(3, AnimalCard.Coyote());
        return new Bot(board, waitingBoard, deck);
    }

    @Override
    public void botAction(int turnNumber, Bot bot) {
        switch (turnNumber)
        {
            case 1 -> {
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
