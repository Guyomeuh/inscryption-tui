package view;

import model.observer.PlayerObserver;

import java.util.ArrayList;

public class PlayerTextObserver implements PlayerObserver {
    private Integer m_deckCardAmount;
    private ArrayList<String> m_playerHand;
    private Boolean[] m_playerBoardStatus;
    private Integer[] m_playerBoardHp;
    private Integer[] m_playerBoardAtt;
    private String[] m_playerBoardModif;

    public PlayerTextObserver()
    {
        m_deckCardAmount = 0;
        m_playerHand = new ArrayList<String>();
        m_playerBoardStatus = new Boolean[4];
        m_playerBoardHp = new Integer[4];
        m_playerBoardAtt = new Integer[4];
        m_playerBoardModif = new String[4];

    }

    @Override
    public void updateDeckCount(Integer cardsAmount) {
        m_deckCardAmount = cardsAmount;
    }

    @Override
    public void updateHand(ArrayList<String> hand) {
        m_playerHand = hand;
    }

    @Override
    public void updatePlayerBoardStatus(Boolean[] boardStatus) {
        m_playerBoardStatus = boardStatus;
    }

    @Override
    public void updatePlayerBoardHp(Integer[] boardHp) {
        m_playerBoardHp = boardHp;
    }

    @Override
    public void updatePlayerBoardAtt(Integer[] boardAtt) {
        m_playerBoardAtt = boardAtt;
    }

    @Override
    public void updatePlayerBoardModif(String[] boardModif) {
        m_playerBoardModif = boardModif;
    }

    @Override
    public Boolean getPlayerBoardStatus(Integer index) {
        return m_playerBoardStatus[index];
    }

    @Override
    public Integer getPlayerBoardHp(Integer index) {
        return m_playerBoardHp[index];
    }

    @Override
    public Integer getPlayerBoardAtt(Integer index) {
        return m_playerBoardAtt[index];
    }

    @Override
    public String getPlayerBoardModif(Integer index) {
        return m_playerBoardModif[index];
    }

    @Override
    public String getHandCard(Integer index) {
        return m_playerHand.get(index);
    }

    @Override
    public Integer getDeckCount() {
        return m_deckCardAmount;
    }
}
