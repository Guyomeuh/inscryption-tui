package view;

import model.observer.BotObserver;

public class BotTextObserver implements BotObserver {
    private Boolean[] m_waitingBoardStatus;
    private Integer[] m_waitingBoardHp;
    private Integer[] m_waitingBoardAtt;
    private String[] m_waitingBoardModif;
    private Boolean[] m_boardStatus;
    private Integer[] m_boardHp;
    private Integer[] m_boardAtt;
    private String[] m_boardModif;

    @Override
    public void updateBotWaitingBoardStatus(Boolean[] nextBoardStatus) {
        m_waitingBoardStatus = nextBoardStatus;
    }

    @Override
    public void updateBotWaitingBoardHp(Integer[] nextBoardHp) {
        m_waitingBoardHp = nextBoardHp;
    }

    @Override
    public void updateBotWaitingBoardAtt(Integer[] nextBoardAtt) {
        m_waitingBoardAtt = nextBoardAtt;
    }

    @Override
    public void updateBotWaitingBoardModif(String[] nextBoardModif) {
        m_waitingBoardModif = nextBoardModif;
    }

    @Override
    public void updateBotBoardStatus(Boolean[] boardStatus) {
        m_boardStatus = boardStatus;
    }

    @Override
    public void updateBotBoardHp(Integer[] boardHp) {
        m_boardHp = boardHp;
    }

    @Override
    public void updateBotBoardAtt(Integer[] boardAtt) {
        m_boardAtt = boardAtt;
    }

    @Override
    public void updateBotBoardModif(String[] boardModif) {
        m_boardModif = boardModif;
    }

    @Override
    public Boolean getBotWaitingBoardStatus(Integer index) {
        return m_waitingBoardStatus[index];
    }

    @Override
    public Integer getBotWaitingBoardHp(Integer index) {
        return m_waitingBoardHp[index];
    }

    @Override
    public Integer getBotWaitingBoardAtt(Integer index) {
        return m_waitingBoardAtt[index];
    }

    @Override
    public String getBotWaitingBoardModif(Integer index) {
        return m_waitingBoardModif[index];
    }

    @Override
    public Boolean getBotBoardStatus(Integer index) {
        return m_boardStatus[index];
    }

    @Override
    public Integer getBotBoardHp(Integer index) {
        return m_boardHp[index];
    }

    @Override
    public Integer getBotBoardAtt(Integer index) {
        return m_boardAtt[index];
    }

    @Override
    public String getBotBoardModif(Integer index) {
        return m_boardModif[index];
    }
}
