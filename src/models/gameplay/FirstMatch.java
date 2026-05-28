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
        deck.add(new AnimalCard("Coyote",1,2,0,4));
        deck.add(new AnimalCard("Loup", 2,3,2,0));
        deck.add(new AnimalCard("Loup", 2,3,2,0));
        deck.add(new AnimalCard("Ecureuil", 1,0,0,0));
        PlayerBoard board = new PlayerBoard();
        PlayerBoard waitingBoard = new PlayerBoard();
        waitingBoard.set(3, new AnimalCard("Coyote",1,2,0,4));
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
//            case 2 -> {
//                bot.place(1,0);
//                bot.place(2, 0);
//            }
//            case 3 -> {
//                bot.place(3, 0);
//            }
//            default -> {}
        }

    }
}
