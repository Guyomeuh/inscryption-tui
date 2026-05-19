package model.gameplay;

public class Game {
    private GameStrategy m_strategy;
    private Board m_board;
    private Player m_player;
    private Player m_bot;

    public Game(GameStrategy strategy, Player player)
    {
        m_strategy = strategy;
        m_player = player;
        m_board = initBoard();
        m_bot = initBot();
    }

    public void setStrategy(GameStrategy strategy)
    {
        m_strategy = strategy;
        m_board = initBoard();
        m_bot = initBot();
    }

    public void initBoard()
    {
        m_strategy.initBoard();
    }

    public void initBot()
    {
        m_strategy.initBot();
    }

    public void endTurn(Player target)
    {
        m_board.attack(target);
        m_bot.play();
    }

    public void sacrifice(Integer position, Player player)
    {
        if (m_board.isOccupied(position, player))
        {
            m_board.remove(position, player);
        }
    }

    public Boolean place(Integer position, Player player, Card card)
    {
        if(m_board.isFull(Player player) || m_board.isOccupied(position, player))
        {
            return false;
        }
        m_board.set(position, player, card);
        return true;
    }

    public Boolean draw(Player player)
    {
        if (player instanceof Bot)
        {
            if (!m_bot.handEmpty())
            {
                m_bot.draw();
                return true;
            }
            else{
                return false;
            }
        }
        else if (!m_player.handEmpty) {
            m_player.draw();
            return true;
        }
        else { return false;}
    }
}
