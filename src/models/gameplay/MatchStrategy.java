package models.gameplay;

public interface MatchStrategy {
    public Bot initBot();
    public void botAction(int turnNumber, Bot bot );
}
