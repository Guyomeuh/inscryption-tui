package model.observer;

public interface GameObserver {
    void updateTurn(Integer turnNumber);
    void updateBalance(Integer balance);
    void updateGameNumber(Integer gameNumber);
}
