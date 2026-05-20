package model.gameplay;

import java.util.ArrayList;

public class Game {
    private MatchStrategy m_strategy;
    private final Player m_player;
    private Combat m_combat;
    private ArrayList<GameObserver> m_observer;

    public Game(MatchStrategy strategy, Player player)
    {
        m_strategy = strategy;
        m_player = player;
        m_combat = new Combat(m_strategy.initBoard(), m_strategy.initBot(), m_player);
    }

    public void setStrategy(MatchStrategy strategy)
    {
        m_strategy = strategy;
        m_combat = new Combat(m_strategy.initBoard(), m_strategy.initBot(), m_player);
    }

    public void nextCombat()
    {
        if (m_strategy instanceof FirstMatch)
        {
            m_strategy = new SecondMatch();
        }
        else if (m_strategy instanceof SecondMatch)
        {
            m_strategy = new ThirdMatch();
        }
        else
        {
            m_strategy = new FirstMatch();
        }
    }

    public void endTurn()
    {
        m_combat.endTurn();
    }

    public void sacrifice(Integer position)
    {
        m_combat.sacrifice(position);
    }

    public Boolean place(Integer position, Integer numCard)
    {
        m_combat.place(position, numCard);
    }

    public Boolean draw(Player player)
    {
        m_combat.draw();
    }

    public addObserver(GameObserver observer)
    {
        m_observer.add(observer);
    }
}
