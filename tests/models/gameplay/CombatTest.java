package models.gameplay;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import models.cards.AliveCard;
import models.cards.AliveCardFactory;
import models.observer.BotObserver;
import view.PlayerTextObserver;

public class CombatTest {
    private static class EmptyBotObserver implements BotObserver {
        @Override public void updateBotWaitingBoardStatus(boolean[] nextBoardStatus) {}
        @Override public void updateBotWaitingBoardHp(int[] nextBoardHp) {}
        @Override public void updateBotWaitingBoardAtt(int[] nextBoardAtt) {}
        @Override public void updateBotWaitingBoardModif(String[] nextBoardModif) {}
        @Override public void updateBotWaitingBoardName(String[] nextBoardName) {}
        @Override public void updateBotBoardStatus(boolean[] boardStatus) {}
        @Override public void updateBotBoardHp(int[] boardHp) {}
        @Override public void updateBotBoardAtt(int[] boardAtt) {}
        @Override public void updateBotBoardModif(String[] boardModif) {}
        @Override public void updateBotBoardName(String[] boardName) {}
        @Override public boolean getBotWaitingBoardStatus(int index) { return false; }
        @Override public int getBotWaitingBoardHp(int index) { return 0; }
        @Override public int getBotWaitingBoardAtt(int index) { return 0; }
        @Override public String getBotWaitingBoardModif(int index) { return ""; }
        @Override public String getBotWaitingBoardName(int index) { return ""; }
        @Override public boolean getBotBoardStatus(int index) { return false; }
        @Override public int getBotBoardHp(int index) { return 0; }
        @Override public int getBotBoardAtt(int index) { return 0; }
        @Override public String getBotBoardModif(int index) { return ""; }
        @Override public String getBotBoardName(int index) { return ""; }
    }

    private static class NoOpMatchStrategy implements MatchStrategy {
        private final Bot m_bot;
        private final Board m_playerBoard;

        public NoOpMatchStrategy(Bot bot, Board playerBoard) {
            m_bot = bot;
            m_playerBoard = playerBoard;
        }

        @Override
        public Bot initBot() {
            return m_bot;
        }

        @Override
        public void botAction(int turnNumber, Bot bot) {
        }

        @Override
        public Board initPlayerBoard() {
            return m_playerBoard;
        }
    }

    @Test
    public void allCardsAttackAtEndOfTurn() {
        ArrayList<AliveCard> deck = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            deck.add(AliveCardFactory.Grizzly());
        }

        Player player = new Player(deck, new Board(), new PlayerTextObserver());
        Board botBoard = new Board();
        botBoard.set(0, AliveCardFactory.Corbeau());
        botBoard.set(1, AliveCardFactory.Ecureuil());

        Bot bot = new Bot(botBoard, new Board(), new ArrayList<AliveCard>(), new EmptyBotObserver());
        Combat combat = new Combat(player, new NoOpMatchStrategy(bot, new Board()), new EmptyBotObserver());

        assertTrue(player.place(0, 0));
        assertTrue(player.place(1, 0));

        assertTrue(combat.endTurn());
        assertEquals(Integer.valueOf(1), combat.getTurn());
        assertEquals(0, combat.checkVictory());

        assertEquals(0, botBoard.getHp(0));
        assertEquals(0, botBoard.getHp(1));
    }

    @Test
    public void balanceUpdatesAndVictoryCondition() {
        ArrayList<AliveCard> deck = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            deck.add(AliveCardFactory.Grizzly());
        }

        Player player = new Player(deck, new Board(), new PlayerTextObserver());
        Bot bot = new Bot(new Board(), new Board(), new ArrayList<AliveCard>(), new EmptyBotObserver());
        Combat combat = new Combat(player, new NoOpMatchStrategy(bot, new Board()), new EmptyBotObserver());

        player.place(0, 0);
        combat.endTurn();
        combat.endTurn();
        combat.endTurn();

        assertEquals(Integer.valueOf(2), combat.getTurn());
        assertEquals(1, combat.checkVictory());
    }
}
