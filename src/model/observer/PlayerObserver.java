package model.observer;

import java.util.ArrayList;

public interface PlayerObserver {
    void updatePlayerDeck(Integer cardNb);
    void updatePlayerHand(ArrayList<AliveCard> hand);
    void updatePlayerBoard(PlayerBoard board);
}
