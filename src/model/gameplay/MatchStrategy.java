package model.gameplay;

public interface MatchStrategy {
    public Bot initBot()
    {
        return new Bot();
    }
}
