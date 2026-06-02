package models.observer;

import java.util.ArrayList;

public interface PlayerObserver {
    void updatePlayerDeckCount(int cardsAmount);
    void updatePlayerHand(ArrayList<String> hand);
    void updatePlayerBoneAmount(int bone);
    void updatePlayerBoardStatus(boolean[] boardStatus);
    void updatePlayerBoardHp(int[] boardHp);
    void updatePlayerBoardAtt(int[] boardAtt);
    void updatePlayerBoardModif(String[] boardModif);
    void updatePlayerBoardName(String[] boardName);

    boolean getPlayerBoardStatus(int index);
    int getPlayerBoardHp(int index);
    int getPlayerBoneAmount();
    int getPlayerBoardAtt(int index);
    String getPlayerBoardModif(int index);
    String getPlayerHandCard(int index);
    int getPlayerDeckCount();
    String getPlayerBoardName(int index);
    int getPlayerHandSize();
}
