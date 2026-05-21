package view;

import model.observer.BotObserver;

public class BotTextObserver implements BotObserver {
    private Boolean[] m_waitingBoardStatus;
    private Integer[] m_waitingBoardHp;
    private Integer[] m_waitingBoardAtt;
    private String[] m_waitingBoardModif;
    private String[] m_waitingBoardName;
    private Boolean[] m_boardStatus;
    private Integer[] m_boardHp;
    private Integer[] m_boardAtt;
    private String[] m_boardModif;
    private String[] m_boardName;

    public BotTextObserver()
    {
        m_waitingBoardStatus = new Boolean[4];
        m_waitingBoardHp = new Integer[4];
        m_waitingBoardAtt = new Integer[4];
        m_waitingBoardModif = new String[4];
        m_waitingBoardName = new String[4];
        m_boardStatus = new Boolean[4];
        m_boardHp = new Integer[4];
        m_boardAtt = new Integer[4];
        m_boardModif = new String[4];
        m_boardName = new String[4];

//        m_waitingBoardStatus = new Boolean[]{true, false, false, false};
//        m_waitingBoardHp = new Integer[] {500,0,0,0};
//        m_waitingBoardAtt = new Integer[] {2,0,0,0};
//        m_waitingBoardModif = new String[] {"","","",""};
//        m_waitingBoardName = new String[] {"Loup","","",""};
//        m_boardStatus = new Boolean[]{false, false, false, false};
//        m_boardHp = new Integer[] {0,0,0,0};
//        m_boardAtt = new Integer[] {0,0,0,0};
//        m_boardModif = new String[] {"","","",""};
//        m_boardName = new String[] {"","","",""};

    }

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
    public void updateBotWaitingBoardName(String[] nextBoardName) {
        m_waitingBoardName = nextBoardName;
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
    public void updateBotBoardName(String[] boardName) {
        m_boardName = boardName;
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
    public String getBotWaitingBoardName(Integer index) {
        return m_waitingBoardName[index];
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

    @Override
    public String getBotBoardName(Integer index) {
        return m_boardName[index];
    }
}
