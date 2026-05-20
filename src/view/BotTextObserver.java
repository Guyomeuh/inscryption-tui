package view;

import model.observer.BotObserver;

public class BotTextObserver implements BotObserver {
    Boolean[] m_bordStatus;

    @Override
    public void updateBotBoard(PlayerBoard board) {

    }

    @Override
    public void updateBotNextBoard(PlayerBoard nextBoard) {

    }

    public Boolean getBordStatus(Integer index)
    {
        return m_bordStatus[index];
    }
}
