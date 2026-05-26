package models.gameplay;

import models.observer.BotObserver;

public interface MatchStrategy {
    public Bot initBot(BotObserver observer);
}
