package models.gameplay;

public class Combat {
    private final Player m_player;
    private final Bot m_bot;
    private Playable m_currentPlayer;
    private static Integer m_turn = 1;
    private int m_balance;

    public Combat(Bot bot, Player player)
    {
        m_player = player;
        m_bot = bot;
        m_currentPlayer = player;
        m_balance = 0;
    }

    public boolean draw()
    {
        return m_player.draw();
    }

    public int place(int position, int numCard)
    {
        return m_currentPlayer.place(position, numCard);
    }

    public int availableBlood()
    {
        return m_player.availableBlood();
    }

    public int getBloodCost(int cardIndex)
    {
        return m_player.getBloodCost(cardIndex);
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
                if (!m_bot.getDamaged(i, damages[i]))
                {
                    m_balance+=damages[i];
                }
            }
            m_bot.updateAll();
            m_bot.transferCards();
            m_currentPlayer = m_bot;
        } else{
            for (int i = 0; i < 4; i++)
            {
                if (!m_player.getDamaged(i, damages[i]))
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
