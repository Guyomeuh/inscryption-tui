package model.observer;

public interface BotObserver {
    void updateBotWaitingBoardStatus(Boolean[] nextBoardStatus);
    void updateBotWaitingBoardHp(Integer[] nextBoardHp);
    void updateBotWaitingBoardAtt(Integer[] nextBoardAtt);
    void updateBotWaitingBoardModif(String[] nextBoardModif);
    void updateBotBoardStatus(Boolean[] nextBoardStatus);
    void updateBotBoardHp(Integer[] nextBoardHp);
    void updateBotBoardAtt(Integer[] nextBoardAtt);
    void updateBotBoardModif(String[] nextBoardModif);

    Boolean getBotWaitingBoardStatus(Integer index);
    Integer getBotWaitingBoardHp(Integer index);
    Integer getBotWaitingBoardAtt(Integer index);
    String getBotWaitingBoardModif(Integer index);
    Boolean getBotBoardStatus(Integer index);
    Integer getBotBoardHp(Integer index);
    Integer getBotBoardAtt(Integer index);
    String getBotBoardModif(Integer index);
}
