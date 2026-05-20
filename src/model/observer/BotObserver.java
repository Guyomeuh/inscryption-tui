package model.observer;

public interface BotObserver {
    void updateBotBoard(PlayerBoard board);
    void updateBotNextBoard(PlayerBoard nextBoard);
}
