package models.observer;

import java.util.ArrayList;

public interface PlayerObserver {
    void updatePlayerDeckCount(Integer cardsAmount);
    void updatePlayerHand(ArrayList<String> hand);
    void updatePlayerBoardStatus(Boolean[] boardStatus);
    void updatePlayerBoardHp(Integer[] boardHp);
    void updatePlayerBoardAtt(Integer[] boardAtt);
    void updatePlayerBoardModif(String[] boardModif);
    void updatePlayerBoardName(String[] boardName);

    Boolean getPlayerBoardStatus(Integer index);
    Integer getPlayerBoardHp(Integer index);
    Integer getPlayerBoardAtt(Integer index);
    String getPlayerBoardModif(Integer index);
    String getPlayerHandCard(Integer index);
    Integer getPlayerDeckCount();
    String getPlayerBoardName(Integer index);
    Integer getPlayerHandSize();
}
