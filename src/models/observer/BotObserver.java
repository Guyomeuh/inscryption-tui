package models.observer;

public interface BotObserver {
    void updateBotWaitingBoardStatus(boolean[] nextBoardStatus);
    void updateBotWaitingBoardHp(int[] nextBoardHp);
    void updateBotWaitingBoardAtt(int[] nextBoardAtt);
    void updateBotWaitingBoardModif(String[] nextBoardModif);
    void updateBotWaitingBoardName(String[] nextBoardName);
    void updateBotBoardStatus(boolean[] boardStatus);
    void updateBotBoardHp(int[] boardHp);
    void updateBotBoardAtt(int[] boardAtt);
    void updateBotBoardModif(String[] boardModif);
    void updateBotBoardName(String[] boardName);

    boolean getBotWaitingBoardStatus(int index);
    int getBotWaitingBoardHp(int index);
    int getBotWaitingBoardAtt(int index);
    String getBotWaitingBoardModif(int index);
    String getBotWaitingBoardName(int index);
    boolean getBotBoardStatus(int index);
    int getBotBoardHp(int index);
    int getBotBoardAtt(int index);
    String getBotBoardModif(int index);
    String getBotBoardName(int index);
}
