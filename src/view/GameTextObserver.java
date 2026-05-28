package view;

import models.observer.GameObserver;

public class GameTextObserver implements GameObserver {
    private Integer m_turn;
    private Integer m_balance;
    private Integer m_gameNumber;

    public GameTextObserver(){
        m_turn = 1;
        m_balance = 0;
        m_gameNumber = 1;
    }

    @Override
    public void updateTurn(Integer turnNumber) {
        m_turn = turnNumber;
    }

    @Override
    public void updateBalance(Integer balance) {
        m_balance = balance;
    }

    @Override
    public void updateGameNumber(Integer gameNumber) {
        m_gameNumber = gameNumber;
    }

    public String getGameNumber()
    {
        return m_gameNumber.toString();
    }

    public String getBalance()
    {
        return m_balance.toString();
    }

    public String getTurn()
    {
        return (m_turn == 1) ? m_turn.toString() + "er" : m_turn.toString() + "e";
    }
}
