package model.observer;

import java.util.ArrayList;

public interface PlayerObserver {
    void updateDeckCount(Integer cardsAmount);
    void updateHand(ArrayList<String> hand);
    void updatePlayerBoardStatus(Boolean[] boardStatus);
    void updatePlayerBoardHp(Integer[] boardHp);
    void updatePlayerBoardAtt(Integer[] boardAtt);
    void updatePlayerBoardModif(String[] boardModif);

    Boolean getPlayerBoardStatus(Integer index);
    Integer getPlayerBoardHp(Integer index);
    Integer getPlayerBoardAtt(Integer index);
    String getPlayerBoardModif(Integer index);
    String getHandCard(Integer index);
    Integer getDeckCount();

}
