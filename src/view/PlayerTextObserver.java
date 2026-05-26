package view;

import models.cards.AnimalCard;
import models.observer.PlayerObserver;

import java.util.ArrayList;

public class PlayerTextObserver implements PlayerObserver {
    private Integer m_deckCardAmount;
    private ArrayList<String> m_playerHand;
    private Boolean[] m_playerBoardStatus;
    private Integer[] m_playerBoardHp;
    private Integer[] m_playerBoardAtt;
    private String[] m_playerBoardModif;
    private String[] m_playerBoardName;

    public PlayerTextObserver()
    {
        m_deckCardAmount = 0;
        m_playerHand = new ArrayList<String>();
        m_playerBoardStatus = new Boolean[4];
        m_playerBoardHp = new Integer[4];
        m_playerBoardAtt = new Integer[4];
        m_playerBoardModif = new String[4];
        m_deckCardAmount = 15;


    }

    @Override
    public void updatePlayerDeckCount(Integer cardsAmount) {
        m_deckCardAmount = cardsAmount;
    }

    @Override
    public void updatePlayerHand(ArrayList<String> hand) {
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
    public void updatePlayerBoardName(String[] boardName) {
        m_playerBoardName = boardName;
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
    public String getPlayerHandCard(Integer index) {
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
    public String getPlayerBoardName(Integer index) {
        return m_playerBoardName[index];
    }
}
