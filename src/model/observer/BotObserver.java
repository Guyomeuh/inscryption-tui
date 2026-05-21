package model.observer;

public interface BotObserver {
    void updateBotWaitingBoardStatus(Boolean[] nextBoardStatus);
    void updateBotWaitingBoardHp(Integer[] nextBoardHp);
    void updateBotWaitingBoardAtt(Integer[] nextBoardAtt);
    void updateBotWaitingBoardModif(String[] nextBoardModif);
    void updateBotWaitingBoardName(String[] nextBoardName);
    void updateBotBoardStatus(Boolean[] boardStatus);
    void updateBotBoardHp(Integer[] boardHp);
    void updateBotBoardAtt(Integer[] boardAtt);
    void updateBotBoardModif(String[] boardModif);
    void updateBotBoardName(String[] boardName);

    Boolean getBotWaitingBoardStatus(Integer index);
    Integer getBotWaitingBoardHp(Integer index);
    Integer getBotWaitingBoardAtt(Integer index);
    String getBotWaitingBoardModif(Integer index);
    String getBotWaitingBoardName(Integer index);
    Boolean getBotBoardStatus(Integer index);
    Integer getBotBoardHp(Integer index);
    Integer getBotBoardAtt(Integer index);
    String getBotBoardModif(Integer index);
    String getBotBoardName(Integer index);
}
