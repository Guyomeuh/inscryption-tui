package models.gameplay;

import models.observer.BotObserver;
import models.observer.GameObserver;

import java.util.ArrayList;

public class Game {
    private int m_gameNumber;
    private final Player m_player;
    private Combat m_combat;
    private ArrayList<GameObserver> m_observer;
    private BotObserver m_botObserver;

    public Game(Player player, GameObserver gameObs, BotObserver botObs)
    {
        m_player = player;
        m_observer = new ArrayList<>();
        m_observer.add(gameObs);
        m_botObserver = botObs;
        m_gameNumber = 1;
        MatchStrategy strategy = new FirstMatch();
        m_combat = new Combat(m_player, strategy, m_botObserver);
    }
    public void botTurn()
    {
        m_combat.botTurn();
        updateBalance();
        updateTurn();
    }

    public void setStrategy(MatchStrategy strategy)
    {
        MatchStrategy newStrategy = strategy;
        m_combat = new Combat(m_player, newStrategy, m_botObserver);
    }

    public void updateAll()
    {
        updateTurn();
        updateBalance();
        updateGameNumber();
    }
    public void nextCombat()
    {
        if (m_gameNumber == 1)
        {
            MatchStrategy strategy = new SecondMatch();
            m_combat = new Combat(m_player, strategy, m_botObserver);
            m_gameNumber++;
            updateAll();
        }
        else if (m_gameNumber == 2)
        {
            MatchStrategy strategy = new ThirdMatch();
            m_combat = new Combat(m_player, strategy, m_botObserver);
            m_gameNumber++;
            updateAll();
        }
        else
        {
            MatchStrategy strategy = new FirstMatch();
            m_combat = new Combat(m_player, strategy, m_botObserver);
            m_gameNumber = 1;
            updateAll();
        }
    }

    public boolean endTurn()
    {
        boolean res = m_combat.endTurn();
        updateAll();
        return res;
    }

    public void reinitPlayer()
    {
        m_player.reinitPlayer();
        m_player.initHand();
        m_player.updateAll();
    }

    public int getBloodCost(int cardIndex)
    {
        return m_combat.getBloodCost(cardIndex);
    }
    public int sacrifice(Integer position)
    {
        return m_combat.sacrifice(position);
    }

    public boolean place(Integer position, Integer numCard)
    {
        return m_combat.place(position, numCard);
    }

    public int getHandSize()
    {
        return m_player.getHandSize();
    }
    public int getDeckSize() { return m_player.getDeckSize();}

    public int availableBlood()
    {
        return m_combat.availableBlood();
    }

    public boolean draw()
    {
        return m_combat.draw();
    }

    public void addObserver(GameObserver observer)
    {
        m_observer.add(observer);
    }

    public void updateTurn()
    {
        for (GameObserver i : m_observer)
        {
            i.updateTurn(m_combat.getTurn());
        }
    }

    public void updateBalance()
    {
        for (GameObserver i : m_observer)
        {
            i.updateBalance(m_combat.getBalance());
        }
    }

    public void updateGameNumber()
    {
        for (GameObserver i : m_observer)
        {
            i.updateGameNumber(m_gameNumber);
        }
    }

    public int checkVictory()
    {
        return m_combat.checkVictory();
    }
}
