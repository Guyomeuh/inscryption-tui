package model.gameplay;

import java.util.ArrayList;
import java.util.Optional;

public class Board {
    private static Integer m_turn = 0;
    private Optional<Card>[] m_playerBoard;
    private Optional<Card>[] m_botBoard;
    private Optional<Card>[] m_botToBeComing;

    private Board(Integer numGame)
    {
        switch (numGame)
        {
            case 1 ->
                    m_playerBoard = new Optional<Card>[4];
                    m_botBoard = new Optional<Card>[4];
                    m_botToBeComing = new Optional<Card>[4];
                    for (int i = 0; i < 4; i++)
                    {
                        m_playerBoard[i] = Optional.empty();
                        m_botBoard[i] = Optional.empty();
                        m_botToBeComing[i] = Optional.empty();
                    }
        }
    }

    public static Board Game1(){
        return new Board(1);
    }

    public static Board Game2(){
        return new Board(2);
    }

    public static Board Game3(){
        return new Board(3);
    }

    public Boolean isFull(Player player)
    {
        if (player instanceof Bot)
        {
            for (int i = 0; i < 4; i++)
            {
                if(m_botBoard[i].isEmpty())
                {
                    return false;
                }
            }
        }
        else
        {
            for (int i = 0; i < 4; i++)
            {
                if(m_playerBoard[i].isEmpty())
                {
                    return false;
                }
            }
        }
        return true;
    }

}
