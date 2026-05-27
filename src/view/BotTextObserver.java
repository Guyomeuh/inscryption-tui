package view;

import models.observer.BotObserver;

import java.util.Arrays;

public class BotTextObserver implements BotObserver {
    private boolean[] m_waitingBoardStatus;
    private int[] m_waitingBoardHp;
    private int[] m_waitingBoardAtt;
    private String[] m_waitingBoardModif;
    private String[] m_waitingBoardName;

    private boolean[] m_boardStatus;
    private int[] m_boardHp;
    private int[] m_boardAtt;
    private String[] m_boardModif;
    private String[] m_boardName;

    public BotTextObserver()
    {
        m_waitingBoardStatus = new boolean[4];
        m_waitingBoardHp = new int[4];
        m_waitingBoardAtt = new int[4];
        m_waitingBoardModif = new String[4];
        m_waitingBoardName = new String[4];
        m_boardStatus = new boolean[4];
        m_boardHp = new int[4];
        m_boardAtt = new int[4];
        m_boardModif = new String[4];
        m_boardName = new String[4];
    }

    @Override
    public void updateBotWaitingBoardStatus(boolean[] nextBoardStatus) {
        m_waitingBoardStatus = nextBoardStatus;
    }

    @Override
    public void updateBotWaitingBoardHp(int[] nextBoardHp) {
        m_waitingBoardHp = nextBoardHp;
    }

    @Override
    public void updateBotWaitingBoardAtt(int[] nextBoardAtt) {
        m_waitingBoardAtt = nextBoardAtt;
    }

    @Override
    public void updateBotWaitingBoardModif(String[] nextBoardModif) {
        m_waitingBoardModif = nextBoardModif;
    }

    @Override
    public void updateBotWaitingBoardName(String[] nextBoardName) {
        m_waitingBoardName = Arrays.copyOf(nextBoardName, nextBoardName.length);
    }

    @Override
    public void updateBotBoardStatus(boolean[] boardStatus) {
        m_boardStatus = boardStatus;
    }

    @Override
    public void updateBotBoardHp(int[] boardHp) {
        m_boardHp = boardHp;
    }

    @Override
    public void updateBotBoardAtt(int[] boardAtt) {
        m_boardAtt = boardAtt;
    }

    @Override
    public void updateBotBoardModif(String[] boardModif) {
        m_boardModif = boardModif;
    }

    @Override
    public void updateBotBoardName(String[] boardName) {
        m_boardName = boardName;
    }

    @Override
    public boolean getBotWaitingBoardStatus(int index) {
        return m_waitingBoardStatus[index];
    }

    @Override
    public int getBotWaitingBoardHp(int index) {
        return m_waitingBoardHp[index];
    }

    @Override
    public int getBotWaitingBoardAtt(int index) {
        return m_waitingBoardAtt[index];
    }

    @Override
    public String getBotWaitingBoardModif(int index) {
        return m_waitingBoardModif[index];
    }

    @Override
    public String getBotWaitingBoardName(int index) {
        return m_waitingBoardName[index];
    }

    @Override
    public boolean getBotBoardStatus(int index) {
        return m_boardStatus[index];
    }

    @Override
    public int getBotBoardHp(int index) {
        return m_boardHp[index];
    }

    @Override
    public int getBotBoardAtt(int index) {
        return m_boardAtt[index];
    }

    @Override
    public String getBotBoardModif(int index) {
        return m_boardModif[index];
    }

    @Override
    public String getBotBoardName(int index) {
        return m_boardName[index];
    }
}
