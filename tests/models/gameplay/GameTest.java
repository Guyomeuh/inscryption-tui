package models.gameplay;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.junit.Test;

import models.cards.AliveCard;
import models.cards.AliveCardFactory;
import view.BotTextObserver;
import view.GameTextObserver;
import view.PlayerTextObserver;

public class GameTest {
    @Test
    public void gameSetupInitializesDeckAndHand() {
        ArrayList<AliveCard> deck = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            deck.add(AliveCardFactory.Grizzly());
        }

        Player player = new Player(deck, new Board(), new PlayerTextObserver());
        Game game = new Game(player, deck, new GameTextObserver(), new BotTextObserver());

        assertEquals(4, game.getHandSize());
        assertEquals(6, game.getDeckSize());
        assertEquals(1, game.getGameNumber());
        assertEquals(0, game.checkVictory());
    }

    @Test
    public void addNewCardAppendsToDeck() {
        ArrayList<AliveCard> deck = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            deck.add(AliveCardFactory.Grizzly());
        }

        Player player = new Player(deck, new Board(), new PlayerTextObserver());
        Game game = new Game(player, deck, new GameTextObserver(), new BotTextObserver());

        int originalSize = game.getDeckSize();
        game.addNewCard("Elan");

        assertEquals(originalSize + 1, game.getDeckSize());
        assertEquals("Elan", game.getDeckCardName(originalSize));
    }

    @Test
    public void nextCombatAdvancesGameNumber() {
        ArrayList<AliveCard> deck = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            deck.add(AliveCardFactory.Grizzly());
        }

        Player player = new Player(deck, new Board(), new PlayerTextObserver());
        Game game = new Game(player, deck, new GameTextObserver(), new BotTextObserver());

        game.nextCombat();
        assertEquals(2, game.getGameNumber());
    }

    @Test
    public void secondMatchReplacesChatWithNewCards() throws Exception {
        ArrayList<AliveCard> deck = new ArrayList<>();
        deck.add(AliveCardFactory.Chat());
        deck.add(AliveCardFactory.Chat());
        deck.add(AliveCardFactory.Grizzly());
        deck.add(AliveCardFactory.Grizzly());

        Player player = new Player(deck, new Board(), new PlayerTextObserver());
        Game game = new Game(player, deck, new GameTextObserver(), new BotTextObserver());

        Method builder = Game.class.getDeclaredMethod("buildPlayerDeckForGame", int.class);
        builder.setAccessible(true);
        @SuppressWarnings("unchecked")
        ArrayList<AliveCard> secondDeck = (ArrayList<AliveCard>) builder.invoke(game, 2);

        assertEquals("Loup", secondDeck.get(0).getName());
        assertEquals("Hermine", secondDeck.get(1).getName());
    }

    @Test
    public void drawAndPlaceUpdateDeckAndHand() {
        ArrayList<AliveCard> deck = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            deck.add(AliveCardFactory.Grizzly());
        }

        Player player = new Player(deck, new Board(), new PlayerTextObserver());
        Game game = new Game(player, deck, new GameTextObserver(), new BotTextObserver());

        assertTrue(game.draw());
        assertEquals(5, game.getDeckSize());
        assertEquals(5, game.getHandSize());

        assertTrue(game.place(1, 0));
    }

    @Test
    public void losingTheGameAfterBotAttackReturnsNegativeVictory() {
        ArrayList<AliveCard> deck = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            deck.add(AliveCardFactory.Grizzly());
        }

        Player player = new Player(deck, new Board(), new PlayerTextObserver());
        Game game = new Game(player, deck, new GameTextObserver(), new BotTextObserver());

        Board botBoard = new Board();
        botBoard.set(0, AliveCardFactory.Grizzly());
        botBoard.set(1, AliveCardFactory.Grizzly());

        MatchStrategy strategy = new MatchStrategy() {
            @Override
            public Bot initBot() {
                return new Bot(botBoard, new Board(), new ArrayList<AliveCard>(), new BotTextObserver());
            }

            @Override
            public void botAction(int turnNumber, Bot bot) {
            }

            @Override
            public Board initPlayerBoard() {
                return new Board();
            }
        };

        game.setStrategy(strategy);
        game.endTurn();
        game.endTurn();

        assertEquals(-1, game.checkVictory());
    }
}
