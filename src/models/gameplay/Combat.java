package models.gameplay;

import models.observer.BotObserver;

public class Combat {
    private final Player m_player;
    private final Bot m_bot;
    private Playable m_currentPlayer;
    private final MatchStrategy m_strategy;
    private Integer m_turn;
    private int m_balance;

    public Combat(Player player, MatchStrategy strategy, BotObserver botObserver)
    {
        m_player = player;
        m_strategy = strategy;
        m_bot = m_strategy.initBot();
        m_bot.addObserver(botObserver);
        m_currentPlayer = player;
        m_player.setNewBoard(m_strategy.initPlayerBoard());
        m_balance = 0;
        m_turn = 1;
        m_bot.updateAll();
    }

    public void botTurn()
    {
        m_bot.transferCards();
        m_strategy.botAction(m_turn,m_bot);
        endTurn();
    }

    public boolean draw()
    {
        return m_player.draw();
    }

    public boolean place(int position, int numCard)
    {
        return m_currentPlayer.place(position, numCard);
    }

    public int availableBlood()
    {
        return m_player.availableBlood();
    }
    
    public int sacrifice(Integer position)
    {
        return m_player.sacrifice(position);
    }

    public boolean endTurn() {
        int[] damages = m_currentPlayer.endTurn();
        if (m_currentPlayer == m_player) {
            for (int i = 0; i < 4; i++)
            {
                if (m_bot.isAirborne(i) || !m_bot.getDamaged(i, damages[i]))
                {
                    m_balance+=damages[i];
                }
            }
            m_bot.updateAll();
            m_currentPlayer = m_bot;
        } else{
            for (int i = 0; i < 4; i++)
            {
                if (m_player.isAirborne(i) || !m_player.getDamaged(i, damages[i]))
                {
                    m_balance-=damages[i];
                }
            }
            m_player.updateAll();
            m_currentPlayer = m_player;
            m_turn++;
        }

        return true;
    }

    public Integer getTurn()
    {
        return m_turn;
    }

    public int getBalance()
    {
        return m_balance;
    }

    public int checkVictory()
    {
        if (m_balance >= 5)
        {
            return 1;
        }
        else if (m_balance <= -5)
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }


}
