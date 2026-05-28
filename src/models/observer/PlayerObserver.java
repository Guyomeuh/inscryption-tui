package models.observer;

import java.util.ArrayList;

public interface PlayerObserver {
    void updatePlayerDeckCount(int cardsAmount);
    void updatePlayerHand(ArrayList<String> hand);
    void updatePlayerBoardStatus(boolean[] boardStatus);
    void updatePlayerBoardHp(int[] boardHp);
    void updatePlayerBoardAtt(int[] boardAtt);
    void updatePlayerBoardModif(String[] boardModif);
    void updatePlayerBoardName(String[] boardName);

    Boolean getPlayerBoardStatus(int index);
    Integer getPlayerBoardHp(int index);
    Integer getPlayerBoardAtt(int index);
    String getPlayerBoardModif(int index);
    String getPlayerHandCard(int index);
    Integer getPlayerDeckCount();
    String getPlayerBoardName(int index);
    Integer getPlayerHandSize();
}
