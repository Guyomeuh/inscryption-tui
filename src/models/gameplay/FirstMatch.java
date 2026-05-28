package models.gameplay;

public class FirstMatch implements MatchStrategy {
    public FirstMatch()
    {

    }

    public Bot initBot()
    {
        return new Bot();
    }
}
