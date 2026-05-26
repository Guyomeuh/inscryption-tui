package models.gameplay;

import models.observer.BotObserver;
import models.observer.GameObserver;

import java.util.ArrayList;

public class Game {
    private MatchStrategy m_strategy;
    private int m_gameNumber;
    private final Player m_player;
    private Combat m_combat;
    private ArrayList<GameObserver> m_observer;

    public Game(MatchStrategy strategy, Player player, GameObserver gameObs, BotObserver observer)
    {
        m_strategy = strategy;
        m_player = player;
        m_combat = new Combat(m_strategy.initBot(observer), m_player);
        m_observer = new ArrayList<>();
        m_observer.add(gameObs);
        m_gameNumber = 1;

    }

    public void setStrategy(MatchStrategy strategy, BotObserver observer)
    {
        m_strategy = strategy;
        m_combat = new Combat(m_strategy.initBot(observer), m_player);
    }

    public void nextCombat()
    {
        if (m_strategy instanceof FirstMatch)
        {
            m_strategy = new SecondMatch();
            //m_combat = new Combat(m_strategy.initBot(observer), m_player);
        }
        else if (m_strategy instanceof SecondMatch)
        {
            m_strategy = new ThirdMatch();
            //m_combat = new Combat(m_strategy.initBot(observer), m_player);

        }
        else
        {
            m_strategy = new FirstMatch();
        }
    }

    public boolean endTurn()
    {
        boolean res = m_combat.endTurn();
        updateBalance();
        updateTurn();
        return res;
    }

    public int getBloodCost(int cardIndex)
    {
        return m_combat.getBloodCost(cardIndex);
    }
    public int sacrifice(Integer position)
    {
        return m_combat.sacrifice(position);
    }

    public int place(Integer position, Integer numCard)
    {
        return m_combat.place(position, numCard);
    }

    public int getHandSize()
    {
        return m_player.getHandSize();
    }

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
