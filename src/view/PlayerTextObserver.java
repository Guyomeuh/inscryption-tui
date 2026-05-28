package view;

import models.observer.PlayerObserver;

import java.util.ArrayList;

public class PlayerTextObserver implements PlayerObserver {
    private int m_deckCardAmount;
    private ArrayList<String> m_playerHand;
    private boolean[] m_playerBoardStatus;
    private int[] m_playerBoardHp;
    private int[] m_playerBoardAtt;
    private String[] m_playerBoardModif;
    private String[] m_playerBoardName;

    public PlayerTextObserver()
    {
        m_deckCardAmount = 0;
        m_playerHand = new ArrayList<String>();
        m_playerBoardStatus = new boolean[4];
        m_playerBoardHp = new int[4];
        m_playerBoardAtt = new int[4];
        m_playerBoardModif = new String[4];
        m_deckCardAmount = 15;


    }

    @Override
    public void updatePlayerDeckCount(int cardsAmount) {
        m_deckCardAmount = cardsAmount;
    }

    @Override
    public void updatePlayerHand(ArrayList<String> hand) {
        m_playerHand = hand;
    }

    @Override
    public void updatePlayerBoardStatus(boolean[] boardStatus) {
        m_playerBoardStatus = boardStatus;
    }

    @Override
    public void updatePlayerBoardHp(int[] boardHp) {
        m_playerBoardHp = boardHp;
    }

    @Override
    public void updatePlayerBoardAtt(int[] boardAtt) {
        m_playerBoardAtt = boardAtt;
    }

    @Override
    public void updatePlayerBoardModif(String[] boardModif) {
        m_playerBoardModif = boardModif;
    }

    @Override
    public void updatePlayerBoardName(String[] boardName) {
        m_playerBoardName = boardName;
    }

    @Override
    public Boolean getPlayerBoardStatus(int index) {
        return m_playerBoardStatus[index];
    }

    @Override
    public Integer getPlayerBoardHp(int index) {
        return m_playerBoardHp[index];
    }

    @Override
    public Integer getPlayerBoardAtt(int index) {
        return m_playerBoardAtt[index];
    }

    @Override
    public String getPlayerBoardModif(int index) {
        return m_playerBoardModif[index];
    }

    @Override
    public String getPlayerHandCard(int index) {
        return m_playerHand.get(index);
    }


    @Override
    public Integer getPlayerHandSize() {
        return m_playerHand.size();
    }

    @Override
    public Integer getPlayerDeckCount() {
        return m_deckCardAmount;
    }

    @Override
    public String getPlayerBoardName(int index) {
        return m_playerBoardName[index];
    }
}
