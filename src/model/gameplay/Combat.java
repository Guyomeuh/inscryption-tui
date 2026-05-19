package model.gameplay;

public class Combat {
    private final Player m_player;
    private final Player m_bot;
    private Player m_currentPlayer;
    private static Integer m_turn = 1;

    public Combat(Player bot, Player player)
    {
        m_player = player;
        m_bot = bot;
        m_currentPlayer = player;
    }

    public void draw()
    {
        m_currentPlayer.draw();
    }

    public void place(Integer position, Integer numCard)
    {
        m_currentPlayer.place(position, numCard);
    }

    public void sacrifice(Integer position)
    {
        m_currentPlayer.sacrifice(position);
    }

    public void endTurn()
    {
        m_currentPlayer.attack();
        if (m_currentPlayer.Equals(m_player))
        {
            m_currentPlayer = m_bot;
        }
        else
        {
            m_currentPlayer = m_player;
        }
        m_turn++;
    }

    public Integer getTurn()
    {
        return m_turn;
    }


}
