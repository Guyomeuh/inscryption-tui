package models.gameplay;

import models.observer.BotObserver;

public interface MatchStrategy {
    public Bot initBot();
    public void botAction(int turnNumber, Bot bot );
    public PlayerBoard initPlayerBoard();
}
